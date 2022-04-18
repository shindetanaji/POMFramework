package com.qc.pom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNGReport {
	static ExtentReports extent;

	public static ExtentReports setupReport() {
		String path = "test-output/ExtentReport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Test Automation Report");
		reporter.config().setDocumentTitle("Queue Codes Test Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Queue Codes");
		extent.setSystemInfo("User Name", "Tanaji Shinde");
		return extent;
	}
}
