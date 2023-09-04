package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class NoticeRequestDTO {

    @Getter@Setter
    public static class SaveDTO{
        private boolean open;
        private String bizImg;
        private String semiTitle;
        private String semiContent;
        private String workField;
        private String bizName;
        private String bizAddress;
        private String career;
        private String education;
        private String mainContent;
        private String deadLine;
    }

    
}
