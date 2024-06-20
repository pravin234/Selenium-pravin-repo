package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

import Files.Payload;
import Files.ReUsableMethods;

public class Map1 {

    public static void main(String[] args) {

        // Step 1: Validate if Add Place API is working as expected
        // Add place -> Update Place with New Address -> Get Place to validate if New
        // address is present in response

        // Base URI for the RestAssured API
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Step 2: Add a place using POST request
        // given - all input details
        // when - Submit the API - resource, http method
        // Then - validate the response
        String response = given().log().all()
                .queryParam("Key", "qaclick123")
                .header("content-type", "application/json")
                .body(Payload.AddPlace()) // Payload.AddPlace() returns the body content for adding a place
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200) // Assert that the status code is 200
                .body("scope", equalTo("APP")) // Assert that the response body has a scope of "APP"
                .header("server", "Apache/2.4.52 (Ubuntu)") // Assert that the server header is "Apache/2.4.52 (Ubuntu)"
                .extract().response().asString(); // Extract the response as a String

        System.out.println(response); // Print the response

        // Parse the JSON response to get the place ID
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id"); // Extract place_id from the response
        System.out.println(placeId); // Print the place ID

        // Step 3: Update the place with a new address using PUT request
        String newAddress = "Summer Walk, Africa"; // New address to be updated

        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\r\n" + 
                      "\"place_id\":\"" + placeId + "\",\r\n" + 
                      "\"address\":\"" + newAddress + "\",\r\n" + 
                      "\"key\":\"qaclick123\"\r\n" + 
                      "}") // Body content for updating the place with new address
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200) // Assert that the status code is 200
                .body("msg", equalTo("Address successfully updated")); // Assert that the response message is as expected

        // Step 4: Get the place to validate if the new address is present in the response using GET request
        String getPlaceResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200) // Assert that the status code is 200
                .extract().response().asString(); // Extract the response as a String

        // Parse the JSON response to get the actual address
        JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address"); // Extract the address from the response
        System.out.println(actualAddress); // Print the actual address

        // Assert that the actual address is the same as the new address
        Assert.assertEquals(actualAddress, "Summer Walk, Africa");
    }
}
