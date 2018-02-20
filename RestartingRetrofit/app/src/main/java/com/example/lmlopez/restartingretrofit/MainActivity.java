package com.example.lmlopez.restartingretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lmlopez.restartingretrofit.model.Weather.WeatherInfo;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView temperatura;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paso 0: Rescatar los elementos de la UI
        temperatura = findViewById(R.id.temperatura);
        imagen = findViewById(R.id.imagen);

        //Paso 1: Generar el servicio completo
        OpenweatherApi openweatherApi = ServiceGenerator.createService(OpenweatherApi.class);

        //Paso 2: Invocar al servicio concreto
        Call<WeatherInfo> peticion = openweatherApi.getWeatherInfoByCity("Ubeda");

        //Paso 3: Invocar al método enqueue (ejecutar la petición asíncronamente)
        peticion.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(response.isSuccessful()) {
                    //Rescatamos los datos de la respuesta
                    WeatherInfo weatherInfo = response.body();
                    //Aquí "dibujamos" todos los datos en la interfaz de usuario
                    Log.i("Retrofit OK", weatherInfo.toString());

                    String txt_temperatura = Double.toString(weatherInfo.getMain().getTemp());
                    temperatura.setText(txt_temperatura);

                    if (weatherInfo.getWeather().size() > 0) {
                        Picasso
                                .with(getApplicationContext())
                                .load("http://openweathermap.org/img/w/" + weatherInfo.getWeather().get(0).getIcon() + ".png")
                                .into(imagen);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Lo sentimos, pero ocurrió algún error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lo sentimos, pero ocurrió algún error de red", Toast.LENGTH_SHORT).show();
                Log.e("Retrofit Fail", t.toString());
            }
        });

        Log.d("saludo", "Hola a los niños!!!! Y a las niñas también");


    }
}
