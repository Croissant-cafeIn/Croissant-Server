package com.cafein.croissants.web.service;

import com.cafein.croissants.web.controller.dto.LoginRequestDto;
import com.cafein.croissants.web.dao.OwnerDao;
import com.cafein.croissants.web.dao.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private OwnerDao ownerDao;

    public Owner doLogin(LoginRequestDto loginRequestDto) {
        Owner owner = ownerDao.findByEmail(loginRequestDto.getEmail());
        return owner.validPassword(loginRequestDto.getPassword());
    }
}
