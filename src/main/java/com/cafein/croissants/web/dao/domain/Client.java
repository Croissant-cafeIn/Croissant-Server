package com.cafein.croissants.web.dao.domain;

import com.cafein.croissants.web.dao.domain.exception.PasswordMismatchException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Client {
    private Integer id;
    private String email;
    private String password;
    private Integer point;

    public Client(String email, String password, Integer point) {
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public Client(Integer id, String email, String password, Integer point) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public Client checkPassword(String password) {
        if(!password.equals(this.password)) {
            throw new PasswordMismatchException();
        }

        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPoint() {
        return point;
    }
}
