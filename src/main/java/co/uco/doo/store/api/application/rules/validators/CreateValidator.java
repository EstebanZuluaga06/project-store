package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

public class CreateValidator implements RuleValidator {

    private final int MAX_CHARACTERS_NAME=40;
    @Override
    public void validateRules(Product product) throws ProductExceptions {
        validateFieldName(product.getName());
    }

    private void validateFieldName(String fieldName) throws ProductExceptions {
        if(!(fieldName.length()>MAX_CHARACTERS_NAME)) return;
        throw new ProductExceptions("El campo name no puede tener mas de 40 caracteres");

    }
}
