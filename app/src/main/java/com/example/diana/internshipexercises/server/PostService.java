package com.example.diana.internshipexercises.server;

import com.example.diana.internshipexercises.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
