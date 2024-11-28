package com.pdm.farming.Layers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pdm.farming.Entities.Farmer;
import com.pdm.farming.repository.FarmerRepository;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found"));
    }

    public Farmer updateFarmer(Long id, Farmer updatedFarmer) {
        Farmer existingFarmer = getFarmerById(id);
        existingFarmer.setEmail(updatedFarmer.getEmail());
        existingFarmer.setProfileStatus(updatedFarmer.getProfileStatus());
        existingFarmer.setFirstName(updatedFarmer.getFirstName());
        existingFarmer.setLastName(updatedFarmer.getLastName());
        existingFarmer.setFarmLocation(updatedFarmer.getFarmLocation());
        existingFarmer.setPhoneNumber(updatedFarmer.getPhoneNumber());
        return farmerRepository.save(existingFarmer);
    }

    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }
}
