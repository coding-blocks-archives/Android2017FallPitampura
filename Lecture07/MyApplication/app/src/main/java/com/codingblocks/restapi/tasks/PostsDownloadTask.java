package com.codingblocks.restapi.tasks;

import android.os.AsyncTask;

import com.codingblocks.restapi.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by arnav on 9/10/2017.
 */

public class PostsDownloadTask extends
        AsyncTask<String, Void, ArrayList<Post>> {
//    URL url = null;
//
//    public PostsDownloadTask(String url) throws MalformedURLException {
//        this.url = new URL(url);
//    }
//
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }

    @Override
    protected ArrayList<Post> doInBackground(String... strings) {
        String data = null;
        ArrayList<Post> posts = new ArrayList<>();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String buf = "";

            while (buf != null) {
                sb.append(buf);
                buf = br.readLine();
            }

            data = sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONArray postsJSONArray = new JSONArray(data);
            for (int i = 0; i < postsJSONArray.length(); i++) {
                JSONObject postJSONObject = postsJSONArray.getJSONObject(i);

                posts.add(new Post(
                        postJSONObject.getInt("id"),
                        postJSONObject.getString("title"),
                        postJSONObject.getString("body")
                ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
