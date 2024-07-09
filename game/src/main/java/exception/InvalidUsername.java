package exception;

public class InvalidUsername extends Exception{
    public InvalidUsername() {
        super("username is not valid");
    }

    public InvalidUsername(String message) {
        super(message);
    }
}
