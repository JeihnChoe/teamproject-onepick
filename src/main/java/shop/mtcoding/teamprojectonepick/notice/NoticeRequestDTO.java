package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.teamprojectonepick.notice.NoticeRequestDTO.DetailDTO;
import shop.mtcoding.teamprojectonepick.tech.Tech;

@Component
public class NoticeRequestDTO {

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
    public static class DetailDTO{
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
    public class UpdateDTO {
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




}