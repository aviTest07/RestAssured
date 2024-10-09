package Utility;

import java.io.File;


import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static String  getTestData(String key) throws IOException, ParseException
	{
	String testdata;
	// TODO Auto-generated catch block
	testdata=(String)getJsonObject().get(key);
	return testdata;
	}
	private static JSONObject getJsonObject() throws IOException, ParseException {
	// TODO Auto-generated method stub
	//Read the Json file
	File filename=new File("C:\\Users\\hp\\eclipse-workspace\\TestRestassured\\src\\test\\resources\\TestData.Json");
	String  json= FileUtils.readFileToString(filename,"UTF-8");
	Object obj= new JSONParser().parse(json);
	JSONObject jsonobj=(JSONObject) obj;
	return jsonobj;
	}
	 public static JSONArray getJsonarray(String key) throws IOException, ParseException
	 {
	JSONObject jsonobject= getJsonObject();
	JSONArray jsonarray= (JSONArray)jsonobject.get(key);
	return jsonarray;
	 }
	 public static Object getJSonArrayData(String key,int index) throws IOException, ParseException
	 {
	JSONArray data= getJsonarray(key);
	Iterator <String> itr =data.iterator();
	while(itr.hasNext())
	{
	System.out.println(itr.next());
	}
	return  data.get(index);
	 }
	 }

