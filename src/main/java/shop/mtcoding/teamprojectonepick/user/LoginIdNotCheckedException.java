package shop.mtcoding.teamprojectonepick.user;

public class LoginIdNotCheckedException extends RuntimeException {

    public LoginIdNotCheckedException() {
        super("아이디 중복체크 안됌!!");
    }
}
