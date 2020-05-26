package com.cafein.croissants.web.dao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Owner {
    private Integer id;
    private String email;
    private String name;
    private String password;

    public Owner(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Owner(Integer id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public Owner validPassword(String password) {
        if (this.password.equals(password)) {
            return this;
        }

        throw new IllegalArgumentException("비밀번호가 들립니다.");
    }
}
