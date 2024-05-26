package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

public interface RuleValidator {
    void validateRules(Product product) throws ProductExceptions;
}
