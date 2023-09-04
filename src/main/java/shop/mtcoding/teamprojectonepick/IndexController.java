package shop.mtcoding.teamprojectonepick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/index/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/index/loginForm";
    }

}
