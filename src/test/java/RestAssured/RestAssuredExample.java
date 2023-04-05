package RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredExample {
	CreatePost cp=new CreatePost();
	
	@Test 
	public void test01()
	{
//		Response response= RestAssured.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=110001&date=31-03-2021");
//		System.out.println(response.asString());
//		System.out.println(response.contentType());
//		System.out.println(response.statusCode());
		String name=RestAssured.given()
				.param("pincode","500084")
				.param("date","20-08-2021")
				.pathParam("key","findByPin")
				.when()
				.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/{key}")
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().path("sessions[0].name");
		assertEquals(name,"Apollo My Home WorkPlace");
	}
	
	@Test 
	public void postFun()
	{
		String s=RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\"id\": 9,\"title\": \"Raghu\",\"author\": \"xyz\"}")
		.when()
			.post("http://localhost:3000/posts")
		.then()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.extract().response().asString();
		System.out.println(s);
	}
	
	@Test 
	public void postFuncCreatePost()
	{
		
		
		cp.setId(10);
		cp.setTitle("Raghuvaran2");
		cp.setAuthor("Raghu-1717");
		
		
		String s1=RestAssured.given()
			.contentType(ContentType.JSON)
			.body(cp)
			.log().all()
		.when()
		.post("http://localhost:3000/posts")
		.then()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all()
			.extract().response().asString();
		System.out.println(s1);
			
	}
	
	@Test 
	public void putFunc()
	{
		cp.setId(5);
		cp.setTitle("Aish");
		cp.setAuthor("best friend");
		
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body(cp)
		.when()
		 	.put("http://localhost:3000/posts/6")
		 .then()
			.contentType(ContentType.JSON)
			.statusCode(200);
			
		 	
	}
	
	@Test
	public void deleteFun()
	{
		String s=RestAssured.when()
				.delete("http://localhost:3000/posts/7")
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().response().asString();
			System.out.println(s);
		
		
	}
	
	@Test
	public void patchFun()
	{
		cp.setId(6);
		cp.setAuthor("Anandhi--");
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(cp)
		.when()
	 		.patch("http://localhost:3000/posts/7")
	 	.then()
	 		.contentType(ContentType.JSON)
	 		.statusCode(200);
		
		
	}
	@Test
	public void getFuc()
	{
		String name=RestAssured.given()
				.when()
				.get("http://localhost:3000/posts/")
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().path("[0].title");
		System.out.println(name);
	}

}
