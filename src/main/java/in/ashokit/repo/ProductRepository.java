package in.ashokit.repo;

import in.ashokit.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    public List<ProductEntity> findByCategoryCategoryId(Integer categoryId);

    public List<ProductEntity> findByNameContainingIgnoreCase(String name);
}
