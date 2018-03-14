package com.zeros.springreactivesample;

import java.util.Date;

public class StoryEvent {
    private String storyId;
    private Date date;

    public StoryEvent() {
    }

    public StoryEvent(String storyId, Date date) {

        this.storyId = storyId;
        this.date = date;
    }

    public String getStoryId() {
        return storyId;
    }

    public Date getDate() {
        return date;
    }
}
