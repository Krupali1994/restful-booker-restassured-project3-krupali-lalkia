package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingExtraction {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        String firstName = response.extract().path("firstname");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + firstName);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test002() {
        String lastName = response.extract().path("lastname");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + lastName);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test003() {
        int price = response.extract().path("totalprice");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + price);
        System.out.println("------------------End of Test---------------------------");

    }
}
