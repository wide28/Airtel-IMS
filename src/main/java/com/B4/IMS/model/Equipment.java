package com.B4.IMS.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String deviceType; // e.g., Laptop, Desktop, Mobile Phone

    private String brand;
    private String model;
    
    @Column(nullable = false)
    private String status; // e.g., AVAILABLE, ASSIGNED, MAINTENANCE

    private LocalDate dateAdded;

    // Default Constructor
    public Equipment() {
        this.dateAdded = LocalDate.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateAdded() { return dateAdded; }
    public void setDateAdded(LocalDate dateAdded) { this.dateAdded = dateAdded; }
}