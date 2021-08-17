package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValBooleanTest {

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

