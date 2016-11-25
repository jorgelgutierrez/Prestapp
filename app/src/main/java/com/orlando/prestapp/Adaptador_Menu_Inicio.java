package com.orlando.prestapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Orlando on 26/09/2016.
 */
public class Adaptador_Menu_Inicio extends ArrayAdapter<String>{

    Context mycontext;
    int mylayoutResourceId;

    String myTitulos[] = null;

    public Adaptador_Menu_Inicio(Context context, int resource, String[] titulos) {
        super(context, resource, titulos);

        this.mycontext = context;
        this.mylayoutResourceId = resource;
        this.myTitulos = titulos;

    }

    @TargetApi(Build.VERSION_CODES.M)
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        Lista_Menu_Holder holder = null;

        if(row == null){

            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate(mylayoutResourceId,parent,false);

            holder = new Lista_Menu_Holder();
            holder.titulo = (TextView) row.findViewById(R.id.idtext);
            holder.imagen = (ImageView) row.findViewById(R.id.idimage);
            row.setTag(holder);

        }else{

            holder = (Lista_Menu_Holder) row.getTag();
        }

        holder.titulo.setText(myTitulos[position]);
        if (myTitulos[position].equals("Cables")) {
            int a = R.mipmap.ic_cable;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Proyectores")){
            int a = R.mipmap.ic_projector;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Controles")){
            int a = R.mipmap.ic_control;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Uso TV 80 Pulgadas")){
            int a = R.mipmap.ic_screen;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Uso de Proyectores Wi-Fi")){
            int a = R.mipmap.ic_wifi_projector;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Uso de UDG Movil")){
            int a = R.mipmap.ic_udg_movil;
            holder.imagen.setImageResource(a);
        }else if(myTitulos[position].equals("Realiza tu Reporte")){
            int a = R.mipmap.ic_report;
            holder.imagen.setImageResource(a);
        }
        return row;
    }

    static class Lista_Menu_Holder {
        TextView titulo;
        ImageView imagen;
    }
}

