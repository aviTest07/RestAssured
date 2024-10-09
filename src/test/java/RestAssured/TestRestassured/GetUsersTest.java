package RestAssured.TestRestassured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetUsersTest 
{
	
	public static RequestSpecBuilder  requestSpecBuilder;
	@Test
	public  void getRequest()
	{
	 requestSpecBuilder = new RequestSpecBuilder();
	requestSpecBuilder.
	setBaseUri("https://automationexercise.com/api/productsList/")
	.addHeader("Content-Type","application/json");
	
	}
	
	RequestSpecification req=requestSpecBuilder.build();
	
	public static ResponseSpecBuilder responsespecfication;
	
	public void getrespinse()
	{
		responsespecfication=new ResponseSpecBuilder();
		responsespecfication.expectBody(null)
		.expectStatusCode(0);
	}
	
	ResponseSpecification res=responsespecfication.build();
	@Test
	public void actualtest() 
	{
		
		String response=given().spec(req).then().spec(res).toString();
	
		
	}
}
