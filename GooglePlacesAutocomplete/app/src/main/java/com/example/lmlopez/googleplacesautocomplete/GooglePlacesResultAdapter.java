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

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }
}
