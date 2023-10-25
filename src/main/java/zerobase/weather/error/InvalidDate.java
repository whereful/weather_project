package zerobase.weather.error;

public class InvalidDate extends RuntimeException {
    private static final String message = "너무 과거 혹은 미래";

    public InvalidDate() {
        super(message);
    }
}
