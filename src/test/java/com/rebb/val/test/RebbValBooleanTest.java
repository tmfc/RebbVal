package com.rebb.val.test;

import com.rebb.val.DemoCustomValidator;
import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}

