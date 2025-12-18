package com.gismateaching.spring_boot_example.repository;

import com.gismateaching.spring_boot_example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, String> {
}
