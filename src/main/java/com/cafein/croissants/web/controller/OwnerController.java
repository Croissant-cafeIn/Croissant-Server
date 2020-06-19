package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.controller.dto.OwnerRequestDto;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.dao.domain.Store;
import com.cafein.croissants.web.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owner")
@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/new")  // owner 등록
    public String registerPage() {
        return "signup";
    }

    @PostMapping("/new") // owner 등록
    public String register(OwnerRequestDto requestDto) {
        ownerService.register(requestDto);
        return "redirect:/login";
    }

    @PostMapping("/login") // Android에서 Owner Login 하기
    public ResponseEntity<Owner> login(@RequestBody LoginRequestDto loginRequestDto) {
        Owner owner = ownerService.findByEmail(loginRequestDto.getEmail())
                .checkPassword(loginRequestDto.getPassword());

        return new ResponseEntity<>(owner, HttpStatus.OK);
    }
}
