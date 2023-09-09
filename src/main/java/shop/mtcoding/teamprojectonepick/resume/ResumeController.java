package shop.mtcoding.teamprojectonepick.resume;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.teamprojectonepick._core.util.Script;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.tech.resume.TechResume;
import shop.mtcoding.teamprojectonepick.tech.resume.TechResumeRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class ResumeController {

        @Autowired
        private ResumeService resumeService;

        @Autowired
        private ResumeRepository resumeRepository;

        @Autowired
        private TechResumeRepository techResumeRepository;

        @Autowired
        private TechRepository techRepository;

        @Autowired
        private HttpSession session;

        // 완료
        @GetMapping("/resume/writeForm")
        public String writeResumeForm(HttpServletRequest request) {
                // TechResume techResume = techResumeRepository.mFindByIdJoinResume(3);
                // request.setAttribute("techResume", techResume);

                List<Tech> techs = techRepository.findAll();

                List<ResumeResponse.TechDTO> techDTOs = new ArrayList<>();
                for (Tech tech : techs) {
                        ResumeResponse.TechDTO techDTO = new ResumeResponse.TechDTO(tech.getId(), tech.getTechname(),
                                        true);
                        techDTOs.add(techDTO);
                }
                request.setAttribute("techs", techDTOs);

                return "/resume/writeResumeForm";
        }

        // 완료
        @PostMapping("/resume/write")
        public String writeResume(ResumeRequest.SaveDTO saveDTO,
                        @RequestParam(name = "tech-resume") List<Integer> techId) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                System.out.println(techId);
                resumeService.이력서작성(saveDTO, techId, sessionUser.getId());
                System.out.println("테스트 :" + saveDTO.careerPeriodS1);

                return "redirect:/userProfileForm";
        }

        // 완료
        @GetMapping("/resume/{id}/viewForm")
        public String viewResumeForm(@PathVariable Integer id, HttpServletRequest request) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                Resume resume = resumeService.이력서상세보기(id);
                List<TechResume> techResumes = techResumeRepository.mFindByIdJoinResumeJoinUser(id);
                resume.setResumeImg(resume.getResumeImg());
                request.setAttribute("resume", resume);
                request.setAttribute("techResumes", techResumes);
                return "/resume/viewResumeForm";
        }

        // 완료
        @PostMapping("/resume/{id}/delete")
        public @ResponseBody String delete(@PathVariable Integer id) {
                resumeService.삭제하기(id);
                return Script.href("/userProfileForm", "삭제되었습니다.");
        }

        @GetMapping("/resume/{id}/updateForm")
        public String updateResumeForm(@PathVariable Integer id, Model model) {
                Resume resume = resumeService.이력서상세보기(id);
                List<TechResume> techResumes = techResumeRepository.mFindByIdJoinResumeJoinUser(id);

                List<Tech> techs = techRepository.findAll();

                List<ResumeResponse.TechDTO> techDTOs = new ArrayList<>();
                for (Tech tech : techs) {
                        boolean checked = false;
                        if (techResumes.stream().anyMatch(tr -> tr.getTech().getId().equals(tech.getId()))) {
                                checked = true;
                        }
                        ResumeResponse.TechDTO techDTO = new ResumeResponse.TechDTO(tech.getId(), tech.getTechname(),
                                        checked);
                        techDTOs.add(techDTO);
                }

                // 태그 디티오
                model.addAttribute("techs", techs); // 이거 삭제
                model.addAttribute("testDTOs", techDTOs);

                // 태그 디티오

                model.addAttribute("resume", resume);
                model.addAttribute("eduDTO", new ResumeResponse.EduDTO(resume.getEducation()));
                // System.out.println("테스트 : " + checkedTechs);
                model.addAttribute("techResumes", techResumes);
                return "resume/updateResumeForm";
        }

        @PostMapping("/resume/{id}/update")
        public String updateResume(@PathVariable Integer id, ResumeRequest.UpdateDTO updateDTO) {
                User sessionUser = (User) session.getAttribute("sessionUser");
                // System.out.println("테스트 : " + techId);
                System.out.println("테스트1 : " + id);
                System.out.println(updateDTO.getTitle());
                resumeService.이력서수정하기(updateDTO, id, sessionUser.getId());
                return "redirect:/";
        }

        @GetMapping("/api/resumeSession")
        public @ResponseBody List<Resume> findByUserId() {

                // User sessionUser = (User) session.getAttribute("sessionUser");
                // if (sessionUser.getUsercode() != 1) {
                // throw new MyApiException("기업 회원이 아닙니다");
                // }
                User sessionUser = (User) session.getAttribute("sessionUser");
                return resumeRepository.findByUserId(sessionUser.getId());

        }

}
