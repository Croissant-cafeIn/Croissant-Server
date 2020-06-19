package com.cafein.croissants.web.dao.domain.exception;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super("비밀번호가 맞지 않습니다.");
    }
}
