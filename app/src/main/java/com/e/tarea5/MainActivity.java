package com.e.tarea5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap Mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Mapa = googleMap;
        Mapa.getUiSettings().setZoomControlsEnabled(true);
    }

    public void cambiarVista(View view){
        if(Mapa.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
            Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else{
            Mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    public void moverCamara(View view){
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.026631, -79.467448), 5);
        Mapa.moveCamera(camUpd1);
    }
}