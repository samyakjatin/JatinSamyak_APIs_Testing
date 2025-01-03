package post_restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationController01 {

    @Test
    public void createSymmetry() {
        
        // Set the base URI
        RestAssured.baseURI = "http://localhost:8080/api/v1"; 
        RequestSpecification request = RestAssured.given();
        
        // Add Authorization header for Bearer Token Authentication
        String token = Config.token;  // Get token from the Config class     
        request.header("Authorization", "Bearer " + token);  // Add Bearer token in Authorization header
        
        // Set the Content-Type header to application/json
        request.header("Content-Type", "application/json");  
        
        // Create the JSON body for the POST request
        String jsonBody = "{\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"midName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"userName\": \"string\",\n" +
                "  \"phoneNumber\": \"string\",\n" +
                "  \"faxNo\": \"string\",\n" +
                "  \"companyName\": \"string\",\n" +
                "  \"email2\": \"string\",\n" +
                "  \"role\": \"string\",\n" +
                "  \"status\": \"ACTIVE\",\n" +
                "  \"referenceName\": \"string\",\n" +
                "  \"remark\": \"string\",\n" +
                "  \"addressInfo\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"houseNo\": \"string\",\n" +
                "    \"city\": \"string\",\n" +
                "    \"zipCode\": \"string\",\n" +
                "    \"state\": \"string\",\n" +
                "    \"country\": \"string\",\n" +
                "    \"countryId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  },\n" +
                "  \"active\": \"string\",\n" +
                "  \"kycStatus\": \"string\",\n" +
                "  \"userInterest\": \"string\",\n" +
                "  \"ledgerType\": \"string\",\n" +
                "  \"isSupplier\": \"string\",\n" +
                "  \"noOfBoxes\": \"string\",\n" +
                "  \"pendingBoxes\": 0,\n" +
                "  \"auctionIds\": [\n" +
                "    \"3fa85f64-5717-4562-b3fc-2c963f66afa6\"\n" +
                "  ],\n" +
                "  \"validIdProofName\": \"string\",\n" +
                "  \"companyIdProof\": \"string\",\n" +
                "  \"userId\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                "  \"soldCommision\": 0,\n" +
                "  \"unsoldCommision\": 0\n" +
                "}";

        // Add the JSON body to the request
        request.body(jsonBody);
        
        // Send the POST request
        Response response = request.post("/auth/register");
        
        // Print the response status and body for debugging
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response: " + response.getBody().asString());  // Added response logging
        System.out.println("---------------Response Details---------------");
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        
        // Check if the status code is 200 (OK) or 201 (Created)
        if (statusCode == 200) {
            System.out.println("Request succeeded: Data inserted successfully.");
        } else if (statusCode == 201) {
            System.out.println("Request succeeded: Symmetry created.");
        } else if (statusCode == 400) {
            System.out.println("Bad Request: Invalid input.");
        } else if (statusCode == 403) {
            System.out.println("Forbidden: Access is denied.");
        } else if (statusCode == 500) {
            System.out.println("Internal Server Error: The server encountered an unexpected condition.");
        }

        // Assert that the status code is 200 (OK) or 201 (Created)
        Assert.assertTrue(statusCode == 200 || statusCode == 201, "Expected 200 OK or 201 Created, but got: " + statusCode);
    }
}
