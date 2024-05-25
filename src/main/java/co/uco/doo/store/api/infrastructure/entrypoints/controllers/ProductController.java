package co.uco.doo.store.api.infrastructure.entrypoints.controllers;

import co.uco.doo.store.api.infrastructure.entrypoints.dtos.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/store")
public class ProductController {

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAll()
    {
        return new ResponseEntity<>(gteProducts(), HttpStatus.OK);
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
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ProductResponse product)
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
