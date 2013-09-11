package com.pawhub.lostandfound.transferobjects;

public abstract class Report {
	
	public static final int TYPE_DOG=0;
	public static final int TYPE_CAT=1;
	public static final int TYPE_OTHER=2;
	
	private String idReport;
	private int petType;
	private String lastlocation;
	private Boolean hasPicture;
	private String pathPicture;
	
}
