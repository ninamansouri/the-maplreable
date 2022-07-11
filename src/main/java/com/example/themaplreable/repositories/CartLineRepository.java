package com.example.themaplreable.repositories;

import com.example.themaplreable.model.CartLine;
import com.example.themaplreable.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Repository for the CartLine entity.
 */
@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {

    /**
     * Find cart line by productId
     */
    @Query("SELECT c FROM CartLine c WHERE c.productId.id = ?1")
    CartLine findByProductId(Long productId);
}
