package co.uco.doo.store.api.infrastructure.entrypoints.dtos;

import co.uco.doo.store.api.domain.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String supplier;
    private String category;
    private boolean isActive;


    public static ProductResponse from(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSupplier(),
                product.getCategory().getName(),
                product.isActive()
        );
    }
}
