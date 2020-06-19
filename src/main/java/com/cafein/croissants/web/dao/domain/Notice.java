package com.cafein.croissants.web.dao.domain;

import com.cafein.croissants.web.dao.domain.exception.PasswordMismatchException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Notice {
    private Integer id;
    private String email;
    private String password;
    private Integer point;

    public Notice(String email, String password, Integer point) {
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public Notice(Integer id, String email, String password, Integer point) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public Notice checkPassword(String password) {
        if(!password.equals(this.password)) {
            throw new PasswordMismatchException();
        }

        return this;
    }
}
