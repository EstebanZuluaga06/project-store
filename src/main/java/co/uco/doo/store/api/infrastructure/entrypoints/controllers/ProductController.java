package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

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
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody ProductDto product)
    {
        return new ResponseEntity<>("update product"+ product.getName(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        return new ResponseEntity<>("delete product"+ id.toString(),HttpStatus.ACCEPTED);
    }


    private List<ProductDto> gteProducts()
    {
        ProductDto productResponse=new ProductDto(1L,"camisa","camisa blanca","Nike","Ropa",true);
        return Arrays.asList(productResponse);
    }

}
