package com.cafein.croissants.web.service.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("client 이름을 찾을 수 없습니다.");
    }

}
