package com.cafein.croissants.web.service;

import com.cafein.croissants.web.controller.dto.MenuRequestDto;
import com.cafein.croissants.web.dao.MenuDao;
import com.cafein.croissants.web.dao.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public Integer register(MenuRequestDto menuRequestDto, Integer storeId) {
        Menu newMenu = menuRequestDto.toEntity(storeId);
        return menuDao.insert(newMenu);
    }

    public List<Menu> findAll(Integer storeId) {
        return menuDao.findAll(storeId);
    }
}
