package shop.mtcoding.teamprojectonepick._core.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.teamprojectonepick._core.error.ex.MyApiException;
import shop.mtcoding.teamprojectonepick._core.error.ex.MyException;
import shop.mtcoding.teamprojectonepick._core.error.ex.PasswordNotMatchedException;
import shop.mtcoding.teamprojectonepick._core.util.ApiUtil;
import shop.mtcoding.teamprojectonepick._core.util.Script;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandeler {

    // TODO request -> filter -> dispatcherServlet -> interceptor -> controllerAdvice & restControllerAdvice -> controller -> service

    @ExceptionHandler(MyException.class)
    public String error(MyException e) {
        log.error("error", e);
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(MyApiException.class)
    public ApiUtil<String> error(MyApiException e) {
        return new ApiUtil<String>(false, e.getMessage());
    }

    @ExceptionHandler(PasswordNotMatchedException.class)
    public String error(PasswordNotMatchedException e) {
        return Script.back(e.getMessage());
    }
}
