package pl.akademiaqa.tests.space;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.UpdateSpaceRequest;
import pl.akademiaqa.url.dto.space.request.UpdateSpaceRequestDto;

class CreateSpaceWithPOJOTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateSpaceWithPOJOTest.class); //fabryka która utworzy logger na podstawie nazwy klasy

    private static final String SPACE_NAME = "MY SPACE FROM JAVA";
    private static final String SPACE_NAME_UPDATE = "MY SPACE FROM JAVA 1234 $%^";


    @Test
    void createSpaceTest() {

        JSONObject space = new JSONObject();
        space.put("name", SPACE_NAME);


        final var response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(SPACE_NAME);

        final var spaceId = response.jsonPath().getString("id");

        UpdateSpaceRequestDto spaceDto = new UpdateSpaceRequestDto(); //tworzymy obiekt za pomocą klasy dto
        //następnie za pomocą setterów ustawiamy dane
        spaceDto.setName(SPACE_NAME_UPDATE);


        final var updateResponse = UpdateSpaceRequest.updateSpace(spaceDto, spaceId);
        LOGGER.info("CREATE SPACE RESPONSE OBJECT: {}", updateResponse);
//
//
//        JSONObject updateSpace = new JSONObject();
//        updateSpace.put("name", SPACE_NAME_UPDATE);
//
//        final var updateResponse = UpdateSpaceRequest.updateSpace(updateSpace, spaceId);
//        Assertions.assertThat(updateResponse.statusCode()).isEqualTo(200);
//        Assertions.assertThat(updateResponse.jsonPath().getString("name")).isEqualTo(SPACE_NAME_UPDATE);


//        final var deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
//        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);

    }
}
