public class NotValidMailException extends Exception{

    public NotValidMailException()
    {
        super("Invalid email format");
    }
}
