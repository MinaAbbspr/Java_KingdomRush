package exception;

public class InvalidPassword extends Exception{
    public InvalidPassword() {
        super("password is not valid");
    }

    public InvalidPassword(String message) {
        super(message);
    }
}
