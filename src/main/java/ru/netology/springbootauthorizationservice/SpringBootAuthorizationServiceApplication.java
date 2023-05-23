package ru.netology.springbootauthorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.netology.springbootauthorizationservice.controller.AuthorizationController;
import ru.netology.springbootauthorizationservice.repository.UserRepository;
import ru.netology.springbootauthorizationservice.repository.UserRepositoryImpl;
import ru.netology.springbootauthorizationservice.service.AuthorizationService;

@SpringBootApplication
public class SpringBootAuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAuthorizationServiceApplication.class, args);
	}

	@Bean
	public AuthorizationService authorizationService(UserRepository userRepository) {
		return new AuthorizationService(userRepository);
	}

	@Bean
	public UserRepository userRepository() {
		// Возвращайте соответствующую реализацию UserRepository
		return new UserRepositoryImpl();
	}
}
