package co.uco.doo.store.api.infrastructure.drivenadapters.repositories;

import co.uco.doo.store.api.domain.models.Product;
import co.uco.doo.store.api.domain.ports.outputs.ProductRepository;
import co.uco.doo.store.api.infrastructure.drivenadapters.entities.ProductEntity;
import co.uco.doo.store.api.infrastructure.drivenadapters.jpa.JpaProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository repository;
    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).map(ProductEntity::ToProduct).orElse(null);
    }

    @Override
    public List<Product> getAll() {
       return repository.findAll().stream().map(ProductEntity::ToProduct).collect(Collectors.toList());
    }

    @Override
    public Long create(Product product) {
        return repository.save(ProductEntity.from(product)).getId();
    }

    @Override
    public Long update(Product product) {
        Optional<ProductEntity> optionalProduct=repository.findById(product.getId());
        if(optionalProduct.isPresent()){
            ProductEntity productEntity=optionalProduct.get();
            productEntity.setName(product.getName());
            productEntity.setDescription(product.getDescription());
            productEntity.setSupplier(product.getSupplier());
            productEntity.setCategory(product.getCategory().getValue());
            return repository.save(productEntity).getId();
        }
        throw new RuntimeException("Product not found with id " + product.getId());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
