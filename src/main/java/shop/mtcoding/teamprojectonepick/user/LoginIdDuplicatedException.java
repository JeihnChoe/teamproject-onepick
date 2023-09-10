package shop.mtcoding.teamprojectonepick.user;

public class LoginIdDuplicatedException extends RuntimeException {

    public LoginIdDuplicatedException() {
        super("로그인 아이디 중복...");
    }
}
