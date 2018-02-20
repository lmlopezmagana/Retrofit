package com.example.lmlopez.googleplacesautocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.lmlopez.googleplacesautocomplete.model.Prediction;
import com.example.lmlopez.googleplacesautocomplete.model.PredictionResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lmlopez on 20/02/2018.
 */

public class GooglePlacesResultAdapter extends BaseAdapter
            implements Filterable {


    private Context mContext;
    private List<Prediction> resultList = new ArrayList<Prediction>();


    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Prediction getItem(int i) {
        return resultList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //android.R.layout.simple_dropdown_item_1line
        //return null;
        if (view == null) {
            //Inflamos el Layout
            LayoutInflater inflater =
                    (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, viewGroup, false);

        }

        //Obtenemos la referencia al Textview
        TextView text = view.findViewById(android.R.id.text1);
        //Obtenemos el elemento i-ésimo
        Prediction p = getItem(i);
        //Setteamos el texto
        text.setText(p.getDescription());

        return view;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                //return null;
                FilterResults filterResults = new FilterResults();
                if (charSequence != null) {
                    //Realizamos la búsqueda
                    List<Prediction> resultados = findCities(charSequence);
                    //Si tenemos resultados, los añadimos
                    if (resultados != null) {
                        filterResults.values = resultados;
                        filterResults.count = resultados.size();
                    }
                    //Si no, devolvemos un conjunto vacío de resultados

                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            }
        };
    }


    private List<Prediction> findCities(CharSequence text) {
        List<Prediction> result = null;

        //Generar el servicio
        GooglePlacesApi api = ServiceGenerator.createService(GooglePlacesApi.class);
        //Obtener la petcición
        Call<PredictionResult> call = api.autoComplete(text.toString());

        //call.enqueue();
        try {
            Response<PredictionResult> response = call.execute();

            if (response.isSuccessful()) {
                if ("OK".equalsIgnoreCase(response.body().getStatus()))
                    result = response.body().getPredictions();
            }

            //TODO Manejo de errores

        } catch (IOException e) {
            //TODO Manejo de la excepción
            e.printStackTrace();
        }


        return result;
    }


}
