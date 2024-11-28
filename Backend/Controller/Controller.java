package com.pdm.farming.Layers;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdm.farming.Entities.Farmer;

@RestController
@RequestMapping("/api/farmers")
public class Controller {

    private final FarmerService farmerService;

    public Controller(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
        return ResponseEntity.ok(farmerService.createFarmer(farmer));
    }

    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Long id, @RequestBody Farmer farmer) {
        return ResponseEntity.ok(farmerService.updateFarmer(id, farmer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.noContent().build();
    }
}