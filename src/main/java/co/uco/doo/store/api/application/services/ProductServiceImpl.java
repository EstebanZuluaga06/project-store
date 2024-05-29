package co.uco.doo.store.api.application.services;

import co.uco.doo.store.api.application.rules.Rule;
import co.uco.doo.store.api.application.rules.TypeEnum;
import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
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
    private final Rule rule;
    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Long create(Product product) throws ProductExceptions {
        rule.Validate(product, TypeEnum.CREATE);
        return productRepository.create(product);
    }

    @Override
    public Long update(Product product) throws ProductExceptions {
        rule.Validate(product, TypeEnum.UPDATE);
        return productRepository.update(product);
    }

    @Override
    public void delete(Product product) throws ProductExceptions {
        rule.Validate(product,TypeEnum.DELETE);
        productRepository.delete(product.getId());
    }
}
