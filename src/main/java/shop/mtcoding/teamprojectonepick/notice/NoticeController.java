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

import shop.mtcoding.teamprojectonepick.notice.NoticeRequestDTO.DetailDTO;
import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.techNotice.TechNotice;
import shop.mtcoding.teamprojectonepick.techNotice.TechNoticeRepository;
import shop.mtcoding.teamprojectonepick.user.User;
import shop.mtcoding.teamprojectonepick.user.UserResponseDTO;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    private NoticeRequestDTO noticeRequestDTO;

    @Autowired
    private HttpSession session;

    @Autowired
    private TechNoticeRepository techNoticeRepository;

    @GetMapping("/api/searchNotice")
    public @ResponseBody List<Notice> open(@RequestParam(defaultValue = "open") String open) {

        return noticeRepository.findByOpen("on");
    }

    // 공고등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/writeNoticeForm")

    public String writeNoticeForm(HttpServletRequest request) {
        List<Tech> techs = techRepository.findAll();
        request.setAttribute("techs", techs);

        return "/notice/writeNoticeForm";
    }

    @PostMapping("/notice/writeNotice")
    public String writeNotice(NoticeRequestDTO.SaveDTO saveDTO,
            @RequestParam(name = "tech-notice") List<Integer> techId, @RequestParam("userImg") MultipartFile file) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        noticeService.공고등록(saveDTO, techId);
        return "redirect:/bizProfileForm";
    }

    // 공고상세ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // @GetMapping("/detailNoticeForm/{id}")
    // public String detailNoticeForm(@PathVariable Integer id, Model model) {
    // Notice notice = noticeService.상세보기(id);
    // model.addAttribute("notice", notice);
    // return "notice/detailNoticeForm";
    // }
    @GetMapping("/detailNoticeForm/{id}")
    public String detailNoticeForm(@PathVariable Integer id, HttpServletRequest request) {
        Notice notice = noticeService.공고조회(id);
        List<TechNotice> techNotices = techNoticeRepository.mFindByIdJoinNoticeJoinUser(id);
        notice.setUserImg("" + notice.getUserImg());
        request.setAttribute("notice", notice);
        request.setAttribute("techNotice", techNotices);
        // NoticeRequestDTO.DetailDTO detailDTO = new NoticeRequestDTO.DetailDTO(
        // "" + notice.getUserImg(),
        // notice.getSemiTitle(),
        // notice.getSemiContent(),
        // notice.getWorkField(),
        // notice.getBizName(),
        // notice.getAddress(),
        // notice.getAddress2(),
        // notice.getCareer(),
        // notice.getEducation(),
        // notice.getMainContent(),
        // notice.getDeadLine()
        // );
        // model.addAttribute("noticeInfo", detailDTO);
        return ("/notice/detailNoticeForm");
    }

    // 공고수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 공고삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 공고목록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
}
