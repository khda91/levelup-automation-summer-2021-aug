package ru.levelup.at.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.FileWriter;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssuredSimpleExampleTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void getUserTest() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured
            .given()
            .log().all()
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void createUserTest() {
        String fullName = FAKER.name().fullName();
        String job = FAKER.job().title();

        RestAssured
            .given()
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\n"
                + "    \"name\": \"" + fullName + "\",\n"
                + "    \"job\": \"" + job + "\"\n"
                + "}")
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .log().all()
            .statusCode(201)
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(fullName))
            .body("job", Matchers.equalTo(job))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }

    @Test
    public void getUserResponseToFileTest() {
        Response response = RestAssured
            .given()
            .log().all()
            // .auth()
            // .oauth2("")
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"))
            .extract().response();

        try (FileWriter fileWriter = new FileWriter("target/api/response_to_file_example.json")) {
            fileWriter.write(response.body().asPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
