package co.uco.doo.store.api.domain.models;

import co.uco.doo.store.api.domain.models.enums.CategoryEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private String supplier;
    private CategoryEnum category;
    private boolean isActive;
}
