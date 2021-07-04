package com.shadowJava.Springboot.l1.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    // Constructor
    public FeatureEndpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authenticated", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){ // @Selector can be used on a parameter of an @Endpoint method to indicate that the parameter is used to select a subset of the endpoint's data. i.e http://localhost:8080/actuator/features has {"Department":{"enabled":true},"Authenticated":{"enabled":false},"User":{"enabled":false}}, with @Selector we can use say http://localhost:8080/actuator/features/Department which lefts us view only subset info which is info for Departments only
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
