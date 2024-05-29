package co.uco.doo.store.api.application.rules.ruleImplementation;


import co.uco.doo.store.api.application.rules.Rule;
import co.uco.doo.store.api.application.rules.TypeEnum;
import co.uco.doo.store.api.application.rules.validators.CreateValidator;
import co.uco.doo.store.api.application.rules.validators.DeleteValidator;
import co.uco.doo.store.api.application.rules.validators.UpdateValidator;
import co.uco.doo.store.api.application.rules.validators.ValidatorContext;
import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.ports.outputs.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductRule implements Rule {

    private final ProductRepository productRepository;
    @Override
    public void Validate(Product product, TypeEnum type) throws ProductExceptions {
        ValidatorContext validator=new ValidatorContext();
        switch (type) {
            case CREATE:
                validator.setValidator(new CreateValidator());
                break;
            case UPDATE:
                validator.setValidator(new UpdateValidator());
                break;
            case DELETE:
                validator.setValidator(new DeleteValidator(productRepository));
            default:
                break;

        }
        validator.execute(product);
    }
}
