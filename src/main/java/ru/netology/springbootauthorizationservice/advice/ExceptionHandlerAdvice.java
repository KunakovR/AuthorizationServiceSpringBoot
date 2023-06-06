package ru.netology.springbootauthorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springbootauthorizationservice.service.AuthorizationService;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(AuthorizationService.InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(AuthorizationService.InvalidCredentials ex) {
        String errorMessage = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(AuthorizationService.UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(AuthorizationService.UnauthorizedUser ex) {
        String errorMessage = ex.getMessage();
        System.out.println(errorMessage); // Выводим сообщение об ошибке в консоль
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }
}

