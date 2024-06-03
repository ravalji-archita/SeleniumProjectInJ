package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("TestResult-byAR");
		ExtentReports extent=new ExtentReports();
		
		extent=new ExtentReports();//main class object
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Archita Ravalji");
		
		return extent;
	}
}
