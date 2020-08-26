package com.e.tarea5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

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
        Mapa.setOnMapClickListener(this);

        //  Puntos seleccionados
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012934, -79.469373)).title("Facultad de Ciencias Agrarias"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012610, -79.470562)).title("Facultad de Ciencias de la Ingeniería"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012188, -79.470134)).title("Facultad de Ciencias Empresariales"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012164, -79.470752)).title("Escuteq"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012871, -79.467646)).title("Auditorio Carlos Cortaza"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012706, -79.471084)).title("Facultad de Ciencias Ambientales"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.013026, -79.470533)).title("Coordinación de FCI"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012400, -79.468455)).title("Biblioteca"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012236, -79.469654)).title("Unidad de TIC"));
        Mapa.addMarker(new MarkerOptions().position(new LatLng(-1.012262, -79.469235)).title("Unidad de posgrado"));
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
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.012542, -79.469177), 17);
        Mapa.moveCamera(camUpd1);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        /* Mapa.addMarker(new MarkerOptions().position(latLng).title("Punto"));
        Projection proj = Mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(MainActivity.this,"Click\n" +"Lat: " + latLng.latitude + "\n" +"Lng: " + latLng.longitude + "\n" +
        "X: " + coord.x + " - Y: " + coord.y, Toast.LENGTH_SHORT).show();*/
    }

    public void pintarPoligono(View view){
        PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(-1.011901, -79.471756))
                .add(new LatLng(-1.012331, -79.467175))
                .add(new LatLng(-1.013219, -79.467214))
                .add(new LatLng(-1.012976, -79.471886))
                .add(new LatLng(-1.011901, -79.471756));
        lineas.width(4);
        lineas.color(Color.GREEN);
        Mapa.addPolyline(lineas);
    }
}