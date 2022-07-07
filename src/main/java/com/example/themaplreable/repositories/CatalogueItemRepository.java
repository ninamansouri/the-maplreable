package com.example.themaplreable.repositories;


import com.example.themaplreable.model.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the CatalogueItem entity.
 */
@Repository
public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Long> {

}
