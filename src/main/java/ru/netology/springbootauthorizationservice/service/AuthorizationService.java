package ru.netology.springbootauthorizationservice.service;

import ru.netology.springbootauthorizationservice.authorities.Authorities;
import ru.netology.springbootauthorizationservice.repository.UserRepository;

import java.util.List;

public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<Authorities> str) {
        return str == null || str.isEmpty();
    }

    public class InvalidCredentials extends RuntimeException {
        public InvalidCredentials(String msg) {
            super(msg);
        }
    }

    public class UnauthorizedUser extends RuntimeException {
        public UnauthorizedUser(String msg) {
            super(msg);
        }
    }
}
