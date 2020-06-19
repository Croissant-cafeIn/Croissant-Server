package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.MenuRequestDto;
import com.cafein.croissants.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
public class NoticeController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/new/{storeId}")  // 새로운 메뉴 등록하기
    public String registerMenuPage(@PathVariable Integer storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "register-menu";
    }

    @PostMapping("/new/{storeId}")
    public String registerMenu(@PathVariable Integer storeId, MenuRequestDto menuRequestDto, Model model) {
        Integer id = menuService.register(menuRequestDto, storeId);
        model.addAttribute("storeId", id);

        return "redirect:/store/list/" + storeId;
    }

}
