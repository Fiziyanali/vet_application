package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.service.IOwnerService;
import com.vetApplication.beyzaClinic.service.IPetService;
import com.vetApplication.beyzaClinic.service.ISearchService;
import com.vetApplication.beyzaClinic.service.IUserService;
import com.vetApplication.beyzaClinic.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchServiceImpl searchService;
    private IOwnerService ownerService;
    private IPetService petService;

    public SearchController(SearchServiceImpl searchService, IOwnerService ownerService, IPetService petService) {
        this.searchService = searchService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/search")
    public String search(Model model, OwnerEntity ownerEntity, PetEntity petEntity,@Param("keyword") String keyword) {
        model.addAttribute("owners",ownerService.getAllOwners());
        model.addAttribute("pets",petService.getAllPets());
        List<PetEntity> list;
        if (keyword != null) {
            list = searchService.getByKeyword(keyword);
        }else {
            list = searchService.getAllPets();
        }
        model.addAttribute("list", list);
        return "search";
    }


}
