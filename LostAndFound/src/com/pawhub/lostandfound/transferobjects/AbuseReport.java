package com.pawhub.lostandfound.transferobjects;

public class AbuseReport extends Report{

	private static final long serialVersionUID = 6533248312973019131L;
	
	private String commentAboutSituation; 
	
	public AbuseReport(String idReport, int petType, String lastlocation,
			String pathPicture, String comments, String commentAboutSituation) {
		super(idReport, petType, lastlocation, pathPicture, comments);
		this.commentAboutSituation = commentAboutSituation;
	}

	public String getCommentAboutSituation() {
		return commentAboutSituation;
	}

}
