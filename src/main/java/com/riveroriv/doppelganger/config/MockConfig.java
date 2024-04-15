package com.riveroriv.doppelganger.config;

import com.riveroriv.doppelganger.dto.Mock;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "api")
public class MockConfig {
    private Map<String, Mock> mocks;
}