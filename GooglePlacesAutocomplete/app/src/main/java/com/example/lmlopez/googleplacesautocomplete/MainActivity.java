package com.example.lmlopez.googleplacesautocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lmlopez.googleplacesautocomplete.model.details.DetailsResult;
import com.example.lmlopez.googleplacesautocomplete.model.prediction.Prediction;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DelayAutoCompleteTextView autoCompleteTextView;
    ImageView img;
    TextView textLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLatLng = findViewById(R.id.textView);
        img = findViewById(R.id.imageView);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        autoCompleteTextView.setAdapter(new GooglePlacesResultAdapter(MainActivity.this));

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                GooglePlacesApi api = ServiceGenerator.createService(GooglePlacesApi.class);

                Prediction p = (Prediction) autoCompleteTextView.getAdapter().getItem(i);

                Call<DetailsResult> call =  api.getPlaceDetails(p.getPlace_id());

                //1ª versión
                call.enqueue(new Callback<DetailsResult>() {
                    @Override
                    public void onResponse(Call<DetailsResult> call, Response<DetailsResult> response) {
                        if (response.isSuccessful()) {
                            DetailsResult result = response.body();
                            textLatLng.setText(String.format("%f, %f",
                                    result.getResult().getGeometry().getLocation().getLat(),
                                    result.getResult().getGeometry().getLocation().getLng()));

                            if (result.getResult().getPhotos() != null) {
                                if (!result.getResult().getPhotos().isEmpty()) {
                                    String photo_url = String.format("https://maps.googleapis.com/maps/api/place/photo?maxwidth=1000&key=AIzaSyD_FMG1EnTUm3Ja7bSnlCV2VINLFq7rLMw&photoreference=%s", result.getResult().getPhotos().get(0).getPhoto_reference());
                                    Picasso
                                            .with(MainActivity.this)
                                            .load(photo_url)
                                            .into(img);
                                }

                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<DetailsResult> call, Throwable t) {

                    }
                });





            }
        });


    }
}
