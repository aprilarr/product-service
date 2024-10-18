package com.apri.product.service;

import com.apri.product.dto.ProductDto;
import com.apri.product.dto.ProductRequestDto;
import com.apri.product.entity.Product;
import com.apri.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto createProduct(ProductRequestDto productRequestDto) {
        var product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .status(Product.Status.PENDING)
                .build();
        productRepository.save(product);
        return productDtoBuilder(product);
    }

    private ProductDto productDtoBuilder(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().toString())
                .status(product.getStatus())
                .build();
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public ProductDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        var product = productRepository.findById(id).orElseThrow();
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        productRepository.save(product);
        return productDtoBuilder(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductPending() {
        return productRepository.findAllByStatus(Product.Status.PENDING);
    }

    public ProductDto approveProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        product.setStatus(Product.Status.APPROVED);
        productRepository.save(product);
        return productDtoBuilder(product);
    }

    public ProductDto rejectProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        product.setStatus(Product.Status.REJECTED);
        productRepository.save(product);
        return productDtoBuilder(product);
    }

}
