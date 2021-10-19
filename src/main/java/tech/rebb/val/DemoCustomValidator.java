package tech.rebb.val;

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
