package com.invillia.acme.store.seed;

import com.invillia.acme.store.entity.Store;
import com.invillia.acme.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class StoreSeeder {

    @Bean(name = "storeSeederBean")
    CommandLineRunner initDatabase(StoreRepository repository) {
        return args -> {
            for (int i = 0; i < 10; i ++){
                log.info("Preloading " + repository.save(new Store("Company 001", "Address 1")));
                log.info("Preloading " + repository.save(new Store("Company 002", "Address 2")));
            }
        };
    }
}