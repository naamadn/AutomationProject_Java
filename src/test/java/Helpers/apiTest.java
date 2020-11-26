package Helpers;

import Utilities.commonOps;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class apiTest extends commonOps
{
    String url = "http://localhost:3000";
    RequestSpecification httpRequest;
    Response response;
    JSONObject params = new JSONObject();
    JsonPath jp;

  //  @BeforeClass
    public void start()
    {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");
        httpRequest.header("Content-Type", "application/json");
    //   httpRequest.header("Content-Type", "application/json", "Bearer eyJrIjoidHUxUjBNMGJzSjRwdzN0a0xqdVNiQmpUVHkwUjMyQkQiLCJuIjoiQVBJX2tleV8yIiwiaWQiOjF9");

    }
  //  @Test
    public void test01()
    {
        response = httpRequest.get("/api/users/");
      // response.prettyPrint();
        jp = response.jsonPath();
        System.out.println(jp.getString("[0].name"));

    }

   // @Test
    public void test02()
    {
      //  httpRequest.header("Content-Type", "application/json", "eyJrIjoielY3dlpHMHJUNHRXOWtRZE5DcmdTcjZadkg0UjNQckYiLCJuIjoiQVBJX2tleV8xIiwiaWQiOjF9");
      //  response = httpRequest.get("/api/dashboards/db/dashboard2");
        response = httpRequest.get("/api/dashboards/home");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
        assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void test03()
    {
      // httpRequest.header("Content-Type", "application/json", "eyJrIjoielY3dlpHMHJUNHRXOWtRZE5DcmdTcjZadkg0UjNQckYiLCJuIjoiQVBJX2tleV8xIiwiaWQiOjF9");
       params.put("name", "mykey");
       params.put("role", "Admin");
      // params.put("secondsToLive", "86400");

        httpRequest.body(requestParams.toJSONString());
        response =httpRequest.post("/api/auth/keys");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
        assertEquals(response.getStatusCode(),200);


    }
}
