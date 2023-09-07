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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamprojectonepick._core.util.Script;
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

        // 완료
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
        public String writeResume(ResumeRequestDTO.SaveDTO saveDTO,
                        @RequestParam(name = "tech-resume") List<Integer> techId) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                System.out.println(techId);
                resumeService.이력서작성(saveDTO, techId, sessionUser.getId());
                System.out.println("테스트 :" + saveDTO.careerPeriodS1);

                return "redirect:/userProfileForm";
        }

        // 완료
        @GetMapping("/viewResumeForm/{id}")
        public String viewResumeForm(@PathVariable Integer id, HttpServletRequest request) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                Resume resume = resumeService.이력서상세보기(id);
                List<TechResume> techResumes = techResumeRepository.mFindByIdJoinResumeJoinUser(id);
                resume.setResumeImg("" + resume.getResumeImg());
                request.setAttribute("resume", resume);
                request.setAttribute("techResumes", techResumes);
                return "/resume/viewResumeForm";
        }

        @PostMapping("/deleteResume/{id}")
        public @ResponseBody String delete(@PathVariable Integer id) {
                resumeService.삭제하기(id);
                return Script.href("/userProfileForm", "삭제되었습니다.");
        }

        @GetMapping("/updateResume/{id}")
        public String updateForm(@PathVariable Integer id, Model model) {
                Resume resume = resumeService.이력서상세보기(id);
                List<TechResume> techResumes = techResumeRepository.mFindByIdJoinResumeJoinUser(id);
                model.addAttribute("resume", resume);
                return "board/updateForm";
        }

        @PostMapping("/updateResume/{id}")
        public String update(@PathVariable Integer id, ResumeRequestDTO.UpdateDTO updateDTO) {
                resumeService.삭제하기(id);
                return Script.href("/userProfileForm", "삭제되었습니다.");
        }

}
