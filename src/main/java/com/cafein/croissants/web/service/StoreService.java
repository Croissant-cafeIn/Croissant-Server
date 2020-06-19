package com.cafein.croissants.web.service;

import com.cafein.croissants.web.controller.dto.StoreRequestDto;
import com.cafein.croissants.web.dao.StoreDao;
import com.cafein.croissants.web.dao.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    public Integer register(StoreRequestDto storeRequestDto, Integer ownerId) {
        Store newStore = storeRequestDto.toEntity(ownerId);
        return storeDao.insert(newStore);
    }
    public List<Store> findAll() {
        return storeDao.findAll();
    }

    public List<Store> findAll(Integer ownerId) {
        return storeDao.findAll(ownerId);
    }

    public Store findById(Integer storeId) {
        return storeDao.findById(storeId);
    }

    public void updateCongestion(Integer storeId, Integer congestion) {
        storeDao.updateCongestion(storeId, congestion);
    }
}
