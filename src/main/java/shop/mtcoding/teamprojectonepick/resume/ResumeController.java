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
import shop.mtcoding.teamprojectonepick.techResume.TechResumeRequestDTO;
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
    public String writeResume(ResumeRequestDTO.SaveDTO saveDTO, TechResumeRequestDTO.TechResumeSaveDTO trSaveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");

        resumeService.이력서작성(saveDTO, trSaveDTO);
        // TechResumeService.이력서기술저장();

        System.out.println("테스트Title : " + saveDTO.getTitle());
        System.out.println("테스트SemiContent : " + saveDTO.getSemiContent());
        System.out.println("테스트Content : " + saveDTO.getContent());
        System.out.println("테스트Education : " + saveDTO.getEducation());
        System.out.println("테스트School : " + saveDTO.getSchool());
        System.out.println("테스트Major : " + saveDTO.getMajor());
        System.out.println("테스트Career1 : " + saveDTO.getCareer1());
        System.out.println("테스트CareerPeriod1 : " + saveDTO.getCareerPeriod1());
        System.out.println("테스트CareerPeriod1_1 : " + saveDTO.getCareerPeriod1_1());
        System.out.println("테스트Career2 : " + saveDTO.getCareer2());
        System.out.println("테스트CareerPeriod2 : " + saveDTO.getCareerPeriod2());
        System.out.println("테스트CareerPeriod2_1 : " + saveDTO.getCareerPeriod2_1());
        System.out.println("테스트Career3 : " + saveDTO.getCareer3());
        System.out.println("테스트CareerPeriod3 : " + saveDTO.getCareerPeriod3());
        System.out.println("테스트CareerPeriod3_1 : " + saveDTO.getCareerPeriod3_1());
        System.out.println("테스트Open : " + saveDTO.getOpen());
        System.out.println("테스트Etc1 : " + saveDTO.getEtc1());
        System.out.println("테스트Etc2 : " + saveDTO.getEtc2());
        System.out.println("테스트Etc3 : " + saveDTO.getEtc3());
        System.out.println("테스트EtcPeriod1 : " + saveDTO.getEtcPeriod1());
        System.out.println("테스트EtcPeriod2 : " + saveDTO.getEtcPeriod2());
        System.out.println("테스트EtcPeriod3 : " + saveDTO.getEtcPeriod3());
        System.out.println("테스트Link1 : " + saveDTO.getLink1());
        System.out.println("테스트Link2 : " + saveDTO.getLink2());
        System.out.println("테스트Link3 : " + saveDTO.getLink3());
        System.out.println("테스트WorkField : " + saveDTO.getWorkField());
        System.out.println("테스트ResumeImg : " + saveDTO.getResumeImg());

        return "/userBoard/manageResumeForm";
    }
}

// 이력서 작성 - 기술 테이블 ajax로 출력하는거 해야됨