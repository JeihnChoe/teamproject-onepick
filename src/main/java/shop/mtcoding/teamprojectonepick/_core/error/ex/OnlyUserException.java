package shop.mtcoding.teamprojectonepick._core.error.ex;

public class OnlyUserException extends RuntimeException {

    public OnlyUserException() {
        super("유저만 이용 가능...");
    }
}
