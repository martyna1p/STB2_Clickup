package pl.akademiaqa.requests.task;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;
import pl.akademiaqa.url.dto.task.request.CreateTaskRequestDto;
import pl.akademiaqa.url.dto.task.response.CreateTaskResponseDto;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {

    public static Response createTask(JSONObject task, String listId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(task.toString())
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static CreateTaskResponseDto createTask(CreateTaskRequestDto taskDto, String listId) { //może być ta sama nazwa jak wyżej, metody róznią się parametrami więc się nadpiszą

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(taskDto) //przy obiekcie typu dto nie musimy wywoływac metody to string
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .statusCode(200)//dodajemy ten status kod bo w przypadku zwracania respons ajako obiekt dto ifno o statusie nam zniknie
                .log().ifError()
                .extract()
                .response()
                .as(CreateTaskResponseDto.class); //zwracamy response jako obiekt javowy określony w metodzie creteTaskresponsedto
    }
}
