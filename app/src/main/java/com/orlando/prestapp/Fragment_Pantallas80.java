package com.orlando.prestapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Pantallas80.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Pantallas80#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Pantallas80 extends Fragment {

Spinner Equipo;

    public Fragment_Pantallas80() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__pantallas80, container, false);


    }

    private void findViewBtId() {
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private final static String[] names = {"Proyector", "Canaleta", "Cable HDMI", "Cable de corriente electrica"};
}
