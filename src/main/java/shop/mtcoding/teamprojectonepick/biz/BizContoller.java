package shop.mtcoding.teamprojectonepick.biz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BizContoller {

    @GetMapping("/bizProfileForm")
    public String bizProfileForm() {
        return "/biz/bizProfileForm";
    }

    @GetMapping("/fixBizProfileForm")
    public String fixBizProfileForm() {
        return "/biz/fixBizProfileForm";
    }

    @GetMapping("/bizJoinForm")
    public String bizJoinForm() {
        return "/biz/bizJoinForm";
    }

}
