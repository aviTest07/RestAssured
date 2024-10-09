package RestAssured.TestRestassured;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentReport;

public class BaseTest 
{
	public void config(@Optional("Optional name Automation ")
	String reportname, @Optional("API Report") String flow)
	throws IOException 
	{
		//Create the path in which we will create folder to keep html reports
		
String subfolderpath=System.getProperty("user.dir")+"/htmlReports/"+getTimestamps();
		
		//create sub folder
		
		
	}
	@BeforeMethod(alwaysRun = true)
	public static void LogBeforeMethod() 
	{
	//final Logging log = Logging.getInstance();
		
	System.out.println("Test Case Execution Started");
	}
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
	if (result.getStatus() == ITestResult.SUCCESS) {
ExtentReport.extentlog.log(LogStatus.PASS,"Test Case :"+result.getName()
+"is passed");	
	}
	 else if (result.getStatus() == ITestResult.FAILURE) {
		ExtentReport.extentlog.log(LogStatus.FAIL,"Test case :"
		+ result.getName()+" is failed" );
		ExtentReport.extentlog.log(LogStatus.FAIL,"Test case is failed due to: " + result.getThrowable());
		} 
	 else if (result.getStatus() == ITestResult.SKIP) {
		ExtentReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped " + 
		result.getName());
		}
		ExtentReport.rep.endTest(ExtentReport.extentlog);
		}
	
public String getTimestamps()
{
	String timestamp= new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
	return timestamp;
}



	}
