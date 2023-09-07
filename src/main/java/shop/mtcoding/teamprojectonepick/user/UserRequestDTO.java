package shop.mtcoding.teamprojectonepick.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserRequestDTO {
    @Getter
    @Setter
    public static class JoinDTO {
        private String loginId;
        private String password;
        private String username;
        private String email;
        private String tel;
        private String birth;
        private int usercode;
    }

    @Getter
    @Setter
    public static class BizJoinDTO {
        private String loginId;
        private String password;
        private String username;
        private String email;
        private String tel;
        private String bizname;
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
        private String bizname;
        private String username;
        private String tel;
        private String address;
        private String address2;
        private MultipartFile pic;
    }

}
