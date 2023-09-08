package shop.mtcoding.teamprojectonepick.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResumeResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class TechDTO {
        private Integer id;
        private String techName;
        private Boolean checked;
    }
}
