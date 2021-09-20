package ru.levelup.at.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileWriter;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssuredSpecificationTest {

    private static final Faker FAKER = new Faker();

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";

        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void getUserTest() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/users/2")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
    }

    @DataProvider
    public Object[][] userDataProvider() {
        return new Object[][] {
            {"2", "janet.weaver@reqres.in"},
            {"3", "emma.wong@reqres.in"},
            {"6", "tracey.ramos@reqres.in"}
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void getUserDataProviderTest(String id, String expectedEmail) {
        RestAssured
            .given()
            .spec(requestSpecification)
            .pathParam("id", id)
            .when()
            .get("/users/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.email", Matchers.equalTo(expectedEmail));
    }

    @Test
    public void createUserTest() {
        String fullName = FAKER.name().fullName();
        String job = FAKER.job().title();

        RestAssured
            .given()
            .spec(requestSpecification)
            .body("{\n"
                + "    \"name\": \"" + fullName + "\",\n"
                + "    \"job\": \"" + job + "\"\n"
                + "}")
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(fullName))
            .body("job", Matchers.equalTo(job))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }

    @DataProvider
    public Object[][] createUserDataProvider() {
        return new Object[][] {
            {FAKER.name().fullName(), FAKER.job().title()},
            {FAKER.name().fullName(), FAKER.job().title()},
            {FAKER.name().fullName(), FAKER.job().title()}
        };
    }

    @Test(dataProvider = "createUserDataProvider")
    public void createUserDataProviderTest(String fullName, String job) {
        RestAssured
            .given()
            .spec(requestSpecification)
            .body("{\n"
                + "    \"name\": \"" + fullName + "\",\n"
                + "    \"job\": \"" + job + "\"\n"
                + "}")
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(fullName))
            .body("job", Matchers.equalTo(job))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }
}
