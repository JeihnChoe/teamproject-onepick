package shop.mtcoding.teamprojectonepick.techResume;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public class TechResumeRequestDTO {

    @Data
    public static class TechResumeSaveDTO {
        List<Integer> techId;
    }

}
