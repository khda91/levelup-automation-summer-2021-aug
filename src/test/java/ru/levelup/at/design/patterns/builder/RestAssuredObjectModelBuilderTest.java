package ru.levelup.at.design.patterns.builder;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RestAssuredObjectModelBuilderTest {

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

    @DataProvider
    public Object[][] createUserDataProvider() {
        return new Object[][] {
            {new CreateUserRequest(FAKER.name().fullName(), null)},
            {new CreateUserRequest(null, FAKER.job().title())},
            {new CreateUserRequest(null, null)}
        };
    }

    @DataProvider
    public Object[][] createUserBuilderDataProvider() {
        return new Object[][] {
            {CreateUserRequest.builder()
                              .setName(FAKER.name().fullName())
                .build()},
            {CreateUserRequest.builder()
                              .setJob(FAKER.job().title())
                .build()},
            {CreateUserRequest.builder().build()}
        };
    }

    @Test(dataProvider = "createUserBuilderDataProvider")
    public void createUserDataProviderTest(CreateUserRequest createUserRequest) {
        RestAssured
            .given()
            .spec(requestSpecification)
            .body(createUserRequest)
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .body("id", Matchers.matchesRegex("\\d+"))
            .body("name", Matchers.equalTo(createUserRequest.getName()))
            .body("job", Matchers.equalTo(createUserRequest.getJob()))
            .body("createdAt", Matchers.not(Matchers.emptyString()));
    }
}
