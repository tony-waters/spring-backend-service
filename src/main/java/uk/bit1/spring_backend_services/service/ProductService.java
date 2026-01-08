package uk.bit1.spring_backend_services.service;

import uk.bit1.spring_backend_services.dto.ProductDto;
import uk.bit1.spring_backend_services.entity.Product;
import uk.bit1.spring_backend_services.repository.ProductRepository;

import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto getProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return convertToDto(product.get());
    }

    public ProductDto addNewProduct(ProductDto productDto) {
        Product product = productRepository.save(convertFromDto(productDto));
        return convertToDto(product);
    }

    private Product convertFromDto(ProductDto productDto) {
        return new Product(
                productDto.name(),
                productDto.description()
        );
    }

    private ProductDto convertToDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getDescription()
        );
    }

}
