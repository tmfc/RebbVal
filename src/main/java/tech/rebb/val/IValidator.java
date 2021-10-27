package tech.rebb.val;

/**
 * Interface for custom validator
 * @author William
 * @version 1.0.0
 */
public interface IValidator {
    public boolean run(Object obj) throws RebbValException;
}
