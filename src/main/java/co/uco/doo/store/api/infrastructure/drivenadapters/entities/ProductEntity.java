package co.uco.doo.store.api.infrastructure.drivenadapters.entities;

import co.uco.doo.store.api.domain.exceptions.ProductExceptions;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, String supplier, int category) {
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.category = category;

    }

    public Product ToProduct() throws ProductExceptions {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .supplier(supplier)
                .category(CategoryEnum.getByValue(category))
                .build();
    }

    public static ProductEntity from(Product product){
        return new ProductEntity(
                product.getName(),
                product.getDescription(),
                product.getSupplier(),
                product.getCategory().getValue()
        );
    }
}
