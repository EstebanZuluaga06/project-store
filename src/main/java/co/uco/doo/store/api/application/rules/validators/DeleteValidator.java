package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.ports.outputs.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteValidator implements RuleValidator{

    private final ProductRepository productRepository;
    @Override
    public void validateRules(Product product) throws ProductExceptions {
        Product productDb=validateProductExist(product);
    }

    private Product validateProductExist(Product product) throws ProductExceptions {
        Product productDb=productRepository.getProductById(product.getId());
        if(productDb!=null)return productDb;
        throw new ProductExceptions("El producto no existe");
    }
}
