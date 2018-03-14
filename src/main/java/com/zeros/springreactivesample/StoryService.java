package com.zeros.springreactivesample;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    Mono<Story> get(String id) {
        return storyRepository.findById(id);
    }

    Flux<Story> getAll() {
        return storyRepository.findAll();
    }

    public Flux<StoryEvent> events(String storyId) {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<StoryEvent> storyEvents = Flux.fromStream(Stream.generate(() -> new StoryEvent(storyId, new Date())));
        return Flux.zip(interval, storyEvents).map(Tuple2::getT2);
    }
}
