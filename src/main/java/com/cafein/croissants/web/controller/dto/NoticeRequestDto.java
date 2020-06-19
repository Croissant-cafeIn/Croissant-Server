package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NoticeRequestDto {
    private String email;
    private String name;
    private String password;

    public Owner toEntity() {
        return new Owner(email, name, password);
    }
}
