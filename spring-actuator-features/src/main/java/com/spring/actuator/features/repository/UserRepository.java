package com.spring.actuator.features.repository;

import com.spring.actuator.features.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public interface UserRepository {

    public List<User> getAllUsers();
    public Long getUsersActiveStatus(String status);
}
