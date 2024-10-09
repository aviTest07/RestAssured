package Utility;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport 
{

	public static ExtentReports rep=null;
	public static ExtentTest extentlog;
	
	public static void initialize(String path)
	{
		if(rep==null)
		{
			rep=new ExtentReports(path,true);
			rep.addSystemInfo("Host Name",System.getProperty("user.name"));
			rep.addSystemInfo("Environment","QA");
			rep.loadConfig(new File(System.getProperty("user.dir")+"Resources/extent-config.xml"));
			
		}
	}
}
