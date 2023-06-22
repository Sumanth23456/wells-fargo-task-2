package com.wellsfargo.counselor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.wellsfargo.counselor.repository.AdvisorRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Entrypoint {

    public static void main(String[] args) {
    	ConfigurableApplicationContext context= SpringApplication.run(Entrypoint.class, args);
    	AdvisorRepository ar=context.getBean(AdvisorRepository.class);


    }

}
