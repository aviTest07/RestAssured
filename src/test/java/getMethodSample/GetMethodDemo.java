package getMethodSample;

import io.restassured.path.json.JsonPath;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utility.JsonReader;
import Utility.PropertyFileReader;
import Utility.SoftAssertUtil;
import Utility.StatusCode;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Header;
import  static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
//import  static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;


public class GetMethodDemo 
{
@Test
public void checkgetRequest()
{
given().log().all().
when().get("https://automationexercise.com/api/productsList").
then().assertThat().
statusCode(200);
//.body("name",hasItems("Blue Top" ));
//extract().response();
}

@Test
public void checkGetRequestwithresponse()
{
RestAssured.baseURI=  "https://automationexercise.com";
Response response=given().log().all().   //Requestspecification
when().get("api/brandsList").   //Response
then().  //ValidatableResponse

extract().response();  //ExtractableResponse

System.out.println(response.getStatusCode());
List <HashMap<Integer,String>> brand = response.jsonPath().getList("brands");
System.out.println(brand);
assertThat(response.jsonPath().getList("brands.id"),hasItems(42,2));
assertThat(response.jsonPath().getList("brands.brand"),hasItems("Polo","H&M","Madame"));
assertEquals(response.getStatusCode(),StatusCode.SUCCESS.codes);
assertThat(response.jsonPath().getList("brands.brand"),hasSize(34));
}
@Test
public void checkGetQueryParam()
{
HashMap <String,String> map=new HashMap <String,String> ();
map.put("place_id", "83869278e9e757c8dbb666c41a496bfd");
map.put("key", "qaclick123");
RestAssured.baseURI="https://rahulshettyacademy.com";
Response response1=given().log().all().queryParams(map)
.when()
.get("maps/api/place/get/json").then().extract().response();
Headers headers=response1.getHeaders();
for (Header h:headers)
{
System.out.println(h.getName()+ " : " + h.getValue()) ;
}
/*JsonPath js=new JsonPath(response);
System.out.println(js.getString("accuracy"));
*/
System.out.println(response1.getStatusCode());
System.out.println(response1.jsonPath().getString("location.latitude"));
System.out.println(response1.asString());

SoftAssertUtil.assertsTrue(true,StatusCode.SUCCESS.message );
}
@Test
public void checkGetpathParam() throws IOException, ParseException, org.json.simple.parser.ParseException
{
String uri=PropertyFileReader.propertyReader("baseURI");
System.out.println(uri);
RestAssured.baseURI= uri;
given().auth().basic(JsonReader.getTestData("username"),JsonReader.getTestData("password")).
header("Content-Type","application/json").
when().get("basic-auth/example_username/example_password").then().
assertThat().statusCode(200);
String str="cars";
System.out.println(JsonReader.getJSonArrayData(str,2));
}
@DataProvider(name="testdata")
public Object[][] getdata()
{
return new Object[][]
{
{"894c3ef91e5df4ea2862b5dbfe96e45b","qaclick123"},
};
}
@Test(dataProvider="testdata")
public void dataProvidersDemo(String place_id,String key)
{
RestAssured.baseURI=  "https://rahulshettyacademy.com";
Response response1=given().log().all().queryParam("place_id",place_id).queryParam("key",key)
.when()
.get("maps/api/place/get/json").then().extract().response();
Headers headers=response1.getHeaders();
for (Header h:headers)
{
System.out.println(h.getName()+ " : " + h.getValue()) ;
}
/*JsonPath js=new JsonPath(response);
System.out.println(js.getString("accuracy"));
*/
System.out.println(response1.getStatusCode());
System.out.println(response1.jsonPath().getString("location.latitude"));
System.out.println(response1.asString());
//SoftAssertUtil softutils=new SoftAssertUtil();

SoftAssertUtil.assertsTrue(true,StatusCode.SUCCESS.message );


}
@Test
public void checkPostmethod()
{
RestAssured.baseURI=  "https://rahulshettyacademy.com";
Response responsePost=given().header("Content-Type","application/json").
body("{\r\n"
+ "    \"accuracy\": 50,\r\n"
+ "    \"name\": \"Acdhouse\",\r\n"
+ "    \"phone_number\": \"1234567898\",\r\n"
+ "    \"address\": \"World trade centre\",\r\n"
+ "    \"website\": \"https://magento.softwaretestingboard.com/\",\r\n"
+ "    \"language\": \"English\",\r\n"
+ "    \"location\": {\r\n"
+ "        \"lat\": -33.2324,\r\n"
+ "        \"lng\": 38.4555\r\n"
+ "    },\r\n"
+ "    \"types\": [\r\n"
+ "        \"ShoePark\",\r\n"
+ "        \"Shop1\"\r\n"
+ "    ]\r\n"
+ "}").when()
.post("/maps/api/place/add/json");


assertEquals(responsePost.statusCode(),StatusCode.SUCCESS.codes);
System.out.println(responsePost.asString());
System.out.println( responsePost.jsonPath().getString("id"));

}

}
