package pl.akademiaqa.url.dto.task.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter //dzięki tej anotacji z lomboka nie musimy generowac getterów poniżej
@ToString //dzięki tej anotacji z lomboka nie musimy dodawac metody toString
@JsonIgnoreProperties(ignoreUnknown = true) //adnotacja pozwala na zignorowanie pól w jsonie których nie rozpoznam
public class CreateTaskResponseDto {

    private String id;
    private String name;
    @JsonProperty("text_content") //mówimy jacksonowi że nasz pole textContent w jasonie widnieje jako text_content
    private String textContent;
    private String description;
    private CreateTaskStatusResponseDto status;
    private CreateTaskCreatorResponseDto creator;

}
