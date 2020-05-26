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

    public Client toEntity() {
        return new Client(email, password);
    }
}
