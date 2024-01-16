package com.restful.booker.testsuite;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class BookingAssertion {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/10")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        response.body(".", hasKey("bookingdates"));

    }

    @Test
    public void test002() {

        response.body(".", hasKey("depositpaid"));
    }

    @Test
    public void test003() {
        response.body("", hasKey("totalprice"));
    }

    @Test
    public void test004() {

        response.body(".", hasKey("totalprice"));
    }

    @Test
    public void test005() {
        response.body("bookingdates", hasKey("checkin"));

    }
}
