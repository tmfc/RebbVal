package com.rebb.val.test;

import com.rebb.val.DemoCustomValidator;
import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValArrayTest {

    @Test
    public void testNumberInArray()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val(1, "in [1, 2, 3]"));
        assertFalse(v.val(8, "in [1, 2, 3]"));
        assertTrue(v.val(8, "not in [1, 2, 3]"));
    }
}

