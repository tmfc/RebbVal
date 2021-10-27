package tech.rebb.val;

/**
 * Custom exception class for RebbVal
 * @author William
 * @version 1.0.0
 */
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
