package shop.mtcoding.teamprojectonepick.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserContoller {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    // 개인 변동사항

    @GetMapping("/userJoinForm")
    public String userJoinForm() {
        return ("/user/userJoinForm");
    }

    @GetMapping("/userProfileForm")
    public String userProfile() {
        return ("/user/userProfileForm");
    }

    @GetMapping("/fixUserProfileForm")
    public String fixUserProfile() {
        return ("/user/fixUserProfileForm");
    }

    // 기업 변동사항

    @GetMapping("/bizJoinForm")
    public String bizJoinForm() {
        return "/user/bizJoinForm";
    }

    @GetMapping("/bizProfileForm")
    public String bizProfileForm() {
        return "/user/bizProfileForm";
    }

    @GetMapping("/fixBizProfileForm")
    public String fixBizProfileForm() {
        return "/user/fixBizProfileForm";
    }

}
