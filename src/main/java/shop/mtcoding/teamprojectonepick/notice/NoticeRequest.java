package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class NoticeRequest {

    @Data
    public static class SaveDTO {
        private String open;
        private MultipartFile userImg;
        private String semiTitle;
        private String semiContent;
        private String workField;
        private String bizName;
        private String address;
        private String address2;
        private String career;
        private String education;
        private String mainContent;
        private String deadLine;
        private String techNotice;
    }

    @Data
    @AllArgsConstructor
    public static class DetailDTO {
        private String userImg;
        private String semiTitle;
        private String semiContent;
        private String workField;
        private String bizName;
        private String address;
        private String address2;
        private String career;
        private String education;
        private String mainContent;
        private String deadLine;
    }

    @Data
    @AllArgsConstructor
    public static class UpdateDTO {
        private String open;
        private MultipartFile userImg;
        private String semiTitle;
        private String semiContent;
        private String workField;
        private String bizName;
        private String address;
        private String address2;
        private String career;
        private String education;
        private String mainContent;
        private String deadLine;
        private String techNotice;
        private String previewImg;
    }

}
