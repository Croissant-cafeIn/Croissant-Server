package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.ClientRequestDto;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/client")
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/android/new")
    public String registerPage() {
        return "client-signup";
    }

    @PostMapping("/android/new")  // Android 새로운 client 등록
    public ResponseEntity<Void> clientregister(@RequestBody ClientRequestDto requestDto){
       clientService.register(requestDto);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/list")  // Master 전체 client 정보 보기
    public String showClinets(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);

        return "client";
    }
}
