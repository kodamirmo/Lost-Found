package com.pawhub.lostandfound;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCasesMap extends Fragment{
	
	private static int SERVICE_DISABLED = 3;
	
	private GoogleMap map;
	private SupportMapFragment fragmentoDeMapa;
	private Fragment fragment;
	private Context context;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		context = inflater.getContext();
        return inflater.inflate(R.layout.fragment_map_causes, container, false);
    }
	
	@Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        
        if ((map == null) 
				&& (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == SERVICE_DISABLED))
			try {
				initMap();
				fillMarkers();
			} catch (GooglePlayServicesNotAvailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
    }
	
	private void initMap()throws GooglePlayServicesNotAvailableException{
		
		fragment=getFragmentManager().findFragmentById(R.id.myMap);
        fragmentoDeMapa=(SupportMapFragment)fragment;
    	map=fragmentoDeMapa.getMap();
    	
    	LatLng coordenada=new LatLng(19.4326018,-99.1332049);
    	
    	CameraPosition camPos = new CameraPosition.Builder()
        .target(coordenada).zoom(12).build();
    	
    	CameraUpdate cameraUpdate =
        	    CameraUpdateFactory.newCameraPosition(camPos);
    	
    	map.moveCamera(cameraUpdate);	
	}
	
	public void removeMap(){
		Log.i("TAG","Remove map");
		fragment.getFragmentManager().beginTransaction().remove(fragmentoDeMapa).commit();
	}
	
	private void fillMarkers(){
		addMarker("Perro","Extraviado",19.4326018,-99.1332049);
		addMarker("Gato","Adoptado",19.5326118,-99.1332149);
		
	}
	
	private void addMarker(String title,String snippet,double corLat,double corLong){
		 LatLng coordenada = new LatLng(corLat,corLong);
    	 
    	  map.addMarker(new MarkerOptions()
          .position(coordenada)
          .title(title)
          .snippet(snippet)
          .icon(BitmapDescriptorFactory.fromResource(R.drawable.pointer)));
	}
}
