package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

public class UpdateValidator implements RuleValidator{


    @Override
    public void validateRules(Product product) throws ProductExceptions {
        GeneralFieldValidator.validateFieldNameNull(product.getName());
        GeneralFieldValidator.validateFieldNameNull(product.getDescription());
        GeneralFieldValidator.validateFieldNameNull(product.getSupplier());

        GeneralFieldValidator.validateNameLength(product.getName());
        GeneralFieldValidator.validateDescriptionLength(product.getDescription());
    }
}
