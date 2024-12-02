package com.pdm.farming.Repository;





import com.pdm.farming.Entities.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Long> {
    Soil findByField_FieldId(Long fieldId); // Custom query to fetch Soil by Field ID
}

