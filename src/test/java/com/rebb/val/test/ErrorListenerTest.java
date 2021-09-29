package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorListenerTest {

    @Test
    public void testErrorListener() {
        RebbVal v = new RebbVal();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

        Date date1 = null;
        try {
            date1 = ft.parse("2020-05-01");
            assertFalse(v.val(date1, "older than a_string"));

            assertEquals(1, v.getErrors().size());
            assertEquals("line 1:11 mismatched input 'a' expecting {'not', '(', 'between', 'in', 'contains', 'max', 'is', 'match', 'starts', 'ends', ']', '[', StringLiteral, NumbericLiteral, DateLiteral, TimeLiteral, '=', '!=', '<', '<=', '>', '>=', 'older', 'younger'}", v.getErrors().get(0));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

