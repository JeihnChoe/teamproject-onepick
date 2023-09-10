package shop.mtcoding.teamprojectonepick.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.teamprojectonepick.user.UserRequest.PasswordRequestDTO;

@Slf4j
@RestController // 얘는 API용 - 포스트맨, ajax, 얘는 json을 반환
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    // POST /api/users/login-id-check 경로로 들어오는 요청을 받을 메서드
    @PostMapping("/login-id-check")
    public ResponseEntity<String> checkLoginId(@RequestBody UserRequest.LoginIdCheckDTO loginIdCheckDTO) {
        userService.로그인아이디중복체크(loginIdCheckDTO.getLoginId());
        return ResponseEntity.ok("사용 가능한 로그인 아이디입니다.");
    }
}
