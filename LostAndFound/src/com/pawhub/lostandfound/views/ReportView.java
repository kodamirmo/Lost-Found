package com.pawhub.lostandfound.views;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pawhub.lostandfound.R;
import com.pawhub.lostandfound.transferobjects.*;

public class ReportView {

	private Report reportObject;
	private LayoutInflater inflater;
	
	private View reportChart;
	
	public ReportView(Report reportObject,LayoutInflater inflater) {
		this.reportObject = reportObject;
		this.inflater=inflater;		
	}
	
	private void generateChart_1(){
		View v=inflater.inflate(R.layout.detail_chart_1, null);
		generateChartGeneral(v);
		
		LinearLayout colorBackGound=(LinearLayout)v.findViewById(R.id.linearmain2);
		colorBackGound.setBackgroundResource(getTransparentColorReport(reportObject.getTypeReport()));
		
		reportChart=v;
	}
	
	private void generateChart_2(){
		View v=inflater.inflate(R.layout.detail_chart_2, null);
		generateChartGeneral(v);
		
		LinearLayout colorBackGound=(LinearLayout)v.findViewById(R.id.linearmain2);
		colorBackGound.setBackgroundResource(getColorReport(reportObject.getTypeReport()));
		
		reportChart=v;
	}
	
	private void generateChartGeneral(View v){
		
		////////   Alert
		final ImageView imageViewAlert=(ImageView) v.findViewById(R.id.ivChart_Alert);
		if(reportObject.isAlert())
			imageViewAlert.setImageResource(R.drawable.alert_active);
		else
			imageViewAlert.setImageResource(R.drawable.bell);
		
		LinearLayout layoutAlert=(LinearLayout)v.findViewById(R.id.layoutAlert);
		
		layoutAlert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageViewAlert.setImageResource(R.drawable.alert_active);
			}
		});
		
		///////////////////////////////////////////////////////
		
		/////Share
		LinearLayout layoutShare=(LinearLayout)v.findViewById(R.id.layoutShare);
		
		layoutShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				shareIntent();
			}
		});
		
		///////////////////////////////////////////////////////
		
		///////  Num of comments
		TextView tvNumComents=(TextView)v.findViewById(R.id.tvNumComments);
		tvNumComents.setText("" + reportObject.getNumComments());
		
		///////////////////////////////////////////////////////
		
		///// User Name
		TextView tvUserName=(TextView)v.findViewById(R.id.txtUserNameMain);
		tvUserName.setText(reportObject.getUserName());
		////////////////////////////////////////////////////////
		
		///// Type report text
		TextView tvTypeReport=(TextView)v.findViewById(R.id.reportTypeLbl);
		tvTypeReport.setText(getTitleReport(reportObject.getTypeReport()));
		///////////////////////////////////////////////////////
		
		//////// Image Icon
		ImageView imageViewIcon=(ImageView)v.findViewById(R.id.titleIcon);
		imageViewIcon.setImageResource(getIcon(reportObject.getTypeReport()));
		///////////////////////////////////////////////////////
		
		
		////////Resolve
		TextView tvResolve=(TextView)v.findViewById(R.id.tvResolve);
		
		if(reportObject.isResolve())
			tvResolve.setText(" -¡Resuelto!");
		else
			tvResolve.setText("");
		
		///////////////////////////////////////////////////////
		
		/////User message
		TextView tvUserShortMessage=(TextView)v.findViewById(R.id.userShortMsg);
		tvUserShortMessage.setText(reportObject.getComments());
		///////////////////////////////////////////////////////
		
		
	}
	
	private int getTransparentColorReport(int type){
		switch (type) {
		case Report.CAUSE_ABUSE:
			return R.drawable.detail_chart_transparent_bottom_yellow;
		case Report.CAUSE_ACCIDENT:
			return R.drawable.detail_chart_transparent_bottom_pink;
		case Report.CAUSE_FOUND:
			return R.drawable.detail_chart_transparent_bottom_green;
		case Report.CAUSE_LOST:
			return R.drawable.detail_chart_transparent_bottom_magenta;
		case Report.CAUSE_HOMELESS:
			return R.drawable.detail_chart_transparent_bottom_blue;
		default:
			return 0;
		}
	}
	
	private int getColorReport(int type){
		switch (type) {
		case Report.CAUSE_ABUSE:
			return R.drawable.detail_chart_yellow;
		case Report.CAUSE_ACCIDENT:
			return R.drawable.detail_chart_pink;
		case Report.CAUSE_FOUND:
			return R.drawable.detail_chart_green;
		case Report.CAUSE_LOST:
			return R.drawable.detail_chart_magenta;
		case Report.CAUSE_HOMELESS:
			return R.drawable.detail_chart_blue;
		default:
			return 0;
		}
	}
	
	private String getTitleReport(int type){
		switch (type) {
		case Report.CAUSE_ABUSE:
			return "Maltrato";
		case Report.CAUSE_ACCIDENT:
			return "Accidente";
		case Report.CAUSE_FOUND:
			return "Encontrado";
		case Report.CAUSE_LOST:
			return "Perdido";
		case Report.CAUSE_HOMELESS:
			return "Busca hogar";
		default:
			return "";
		}
	}
	
	private int getIcon(int type){
		switch (type) {
		case Report.CAUSE_ABUSE:
			return R.drawable.menu_abuse_icon;
		case Report.CAUSE_ACCIDENT:
			return R.drawable.menu_abuse_icon;
		case Report.CAUSE_FOUND:
			return R.drawable.menu_found_icon;
		case Report.CAUSE_LOST:
			return R.drawable.menu_missing_icon;
		case Report.CAUSE_HOMELESS:
			return R.drawable.menu_serchome_icon;
		default:
			return 0;
		}
	}
	
	private void shareIntent(){
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		sharingIntent.setType("text/html");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Texto a compartir");	
		inflater.getContext().startActivity(Intent.createChooser(sharingIntent,"Compartir con"));
	}
	
	public View getReportChart(){
		
		if(reportObject.getHasPicture())
			generateChart_1();
		else
			generateChart_2();

		return reportChart;
	}

}
