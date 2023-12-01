package pl.akademiaqa.url.dto.space.request.features;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateSpaceFeaturesRequestDto {

        @JsonProperty("due_dates")
        private UpdateSpaceFeaturesDueDatesRequestDto dueDates;
        @JsonProperty("time_tracking")
        private UpdateSpaceFeaturesTimeTrackingRequestDto timeTracking;
        private UpdateSpaceFeaturesTagsRequestDto tags;
        @JsonProperty("time_estimates")
        private UpdateSpaceFeaturesTimeEstimatesRequestDto timeEstimates;
        private UpdateSpaceFeaturesChecklistsRequestDto checklists;
        @JsonProperty("custom_fields")
        private UpdateSpaceFeaturesCustomFieldsRequestDto customFields;
        @JsonProperty("remap_dependencies")
        private UpdateSpaceFeaturesRemapDependenciesRequestDto remapDependencies;
        @JsonProperty("dependency_warning")
        private UpdateSpaceFeaturesDependencyWarningRequestDto dependencyWarning;
        private UpdateSpaceFeaturesPortfoliosRequestDto portfolios;

}
