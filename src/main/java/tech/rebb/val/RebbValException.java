package tech.rebb.val;

public class RebbValException extends Exception{
    String message;
    public RebbValException(String message){
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
