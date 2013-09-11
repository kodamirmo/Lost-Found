package com.pawhub.lostandfound.transferobjects;

import java.io.Serializable;

public abstract class Report implements Serializable{
	
	private static final long serialVersionUID = 2330015619136786055L;
	
	public static final int TYPE_DOG=0;
	public static final int TYPE_CAT=1;
	public static final int TYPE_OTHER=2;
	
	private String idReport;
	private int petType;
	private String lastlocation;
	private Boolean hasPicture;
	private String pathPicture;
	
	public Report(String idReport, int petType, String lastlocation,String pathPicture) {
		
		this.idReport = idReport;
		this.petType = petType;
		this.lastlocation = lastlocation;
		
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
	
}
