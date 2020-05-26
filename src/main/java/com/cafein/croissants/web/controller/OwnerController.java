package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.OwnerRequestDto;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/owner")
@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/new")  // 가게 주인 등록
    public String registerPage() {
        return "signup";
    }

    @PostMapping("/new")
    public String register(OwnerRequestDto requestDto) {
        ownerService.register(requestDto);
        return "redirect:/login";
    }

    @GetMapping("/list")  // Master 전체 주인 보기
    public String showOwners(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);

        return "owners";
    }
}
