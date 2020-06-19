package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.controller.dto.OwnerRequestDto;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.dao.domain.Store;
import com.cafein.croissants.web.service.ClientService;
import com.cafein.croissants.web.service.MenuService;
import com.cafein.croissants.web.service.OwnerService;
import com.cafein.croissants.web.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MasterController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/master")  // master 메인페이지
    public String masterPage() {
        return "master-index";
    }

    @GetMapping("/master/allOwnerList") //master 전체 주인 보기
    public String masterOwnerList(Model model){
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "master-owners";
    }

    @GetMapping("/master/allStoreList") //master 전체 가게 보기
    public String masterStoreList(Model model){
        List<Store> stores = storeService.findAll();
        model.addAttribute("stores", stores);
        return "master-stores";
    }

    @GetMapping("/master/allClientList") //master 전체 고객 보기
    public String masterClientList(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "master-client";
    }
    @GetMapping("/master/notice") //master 전체 고객 보기
    public String masterNotice(){
        return "master-notice";
    }

}
