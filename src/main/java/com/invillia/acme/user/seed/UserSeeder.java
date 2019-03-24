package com.invillia.acme.user.seed;

import com.invillia.acme.user.entity.User;
import com.invillia.acme.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class UserSeeder {

    @Bean(name = "userSeederBean")
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            for (int i = 0; i < 10; i ++){
                log.info("Preloading " + repository.save(new User("User Name", "user e-mail", "123456")));
            }
        };
    }
}
