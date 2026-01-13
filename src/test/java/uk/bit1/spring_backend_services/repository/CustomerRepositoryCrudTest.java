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
        Customer customer = new Customer("Bloggs", "Jo");
        Customer insertedCustomer = customerRepository.save(customer);
        assertEquals(entityManager.find(Customer.class, insertedCustomer.getId()), customer);
    }


}
