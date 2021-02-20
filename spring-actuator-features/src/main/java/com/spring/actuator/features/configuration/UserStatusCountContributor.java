package com.spring.actuator.features.configuration;

/*
 *
 * Created by
 * Binkam Abhilash
 * on 20-February-2021
 * spring-actuator-features
 *
 */

import com.spring.actuator.features.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusMap = new HashMap<>();

        userStatusMap.put("Active", userRepository.getUsersActiveStatus("active"));
        userStatusMap.put("InActive", userRepository.getUsersActiveStatus("inactive"));

        builder.withDetail("userStatus", userStatusMap);
    }
}
