package com.B4.IMS.repository;

import com.B4.IMS.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    
    // Custom method to search by serial number, type, brand, or status
    @Query("SELECT e FROM Equipment e WHERE LOWER(e.serialNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(e.deviceType) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(e.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(e.status) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Equipment> searchEquipment(@Param("keyword") String keyword);
}