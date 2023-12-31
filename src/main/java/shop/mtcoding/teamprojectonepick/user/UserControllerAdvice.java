package shop.mtcoding.teamprojectonepick.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(LoginIdNotCheckedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String loginIdNotCheckedExceptionHandle(LoginIdNotCheckedException e) {
        log.error("{}", e.getMessage());
        return "/user/userJoinForm";
    }
}
