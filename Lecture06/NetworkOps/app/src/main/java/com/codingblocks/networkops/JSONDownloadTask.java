package com.codingblocks.networkops;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by arnav on 9/9/2017.
 */

public class JSONDownloadTask extends AsyncTask<String, Void, ArrayList<Post>> {
    @Override
    protected ArrayList<Post> doInBackground(String... strings) {
        String data = null;
        ArrayList<Post> postsList = new ArrayList<>();

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(is);
            StringBuilder sb = new StringBuilder();
            String buffer = "";
            while (buffer != null) {
                sb.append(buffer);
                buffer = br.readLine();
            }
            data = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        try {
            JSONArray postJsonArray = new JSONArray(data);
            for (int i = 0; i < postJsonArray.length(); i++) {
                JSONObject postJsonObj = postJsonArray.getJSONObject(i);
                Post post = new Post(
                        postJsonObj.getInt("id"),
                        postJsonObj.getString("title")
                );
                postsList.add(post);
            }
            return postsList;
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
