package tech.rebb.val.test;

import tech.rebb.val.RebbVal;
import tech.rebb.val.RebbValConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BooleanTest {

    @BeforeEach
    public void before() {
        String[] trueString = new String[]{"true","on", "1", "yes","ok"};
        RebbVal.addGlobalConfig(RebbValConfig.TRUE_STRING, trueString);
    }

    @Test
    public void testBooleanTrue() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(true,"is true"));
        assertFalse(v.val(false,"is true"));
    }

    @Test
    public void testNumberTrue() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(1,"is true"));
        assertFalse(v.val(0,"is true"));
    }

    @Test
    public void testStringTrue() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("1","is true"));
        assertTrue(v.val("on","is true"));
        assertTrue(v.val("true","is true"));
        assertTrue(v.val("yes","is true"));
        assertFalse(v.val("0","is true"));
    }

    @Test
    public void testStringTrueConfigured() {
        RebbVal v = new RebbVal();
        String[] trueString = new String[]{"true"};
        v.addConfig(RebbValConfig.TRUE_STRING, trueString);
        assertFalse(v.val("1","is true"));
        assertFalse(v.val("on","is true"));
        assertTrue(v.val("true","is true"));
        assertFalse(v.val("yes","is true"));
        assertFalse(v.val("0","is true"));
    }

    @Test
    public void testStringTrueGlobalConfigured() {
        String[] trueString = new String[]{"true"};
        RebbVal.addGlobalConfig(RebbValConfig.TRUE_STRING, trueString);
        RebbVal v = new RebbVal();
        assertFalse(v.val("1","is true"));
        assertFalse(v.val("on","is true"));
        assertTrue(v.val("true","is true"));
        assertFalse(v.val("yes","is true"));
        assertFalse(v.val("0","is true"));
    }

    @Test
    public void testBooleanFalse()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val(false,"is false"));
        assertFalse(v.val(true,"is false"));
    }

    @Test
    public void testNumberFalse()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val(0,"is false"));
        assertFalse(v.val(1,"is false"));
    }

    @Test
    public void testStringFalse() {
        RebbVal v = new RebbVal();
        assertFalse(v.val("1","is false"));
        assertFalse(v.val("on","is false"));
        assertFalse(v.val("true","is false"));
        assertFalse(v.val("yes","is false"));
        assertTrue(v.val("0","is false"));
    }
}

