package com.pawhub.lostandfound.views;

import android.view.View;

import com.pawhub.lostandfound.transferobjects.*;
import com.pawhub.lostandfound.transferobjects.Report;

public class ReportView {

	private Report reportObject;
	
	public ReportView(Report reportObject) {
		this.reportObject = reportObject;
		
		AbuseReport p=(AbuseReport)reportObject;
	}
	
	private void generateChart_1(){
		
	}
	
	private void generateChart_2(){
		
	}
	
	public View getReportChart(){
		return null;
	}

}
