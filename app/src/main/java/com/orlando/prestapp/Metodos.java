package com.orlando.prestapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class Metodos {


    ArrayList<String> stock = new ArrayList<String>();
    // constructor
    public Metodos() {

    }

    //Ejecuta la URL estableciendo la conexion y recibe el json en InputStream y posteriormente ser convertido a String...
    public String getJSONfromUrl(String myurl) throws IOException {
        StringBuilder result = new StringBuilder();
        String urlservidor = "http://prestapp.webcindario.com/Consulta_Stock.php?tipo=";
        myurl = urlservidor + myurl;
        Log.wtf("Array List","Obteniendo datos"+myurl);

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int respuesta = conn.getResponseCode();

            if (respuesta == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = new BufferedInputStream(conn.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String linea;
                while((linea = reader.readLine()) != null){
                    result.append(linea);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }

}
