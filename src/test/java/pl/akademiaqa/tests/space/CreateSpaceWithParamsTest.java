package pl.akademiaqa.tests.space;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;
import pl.akademiaqa.requests.space.UpdateSpaceRequest;

import java.util.stream.Stream;

class CreateSpaceWithParamsTest {

    @ParameterizedTest(name = "Create space with space name: {0}")
    @DisplayName("Create space with valid space name and then Update")
    @MethodSource({"createSpaceData"})
    void createSpaceTest(String spaceName, String spaceNameUpdated) {

        JSONObject space = new JSONObject();
        space.put("name", spaceName);

        JSONObject updateSpace = new JSONObject();
        updateSpace.put("name", spaceNameUpdated);

        final var response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(spaceName);

        final var spaceId = response.jsonPath().getString("id");

        final var updateResponse = UpdateSpaceRequest.updateSpace(updateSpace, spaceId);
        Assertions.assertThat(updateResponse.statusCode()).isEqualTo(200);
        Assertions.assertThat(updateResponse.jsonPath().getString("name")).isEqualTo(spaceNameUpdated);


        final var deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);

    }

    private static Stream<Arguments> createSpaceData() {

        return Stream.of(
                Arguments.of("TEST SPACE", "TEST SPACE_UPDATED"),
                Arguments.of("123", "1223 098"),
                Arguments.of("#", "%$ER23")
        );

    }
}
