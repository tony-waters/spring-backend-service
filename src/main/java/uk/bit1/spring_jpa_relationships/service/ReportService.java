package uk.bit1.spring_jpa_relationships.service;

import uk.bit1.spring_jpa_relationships.dto.ProductDto;
import uk.bit1.spring_jpa_relationships.entity.Product;
import uk.bit1.spring_jpa_relationships.repository.CustomerRepository;
import uk.bit1.spring_jpa_relationships.repository.OrderRepository;
import uk.bit1.spring_jpa_relationships.repository.ProductRepository;

public class ReportService {

    private final CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public ReportService(CustomerRepository customerRepository,
                         OrderRepository orderRepository,
                         ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public ProductDto getMostPopularProduct() {
        return null;
    }

    public long getCustomerCount() {
        return customerRepository.count();
    }

}
