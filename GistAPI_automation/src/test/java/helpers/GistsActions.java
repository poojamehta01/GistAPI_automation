package helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.Gist;

public class GistsActions {

    public Response createGist(RequestSpecification rSpec, Gist gist) {

        return rSpec
                .log().all()
                .body(gist)
                .when()
                .post("/gists")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response editGist(RequestSpecification rSpec, Gist gist, String gistId) {

        return rSpec
                .log().all()
                .body(gist)
                .when()
                .patch("/gists/" + gistId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getGist(RequestSpecification rSpec, String gistId) {

        return rSpec
                .when()
                .get("/gists/" + gistId)
                .then()
                .extract()
                .response();
    }

    public Response deleteGists(RequestSpecification rSpec, String gistId) {

        return rSpec
                .when()
                .log().all()
                .delete("/gists/" + gistId)
                .then()
                .extract()
                .response();
    }
}
