package co.uco.doo.store.api.application.rules;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;

public interface Rule {
    void Validate(Product product,TypeEnum type) throws ProductExceptions;
}
