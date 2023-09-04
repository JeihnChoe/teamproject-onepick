package shop.mtcoding.teamprojectonepick.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserContoller {

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
}
