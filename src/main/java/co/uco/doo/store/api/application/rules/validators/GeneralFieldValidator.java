package co.uco.doo.store.api.application.rules.validators;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;

public class GeneralFieldValidator {
    private static final int MAX_CHARACTERS_NAME=40;
    private static final int MIN_CHARACTERS_NAME=2;
    private static final int MAX_CHARACTERS_DESCRIPTION=80;
    private static final int MIN_CHARACTERS_DESCRIPTION=10;
    public static void validateNameLength(String value) throws ProductExceptions {
    if(!(value.length()>MAX_CHARACTERS_NAME || value.length()<MIN_CHARACTERS_NAME)) return;
        throw new ProductExceptions(String.format("El campo nombre debe contener entre %s y %s caracteres",MIN_CHARACTERS_NAME,MAX_CHARACTERS_NAME));
    }
    public static void validateDescriptionLength(String value) throws ProductExceptions {
        if(!(value.length()>MAX_CHARACTERS_DESCRIPTION || value.length()<MIN_CHARACTERS_DESCRIPTION)) return;
        throw new ProductExceptions(String.format("El campo descripción debe contener entre %s y %s caracteres",MIN_CHARACTERS_DESCRIPTION,MAX_CHARACTERS_DESCRIPTION));
    }

    public static void validateFieldNameNull(String fieldName) throws ProductExceptions {
        if(fieldName!=null) return;
        throw new ProductExceptions("No se permiten campos nulos");
    }
}
