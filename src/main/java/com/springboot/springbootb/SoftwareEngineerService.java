package com.springboot.springbootb;

import jakarta.persistence.Transient;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return this.softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the programming teach stack %s that %s has given,
                provide a full learning path and recommendations for the person.
                Make it 250 characters long.
                """.formatted(softwareEngineer.getTechStack(), softwareEngineer.getName());
        String response = this.aiService.chat(prompt);

        softwareEngineer.setRecommendation(response);
        this.softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return this.softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        if (!this.softwareEngineerRepository.existsById(id)) {
            throw new IllegalStateException(id + " not found");
        }
        this.softwareEngineerRepository.deleteById(id);
    }

    @Transactional
    public void updateSoftwareEngineer(Integer id, SoftwareEngineer softwareEngineer) {
        SoftwareEngineer engineer = this.softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
        engineer.setName(softwareEngineer.getName());
        engineer.setTechStack(softwareEngineer.getTechStack());
    }
}
