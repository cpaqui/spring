package com.paqui.openBankRestAPI.configuration;

import com.paqui.openBankRestAPI.bean.repository.OpenBankRepository;
import com.paqui.openBankRestAPI.bean.repository.OpenBankRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cpaqui.openBankRestAPI")
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Bean
    public OpenBankRepository openBankRepository () {
        return new OpenBankRepositoryImpl(new RestTemplate());
    }
}