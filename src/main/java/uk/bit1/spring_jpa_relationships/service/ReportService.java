package uk.bit1.spring_jpa_relationships.service;

import uk.bit1.spring_jpa_relationships.repository.CustomerRepository;

public class ReportService {

    private CustomerRepository customerRepository;

    public ReportService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    public Product getMostPopularProduct() {
//        return null;
//    }

    public long getCustomerCount() {
        return customerRepository.count();
    }

}
