package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;
@Configuration
public class FaircorpApplicationConfig {

    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService Gs){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Gs.greet("String");
            }
        };
    }
}
