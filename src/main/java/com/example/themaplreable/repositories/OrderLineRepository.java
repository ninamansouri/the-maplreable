package com.example.themaplreable.repositories;


import com.example.themaplreable.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the OrderLine entity.
 */
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
