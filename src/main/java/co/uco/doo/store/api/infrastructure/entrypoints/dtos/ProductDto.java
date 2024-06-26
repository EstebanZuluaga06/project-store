package co.uco.doo.store.api.infrastructure.entrypoints.dtos;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.models.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String supplier;
    private String category;

    public static ProductDto from(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSupplier(),
                product.getCategory().getName()
        );
    }

    public Product ToProduct() throws ProductExceptions {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .supplier(supplier)
                .category(CategoryEnum.getByDescription(category))
                .build();
    }

}
