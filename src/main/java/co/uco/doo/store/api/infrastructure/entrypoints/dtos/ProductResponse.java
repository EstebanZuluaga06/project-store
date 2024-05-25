package co.uco.doo.store.api.infrastructure.entrypoints.dtos;

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
}
