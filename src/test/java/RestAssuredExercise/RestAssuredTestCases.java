package RestAssuredExercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import RestAssured.CreatePost;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
@Listeners(listenersPackage.Listener.class)
public class RestAssuredTestCases extends RestAssuredBase {
	CreatePost cp=new CreatePost();
	
	@Test(priority = 0)
	public void postTest()
	{
		int id=17;
		String title="java";
		String author="Raghuvaran";
		cp.setId(id);
		cp.setTitle(title);
		cp.setAuthor(author);
		String s1=RestAssured.given()
			.contentType(ContentType.JSON)
			.body(cp)
		.when()
		.post("http://localhost:3000/posts")
		.then()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.extract().response().asString();
		
		String id1=Integer.toString(id);
		assertEquals(getid(id),id1);
		assertEquals(getTitle(id),title);
		assertEquals(getAuther(id),author);
	
		
	}
	
	@Test(priority = 1)
	public void putTest()
	{
		int id=17;
		String title="c++";
		String author="william";
		cp.setId(id);
		cp.setTitle(title);
		cp.setAuthor(author);
		
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body(cp)
		.when()
		 	.put("http://localhost:3000/posts/"+id)
		 .then()
			.contentType(ContentType.JSON)
			.statusCode(200);
		
		String id1=Integer.toString(id);
		assertEquals(getid(id),id1);
		assertEquals(getTitle(id),title);
		assertEquals(getAuther(id),author);
	}
	@Test(priority = 2)
	public void deleteFun()
	{
		int id=17;
                 RestAssured.when()
				.delete("http://localhost:3000/posts/"+id)
				.then()
				.contentType(ContentType.JSON)
				.statusCode(200);
			
		
		
	}
	

}
