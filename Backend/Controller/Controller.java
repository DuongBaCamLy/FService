package com.pdm.farming.Controller;

import com.pdm.farming.Entities.Soil;
import com.pdm.farming.Service.SoilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soils")
public class Controller {

    @Autowired
    private SoilService soilService;

    // Create a new soil record
    @PostMapping
    public Soil createSoil(@RequestBody Soil soil) {
        return soilService.saveSoil(soil);
    }

    // Get a soil record by ID
    @GetMapping("/{id}")
    public Optional<Soil> getSoilById(@PathVariable Long id) {
        return soilService.getSoilById(id);
    }

    // Get all soil records
    @GetMapping
    public List<Soil> getAllSoils() {
        return soilService.getAllSoils();
    }

    // Update an existing soil record
    @PutMapping("/{id}")
    public Soil updateSoil(@PathVariable Long id, @RequestBody Soil updatedSoil) {
        return soilService.updateSoil(id, updatedSoil);
    }

    // Delete a soil record by ID
    @DeleteMapping("/{id}")
    public void deleteSoil(@PathVariable Long id) {
        soilService.deleteSoil(id);
    }

    // Get a soil record by Field ID
    @GetMapping("/field/{fieldId}")
    public Soil getSoilByFieldId(@PathVariable Long fieldId) {
        return soilService.getSoilByFieldId(fieldId);
    }
}


