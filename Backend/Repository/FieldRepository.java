package com.pdm.farming.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdm.farming.Entities.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
    
    // Custom Query Methods (if needed)
    
    // Find all fields by field location
    Optional<Field> findByFieldLocation(String fieldLocation);
    
    // Find all fields by farmer ID
    Optional<Field> findByFarmer_FarmerId(Long farmerId);

    // Find all fields by field name
    Optional<Field> findByFieldName(String fieldName);

    // Check existence by FieldLocation
    boolean existsByFieldLocation(String fieldLocation);
}
