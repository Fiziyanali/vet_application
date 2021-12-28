package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import com.vetApplication.beyzaClinic.service.IOwnerService;
import com.vetApplication.beyzaClinic.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PetController {
    @Autowired
    private IPetService petService;
    private IOwnerService ownerService;

    public PetController(IPetService petService, IOwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @GetMapping("/pets")
    public String getPets(Model model, PetEntity PetEntity, OwnerEntity ownerEntity) {
        model.addAttribute("pets",petService.getAllPets());
        model.addAttribute("owners",ownerService.getAllOwners());
        return "pets";
    }

    @PostMapping(value="/deletePet/{id}")
    public String deletePetById(@PathVariable Long id, RedirectAttributes atts) {
        try {
            atts.addFlashAttribute("message", "Hayvan silindi!");
            atts.addFlashAttribute("alertClass", "alert-success");
            petService.deletePetById(id);
            return "redirect:/pets";
        } catch(Exception e){
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/pets";
        }
    }

    @PostMapping("/addPet")
    public String createPet(@Valid @ModelAttribute("PetEntity") PetEntity PetEntity, BindingResult result, RedirectAttributes atts) {
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/pets";
        }
        atts.addFlashAttribute("message", "Hayvan başarıyla eklendi!");
        atts.addFlashAttribute("alertClass", "alert-success");
        petService.createPet(PetEntity);
        return "redirect:/pets";
    }

    @PostMapping("/updatePet/{id}")
    public String updatePet(@Valid @ModelAttribute("PetEntity") PetEntity PetEntity, BindingResult result, RedirectAttributes atts, Long id) {
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/pets";
        }
        atts.addFlashAttribute("message", "Hayvan güncellendi!");
        atts.addFlashAttribute("alertClass", "alert-success");
        petService.updatePetById(PetEntity);
        return "redirect:/pets";
    }
}
