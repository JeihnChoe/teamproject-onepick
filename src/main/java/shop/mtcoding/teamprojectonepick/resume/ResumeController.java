package shop.mtcoding.teamprojectonepick.resume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.techResume.TechResume;
import shop.mtcoding.teamprojectonepick.techResume.TechResumeRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private TechResumeRepository techResumeRepository;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/writeResumeForm")
    public String writeResumeForm(HttpServletRequest request) {
        // TechResume techResume = techResumeRepository.mFindByIdJoinResume(3);
        // request.setAttribute("techResume", techResume);

        List<Tech> techs = techRepository.findAll();
        request.setAttribute("techs", techs);
        return "/resume/writeResumeForm";
    }

    // 완료
    @PostMapping("/resume/writeResume")
    public String writeResume(ResumeRequestDTO.SaveDTO saveDTO, TechResumeRepository.) {
        User sessionUser = (User) session.getAttribute("sessionUser");

        resumeService.이력서작성(saveDTO, techResume);
        // TechResumeService.이력서기술저장();
        return "/userBoard/manageResumeForm";
    }
}

// 이력서 작성 - 기술 테이블 ajax로 출력하는거 해야됨