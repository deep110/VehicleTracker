package com.lab.bus.tracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * @author DEEPANKAR
 * @since 30-03-2016.
 */
public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private boolean mfirst = false;
    private ArrayList<LatLng> coordinates;

    private final int[] MAP_TYPES = {GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID};

    private int curMapTypeIndex = 1;

    private GoogleMap map;
    PolylineOptions options;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.getMapAsync(this);
        coordinates = new ArrayList<>();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);

        //initCamera(LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient));

        initCamera(new LatLng(29.87145018,77.89619311));
       // setLocation(new LatLng(29.40,78.244));
    }


    private void initCamera(LatLng latLng) {
        CameraPosition position = CameraPosition.builder()
                .target(latLng)
                .zoom(16f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), null);

        map.setMapType(MAP_TYPES[curMapTypeIndex]);
        map.getUiSettings().setZoomControlsEnabled(true);

        options = new PolylineOptions().width(8).color(Color.RED);
        options.add(latLng);
        coordinates.add(latLng);

        for(int i=0;i<2;i++){
            addPath(i);
        }
    }


    public void setLocation(LatLng latLng){
        if(map!=null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));
            coordinates.add(latLng);
            drawPath();
        }
    }

    public void drawPath(){

        for(int i=0; i<coordinates.size();i++){
            options.add(coordinates.get(i));
        }
        map.addPolyline(options);
    }

    public void addPath(int i){
        switch (i){
            case 0:
                setLocation(new LatLng(29.871451,77.8962));
                break;
            case 1:
                setLocation(new LatLng(29.871452,77.896233));
                break;
            case 2:
                setLocation(new LatLng(29.871453,77.896245));
                break;
            case 3:
                setLocation(new LatLng(29.87145312,77.896256));
                break;
        }
    }


}
