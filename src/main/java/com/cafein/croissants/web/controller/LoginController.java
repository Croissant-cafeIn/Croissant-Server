package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @GetMapping("/login") // Login 하기
    public String login() {
        return "login";
    }

    @PostMapping("/login")  //로그인하기
    public String login(LoginRequestDto loginRequestDto, Model model, HttpSession session) {
        log.info("loginDTo : {}, {}", loginRequestDto.getEmail(), loginRequestDto.getPassword());
        try { //로그인 성공
            Owner owner = loginService.doLogin(loginRequestDto);
            model.addAttribute("owner", owner);
            session.setAttribute("login", owner);

            if( owner.getEmail().equals("master@test.com"))  // Master일 경우 mster 메인페이지로 이동
                return "redirect:/master";

            return "redirect:/";
        } catch (IllegalArgumentException e) {  // 로그인 실패
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
