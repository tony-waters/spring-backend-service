package uk.bit1.spring_jpa_relationships.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import uk.bit1.spring_jpa_relationships.dto.ProductDto;
import uk.bit1.spring_jpa_relationships.entity.Customer;
import uk.bit1.spring_jpa_relationships.entity.Product;
import uk.bit1.spring_jpa_relationships.repository.CustomerRepository;
import uk.bit1.spring_jpa_relationships.repository.OrderRepository;
import uk.bit1.spring_jpa_relationships.repository.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;

    private ProductService productService;;

    private ProductDto testProductDto;

    @BeforeEach
    public void setUp() {
        productService = new ProductService(productRepository);
        testProductDto = new ProductDto(null, "Product Name", "product descriptipon here");
        testProductDto = productService.addNewProduct(testProductDto);
    }

    @AfterEach
    public void tearDown() {
        productService = null;
    }

    @Test
    void test_getProductById() {
        ProductDto product = productService.getProductById(testProductDto.id());
        System.out.println(product);
        assertEquals(testProductDto.id(), product.id());
        assertEquals("Product Name", product.name());
        assertEquals("product descriptipon here", product.description());
    }

}
