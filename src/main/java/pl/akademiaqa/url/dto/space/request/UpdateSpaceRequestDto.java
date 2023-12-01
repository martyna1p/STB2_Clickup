package pl.akademiaqa.url.dto.space.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.akademiaqa.url.dto.space.request.features.UpdateSpaceFeaturesRequestDto;

@Data
public class UpdateSpaceRequestDto {

        private String name;
        private String color;
        @JsonProperty("private")
        private boolean private1;
        @JsonProperty("admin_can_manage")
        private boolean adminCanManage;
        @JsonProperty("multiple_assignees")
        private boolean multipleAssignees;
        private UpdateSpaceFeaturesRequestDto features ;


}
