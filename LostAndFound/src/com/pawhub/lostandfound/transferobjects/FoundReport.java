package com.pawhub.lostandfound.transferobjects;

public class FoundReport extends Report{

	private static final long serialVersionUID = 6277726849474247205L;

	private int agePet;
	private String colorPet;
	private String actuallyLocation;

	public FoundReport(String idReport, int petType, String lastlocation,
			String pathPicture, String comments, int agePet, String colorPet,
			String actuallyLocation) {
		super(idReport, petType, lastlocation, pathPicture, comments);
		this.agePet = agePet;
		this.colorPet = colorPet;
		this.actuallyLocation = actuallyLocation;
		super.typeReport=CAUSE_FOUND;
	}
	
	public int getAgePet() {
		return agePet;
	}

	public String getColorPet() {
		return colorPet;
	}

	public String getActuallyLocation() {
		return actuallyLocation;
	}
}
