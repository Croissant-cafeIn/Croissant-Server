package com.cafein.croissants.web.controller.advice;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorMessageDto {
    private String message;

    public ErrorMessageDto(String message) {
        this.message = message;
    }
}
