package com.spring.actuator.features.configuration;/*
 *
 * Created by
 * Binkam Abhilash
 * on 20-February-2021
 * spring-actuator-features
 *
 */

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id="release-notes")
public class CustomActuatorEndPoint {

    Map<String, List<String>> releaseNotesMap = new HashMap<>();

    @PostConstruct
    private void init() {
        releaseNotesMap.put("version-1.0", Arrays.asList("Home Page Created", "Added Basic endpoint", "Added static data under /info endpoint"));
        releaseNotesMap.put("version-2.0", Arrays.asList("Added dynamic data to /indo endpoint","Spring Actuator added", "Added Custom Actuator endpoint"));
    }

    @ReadOperation
    private Map<String, List<String>> getReleaseNotes() {
        return releaseNotesMap;
    }

    @ReadOperation
    private List<String> getNotesByVersion(@Selector String version) {
        return releaseNotesMap.get(version);
    }

    @WriteOperation
    private void addReleaseNotes(String version, String releaseNotes) {
        
    }
}
