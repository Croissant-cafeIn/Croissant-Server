package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClientRequestDto {
    private String email;
    private String password;
    private int point;

    public Client toEntity() {
        return new Client(email, password, point);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPoint() {
        return point;
    }
}
