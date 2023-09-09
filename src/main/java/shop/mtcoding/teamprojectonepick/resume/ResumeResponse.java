package shop.mtcoding.teamprojectonepick.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResumeResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class TechDTO {
        private Integer id;
        private String techname;
        private Boolean checked;
    }

    @NoArgsConstructor
    @Data
    public static class EduDTO {
        private String education;
        private boolean isGojol;
        private boolean isDaejol;
        private boolean isDaejolMore;

        public EduDTO(String education) {
            this.education = education;
            if (education.equals("고졸")) {
                isGojol = true;
            } else if (education.equals("대졸") || education.equals("대학교 졸업")) {
                isDaejol = true;
            } else {
                isDaejolMore = true;
            }
        }
    }
}
