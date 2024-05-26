package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.ports.inputs.ProductService;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/store")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll()
    {
        return new ResponseEntity<>(productService.getAll()
                .stream()
                .map(ProductDto::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(ProductDto.from(productService.getProductById(id)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product)
    {
        Long id= productService.create(product.ToProduct());
        return getById(id);
    }
    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto product) throws ProductExceptions {
        Long id = productService.update(product.ToProduct());
        return getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        productService.delete(id);
        return new ResponseEntity<>("delete product"+ id.toString(),HttpStatus.ACCEPTED);
    }


}
