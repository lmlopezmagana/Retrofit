package com.example.lmlopez.googleplacesautocomplete;

import android.gesture.Prediction;

import com.example.lmlopez.googleplacesautocomplete.model.PredictionResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lmlopez on 19/02/2018.
 */

public interface GooglePlacesApi {

    @GET("/autocomplete/json")
    Call<PredictionResult> autoComplete(@Query("input") String text);

}
