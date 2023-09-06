package shop.mtcoding.teamprojectonepick.techResume;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public class TechResumeRequestDTO {

    @Data
    public static class SaveDTO {
        Integer techId;
    }

}
