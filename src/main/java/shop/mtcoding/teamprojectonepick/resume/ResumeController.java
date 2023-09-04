package shop.mtcoding.teamprojectonepick.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
    @GetMapping("/writeResumeForm")
    public String writeResumeForm() {
        return "/resume/writeResumeForm";
    }
}
