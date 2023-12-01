package pl.akademiaqa.requests.space;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;
import pl.akademiaqa.url.dto.space.request.UpdateSpaceRequestDto;

import static io.restassured.RestAssured.given;

public class UpdateSpaceRequest {

    public static Response updateSpace(JSONObject updateSpace, String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateSpace.toString())
                .when()
                .put(ClickUpUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static Response updateSpace(UpdateSpaceRequestDto updateSpaceDto, String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateSpaceDto)
                .when()
                .put(ClickUpUrl.getSpaceUrl(spaceId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }
}
