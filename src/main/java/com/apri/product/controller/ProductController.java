package com.apri.product.controller;

import com.apri.product.dto.ProductDto;
import com.apri.product.dto.ProductRequestDto;
import com.apri.product.entity.Product;
import com.apri.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductDto>  createProduct(
            @RequestBody @Validated ProductRequestDto productRequestDto
    ) {
        var product =  productService.createProduct(productRequestDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProduct();
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(
            @PathVariable Long id
    ) {
        return productService.getProductById(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody @Validated ProductRequestDto productRequestDto
    ) {
        var product = productService.updateProduct(id, productRequestDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/pending")
    public List<Product> getProductPending() {
        return productService.getProductPending();
    }

    @PutMapping("/products/{id}/approve")
    public ResponseEntity<ProductDto> approveProduct(
            @PathVariable Long id
    ) {
        var product = productService.approveProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/products/{id}/reject")
    public ResponseEntity<ProductDto> rejectProduct(
            @PathVariable Long id
    ) {
        var product = productService.rejectProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
