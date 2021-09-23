package ru.levelup.at.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.at.api.model.CreateUserRequest;
import ru.levelup.at.api.model.CreateUserResponse;

public class RestAssuredObjectModelDataFromExternalSourceTest {

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
        Object[][] tessData = new Object[3][1];
        try (FileInputStream fis = new FileInputStream("src/test/resources/api/data/emaple_test_data.xlsx")) {
            XSSFWorkbook myExcelBook = new XSSFWorkbook(fis);
            XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
            int rowCount = 3;

            for (int i = 0; i < rowCount; i++) {
                CreateUserRequest request = new CreateUserRequest();

                XSSFRow row = myExcelSheet.getRow(i);

                if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    String name = row.getCell(0).getStringCellValue();
                    System.out.println("name : " + name);
                    request.setName(name);
                }

                if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    String job = row.getCell(1).getStringCellValue();
                    System.out.println("job : " + job);
                    request.setJob(job);
                }

                tessData[i][0] = request;
            }
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tessData;
    }

    @Test(dataProvider = "createUserDataProvider")
    public void createUserDataProviderTest(CreateUserRequest createUserRequest) {
        CreateUserResponse actualResponse = RestAssured
            .given()
            .spec(requestSpecification)
            .body(createUserRequest)
            .when()
            .post("/users")
            .then()
            .spec(responseSpecification)
            .statusCode(201)
            .extract().body().as(CreateUserResponse.class);

        System.out.println("Web Service response -> " + actualResponse);

        CreateUserResponse expectedResponse =
            new CreateUserResponse(createUserRequest.getName(), createUserRequest.getJob());

        assertThat(actualResponse.getId())
            .as("id field does not contain only numeric value")
            .matches(Pattern.compile("\\d+"));

        assertThat(actualResponse)
            .as("User " + createUserRequest.getName() + " was not created")
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expectedResponse);

        assertThat(actualResponse.getCreatedAt())
            .as("createdAt field does not contain value")
            .isNotEmpty();
    }
}
