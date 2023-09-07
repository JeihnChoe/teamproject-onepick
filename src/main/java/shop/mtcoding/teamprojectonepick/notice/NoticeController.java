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

import shop.mtcoding.teamprojectonepick.tech.Tech;
import shop.mtcoding.teamprojectonepick.tech.TechRepository;
import shop.mtcoding.teamprojectonepick.user.User;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

@Autowired
private TechRepository techRepository;

@Autowired
private HttpSession session;

    // 공고등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/writeNoticeForm")

    public String writeNoticeForm(HttpServletRequest request) {
        List<Tech> techs = techRepository.findAll();
        request.setAttribute("techs",techs);
        

        return "/notice/writeNoticeForm";
    }

    @PostMapping("/notice/writeNotice")
    public String writeNotice(NoticeRequestDTO.SaveDTO saveDTO, @RequestParam(name = "tech-notice") List<Integer> techId) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        noticeService.공고등록(saveDTO, techId);
        return "redirect:/bizProfileForm";
    }

    // 공고상세ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    @GetMapping("/notice/{id}")
    public String detailNotice(@PathVariable Integer id, Model model) {
        Notice notice = noticeService.상세보기(id);
        model.addAttribute("notice", notice);
        return "noteic/detailNoticeForm";
    }

    // 공고수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 공고삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 공고목록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
}
