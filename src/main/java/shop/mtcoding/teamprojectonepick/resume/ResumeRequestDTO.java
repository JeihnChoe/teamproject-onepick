package shop.mtcoding.teamprojectonepick.resume;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public interface ResumeRequestDTO {

    @Data
    public static class SaveDTO {
        String title;
        String semiContent;
        String content;
        String education;
        String school;
        String major;
        String career1;
        String careerPeriod1;
        String careerPeriod1_1;
        String career2;
        String careerPeriod2;
        String careerPeriod2_1;
        String career3;
        String careerPeriod3;
        String careerPeriod3_1;
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
