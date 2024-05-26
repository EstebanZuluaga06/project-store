package co.uco.doo.store.api.domain.models.enums;

public enum CategoryEnum {

    TENNIS(1,"Tennis"),
    CLOTHES(2,"Clothes"),
    ACCESSORIES(3,"Accessories");

    private int value;
    private String name;

    CategoryEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static CategoryEnum getByValue(int value) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("No se encontró una categoría con el valor especificado: " + value);
    }
}
