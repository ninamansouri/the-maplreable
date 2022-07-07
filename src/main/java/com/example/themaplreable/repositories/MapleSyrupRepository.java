package com.example.themaplreable.repositories;


import com.example.themaplreable.model.MapleSyrup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the MapleSyrup entity.
 */
@Repository
public interface MapleSyrupRepository extends JpaRepository<MapleSyrup, Long> {
}
