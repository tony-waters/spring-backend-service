package uk.bit1.spring_backend_services.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import uk.bit1.spring_backend_services.entity.Customer;
import uk.bit1.spring_backend_services.entity.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer testCustomer;
    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        testCustomer = new Customer("Bloggs", "Jo");
        Order order1 = new Order("Order 1 for testOrder");
        Order order2 = new Order("Order 2 for testOrder");
        testCustomer.addOrder(order1);
        testCustomer.addOrder(order2);
        customerRepository.save(testCustomer);
    }

    @AfterEach
    public void tearDown() {
        customerRepository.delete(testCustomer);
    }

    @Test
    void customer_can_be_found_by_id() {
        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
        assertNotNull(customer);
        assertEquals(testCustomer.getLastName(), customer.getLastName());
        assertEquals(testCustomer.getFirstName(), customer.getFirstName());
    }

    @Test
    void customer_has_orders() {
        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
        assertEquals(2, customer.getOrders().size());
    }

    @Test
    void customer_details_can_be_updated() {
        testCustomer.setLastName("Mouse");
        testCustomer.setFirstName("Mickey");
        customerRepository.save(testCustomer);

        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
        assertNotNull(customer);
        assertEquals("Mouse", customer.getLastName());
        assertEquals("Mickey", customer.getFirstName());
    }

//    @Test
//    void customer_can_have_zero_orders() {
//        assertDoesNotThrow(() -> testCustomer.getOrders().size());
//        assertEquals(0, testCustomer.getOrders().size());
//    }
//
//    @Test
//    void customer_can_have_orders_added() {
//        testCustomer.addOrder(new Order("Order 1 for testOrder"));
//        testCustomer.addOrder(new Order("Order 2 for testOrder"));
//        customerRepository.save(testCustomer);
//
//        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
//        List<Order> orders = customer.getOrders();
//        assertEquals(2, orders.size());
//        assertEquals("Order 1 for testOrder", orders.get(0).getDescription());
//        assertEquals("Order 2 for testOrder", orders.get(1).getDescription());
//    }
//
//    @Test
//    void customer_can_have_orders_removed() {
//        Order order1 = new Order("Order 1 for testOrder");
//        Order order2 = new Order("Order 2 for testOrder");
//        testCustomer.addOrder(order1);
//        testCustomer.addOrder(order2);
//        customerRepository.save(testCustomer);
//        testCustomer.removeOrder(testCustomer.getOrders().get(0));
//        customerRepository.save(testCustomer);
//
//        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
//        List<Order> orders = customer.getOrders();
//        assertEquals(1, orders.size());
//        assertEquals("Order 2 for testOrder", orders.get(0).getDescription());
//    }
//
//    @Test
//    void customer_and_associated_orders_can_be_deleted() {
//        Order order1 = new Order("Order 1 for testOrder");
//        Order order2 = new Order("Order 2 for testOrder");
//        testCustomer.addOrder(order1);
//        testCustomer.addOrder(order2);
//        customerRepository.save(testCustomer);
//
//        Long customerId = testCustomer.getId();
//        Long id1 = order1.getId();
//        assertEquals(1L, id1);
//        Long id2 = order2.getId();

//        Customer customer = customerRepository.findById(testCustomer.getId()).orElse(null);
//        customerRepository.delete(customer);
//
//        assertEquals(null, customerRepository.findById(testCustomer.getId()).orElse(null));
//        assertEquals(null, orderRepository.findById(id1).orElse(null));
//    }

    @Test
    void reacts_ok_when_removing_non_existent_object() {
        assertThrows(NullPointerException.class, () -> testCustomer.removeOrder(null));
        assertDoesNotThrow(() -> testCustomer.removeOrder(new Order("Spurious order")));
    }

}
