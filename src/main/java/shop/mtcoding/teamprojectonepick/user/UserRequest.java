package shop.mtcoding.teamprojectonepick.user;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserRequest {
    @Data
    public static class JoinDTO {
        private String loginId;
        private boolean loginIdCheck;
        private String password;
        private String passwordConfirm;
        private String username;
        private String email;
        private String tel;
        private String birth;

        private String address;
        private int usercode;
    }

    @Data
    public static class LoginIdCheckDTO {
        private String loginId;
    }

    @Getter
    @Setter
    public static class PasswordRequestDTO {
        private String password;
        private String confirmPassword;
    }

    @Getter
    @Setter
    public static class BizJoinDTO {
        private String loginId;
        private boolean loginIdCheck;
        private String password;
        private String passwordConfirm;
        private String username;
        private String email;
        private String tel;
        private String bizname;
        private String address;
        private String address2;
        private int usercode;
    }

    @Getter
    @Setter
    public static class LoginDTO {
        private String loginId;
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class UpdateDTO {
        private String password;
        private String passwordConfirm;
        private String username;
        private String tel;
        private String birth;
        private String address;

        private MultipartFile pic;
    }

    @Getter
    @Setter
    @ToString
    public static class BizUpdateDTO {
        private String password;
        private String passwordConfirm;
        private String bizname;
        private String username;
        private String tel;
        private String address;
        private String address2;
        private MultipartFile pic;
    }

}
