package com.pawhub.lostandfound.data;

import java.util.ArrayList;

import com.pawhub.lostandfound.transferobjects.AbuseReport;
import com.pawhub.lostandfound.transferobjects.AccidentReport;
import com.pawhub.lostandfound.transferobjects.FoundReport;
import com.pawhub.lostandfound.transferobjects.HomelessReport;
import com.pawhub.lostandfound.transferobjects.LostReport;
import com.pawhub.lostandfound.transferobjects.Report;

public class ReportsDataSource {

	private ArrayList<Report> reports;

	public ReportsDataSource() {
		reports = new ArrayList<Report>();
	}

	public ArrayList<Report> getData(ArrayList<Report> reports) {

		this.reports = reports;

		for (int i = 0; i < reports.size(); i++) {
			int reportType = reports.get(i).getTypeReport();
			switch (reportType) {
			case 0:
				AbuseReport report = new AbuseReport(reports.get(i)
						.getIdReport(), Report.TYPE_DOG, reports.get(i)
						.getLastlocation(), null, reports.get(i).getComments(),
						"sin comentario", false, 11, false, reports.get(i)
								.getUserName());
				reports.add(report);
				break;
			case 1:
				AbuseReport report2 = new AbuseReport(reports.get(i)
						.getIdReport(), Report.TYPE_DOG, reports.get(i)
						.getLastlocation(), null, reports.get(i).getComments(),
						"sin comentario", false, 11, false, reports.get(i)
								.getUserName());
				reports.add(report2);
				break;
			default:
				break;
			}
		}

		return reports;
	}
}
