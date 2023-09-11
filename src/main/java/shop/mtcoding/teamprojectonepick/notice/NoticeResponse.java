package shop.mtcoding.teamprojectonepick.notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NoticeResponse {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IndexDTO {
        private String open;
        private String workField;
        private String address;
        private String career;
        private String education;
    }

}
