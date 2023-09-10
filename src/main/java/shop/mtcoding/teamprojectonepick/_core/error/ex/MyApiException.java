package shop.mtcoding.teamprojectonepick._core.error.ex;

public class MyApiException extends RuntimeException {
    public MyApiException(String message) {
        super(message);
    }

    public MyApiException(String message, String d) {
        super(message);
    }
}
