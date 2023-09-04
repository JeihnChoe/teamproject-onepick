package shop.mtcoding.teamprojectonepick.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    @GetMapping("/writeNoticeForm")
    public String manageNotice() {
        return "/biz/writeNoticeForm";
    }
}
