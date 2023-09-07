package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 공고등록ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    @GetMapping("/writeNoticeForm")

    public String writeNoticeForm() {
        return "/notice/writeNoticeForm";
    }

    @PostMapping("/notice/writeNotice")
    public String writeNotice(NoticeRequestDTO.SaveDTO saveDTO) {
        noticeService.공고등록(saveDTO, 1);
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
