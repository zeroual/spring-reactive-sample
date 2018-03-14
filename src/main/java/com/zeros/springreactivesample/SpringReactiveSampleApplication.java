package com.zeros.springreactivesample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactiveSampleApplication {

    @Bean
    public CommandLineRunner initialise(StoryRepository storyRepository) {
        //storyRepository.deleteAll().block();
        return args -> Flux.just("hi", "salut", "coucou", "hello", "azoul", "marhaba")
                .map(Story::new)
                .map(story -> storyRepository.save(story).subscribe(System.out::println));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveSampleApplication.class, args);
    }
}
