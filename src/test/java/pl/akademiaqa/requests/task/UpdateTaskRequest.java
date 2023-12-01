package pl.akademiaqa.requests.task;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {

    public static Response updateTask(JSONObject updateTask, String taskId) { //może być ta sama nazwa jak wyżej, metody róznią się parametrami więc się nadpiszą

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateTask.toString()) //przy obiekcie typu dto nie musimy wywoływac metody to string
                .when()
                .put(ClickUpUrl.getTaskUrl(taskId))
                .then()
                .statusCode(200)//dodajemy ten status kod bo w przypadku zwracania respons ajako obiekt dto ifno o statusie nam zniknie
                .log().ifError()
                .extract()
                .response();
        //.as(CreateTaskResponseDto.class); //zwracamy response jako obiekt javowy określony w metodzie creteTaskresponsedto
    }
//
//    {
//        "name": "Przetestować clickup i zobaczyć czy update działa",
//            "description": "Ciekawe jak to działa, a czy update działa?",
//            "status": "to do",
//            "priority": null,
//            "parent": null,
//            "time_estimate": null,
//            "assignees": {},
//        "archived": false
//    }


}
