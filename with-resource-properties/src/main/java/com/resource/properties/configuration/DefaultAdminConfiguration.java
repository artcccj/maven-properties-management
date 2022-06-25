package com.resource.properties.configuration;

import com.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Configuration
public class DefaultAdminConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "sys.admin")
    public Admin admin() {
        return new Admin();
    }

    @Component
    public static class Initializer {

        @Resource
        private Admin admin;

        @PostConstruct
        public void initPrint() {
            log.warn(">>>>>> Admin is : {}", admin);
        }
    }
}
