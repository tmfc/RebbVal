package com.rebb.val;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;


public class RebbVal {

    EvalVisitor engine;

    private boolean has_error;
    private List<String> errors;

    public RebbVal()
    {
        this.engine = new EvalVisitor("");
        this.errors = new ArrayList<String>();
//        this.condition = condition;
//        this.object = object;
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
        ValidLexer lexer = new ValidLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidParser parser = new ValidParser(tokens);
        ParseTree tree = parser.unaryTests(); // parse

        engine.setObject(object);

        engine.visit(tree);
        if(!engine.isValid())
        {
            this.has_error = true;
            String error_message = object.toString() + " " + condition + " failed";
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
