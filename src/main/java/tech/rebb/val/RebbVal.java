package tech.rebb.val;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author William
 * @version 1.0.0
 */
public class RebbVal {

    EvalVisitor engine;

    private boolean has_error;
    private List<String> errors;

    static private HashMap<Integer, Object> global_config = new HashMap<>();

    /**
     * construction function for RebbVal
     */
    public RebbVal()
    {
        this.engine = new EvalVisitor("", global_config);
        this.errors = new ArrayList<String>();
//        this.condition = condition;
//        this.object = object;
    }

    /**
     * convert date string in 'yyyy-MM-dd' format to a java.util.Date object
     * @param str date string in format "yyyy-MM-dd"
     * @return date object
     */
    public Date date(String str)
    {
        return date(str, "yyyy-MM-dd");
    }

    /**
     * convert date string to a java.util.Date object
     * @param str date string
     * @param pattern date pattern
     * @return date object
     */
    public Date date(String str, String pattern)
    {
        SimpleDateFormat ft = new SimpleDateFormat (pattern);
        try {
            return ft.parse(str);
        } catch (ParseException e) {
//            e.printStackTrace();
            this.errors.add("Parse date string error, " + e.toString());
            return null;
        }
    }

    /**
     * convert year string to a java.util.Date object
     * @param str year string in format 'yyyy'
     * @return Date object for year-01-01
     */
    public Date year(String str)
    {
        return date(str + "-01-01");
    }

    /**
     * Register a custom validator class in RebbVal engine
     * @param name validator name
     * @param clazz validator class
     */
    public void registerCustomValidator(String name, Class clazz)
    {
        engine.registerCustomValidator(name, clazz);
    }

    /**
     * Set timezone
     * @param timezone the timezone to set
     */
    public void setTimezone(Locale timezone) { engine.setTimezone(timezone); }

    /**
     * Get timezone
     * @return the timezone object
     */
    public Locale getTimezone()
    {
        return engine.getTimezone();
    }

    /**
     * Add a global config
     * @param key config item key
     * @param value config item value
     */
    public static void addGlobalConfig(Integer key, Object value)
    {
        global_config.put(key, value);
    }

    /**
     * Add a instance config
     * @param key config item key
     * @param value config item value
     */
    public void addConfig(Integer key, Object value)
    {
        this.engine.addConfig(key, value);
    }

    /**
     * Do a validate
     * @param object the object to be validated
     * @param condition the validation condition
     * @return validate result
     */
    public boolean val(Object object, String condition)
    {
        this.errors = new ArrayList<String>();
//        this.condition = condition;
//        this.object = object;

        CharStream input = CharStreams.fromString(condition);
        RebbValLexer lexer = new RebbValLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RebbValParser parser = new RebbValParser(tokens);
        parser.addErrorListener(RebbValErrorListener.INSTANCE);
        ParseTree tree = parser.unaryTests(); // parse

        if(RebbValErrorListener.INSTANCE.hasError())
        {
            this.has_error = true;
            this.errors.add(RebbValErrorListener.INSTANCE.getError());
            RebbValErrorListener.INSTANCE.clearError();
            return false;
        }

        engine.setObject(object);

        engine.visit(tree);

        if(!engine.isValid())
        {
            this.has_error = true;
            String error_message;
            if(object == null)
                error_message = "object is null";
            else
                error_message = object.toString() + " " + condition + " failed";
            if(engine.getError() != null && !engine.getError().equals(""))
                error_message += "(" + engine.getError() + ")";
            this.errors.add(error_message);
            return false;
        }

        return true;
    }

    /**
     * Is there errors
     * @return True:has error(s)<br>
     * False:no error
     */
    public boolean hasError() {
        return has_error;
    }

    /**
     * Get error list
     * @return error list
     */
    public List<String> getErrors() {
        return errors;
    }
}
