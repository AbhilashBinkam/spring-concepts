package com.spring.actuator.features.repository;

import com.spring.actuator.features.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserRepositoryImpl implements UserRepository {


    @Override
    public List<User> getAllUsers() {
        return Stream.of(new User(200, "John", "john@gmail.com", "active"),
                new User(201, "Sam", "john@gmail.com", "inActive"),
                new User(210, "Paul", "john@gmail.com", "active"),
                new User(240, "Rambo", "john@gmail.com", "inActive")).collect(Collectors.toList());
    }

    @Override
    public Long getUsersActiveStatus(String status) {
        return getAllUsers().stream().filter(user -> user.getStatus().equalsIgnoreCase(status)).count();
    }
}
