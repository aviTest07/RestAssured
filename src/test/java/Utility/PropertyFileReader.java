package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader 
{

	public static String propertyReader(String key) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	
	FileInputStream fis= 
			new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\TestRestassured\\src\\test\\resources\\Config.Properties");
	Properties prop=new Properties();
	try {
		prop.load(fis);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return prop.getProperty(key);
	}

	
}
