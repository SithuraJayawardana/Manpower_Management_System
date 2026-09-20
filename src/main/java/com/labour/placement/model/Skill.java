package com.labour.placement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name", nullable = false, unique = true, length = 50)
    private String skillName;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "standard_daily_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal standardDailyRate = BigDecimal.ZERO;

    public Skill() {
    }

    public Skill(String skillName, String category, String description, BigDecimal standardDailyRate) {
        this.skillName = skillName;
        this.category = category;
        this.description = description;
        this.standardDailyRate = standardDailyRate;
    }

    public Skill(Long id, String skillName, String category, String description, BigDecimal standardDailyRate) {
        this.id = id;
        this.skillName = skillName;
        this.category = category;
        this.description = description;
        this.standardDailyRate = standardDailyRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStandardDailyRate() {
        return standardDailyRate;
    }

    public void setStandardDailyRate(BigDecimal standardDailyRate) {
        this.standardDailyRate = standardDailyRate;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", category='" + category + '\'' +
                ", standardDailyRate=" + standardDailyRate +
                '}';
    }
}
