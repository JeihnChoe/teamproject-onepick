package shop.mtcoding.teamprojectonepick.resume;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public interface ResumeRequest {

    @Data
    public static class SaveDTO {
        String title;
        String semiContent;
        String content;
        String education;
        String school;
        String major;
        String career1;
        String careerPeriodS1;
        String careerPeriodE1;
        String career2;
        String careerPeriodS2;
        String careerPeriodE2;
        String career3;
        String careerPeriodS3;
        String careerPeriodE3;
        String open;
        String etc1;
        String etc2;
        String etc3;
        String etcPeriod1;
        String etcPeriod2;
        String etcPeriod3;
        String link1;
        String link2;
        String link3;
        String workField;
        MultipartFile resumeImg;
    }

    @Data
    public class UpdateDTO {
        String title;
        String semiContent;
        String content;
        String education;
        String school;
        String major;
        String career1;
        String careerPeriodS1;
        String careerPeriodE1;
        String career2;
        String careerPeriodS2;
        String careerPeriodE2;
        String career3;
        String careerPeriodS3;
        String careerPeriodE3;
        String open;
        String etc1;
        String etc2;
        String etc3;
        String etcPeriod1;
        String etcPeriod2;
        String etcPeriod3;
        String link1;
        String link2;
        String link3;
        String workField;
        MultipartFile resumeImg;
    }

}
