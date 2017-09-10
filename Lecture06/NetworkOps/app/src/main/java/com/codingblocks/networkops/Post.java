package com.codingblocks.networkops;

/**
 * Created by arnav on 9/9/2017.
 */

public class Post {
    Integer id;
    String title;

    public Post(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
