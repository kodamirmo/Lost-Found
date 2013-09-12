package com.pawhub.lostandfound;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CasesListFragment extends Fragment{

	private LinearLayout parentLayout;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cases_list_layout, container, false);
    }
	
	@Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        parentLayout=(LinearLayout)getView().findViewById(R.id.layoutCasesList);
        
        addDetailChart();
        addDetailChart();
        addDetailChart();
    }
	
	private void addDetailChart(){
		LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		inflater.inflate(R.layout.detail_chart_1,parentLayout);
	}
}
