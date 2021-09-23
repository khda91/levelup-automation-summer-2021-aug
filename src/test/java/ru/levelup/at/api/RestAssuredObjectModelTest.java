package ru.levelup.at.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.regex.Pattern;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.api.model.CreateUserRequest;
import ru.levelup.at.api.model.CreateUserResponse;
import ru.levelup.at.api.model.GetUserResponse;
import ru.levelup.at.api.model.SupportData;
import ru.levelup.at.api.model.UserData;

public class RestAssuredObjectModelTest {

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
    public void createUserTest() {
        String fullName = FAKER.name().fullName();
        String job = FAKER.job().title();

        RestAssured
            .given()
            .spec(requestSpecification)
            .body(new CreateUserRequest(fullName, job))
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

    @Test
    public void createUserResponseAsObjectTest() {
        String fullName = FAKER.name().fullName();
        String job = FAKER.job().title();

        CreateUserResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .body(new CreateUserRequest(fullName, job))
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .extract().body().as(CreateUserResponse.class);

        System.out.println("Web Service response - > " + actualResponse);

        CreateUserResponse expectedResponse = new CreateUserResponse(fullName, job);

        assertThat(actualResponse.getId())
            .as("id field does not contain only numeric value")
            .matches(Pattern.compile("\\d+"));

        assertThat(actualResponse)
            .as("User " + fullName + " was not created")
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expectedResponse);

        assertThat(actualResponse.getCreatedAt())
            .as("createdAt field does not contain value")
            .isNotEmpty();

        // .body("id", Matchers.matchesRegex("\\d+"))
        // .body("name", Matchers.equalTo(fullName))
        // .body("job", Matchers.equalTo(job))
        // .body("createdAt", Matchers.not(Matchers.emptyString()));
    }

    @DataProvider
    public Object[][] createUserDataProvider() {
        return new Object[][] {
            {new CreateUserRequest(FAKER.name().fullName(), FAKER.job().title())},
            {new CreateUserRequest(FAKER.name().fullName(), FAKER.job().title())},
            {new CreateUserRequest(FAKER.name().fullName(), FAKER.job().title())}
        };
    }

    @Test(dataProvider = "createUserDataProvider")
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

    @DataProvider
    public Object[][] userDataProvider() {
        UserData janetUserData = new UserData();
        janetUserData.setId(2L);
        janetUserData.setEmail("janet.weaver@reqres.in");
        janetUserData.setFirstName("Janet");
        janetUserData.setLastName("Weaver");
        janetUserData.setAvatar("https://reqres.in/img/faces/2-image.jpg");

        SupportData supportData = new SupportData();
        supportData.setUrl("https://reqres.in/#support-heading");
        supportData.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        UserData emmaUserData = new UserData();
        emmaUserData.setId(3L);
        emmaUserData.setEmail("emma.wong@reqres.in");
        emmaUserData.setFirstName("Emma");
        emmaUserData.setLastName("Wong");
        emmaUserData.setAvatar("https://reqres.in/img/faces/3-image.jpg");

        UserData traceyUserData = new UserData();
        traceyUserData.setId(6L);
        traceyUserData.setEmail("tracey.ramos@reqres.in");
        traceyUserData.setFirstName("Tracey");
        traceyUserData.setLastName("Ramos");
        traceyUserData.setAvatar("https://reqres.in/img/faces/6-image.jpg");

        return new Object[][] {
            {"2", new GetUserResponse(janetUserData, supportData)},
            {"3", new GetUserResponse(emmaUserData, supportData)},
            {"6", new GetUserResponse(traceyUserData, supportData)}
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void getUserDataProviderTest(String id, GetUserResponse expectedResponse) {
        GetUserResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .pathParam("id", id)
            .when()
            .get("/users/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .extract().body().as(GetUserResponse.class);

        assertThat(actualResponse)
            .as("Incorrect data was received for user with id " + id)
            .isEqualTo(expectedResponse);
    }

    @Test(dataProvider = "userDataProvider")
    public void getUserDataProviderWithEqualsTest(String id, GetUserResponse expectedResponse) {
        GetUserResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .pathParam("id", id)
            .when()
            .get("/users/{id}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .extract().body().as(GetUserResponse.class);

        System.out.println("actual \n" + actualResponse);
        System.out.println();
        System.out.println("expected \n" + expectedResponse);

        System.out.println("actual hashCode " + actualResponse.hashCode());
        System.out.println();
        System.out.println("expected hashCode " + expectedResponse.hashCode());

        assertTrue(expectedResponse.equals(actualResponse));
    }
}
