package com.codingblocks.restapi.models;

/**
 * Created by arnav on 9/10/2017.
 */

public class Post {
    Integer id;
    String title;
    String body;

    public Post(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
