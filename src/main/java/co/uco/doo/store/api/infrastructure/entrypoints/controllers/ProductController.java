package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.ports.inputs.ProductService;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.HeaderResponse;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ObjectResponse;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/store")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ObjectResponse> getAll()
    {
        return  ResponseEntity.ok().body(
                new ObjectResponse<>(new HeaderResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
                        productService.getAll()
                                .stream()
                                .map(ProductDto::from)
                                .toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectResponse> getById(@PathVariable Long id){
        return  ResponseEntity.ok().body(
                new ObjectResponse<>(new HeaderResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
                ProductDto.from(productService.getProductById(id))));
    }

    @PostMapping
    public ResponseEntity<ObjectResponse> create(@RequestBody ProductDto product) throws ProductExceptions {
        Long id= productService.create(product.ToProduct());
        return getById(id);
    }
    @PutMapping
    public ResponseEntity<ObjectResponse> update(@RequestBody ProductDto product) throws ProductExceptions {
        Long id = productService.update(product.ToProduct());
        return getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectResponse> delete(@PathVariable Long id) throws ProductExceptions {
        productService.delete(Product.builder().id(id).build());
        return ResponseEntity.ok().body(
                new ObjectResponse<>(
                        new HeaderResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
                        "delete product "+ id.toString()));
    }


}
