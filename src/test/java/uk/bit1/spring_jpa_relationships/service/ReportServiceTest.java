package uk.bit1.spring_jpa_relationships.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import uk.bit1.spring_jpa_relationships.entity.Customer;
import uk.bit1.spring_jpa_relationships.entity.Order;
import uk.bit1.spring_jpa_relationships.repository.CustomerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ReportServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        reportService = new ReportService(customerRepository);
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    void test_getCustomerCount() {
        assertEquals(0, reportService.getCustomerCount());

        Customer customer = new Customer("Waters", "Tony");
        customerRepository.save(customer);
        assertEquals(1, reportService.getCustomerCount());
    }

}
