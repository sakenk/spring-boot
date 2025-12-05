package com.amigoscode.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public List<SoftwareEngineer> getAllSoftwareEngineerById(Integer id) {
        SoftwareEngineer se = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new java.util.NoSuchElementException("SoftwareEngineer with id " + id + " not found"));
        return List.of(se);
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("SoftwareEngineer with id " + id + " does not exist");
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(
            Integer id,
            SoftwareEngineer softwareEngineer) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new java.util.NoSuchElementException("SoftwareEngineer with id " + id + " not found"));
        existingEngineer.setName(softwareEngineer.getName());
        existingEngineer.setTechStack(softwareEngineer.getTechStack());
        softwareEngineerRepository.save(existingEngineer);
    }
}
