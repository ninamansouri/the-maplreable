package com.example.themaplreable.repositories;

import com.example.themaplreable.model.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the CartLine entity.
 */
@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {
}
