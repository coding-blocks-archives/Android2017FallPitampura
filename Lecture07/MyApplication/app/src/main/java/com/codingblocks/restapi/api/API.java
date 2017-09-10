package com.codingblocks.restapi.api;

import com.codingblocks.restapi.models.Post;
import com.codingblocks.restapi.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arnav on 9/10/2017.
 */

public interface API {

    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/users/{userId}")
    Call<User> getUserById(@Path("userId") int userId);

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/posts")
    Call<ArrayList<Post>> getPostsOfUser(@Query("userId") int userId);
}

