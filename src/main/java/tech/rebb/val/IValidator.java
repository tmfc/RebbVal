package tech.rebb.val;

public interface IValidator {
    public boolean run(Object obj) throws RebbValException;
}
