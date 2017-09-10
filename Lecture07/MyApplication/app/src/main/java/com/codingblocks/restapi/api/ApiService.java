package com.codingblocks.restapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arnav on 9/10/2017.
 */

public class ApiService {
    private ApiService () {}

    private static API api = null;

    public static API getAPI () {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(API.class);
        }

        return api;
    }
}
