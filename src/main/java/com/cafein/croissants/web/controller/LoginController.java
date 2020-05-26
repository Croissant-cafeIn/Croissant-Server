package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login") // Login 하기
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginRequestDto loginRequestDto, Model model, HttpSession session) {
        try {
            Owner owner = loginService.doLogin(loginRequestDto);
            model.addAttribute("owner", owner);
            session.setAttribute("login", owner);

            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")  // 로그아웃
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
