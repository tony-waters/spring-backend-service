package uk.bit1.spring_backend_services.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import uk.bit1.spring_backend_services.entity.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(showSql = true)
public class CustomerRepositoryCrudTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testInsert() {
        Customer newCustomer = new Customer("Bloggs", "Jo");
        Customer insertedCustomer = customerRepository.save(newCustomer);
        assertEquals(newCustomer, entityManager.find(Customer.class, insertedCustomer.getId()));
    }

    @Test
    void testUpdate() {
        Customer newCustomer = new Customer("Bloggs", "Jo");
        entityManager.persist(newCustomer);
        String newFirstName = "Joseph";
        newCustomer.setFirstName(newFirstName);
        customerRepository.save(newCustomer);
        assertEquals(newFirstName, entityManager.find(Customer.class, newCustomer.getId()).getFirstName());
    }
}
