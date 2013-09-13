package com.pawhub.lostandfound.transferobjects;

import java.io.Serializable;

import android.graphics.Color;

public abstract class Report implements Serializable{
	
	private static final long serialVersionUID = 2330015619136786055L;
	
	public static final int TYPE_DOG=0;
	public static final int TYPE_CAT=1;
	public static final int TYPE_OTHER=2;
	
	public static final int CAUSE_ABUSE=0;
	public static final int CAUSE_ACCIDENT=1;
	public static final int CAUSE_FOUND=2;
	public static final int CAUSE_LOST=3;
	public static final int CAUSE_HOMELESS=4;
	
	public static final int ABUSE_COLOR=Color.parseColor("#FFD400");
	public static final int ABUSE_ACCIDENT=Color.parseColor("#F3A2B9");
	public static final int ABUSE_FOUND=Color.parseColor("#CDE400");
	public static final int ABUSE_LOST=Color.parseColor("#B71C4E");
	public static final int ABUSE_HOMELESS=Color.parseColor("#63C2D0");
	
	private String idReport;
	private int petType;
	private String lastlocation;
	private Boolean hasPicture;
	private String pathPicture;
	private String comments;
	
	public Report(String idReport, int petType, String lastlocation,String pathPicture,String comments) {
		
		this.idReport = idReport;
		this.petType = petType;
		this.lastlocation = lastlocation;
		this.comments= comments;
		
		if(pathPicture!=null){
			if(!pathPicture.trim().equals("")){
				this.pathPicture = pathPicture;
				hasPicture=true;
			}
			else	 hasPicture=false;
		}
		else 	hasPicture=false;

	}

	public String getIdReport() {
		return idReport;
	}

	public int getPetType() {
		return petType;
	}

	public String getLastlocation() {
		return lastlocation;
	}

	public Boolean getHasPicture() {
		return hasPicture;
	}

	public String getPathPicture() {
		return pathPicture;
	}

	public String getComments() {
		return comments;
	}
	
}
