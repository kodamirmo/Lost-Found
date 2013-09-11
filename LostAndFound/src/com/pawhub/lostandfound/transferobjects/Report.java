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
	
}
