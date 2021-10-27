package tech.rebb.val;

/**
 * Demo class of custom validator
 * @author William
 * @version 1.0.0
 */
public class DemoCustomValidator implements IValidator {

    @Override
    public boolean run(Object obj) throws RebbValException {
        if(obj instanceof String)
        {
            String object = (String)obj;
            return object.equals("Demo");
        }
        else
        {
            throw new RebbValException("Unsupported object type");
        }
    }
}
