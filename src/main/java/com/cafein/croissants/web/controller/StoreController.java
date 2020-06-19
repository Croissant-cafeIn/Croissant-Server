package com.cafein.croissants.web.controller;

import com.cafein.croissants.web.controller.dto.StoreRequestDto;
import com.cafein.croissants.web.dao.domain.Menu;
import com.cafein.croissants.web.dao.domain.Owner;
import com.cafein.croissants.web.dao.domain.Store;
import com.cafein.croissants.web.service.MenuService;
import com.cafein.croissants.web.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/store")
@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/new")  //  store register
    public String registerStorePage() {
        return "register-store";
    }

    @PostMapping("/new")  // store register
    public String registerStore(StoreRequestDto storeRequestDto, HttpSession session) {
        Owner owner = (Owner) session.getAttribute("login");
        if(owner == null) {
            return "redirect:/login";
        }
        Integer id = storeService.register(storeRequestDto, owner.getId());

        return "redirect:/store/list/" + id;
    }
    @GetMapping("/mypage")  // 나의 전체 가게 리스트 조회
    public String getMyStores(Model model, HttpSession session) {
        Owner owner = (Owner) session.getAttribute("login");
        if(owner == null) {
            return "redirect:/login";
        }
        List<Store> stores = storeService.findAll(owner.getId());
        model.addAttribute("stores", stores);

        return "mypage";
    }

//    @GetMapping("/list")  // 나의 전체 가게 리스트 보기
//    public String getStores(Model model, HttpSession session) {
//        Owner owner = (Owner) session.getAttribute("login");
//        if(owner == null) {
//            return "redirect:/login";
//        }
//        List<Store> stores = storeService.findAll(owner.getId());
//        model.addAttribute("stores", stores);
//
//        return "store-list";
//    }

    @GetMapping("/list/{storeId}")  // (가게 등록 후) 나의 가게 상세 조회
    public String getStore(@PathVariable Integer storeId, Model model, HttpSession session) {
        Owner owner = (Owner) session.getAttribute("login");
        if(owner == null) {
            return "redirect:/login";
        }
        Store store = storeService.findById(storeId);
        model.addAttribute("store", store);

        List<Menu> menus = menuService.findAll(storeId);
        model.addAttribute("menus", menus);

        return "store-detail";
    }

    @GetMapping("/allList")  // 이용현황 (전체 가게 리스트 조회)
    public String getALLStores(Model model) {
        List<Store> stores = storeService.findAll();
        model.addAttribute("stores", stores);

        return "status";
    }

    @GetMapping("/android/list")  //Android - 이용현황 (가게 전체 정보 보내주기)
    public ResponseEntity<List<Store>> getAllStoresAd(Model model) {
        List<Store> stores = storeService.findAll();
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }

    @GetMapping("/android/list/{storeId}") //Android - 가게 메뉴 정보 보내주기
    public ResponseEntity<List<Menu>> getStoreMenuAd(@PathVariable Integer storeId, Model model) {
        List<Menu> menus = menuService.findAll(storeId);
        model.addAttribute("menus", menus);

        return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
    }

    @GetMapping("/android/{ownerId}/storeList")  // Android-Owner에서 나의 전체 가게 리스트 보기
    public ResponseEntity<List<Store>> getMystore(@PathVariable Integer ownerId, Model model) {

        List<Store> stores = storeService.findAll(ownerId);
        model.addAttribute("stores", stores);

        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }
    @GetMapping("/android/{storeId}/storeList/{congestion}")  // Android-Owner에서 가게 혼잡도 바꾸기
    public ResponseEntity<Store> updateCongestion(@PathVariable Integer storeId, @PathVariable Integer congestion, Model model) {

        storeService.updateCongestion(storeId, congestion); // 가게 혼잡도 바꾸기

        Store store= storeService.findById(storeId);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}
