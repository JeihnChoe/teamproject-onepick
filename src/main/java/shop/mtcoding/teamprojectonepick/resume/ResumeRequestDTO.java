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
        String career_period1;
        String career_period1_1;
        String career2;
        String career_period2;
        String career_period2_1;
        String career3;
        String career_period3;
        String career_period3_1;
        String open;
        String etc1;
        String etc2;
        String etc3;
        String etc_period1;
        String etc_period2;
        String etc_period3;
        String link1;
        String link2;
        String link3;
        String workField;
        MultipartFile resumeImg;
    }
}
