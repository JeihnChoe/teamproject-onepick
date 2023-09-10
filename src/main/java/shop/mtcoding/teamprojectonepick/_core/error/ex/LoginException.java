package shop.mtcoding.teamprojectonepick._core.error.ex;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("로그인 필수...");
    }
}
