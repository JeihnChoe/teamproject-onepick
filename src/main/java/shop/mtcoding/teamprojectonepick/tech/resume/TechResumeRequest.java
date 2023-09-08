package shop.mtcoding.teamprojectonepick.tech.resume;

import java.util.List;

import lombok.Data;

public class TechResumeRequest {

    @Data
    public static class SaveDTO {
        List<Integer> techId;
    }

}
