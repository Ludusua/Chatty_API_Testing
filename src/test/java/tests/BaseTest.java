package tests;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseTest {
    final static String BASE_URI = "http://chatty.telran-edu.de:8989";
    final static String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NDFkNjQzNC00ZDQwLTQ2MTgtYjZjNC02MzAyYmQ4YzczNjQiLCJpYXQiOjE3MzM2Njg5NjIsImV4cCI6MTczMzg0MTc2Mn0.OFTydgSFKzNGzyiCNM58icxUCLhBhMNJntzC9f5y6j8";
    static RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .addHeader("Authorization", "Bearer " + TOKEN)
            .setContentType(ContentType.JSON)

            .build();
    static RequestSpecification specWithoutToken = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();

    protected Response getRequest(String endPoint, int expectedStatusCode) {
        Response response = given()
                .spec(specification)
                .when()
                .log().all()
                .get(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    protected Response getRequestWithoutToken(String endPoint, int expectedStatusCode) {
        Response response = given()
                .spec(specWithoutToken)
                .when()
                .log().all()
                .get(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    protected Response getRequestWithParam(String endpoint, int expectedStatusCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(expectedStatusCode);
        return response;
    }

    protected Response postRequest(String endPoint, int expectedStatusCode, Object body) {
        Response response = given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    protected Response postRequestWithoutBody(String endPoint, int expectedStatusCode) {
        Response response = given()
                .spec(specification)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    protected Response postRequestWithoutToken(String endPoint, int expectedStatusCode, Object body) {
        Response response = given()
                .spec(specWithoutToken)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    protected Response putRequest(String endpoint, int expectedStatusCode, Object body) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .put(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(expectedStatusCode);
        return response;
    }

    protected Response putRequestWithParam(String endpoint, int expectedStatusCode, Object body, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .put(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(expectedStatusCode);
        return response;
    }

    protected Response deleteRequest(String endpoint, int expectedStatusCode, int id) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(expectedStatusCode);
        return response;
    }

    protected Response deleteRequestWithParam(String endpoint, int expectedStatusCode, String paramName, String paramValue) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .pathParam(paramName, paramValue)
                .log().all()
                .delete(endpoint)
                .then().log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }


}
