package com.ourstore.dao.address;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan(basePackages = {"com.ourstore"})
@EntityScan(basePackages = {"com.ourstore/**"})
@Configuration
@EnableAutoConfiguration
public class DataConfig {
}
