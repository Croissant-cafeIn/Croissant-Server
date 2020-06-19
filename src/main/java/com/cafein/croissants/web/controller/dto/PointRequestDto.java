package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PointRequestDto {
    private String email;
    private int point;

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }
}
