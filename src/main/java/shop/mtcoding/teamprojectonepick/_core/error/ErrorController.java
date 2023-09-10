package shop.mtcoding.teamprojectonepick._core.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/error")
public class ErrorController {

    // Http 상태코드 지정 -> 401 : 인증되지 않은 유저의 접근
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping("/401")
    public String unauthorizedErrorPage() {
        return "ex/401";
    }

    // Http 상태코드 지정 -> 403 : 권한 없음
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @GetMapping("/403-user")
    public String userForbiddenErrorPage() {
        return "ex/403-user";
    }

    // Http 상태코드 지정 -> 403 : 권한 없음
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @GetMapping("/403-biz")
    public String bizForbiddenErrorPage() {
        return "ex/403-biz";
    }
}
