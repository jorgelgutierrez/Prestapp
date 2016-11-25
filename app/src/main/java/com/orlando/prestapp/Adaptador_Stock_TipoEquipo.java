package com.orlando.prestapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Orlando on 26/09/2016.
 */
public class Adaptador_Stock_TipoEquipo extends ArrayAdapter<String>{

    Context mycontext;
    int mylayoutResourceId;

    ArrayList<String> myStock = null;
    String mytipo = "";

    public Adaptador_Stock_TipoEquipo(Context context, int resource, ArrayList<String> stock, String tipo) {
        super(context, resource, stock);

        this.mycontext = context;
        this.mylayoutResourceId = resource;
        this.myStock = stock;
        this.mytipo = tipo;


    }

    @TargetApi(Build.VERSION_CODES.M)
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        Lista_Stock_Holder holder = null;

        if(row == null){

            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate(mylayoutResourceId,parent,false);

            holder = new Lista_Stock_Holder();
            holder.modelo = (TextView) row.findViewById(R.id.modelo);
            holder.stock = (TextView) row.findViewById(R.id.cantidad);
            holder.imagen = (ImageView) row.findViewById(R.id.logo_lista);
            row.setTag(holder);

        }else{

            holder = (Lista_Stock_Holder) row.getTag();
        }

        String string = myStock.get(position);
        String[] parts = string.split(",");
        String modelo = parts[0];
        String stock = parts[1];

        holder.modelo.setText("Modelo:  "+ modelo);
        holder.stock.setText("Stock: "+ stock);
        if(mytipo.equals("Cables")){
            int a = R.drawable.icon_vga;
            holder.imagen.setImageResource(a);
        }else if(mytipo.equals("Controles")){
            int a = R.drawable.icon_control;
            holder.imagen.setImageResource(a);
        }else if(mytipo.equals("Proyectores")){
            int a = R.drawable.dell_projector;
            holder.imagen.setImageResource(a);
        }

        return row;
    }

    static class Lista_Stock_Holder {
        TextView modelo;
        TextView stock;
        ImageView imagen;
    }
}

