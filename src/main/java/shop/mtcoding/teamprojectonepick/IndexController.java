package shop.mtcoding.teamprojectonepick;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/hello")
    public @ResponseBody List<String> hello(@RequestParam(name = "option") List<String> options) {

        System.out.println(options);
        return options;
    }

    @GetMapping("/helloForm")
    public String helloForm() {
        return "/test";
    }
}
