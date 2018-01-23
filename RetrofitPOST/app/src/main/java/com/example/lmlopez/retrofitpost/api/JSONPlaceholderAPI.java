package com.example.lmlopez.retrofitpost.api;

import com.example.lmlopez.retrofitpost.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lmlopez on 23/01/2018.
 */

public interface JSONPlaceholderAPI {


    @GET("/posts")
    public Call<List<Post>> getAllPosts();

    @GET("/posts/{id}")
    public Call<Post> getPostById(@Path("id") Integer id);

    @POST("/posts")
    public Call<Post> sendPost(@Body Post newPost);


}
