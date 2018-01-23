package com.example.lmlopez.retrofitpost;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lmlopez.retrofitpost.api.JSONPlaceholderAPI;
import com.example.lmlopez.retrofitpost.api.ServiceGenerator;
import com.example.lmlopez.retrofitpost.model.Post;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class NewPostActivity extends AppCompatActivity {

    EditText userId, title, body;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        userId = findViewById(R.id.editTextUserId);
        title = findViewById(R.id.editTextTitle);
        body = findViewById(R.id.editTextBody);

        btn_save = findViewById(R.id.buttonSave);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Post newPost = new Post();

                newPost.setUserId(Integer.parseInt(userId.getText().toString()));
                newPost.setTitle(title.getText().toString());
                newPost.setBody(body.getText().toString());

                new NewPostAsyncTask().execute(newPost);




            }
        });


    }

    private class NewPostAsyncTask extends AsyncTask<Post, Void, Post> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(NewPostActivity.this);

            // Set progress dialog style spinner
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            // Set the progress dialog title and message
            pd.setTitle("Retrofit POST");
            pd.setMessage("Posteando un nuevo post, valga la redundancia");

            pd.setIndeterminate(true);

            // Finally, show the progress dialog
            pd.show();
        }

        @Override
        protected Post doInBackground(Post... posts) {
            JSONPlaceholderAPI api = ServiceGenerator.createService(JSONPlaceholderAPI.class);

            Post result = null;

            for(Post newPost : posts) {
                Call<Post> call = api.sendPost(newPost);
                Response<Post> responseNewPost = null;
                try {
                    responseNewPost = call.execute();
                    result = responseNewPost.body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return result;

        }

        @Override
        protected void onPostExecute(Post post) {
            pd.dismiss();

            if (post != null) {
                finish();
            } else {
                Toast.makeText(NewPostActivity.this, "Error en el envío de datos", Toast.LENGTH_SHORT).show();
            }
        }


    }


}
