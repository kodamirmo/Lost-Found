package com.pawhub.lostandfound;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

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

        Fragment fragment=getFragmentManager().findFragmentById(R.id.myMap);
        
        SupportMapFragment fragmentoDeMapa=(SupportMapFragment)fragment;

    	map=fragmentoDeMapa.getMap();

    }
}
