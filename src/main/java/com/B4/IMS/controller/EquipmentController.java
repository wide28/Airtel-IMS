package com.B4.IMS.controller;

import com.B4.IMS.model.Equipment;
import com.B4.IMS.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    // 1. Show the Add Equipment Form
    @GetMapping("/equipment/add")
    public String showAddEquipmentForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "add-equipment";
    }

    // 2. Save the New Equipment
    @PostMapping("/equipment/add")
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        equipmentRepository.save(equipment);
        return "redirect:/dashboard";
    }

    // 3. Show the Edit Form (Loads existing data based on ID)
    @GetMapping("/equipment/edit/{id}")
    public String showEditEquipmentForm(@PathVariable("id") Long id, Model model) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid equipment Id:" + id));
        model.addAttribute("equipment", equipment);
        return "edit-equipment"; // We will create this file next
    }

    // 4. Save the Updated Equipment
    @PostMapping("/equipment/update/{id}")
    public String updateEquipment(@PathVariable("id") Long id, @ModelAttribute("equipment") Equipment equipment) {
        equipment.setId(id); // Ensure we update the existing record, not create a new one
        equipmentRepository.save(equipment);
        return "redirect:/dashboard";
    }

    // 5. Delete Equipment
    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable("id") Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid equipment Id:" + id));
        equipmentRepository.delete(equipment);
        return "redirect:/dashboard";
    }
}