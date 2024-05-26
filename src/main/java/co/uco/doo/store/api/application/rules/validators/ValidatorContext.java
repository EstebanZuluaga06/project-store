package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

public class ValidatorContext {

    private RuleValidator validator;

    public void setValidator(RuleValidator validator) {
        this.validator = validator;
    }

    public void execute(Product product) throws ProductExceptions {this.validator.validateRules(product);}
}
