package uk.bit1.spring_backend_services.service;

import uk.bit1.spring_backend_services.dto.ProductDto;
import uk.bit1.spring_backend_services.repository.CustomerRepository;
import uk.bit1.spring_backend_services.repository.OrderRepository;
import uk.bit1.spring_backend_services.repository.ProductRepository;

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
