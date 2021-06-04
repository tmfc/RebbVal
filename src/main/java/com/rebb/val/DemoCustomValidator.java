package com.rebb.val;

public class DemoCustomValidator implements com.rebb.val.IValidator {

    @Override
    public boolean run(Object obj) throws com.rebb.val.RebbValException {
        if(obj instanceof String)
        {
            String object = (String)obj;
            return object.equals("Demo");
        }
        else
        {
            throw new com.rebb.val.RebbValException("Unsupported object type");
        }
    }
}
