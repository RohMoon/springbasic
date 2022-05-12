package com.basic.environment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/app.properties")
public class TestConfig {

}
