package co.uco.doo.store.api.application.rules.ruleImplementation;

import co.uco.doo.store.api.application.rules.Rule;
import co.uco.doo.store.api.application.rules.TypeEnum;
import co.uco.doo.store.api.application.rules.validators.CreateValidator;
import co.uco.doo.store.api.application.rules.validators.ValidatorContext;
import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductRule implements Rule {
    @Override
    public void Validate(Product product, TypeEnum type) throws ProductExceptions {
        ValidatorContext validator=new ValidatorContext();
        switch (type) {
            case CREATE -> {
                validator.setValidator(new CreateValidator());
            }

        }
        validator.execute(product);
    }
}
