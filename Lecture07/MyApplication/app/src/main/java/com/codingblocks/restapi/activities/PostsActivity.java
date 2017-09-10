package com.codingblocks.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.adapters.PostsAdapter;
import com.codingblocks.restapi.models.Post;
import com.codingblocks.restapi.tasks.PostsDownloadTask;

import java.util.ArrayList;

import static android.view.View.GONE;

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPosts;
    ProgressBar pbPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        pbPosts = (ProgressBar) findViewById(R.id.pbPosts);
        pbPosts.setIndeterminate(true);

        rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        final PostsAdapter postsAdapter = new PostsAdapter(this);
        rvPosts.setAdapter(postsAdapter);

        new PostsDownloadTask(){
            @Override
            protected void onPostExecute(ArrayList<Post> posts) {
                super.onPostExecute(posts);
                postsAdapter.updatePosts(posts);
                pbPosts.setIndeterminate(false);
                pbPosts.setVisibility(GONE);
            }
        }.execute("http://jsonplaceholder.typicode.com/posts");


    }
}
