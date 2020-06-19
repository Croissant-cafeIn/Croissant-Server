package com.cafein.croissants.web.service;

import com.cafein.croissants.web.controller.dto.ClientRequestDto;
import com.cafein.croissants.web.dao.ClientDao;
import com.cafein.croissants.web.dao.domain.Client;
import com.cafein.croissants.web.service.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public boolean register(ClientRequestDto requestDto) {
        return clientDao.insert(requestDto.toEntity()) > 0;
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findByEmail(String email) {
        try {
            return clientDao.findByEmail(email);
        } catch (Exception e) {
            throw new ClientNotFoundException();
        }
    }

    public void addPoint(String email, int point) {
        clientDao.addPoint(email, point);
    }

    public void minusPoint(Integer client_id, int point) {
        clientDao.minusPoint(client_id, point);
    }

    public void updatePassword(String email, String password) {
        clientDao.updatePassword(email, password);
    }
}
