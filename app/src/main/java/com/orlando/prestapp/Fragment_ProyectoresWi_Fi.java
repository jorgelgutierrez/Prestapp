package com.orlando.prestapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


public class Fragment_ProyectoresWi_Fi extends Fragment {

Spinner Equipo;

    public Fragment_ProyectoresWi_Fi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__proyectoreswifi, container, false);


    }

    private void findViewBtId() {
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private final static String[] names = {"Proyector", "Canaleta", "Cable HDMI", "Cable de corriente electrica"};
}
