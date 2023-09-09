package shop.mtcoding.teamprojectonepick.apply;

import lombok.Getter;
import lombok.Setter;

public class ApplyRequest {
    @Getter
    @Setter
    public static class AddDTO {
        private Integer resumeId;
        private Integer noticeId;
    }

}
