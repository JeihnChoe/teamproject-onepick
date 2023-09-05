package shop.mtcoding.teamprojectonepick.resume;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private HttpSession session;

    @GetMapping("/writeResumeForm")
    public String writeResumeForm() {
        return "/resume/writeResumeForm";
    }

    // 완료
    @PostMapping("/resume/writeResume")
    public String writeResume(ResumeRequestDTO.SaveDTO saveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        resumeService.이력서작성(saveDTO, sessionUser.getId());
        return "/userBoard/manageResumeForm";
    }
}

// 이력서 작성 - 기술 테이블 ajax로 출력하는거 해야됨