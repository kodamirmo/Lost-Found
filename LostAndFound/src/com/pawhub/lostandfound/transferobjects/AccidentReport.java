package com.pawhub.lostandfound.transferobjects;

public class AccidentReport extends Report{

	private static final long serialVersionUID = 3072573095922276081L;

	public AccidentReport(String idReport, int petType, String lastlocation,
			String pathPicture,String comments) {
		super(idReport, petType, lastlocation, pathPicture,comments);

	}

}
