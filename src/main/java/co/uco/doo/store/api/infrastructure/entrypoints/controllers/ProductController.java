package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

import co.uco.doo.store.api.domain.ports.inputs.ProductService;
import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ProductResponse;
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
    public ResponseEntity<List<ProductResponse>> getAll()
    {
        return new ResponseEntity<>(productService.getAll()
                .stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(gteProducts().get(0),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductResponse product)
    {
        return new ResponseEntity<>("create product"+ product.getName(),HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody ProductResponse product)
    {
        return new ResponseEntity<>("update product"+ product.getName(),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        return new ResponseEntity<>("delete product"+ id.toString(),HttpStatus.ACCEPTED);
    }


    private List<ProductResponse> gteProducts()
    {
        ProductResponse productResponse=new ProductResponse(1L,"camisa","camisa blanca","Nike","Ropa",true);
        return Arrays.asList(productResponse);
    }

}
