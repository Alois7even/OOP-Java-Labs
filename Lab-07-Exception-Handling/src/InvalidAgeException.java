
public class InvalidAgeException extends Exception {      // extends Exception -> CHECKED
    public InvalidAgeException(String message) {
        super(message);
    }
}