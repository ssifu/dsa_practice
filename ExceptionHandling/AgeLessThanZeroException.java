package ExceptionHandling;

public class AgeLessThanZeroException extends Exception {
    private String message;

    public AgeLessThanZeroException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
