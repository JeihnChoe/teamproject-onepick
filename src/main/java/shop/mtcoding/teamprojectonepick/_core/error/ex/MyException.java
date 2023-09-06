package shop.mtcoding.teamprojectonepick._core.error.ex;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable e) {
        super(e);
    }
}
