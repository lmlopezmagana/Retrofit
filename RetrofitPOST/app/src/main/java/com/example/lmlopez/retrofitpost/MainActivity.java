package com.example.lmlopez.retrofitpost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lmlopez.retrofitpost.api.JSONPlaceholderAPI;
import com.example.lmlopez.retrofitpost.api.ServiceGenerator;
import com.example.lmlopez.retrofitpost.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btn_nuevo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        JSONPlaceholderAPI api = ServiceGenerator.createService(JSONPlaceholderAPI.class);

        Call<List<Post>> call = api.getAllPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.code() == 200) {
                    List<Post> result = response.body();
                    listView.setAdapter(new ArrayAdapter<Post>(MainActivity.this, android.R.layout.simple_list_item_1, result));
                } else {
                    Toast.makeText(MainActivity.this, "No se han encontrado datos", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //TODO
            }
        });

        btn_nuevo = findViewById(R.id.button);

        btn_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewPostActivity.class));
            }
        });

    }
}
