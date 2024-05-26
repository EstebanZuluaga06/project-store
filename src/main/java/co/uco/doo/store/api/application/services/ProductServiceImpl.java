package co.uco.doo.store.api.application.services;

import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.ports.inputs.ProductService;
import co.uco.doo.store.api.domain.ports.outputs.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Long create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Long update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
