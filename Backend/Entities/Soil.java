package com.pdm.farming.Entities;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "soil")
public class Soil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soil_id")
    private Long soilId;

    @Column(name = "soil_temperature")
    private Double soilTemperature;

    @Column(name = "ph_level")
    private Double pHLevel;

    @Column(name = "moisture_level")
    private Double moistureLevel;

    @Column(name = "record_at")
    private LocalDateTime recordAt;

    // Quan hệ 1-1 với Field
    @OneToOne
    @JoinColumn(name = "Field_id")
    private Field field;


    // Getter and Setter for soilId
    public Long getSoilId() {
        return soilId;
    }

    public void setSoilId(Long soilId) {
        this.soilId = soilId;
    }

    // Getter and Setter for soilTemperature
    public Double getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(Double soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    // Getter and Setter for pHLevel
    public Double getpHLevel() {
        return pHLevel;
    }

    public void setpHLevel(Double pHLevel) {
        this.pHLevel = pHLevel;
    }

    // Getter and Setter for moistureLevel
    public Double getMoistureLevel() {
        return moistureLevel;
    }

    public void setMoistureLevel(Double moistureLevel) {
        this.moistureLevel = moistureLevel;
    }

    // Getter and Setter for recordAt
    public LocalDateTime getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(LocalDateTime recordAt) {
        this.recordAt = recordAt;
    }

    // Getter and Setter for field
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}

