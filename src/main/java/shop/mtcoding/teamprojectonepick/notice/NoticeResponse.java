package shop.mtcoding.teamprojectonepick.notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NoticeResponse {
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class TechDTO {
        private Integer id;
        private String techname;
        private Boolean checked;
    }
}
