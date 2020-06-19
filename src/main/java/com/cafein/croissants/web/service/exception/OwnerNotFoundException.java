package com.cafein.croissants.web.service.exception;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException() {
        super("owner 이름을 찾을 수 없습니다.");
    }

}
