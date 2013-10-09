package com.pawhub.lostandfound.transferobjects;

public class LostReport extends Report{

	private static final long serialVersionUID = 6658076717693829388L;
	
	private String lostDate;
	private int agePet;
	private String colorPet;
	private String namePet;
		
	public LostReport(String idReport, int petType, String lastlocation,
			String pathPicture, String comments, String lostDate, int agePet,
			String colorPet, String namePet) {
		super(idReport, petType, lastlocation, pathPicture, comments);
		this.lostDate = lostDate;
		this.agePet = agePet;
		this.colorPet = colorPet;
		this.namePet = namePet;
		super.typeReport=CAUSE_LOST;
	}

	public String getLostDate() {
		return lostDate;
	}


	public int getAgePet() {
		return agePet;
	}


	public String getColorPet() {
		return colorPet;
	}


	public String getNamePet() {
		return namePet;
	}

}
