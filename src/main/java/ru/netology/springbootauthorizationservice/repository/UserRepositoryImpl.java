package ru.netology.springbootauthorizationservice.repository;

import ru.netology.springbootauthorizationservice.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        // Реализация метода для возврата разрешений пользователя или пустого списка

        // Проверяем логин и пароль пользователя
        if ("admin".equals(user) && "admin123".equals(password)) {
            // Возвращаем список разрешений для пользователя "admin"
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(user) && "user123".equals(password)) {
            // Возвращаем список разрешений для пользователя "user"
            return List.of(Authorities.READ);
        } else {
            // Если пользователь не найден, возвращаем пустой список
            return new ArrayList<>();
        }
    }
}
