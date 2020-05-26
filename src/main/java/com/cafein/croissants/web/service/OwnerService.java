package com.cafein.croissants.web.service;

import com.cafein.croissants.web.controller.dto.OwnerRequestDto;
import com.cafein.croissants.web.dao.OwnerDao;
import com.cafein.croissants.web.dao.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerDao ownerDao;

    public boolean register(OwnerRequestDto requestDto) {
        return ownerDao.insert(requestDto.toEntity()) > 0;
    }

    public List<Owner> findAll() {
        return ownerDao.findAll();
    }

    public Owner findByEmail(String email) {
        return ownerDao.findByEmail(email);
    }


}
