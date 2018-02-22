package com.example.lmlopez.viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static String LATITUD = "LAT";
    public static String LONGITUD = "LNG";

    // TODO: Rename and change types of parameters
    private Double mParam1;
    private Double mParam2;

    TextView text;

    //private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(Double param1, Double param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putDouble(LATITUD, param1);
        args.putDouble(LONGITUD, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getDouble(LATITUD);
            mParam2 = getArguments().getDouble(LONGITUD);
        }
    }

    public void refreshContent(Double v1, Double v2) {
        mParam1 = v1;
        mParam2 = v2;
        text.setText(String.format("%f, %f", mParam1, mParam2));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        text = view.findViewById(R.id.latlng);

        refreshContent(mParam1, mParam2);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
