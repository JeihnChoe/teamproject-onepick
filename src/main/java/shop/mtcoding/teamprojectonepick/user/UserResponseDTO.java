package shop.mtcoding.teamprojectonepick.user;

import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserResponseDTO {
    @Getter
    @AllArgsConstructor
    public static class UserInfoResponseDTO {
        private Integer id;
        private String password;
        private String username;
        private String tel;
        private String birth;
        private String address;
        private String picUrl;
    }

    @Getter
    @AllArgsConstructor
    public static class BizUserInfoResponseDTO {
        private String password;
        private String bizname;
        private String username;
        private String tel;
        private String address;
        private String address2;
        private String picUrl;

    }

    @Getter
    @AllArgsConstructor
    static class UserProfileFormDTO {

        private String picUrl;

        private String username;
        private String email;
        private String tel;
    }

    @Getter
    @AllArgsConstructor
    static class BizUserProfileFormDTO {

        private String picUrl;
        private String bizname;
        private String username;
        private String email;
        private String tel;
    }
}