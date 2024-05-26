package co.uco.doo.store.api.domain.ports.outputs;

import co.uco.doo.store.api.domain.models.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductById(Long id);
    List<Product> getAll();
    Long create(Product product);
    Long update(Product product);
    void delete(Long id);


}
