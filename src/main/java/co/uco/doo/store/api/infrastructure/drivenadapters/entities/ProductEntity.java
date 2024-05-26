package co.uco.doo.store.api.infrastructure.drivenadapters.entities;

import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.models.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
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
}
