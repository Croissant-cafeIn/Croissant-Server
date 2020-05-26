package com.cafein.croissants.web.dao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Client {
    private Integer id;
    private String email;
    private String password;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    public Client validPassword(String password) {
        if (this.password.equals(password)) {
            return this;
        }

        throw new IllegalArgumentException("비밀번호가 들립니다.");
    }
}
