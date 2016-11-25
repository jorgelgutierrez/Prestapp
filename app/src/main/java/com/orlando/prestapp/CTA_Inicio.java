package com.orlando.prestapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class CTA_Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton BotonInicio;
    ListView ListaMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cta__inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        String Titulos[] = {"Cables", "Proyectores", "Controles", "Uso TV 80 Pulgadas", "Uso de Proyectores Wi-Fi","Uso de UDG Movil", "Realiza tu Reporte"};
        Adaptador_Menu_Inicio adapter = new Adaptador_Menu_Inicio(this,R.layout.item_menu_nav,Titulos);

        //Inicializando la lista del menu inicio y noticias...
        ListaMenu = (ListView) findViewById(R.id.lista_menu_inicio);

        //Agregando los titulos a la lista menu inicio...
        ListaMenu.setAdapter(adapter);

        //inicio con el Fragmento Principal
        Fragment Fragment = new Fragment_Inicio();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor_Principal,Fragment).commit();

        ListaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                //Obteniendo item seleccionado y enviado a metodo para saber que mostrar en pantalla...
                TextView item = (TextView) view.findViewById(R.id.idtext);
                MostrarContenidoItem(item.getText().toString());
            }
        });
    }


    public void MostrarContenidoItem(String item_seleccionado){

        Fragment fragment = null;
        Boolean fragmentoseleccionado = false;

        if(item_seleccionado.equals("Cables")){
            fragment = new Fragment_Cables();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Proyectores")){
            fragment = new Fragment_Proyectores();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Controles")){
            fragment = new Fragment_Controles();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Uso TV 80 Pulgadas")){
            fragment = new Fragment_Pantallas80();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Uso de Proyectores Wi-Fi")){
            fragment = new Fragment_ProyectoresWi_Fi();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Uso de UDG Movil")){
            fragment = new Fragment_UDGMovil();
            fragmentoseleccionado = true;
        }else if (item_seleccionado.equals("Realiza tu Reporte")){
            fragment = new Fragment_Reportes();
            fragmentoseleccionado = true;
        }

        if(fragmentoseleccionado){
            //Enviardatos a fragment...
            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor_Principal,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cta__inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.IrInicio) {
            //inicio con el Fragmento Principal
            Fragment Fragment = new Fragment_Inicio();
            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor_Principal,Fragment).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        return true;


    }
}
