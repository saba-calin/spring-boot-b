package com.springboot.springbootb;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return this.softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return this.softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        this.softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id) {
        this.softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public void updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        this.softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
    }
}
