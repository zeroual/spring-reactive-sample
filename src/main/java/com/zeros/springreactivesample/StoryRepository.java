package com.zeros.springreactivesample;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StoryRepository extends ReactiveMongoRepository<Story, String> {
}
