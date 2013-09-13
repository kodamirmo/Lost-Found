package com.pawhub.lostandfound;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCasesMap extends Fragment{
	
	private GoogleMap map;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_causes, container, false);
    }
	
	@Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        initMap();

    }
	
	private void initMap(){
		
		Fragment fragment=getFragmentManager().findFragmentById(R.id.myMap);
        SupportMapFragment fragmentoDeMapa=(SupportMapFragment)fragment;
    	map=fragmentoDeMapa.getMap();
    	
    	LatLng coordenada=new LatLng(19.4326018,-99.1332049);
    	
    	CameraPosition camPos = new CameraPosition.Builder()
        .target(coordenada).zoom(12).build();
    	
    	CameraUpdate cameraUpdate =
        	    CameraUpdateFactory.newCameraPosition(camPos);
    	
    	map.moveCamera(cameraUpdate);
	}
}
