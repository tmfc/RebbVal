package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValAgeTest {

    @Test
    public void testAgeCompare() {
        RebbVal v = new RebbVal();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

        Date date1 = null;
        try {
            date1 = ft.parse("2020-05-01");
            assertTrue(v.val(date1, "younger than 18"));
            assertFalse(v.val(date1, "older than 18"));

            Date date2 = ft.parse("1980-05-01");
            assertFalse(v.val(date2, "younger than 18"));
            assertTrue(v.val(date2, "older than 18"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

