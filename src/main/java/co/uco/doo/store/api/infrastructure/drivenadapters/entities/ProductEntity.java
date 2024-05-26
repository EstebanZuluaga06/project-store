package co.uco.doo.store.api.infrastructure.drivenadapters.entities;

import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.models.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="supplier")
    private String supplier;
    @Column(name="category")
    private int category;
    @Column(name="is_active")
    private boolean isActive;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, String supplier, int category, boolean isActive) {
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.category = category;
        this.isActive = isActive;
    }

    public Product ToProduct()
    {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .supplier(supplier)
                .category(CategoryEnum.getByValue(category))
                .isActive(isActive)
                .build();
    }

    public static ProductEntity from(Product product){
        return new ProductEntity(
                product.getName(),
                product.getDescription(),
                product.getSupplier(),
                product.getCategory().getValue(),
                product.isActive()
        );
    }
}
