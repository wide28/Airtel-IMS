package com.B4.IMS.controller;

import com.B4.IMS.model.Equipment;
import com.B4.IMS.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    // 1. Updated Dashboard to handle Search functionality
    @GetMapping("/dashboard")
    public String showDashboard(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Equipment> equipmentList;
        
        // If a search term was entered, use the custom search method. Otherwise, show all.
        if (keyword != null && !keyword.isEmpty()) {
            equipmentList = equipmentRepository.searchEquipment(keyword);
        } else {
            equipmentList = equipmentRepository.findAll();
        }
        
        model.addAttribute("equipments", equipmentList);
        model.addAttribute("keyword", keyword); // Keeps the typed word in the search box
        return "dashboard";
    }

    // 2. New Reports Dashboard
    @GetMapping("/reports")
    public String showReports(Model model) {
        List<Equipment> allEquipment = equipmentRepository.findAll();
        
        // Calculate basic statistics for the report
        long total = allEquipment.size();
        long available = allEquipment.stream().filter(e -> "AVAILABLE".equals(e.getStatus())).count();
        long assigned = allEquipment.stream().filter(e -> "ASSIGNED".equals(e.getStatus())).count();
        long maintenance = allEquipment.stream().filter(e -> "MAINTENANCE".equals(e.getStatus())).count();
        long broken = allEquipment.stream().filter(e -> "BROKEN".equals(e.getStatus())).count();

        model.addAttribute("total", total);
        model.addAttribute("available", available);
        model.addAttribute("assigned", assigned);
        model.addAttribute("maintenance", maintenance);
        model.addAttribute("broken", broken);
        
        return "reports";
    }
}