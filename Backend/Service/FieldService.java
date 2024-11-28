package com.pdm.farming.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdm.farming.Repository.FarmerRepository;
import com.pdm.farming.Repository.FieldRepository;

import jakarta.transaction.Transactional;

import com.pdm.farming.Entities.*;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private FarmerRepository farmerRepository;

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field getFieldById(Long fieldId) {
        return fieldRepository.findById(fieldId).orElse(null);
    }

    public Optional<Field> getFieldsByLocation(String location) {
        return fieldRepository.findByFieldLocation(location);
    }

    public Optional<Field> getFieldsByFarmer(Long farmerId) {
        return fieldRepository.findByFarmer_FarmerId(farmerId);
    }
    // Get fields by name
    public Optional<Field> getFieldsByName(String fieldName) {
        return fieldRepository.findByFieldName(fieldName);
    }

    // Create a new account
    @Transactional
    public Field createField(Field field) {
        Long farmerId = field.getFarmer().getFarmerId();

        // Ensure the Farmer exists
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
    
        // Set the Farmer in the Field entity
        field.setFarmer(farmer);
    
        // Save the Field entity
        return fieldRepository.save(field);
    }
    
    
    public void deleteField(Long fieldId) {
        fieldRepository.deleteById(fieldId);
    }
  /*   public Field updateField(Long fieldId, Field updatedField) {
    return fieldRepository.findById(fieldId).map(existingField -> {
        existingField.setFieldName(updatedField.getFieldName());
        existingField.setFieldLocation(updatedField.getFieldLocation());
        existingField.setFarmer(updatedField.getFarmer());  // Optional: update the associated farmer
        existingField.setSoils(updatedField.getSoils());    // Optional: update the list of soils
        return fieldRepository.save(existingField); // Save the updated field
    }).orElseThrow(() -> new IllegalArgumentException("Field not found!")); // Throw error if field not found
}*/
@Transactional
public Field updateField(Long fieldId, Field updatedField) {
    Field existingField = fieldRepository.findById(fieldId)
            .orElseThrow(() -> new IllegalArgumentException("Field not found"));

    // Update fields
    existingField.setFieldName(updatedField.getFieldName());
    existingField.setFieldLocation(updatedField.getFieldLocation());

    // If farmer is updated, fetch the farmer by ID and associate
    if (updatedField.getFarmer() != null) {
        Farmer farmer = farmerRepository.findById(updatedField.getFarmer().getFarmerId())
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
        existingField.setFarmer(farmer);
    }

    return fieldRepository.save(existingField);
    }
}


