package RestAssuredExercise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredBase {
	
	public String getid(int id1)
	{
		String s=RestAssured.given()
				.when()
				.get("http://localhost:3000/posts/"+id1)
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().response().jsonPath().getString("id").toString();
		return s;
		
	}
	public String getTitle(int id)
	{
		String title=RestAssured.given()
				.when()
				.get("http://localhost:3000/posts/"+id)
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().response().jsonPath().getString("title").toString();
		return title;
		
	}
	public String getAuther(int id)
	{
		String author1=RestAssured.given()
				.when()
				.get("http://localhost:3000/posts/"+id)
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.extract().response().jsonPath().getString("author").toString();
		return author1;
		
	}
	
	
	
	

}
