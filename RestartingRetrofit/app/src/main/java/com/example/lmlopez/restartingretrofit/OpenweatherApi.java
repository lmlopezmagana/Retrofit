package com.example.lmlopez.restartingretrofit;

import com.example.lmlopez.restartingretrofit.model.Weather.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lmlopez on 13/02/2018.
 */

public interface OpenweatherApi {

    //@GET("/data/2.5/weather?APPID=3bcfcde9b7438aa7696f020ed75f5673&units=metric&lang=es")
    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherInfoByCity(@Query("q") String city);


}
