package shop.mtcoding.teamprojectonepick.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UserApiControllerAdvice {

    // LoginIdDuplicatedException 예외만 잡아서 처리
    @ExceptionHandler(LoginIdDuplicatedException.class)
    public ResponseEntity<String> loginIdDuplicatedExceptionHandle(LoginIdDuplicatedException e) {
        log.error("{}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인 아이디가 중복되었습니다.");
    }
}
