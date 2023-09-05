package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Component
public class NoticeRequestDTO {

    @Getter@Setter
    public static class SaveDTO{
        private String open;
        private MultipartFile userImg;
        private String semiTitle;
        private String semiContent;
        private String workField;
        private String bizName;
        private String userAddress;
        private String career;
        private String education;
        private String mainContent;
        private String deadLine;
        
    }

    
}
