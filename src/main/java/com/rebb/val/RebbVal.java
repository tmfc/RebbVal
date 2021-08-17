package com.rebb.val;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class RebbVal {

    EvalVisitor engine;

    private boolean has_error;
    private List<String> errors;

    static private HashMap<Integer, Object> global_config = new HashMap<>();

    public RebbVal()
    {
        this.engine = new EvalVisitor("", global_config);
        this.errors = new ArrayList<String>();
//        this.condition = condition;
//        this.object = object;
    }

    public Date date(String str)
    {
        return date(str, "yyyy-MM-dd");
    }

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

    public Date year(String str)
    {
        return date(str + "-01-01");
    }

    public void registerCustomValidator(String name, Class clazz)
    {
        engine.registerCustomValidator(name, clazz);
    }

    public void setTimezone(Locale timezone) { engine.setTimezone(timezone); }

    public Locale getTimezone()
    {
        return engine.getTimezone();
    }

    public static void addGlobalConfig(Integer key, Object value)
    {
        global_config.put(key, value);
    }

    public void addConfig(Integer key, Object value)
    {
        this.engine.addConfig(key, value);
    }
    public boolean validate(Object object, String condition)
    {
//        this.condition = condition;
//        this.object = object;

        CharStream input = CharStreams.fromString(condition);
        RebbValLexer lexer = new RebbValLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RebbValParser parser = new RebbValParser(tokens);
        ParseTree tree = parser.unaryTest(); // parse

        engine.setObject(object);
        engine.visit(tree);
        return engine.isValid();
    }
    public boolean val(Object object, String condition)
    {
        this.errors = new ArrayList<String>();
//        this.condition = condition;
//        this.object = object;

        CharStream input = CharStreams.fromString(condition);
        RebbValLexer lexer = new RebbValLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RebbValParser parser = new RebbValParser(tokens);
        ParseTree tree = parser.unaryTests(); // parse

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

    public boolean hasError() {
        return has_error;
    }

    public List<String> getErrors() {
        return errors;
    }



}
