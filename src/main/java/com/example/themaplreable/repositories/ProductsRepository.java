package com.example.themaplreable.repositories;


import com.example.themaplreable.model.Product;
import com.example.themaplreable.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the MapleSyrup entity.
 */
@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    /**
     * Get one product by id
     */
    Optional<Product> findById(String productId);

    /**
     * Get products by syrup type
     */
    List<Product> findByType(Type type);

}
