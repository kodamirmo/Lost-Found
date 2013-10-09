package com.pawhub.lostandfound.transferobjects;

public class HomelessReport extends Report{

	private static final long serialVersionUID = 4093595522325763809L;

	public HomelessReport(String idReport, int petType, String lastlocation,
			String pathPicture,String comments) {
		super(idReport, petType, lastlocation, pathPicture,comments);
		
		super.typeReport=CAUSE_HOMELESS;
	}

}
