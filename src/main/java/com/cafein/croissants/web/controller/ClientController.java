package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.ClientRequestDto;
import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.controller.dto.PointRequestDto;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RequestMapping("/client")
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/android/new")  // Android 새로운 client 등록
    public ResponseEntity clientregister(@RequestBody ClientRequestDto requestDto){
       clientService.register(requestDto);

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/android/login") // Android 에서 client Login 하기
    public ResponseEntity<Client> login(@RequestBody LoginRequestDto loginRequestDto) {
        Client client = clientService.findByEmail(loginRequestDto.getEmail())
                .checkPassword(loginRequestDto.getPassword());

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/android/addPoint") // Android에서 client point 추가하기
    public ResponseEntity<Client> addPoint(@RequestBody PointRequestDto pointRequestDto) {
        clientService.addPoint(pointRequestDto.getEmail(), pointRequestDto.getPoint());
        Client client = clientService.findByEmail(pointRequestDto.getEmail());

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/android/updatePassword") // Android에서 client point 추가하기
    public ResponseEntity<Client> addPoint(@RequestBody ClientRequestDto clientRequestDto) {
        clientService.updatePassword(clientRequestDto.getEmail(),clientRequestDto.getPassword());

        Client client = clientService.findByEmail(clientRequestDto.getEmail());

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
