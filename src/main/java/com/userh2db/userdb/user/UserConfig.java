package com.userh2db.userdb.user;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository)
    {
        return args -> {
            User sebastian = new User(
				"Sebastian",
				"Riedel",
				"rs@t-online.de"
			);
            User juli = new User(
				"Juli",
				"Zweig",
				"jz@t-online.de"
			);
            User dowi = new User(
				"Dom",
				"Wi",
				"dw@t-online.de"
			);

            repository.saveAll(List.of(sebastian, juli, dowi));
        };
    }
}
