package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import com.vetApplication.beyzaClinic.service.IOwnerService;
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
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    public OwnerController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String getOwners(Model model, OwnerEntity OwnerEntity) {
        model.addAttribute("owners",ownerService.getAllOwners());
        return "owners";
    }

    @PostMapping(value="/deleteOwner/{id}")
    public String deleteOwnerById(@PathVariable Long id, RedirectAttributes atts) {
        try {
            atts.addFlashAttribute("message", "Kişi silindi!");
            atts.addFlashAttribute("alertClass", "alert-success");
            ownerService.deleteOwnerById(id);
            return "redirect:/owners";
        } catch(Exception e){
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/owners";
        }
    }

    @PostMapping("/addOwner")
    public String createOwner(@Valid @ModelAttribute("OwnerEntity") OwnerEntity OwnerEntity, BindingResult result, RedirectAttributes atts) {
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/owners";
        }
        atts.addFlashAttribute("message", "Kişi başarıyla eklendi!");
        atts.addFlashAttribute("alertClass", "alert-success");
        ownerService.createOwner(OwnerEntity);
        return "redirect:/owners";
    }

    @PostMapping("/updateOwner/{id}")
    public String updateOwner(@Valid @ModelAttribute("OwnerEntity") OwnerEntity OwnerEntity, BindingResult result, RedirectAttributes atts, Long id) {
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/owners";
        }
        atts.addFlashAttribute("message", "Kişi güncellendi!");
        atts.addFlashAttribute("alertClass", "alert-success");
        ownerService.updateOwnerById(OwnerEntity);
        return "redirect:/owners";
    }
}
