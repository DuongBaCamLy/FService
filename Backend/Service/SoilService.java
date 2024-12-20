package com.pdm.farming.Service;
import com.pdm.farming.Entities.Soil;
import com.pdm.farming.Repository.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoilService {

    @Autowired
    private SoilRepository soilRepository;

    // Save or update soil
    public Soil saveSoil(Soil soil) {
        return soilRepository.save(soil);
    }

    // Fetch all soils
    public List<Soil> getAllSoils() {
        return soilRepository.findAll();
    }

    // Fetch soil by ID
    public Optional<Soil> getSoilById(Long soilId) {
        return soilRepository.findById(soilId);
    }

    // Update an existing soil record
    public Soil updateSoil(Long id, Soil updatedSoil) {
        Optional<Soil> existingSoilOpt = soilRepository.findById(id);

        if (existingSoilOpt.isPresent()) {
            Soil existingSoil = existingSoilOpt.get();
            existingSoil.setSoilTemperature(updatedSoil.getSoilTemperature());
            existingSoil.setpHLevel(updatedSoil.getpHLevel());
            existingSoil.setMoistureLevel(updatedSoil.getMoistureLevel());
            existingSoil.setRecordAt(updatedSoil.getRecordAt());
            existingSoil.setField(updatedSoil.getField());
            return soilRepository.save(existingSoil);
        } else {
            throw new RuntimeException("Soil with ID " + id + " not found");
        }
    }

    // Delete soil by ID
    public void deleteSoil(Long soilId) {
        soilRepository.deleteById(soilId);
    }

    // Fetch soil by Field ID
    public Soil getSoilByFieldId(Long fieldId) {
        return soilRepository.findByField_FieldId(fieldId);
    }
}

