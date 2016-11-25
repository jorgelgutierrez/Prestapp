package com.orlando.prestapp;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_Controles extends Fragment {

    ListView Lista_Stock;
    ArrayList<String> stock = new ArrayList<String>();

    public Fragment_Controles() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__controles, container, false);
        Lista_Stock = (ListView) view.findViewById(R.id.lista_stock_controles);
        Lista_Stock.setEnabled(false);

        //Agregando los items de cables...
        new ConsultarStock().execute("Controles");
        return  view;

    }

    //Ejecucion de operacion Consultar Stock de tipo equipo en un hilo separado de la interfaz del usuario....
    private class ConsultarStock extends AsyncTask<String, Void, String> {

        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Cargando");
            pDialog.setCanceledOnTouchOutside(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                Log.wtf("Array List","Consultando");
                Metodos metodos = new Metodos();
                return metodos.getJSONfromUrl((urls[0]));
            } catch (Exception e) {
                e.printStackTrace();
                Log.wtf("Array List",e);
                return "Problemas con la conexion a internet";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            JSONArray resultadoJSON = null;
            pDialog.dismiss();

            try {
                resultadoJSON = new JSONArray(result);

                Log.wtf("Array List",result);
                for (int i = 0; i <= resultadoJSON.length() - 1; i++) {
                    JSONObject linea = resultadoJSON.getJSONObject(i);
                    stock.add(linea.getString("modeloEquipo")+","+linea.getString("cantidadEquipo"));
                }
                Adaptador_Stock_TipoEquipo adapter = new Adaptador_Stock_TipoEquipo(getContext(),R.layout.item_stock_tipoequipo,stock,"Controles");
                Lista_Stock.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
                Log.wtf("Array List",e);

            }

        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
