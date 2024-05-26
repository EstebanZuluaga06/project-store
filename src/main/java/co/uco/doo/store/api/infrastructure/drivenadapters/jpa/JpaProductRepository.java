package co.uco.doo.store.api.infrastructure.drivenadapters.jpa;

import co.uco.doo.store.api.infrastructure.drivenadapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity,Long> {
}
