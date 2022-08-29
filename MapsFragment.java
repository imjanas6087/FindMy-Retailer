package com.example.findmyretailer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsFragment extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    double latitude,  longitude;
    String Address;
    ArrayList<GoogleMap> googleMaps = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);

        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latitude=Double.parseDouble(getIntent().getStringExtra(MainActivity.LATITUDE));
        longitude=Double.parseDouble(getIntent().getStringExtra(MainActivity.LONGITUDE));
        Address = getIntent().getStringExtra(MainActivity.ADDRESS);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng latLng = new LatLng(latitude, longitude);
        map.addMarker(new MarkerOptions().position(latLng).title(Address));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMaps.add(map);
    }
}