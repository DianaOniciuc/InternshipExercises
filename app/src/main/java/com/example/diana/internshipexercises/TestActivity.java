package com.example.diana.internshipexercises;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diana.internshipexercises.model.Post;
import com.example.diana.internshipexercises.server.ServiceProvider;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initview();

       // getPostSynchronously();
        getPostAsynchronously();
    }

    private void getPostAsynchronously() {
        ServiceProvider.createPostService().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               List<Post> posts = response.body();
                if(posts!=null){
                    Log.d(TAG, "there are: "+posts.size());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG,"error trying to get posts");
            }
        });
    }

    private void getPostSynchronously() {
        try {
           Response<List<Post>> response = ServiceProvider.createPostService().getPosts().execute();
           List<Post> posts = response.body();
           if(posts!=null){
               Log.d(TAG, "there are: "+posts.size());
           }
        } catch (IOException e) {
            Log.e(TAG,"error trying to get posts");
        }
    }

    private void initview() {

    }
}
