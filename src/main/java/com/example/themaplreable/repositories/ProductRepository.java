package com.example.themaplreable.repositories;


import com.example.themaplreable.model.Product;
import com.example.themaplreable.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the MapleSyrup entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Get one product by id
     */
    Product findById(String productId);

    /**
     * Get products by syrup type
     */
    List<Product> findByType(Type type);

}
