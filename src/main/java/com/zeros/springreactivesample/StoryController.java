package com.zeros.springreactivesample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/stories")
    public Flux<Story> getAll() {
        return storyService.getAll();
    }

    @GetMapping("/stories/{id}")
    public Mono<Story> getOne(@PathVariable("id") String id) {
        return storyService.get(id);
    }

    @GetMapping(value = "/stories/{id}/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StoryEvent> events(@PathVariable("id") String id) {
        return storyService.events(id);
    }
}
