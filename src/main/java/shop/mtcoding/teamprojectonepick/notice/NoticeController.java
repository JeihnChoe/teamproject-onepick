package shop.mtcoding.teamprojectonepick.notice;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import shop.mtcoding.teamprojectonepick._core.util.Script;
import shop.mtcoding.teamprojectonepick.notice.NoticeRequest.IndexDTO;
import shop.mtcoding.teamprojectonepick.resume.Resume;
import shop.mtcoding.teamprojectonepick.resume.ResumeRepository;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.tech.notice.TechNotice;
import shop.mtcoding.teamprojectonepick.tech.notice.TechNoticeRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private TechNoticeRepository techNoticeRepository;

    @GetMapping("/api/noticeSession")
    public @ResponseBody List<Notice> findByNotice(@RequestParam(defaultValue = "on") String open) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (open.equals("on")) {
            return noticeRepository.findByUserId(sessionUser.getId(), "on");
        } else if (open.equals("off")) {
            return noticeRepository.findByUserId(sessionUser.getId(), "off");
        } else {
            return noticeRepository.findAll();

        }

    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 공고 페이지 가져오기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/notice/writeNoticeForm")
    public String writeNoticeForm(HttpServletRequest request) {
        // TODO: 인증필요
        List<Tech> techs = techRepository.findAll();
        request.setAttribute("techs", techs);
        System.out.println("테스트 : 공고 페이지 가져옴");
        return "/notice/writeNoticeForm";
    }

    // 공고등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @PostMapping("/notice/writeNotice")
    public String writeNotice(NoticeRequest.SaveDTO saveDTO,
            @RequestParam(name = "tech-notice") List<Integer> techId, @RequestParam("userImg") MultipartFile file) {
        // TODO: 인증필요

        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("테스트 : 공고 등록 시작 전");
        noticeService.공고등록(saveDTO, techId, sessionUser.getId());
        System.out.println("테스트 : 공고 등록함");
        return "redirect:/bizProfileForm";

    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 공고상세 페이지
    // 가져오기ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/notice/{id}")
    public String detailNoticeForm(@PathVariable Integer id, HttpServletRequest request) {
        Notice notice = noticeService.공고조회(id);
        List<TechNotice> techNotices = techNoticeRepository.mFindByIdJoinNoticeJoinUser(id);
        notice.setUserImg("" + notice.getUserImg());
        request.setAttribute("notice", notice);
        request.setAttribute("techNotice", techNotices);
        return "/notice/detailNoticeForm";
    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 공고수정 1번ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/notice/updateNoticeForm/{id}")
    public String updateNoticeForm(@PathVariable Integer id, Model model) {
        Notice notice = noticeService.공고조회(id);
        List<TechNotice> techNotices = techNoticeRepository.mFindByIdJoinNoticeJoinUser(id);
        List<Tech> techs = techRepository.findAll();
        model.addAttribute("techs", techs);
        model.addAttribute("notice", notice); // request에 담는 것과 동일
        model.addAttribute("techNotices", techNotices);
        System.out.println("테스트 : 모델에 담아서 폼으로 보내는 단계");
        return "notice/updateNoticeForm";
    }

    // 공고수정 2번ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @PostMapping("/notice/{id}/update")
    public String updateNotice(@PathVariable Integer id, @RequestParam(name = "tech-notice") List<Integer> techId,
            NoticeRequest.UpdateDTO updateDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("테스트: 아이디 받아와서 업데이트하기 전");
        // where 데이터, body, session값
        noticeService.공고수정하기(sessionUser.getId(), techId, id, updateDTO);
        System.out.println("테스트: 아이디 받아와서 업데이트한 후 메인으로 복귀");
        return "redirect:/bizProfileForm";
    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 공고삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    /**
     * 공고 삭제
     * 진성훈
     **/
    @PostMapping("/notice/{id}/delete")
    public @ResponseBody String delete(@PathVariable Integer id) {
        System.out.println("딜리트 실행전");

        noticeService.삭제하기(id);
        System.out.println("딜리트 실행후");

        return Script.href("/user/userProfileForm");
    }

    @GetMapping("/apply/{id}")
    public String applyNoticeForm(@PathVariable Integer id, HttpServletRequest request) {
        Notice notice = noticeService.공고조회(id);
        List<TechNotice> techNotices = techNoticeRepository.mFindByIdJoinNoticeJoinUser(id);
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<Resume> resumes = resumeRepository.findByUserId(sessionUser.getId());
        notice.setUserImg("" + notice.getUserImg());
        request.setAttribute("notice", notice);
        request.setAttribute("techNotice", techNotices);
        request.setAttribute("resumes", resumes);
        System.out.println("테스트 : " + resumes.size());
        return "/notice/applyNoticeForm";
    }

    @GetMapping("/api/noticeIndex")
    public @ResponseBody List<Notice> noticeIndex(
            @RequestParam(defaultValue = "on") String open,
            @RequestParam(defaultValue = "백엔드") String workField,
            @RequestParam(defaultValue = "서울") String address,
            @RequestParam(defaultValue = "신입") String career,
            @RequestParam(defaultValue = "대졸") String education) {

        return null;
    }

}
