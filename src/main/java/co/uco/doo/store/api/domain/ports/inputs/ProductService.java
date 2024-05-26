package co.uco.doo.store.api.domain.ports.inputs;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAll();
    Long create(Product product);
    Long update(Product product) throws ProductExceptions;
    void delete(Long id);

}
