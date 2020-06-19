package com.cafein.croissants.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 메인화면
    public String home() {
        return "index";
    }

    @GetMapping("/notice") // 공지사항
    public String notice() {
        return "notice";
    }

}
