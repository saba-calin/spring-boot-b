package com.springboot.springbootb;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techStack;
    @Column(columnDefinition = "TEXT")
    private String recommendation;

    public SoftwareEngineer() {

    }

    public SoftwareEngineer(String recommendation, String techStack, String name, Integer id) {
        this.recommendation = recommendation;
        this.techStack = techStack;
        this.name = name;
        this.id = id;
    }

    public SoftwareEngineer(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer engineer = (SoftwareEngineer) o;
        return Objects.equals(id, engineer.id) && Objects.equals(name, engineer.name) && Objects.equals(techStack, engineer.techStack) && Objects.equals(recommendation, engineer.recommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack, recommendation);
    }
}
