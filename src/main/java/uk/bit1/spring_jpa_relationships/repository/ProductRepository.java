package uk.bit1.spring_jpa_relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import uk.bit1.spring_jpa_relationships.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
