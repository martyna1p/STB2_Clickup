package pl.akademiaqa.url.dto.space.request.features;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateSpaceFeaturesDueDatesRequestDto {

        private boolean enabled;
        @JsonProperty("start_date")
        private boolean startDate;
        @JsonProperty("remap_due_dates")
        private boolean remapDueDates;
        @JsonProperty("remap_closed_due_date")
        private boolean remapClosedDueDate;
}
