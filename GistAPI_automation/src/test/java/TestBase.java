import helpers.DataProvider;
import helpers.GistsActions;
import helpers.builders.TestDataFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.File;
import models.requests.Gist;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class TestBase {

    protected GistsActions gistsActions;
    private String authToken;

    @BeforeClass
    public void TestBase() {

        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            RestAssured.baseURI = prop.getProperty("uri");
            authToken = prop.getProperty("token");

            if (authToken == null || authToken.equals("")) {
                System.out.println(authToken);
                authToken = System.getenv("GIST_API_KEY");
            }
            gistsActions = new GistsActions();

        } catch (IOException e) {
            System.out.println(e + "   " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected RequestSpecification setAuthorize() {
        return RestAssured.given().auth().oauth2(authToken).contentType(ContentType.JSON);
    }

    protected RequestSpecification setUnAuthorize() {
        return RestAssured.given().contentType(ContentType.JSON);
    }


    protected Gist generateGist(String fileName, String content) {
        final File file = createFile(fileName, content);

        Gist gist = TestDataFactory.getGistBuilder()
                .withDescription(DataProvider.getRandomDescription())
                .withPublicity(true)
                .withFile(file)
                .build();
        return gist;
    }

    protected Gist generateGist(List<File> files) {
        Gist gist = TestDataFactory.getGistBuilder()
                .withDescription(DataProvider.getRandomDescription())
                .withPublicity(true)
                .withFiles(files)
                .build();

        return gist;
    }

    protected File createFile(String fileName, String content) {
        return TestDataFactory.getFileDataBuilder()
                .createFile(fileName)
                .WithContent(content)
                .build();
    }
}