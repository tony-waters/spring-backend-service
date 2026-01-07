package uk.bit1.spring_jpa_relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.bit1.spring_jpa_relationships.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findById(long id);
//
//    List<Customer> findByLastName(String lastName);

}
