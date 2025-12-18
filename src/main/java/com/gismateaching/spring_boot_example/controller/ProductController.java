package com.gismateaching.spring_boot_example.controller;

import com.gismateaching.spring_boot_example.entity.Product;
import com.gismateaching.spring_boot_example.exception.ResourceNotFoundException;
import com.gismateaching.spring_boot_example.repository.IProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Product Management endpoints")
public class ProductController {

    private final IProductRepository IProductRepository;

    public ProductController(IProductRepository IProductRepository) {
        this.IProductRepository = IProductRepository;
    }
    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> getAllProducts() {
        return IProductRepository.findAll();
    }

    @Operation(summary = "Get product by ID")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return IProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Operation(summary = "Create a new product")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return IProductRepository.save(product);
    }

    @Operation(summary = "Update an existing product")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        Product product = IProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setUnitPrice(updatedProduct.getUnitPrice());
        product.setActive(updatedProduct.isActive());
        return IProductRepository.save(product);
    }

    @Operation(summary = "Delete a product")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        Product product = IProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        IProductRepository.delete(product);
    }
}
