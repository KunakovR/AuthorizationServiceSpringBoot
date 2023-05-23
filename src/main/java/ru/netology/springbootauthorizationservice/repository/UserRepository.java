package ru.netology.springbootauthorizationservice.repository;

import ru.netology.springbootauthorizationservice.authorities.Authorities;
import java.util.List;

public interface UserRepository {

    List<Authorities> getUserAuthorities(String user, String password);

}
