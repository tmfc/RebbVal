package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValDateTest {

    @Test
    public void testDateFunction() {
        RebbVal v = new RebbVal();
        String condition = "between 2020-01-01 and 2021-01-01";
        assertTrue(v.val(v.date("2020-05-01"), condition));

        assertNull(v.date("20200501"));
        assertEquals("Parse date string error, java.text.ParseException: Unparseable date: \"20200501\"", v.getErrors().get(0));

        assertFalse(v.val(v.date("20200501"), condition));
        assertEquals("object is null(Object type not supported)", v.getErrors().get(0));
    }

    @Test
    public void testDateBetween() {
        RebbVal v = new RebbVal();
        String condition = "between 2020-01-01 and 2021-01-01";

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = ft.parse("2020-05-01");
            Date date2 = ft.parse("2021-05-01");
            assertTrue(v.val(date1, condition));
            assertFalse(v.val(date2, condition));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDateInterval() {
        RebbVal v = new RebbVal();

        assertTrue(v.val(v.date("2020-05-01"), "[2020-01-01 .. 2021-01-01]"));
        assertFalse(v.val(v.date("2021-05-01"), "[2020-01-01 .. 2021-01-01]"));

        assertTrue(v.val(v.date("2020-01-01"), "[2020-01-01 .. 2021-01-01)"));
        assertFalse(v.val(v.date("2021-01-01"), "[2020-01-01 .. 2021-01-01)"));

        assertFalse(v.val(v.date("2020-01-01"), "(2020-01-01 .. 2021-01-01]"));
        assertTrue(v.val(v.date("2021-01-01"), "(2020-01-01 .. 2021-01-01]"));
    }

    @Test
    public void testDateCompare() {
        RebbVal v = new RebbVal();

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = ft.parse("2020-05-01");
//            Date date2 = ft.parse("2021-05-01");

            assertTrue(v.val(date1, "=2020-05-01"));
            assertFalse(v.val(date1, "=2020-01-01"));

            assertTrue(v.val(date1, "!=2020-01-01"));
            assertFalse(v.val(date1, "!=2020-05-01"));

            assertTrue(v.val(date1, ">2020-01-01"));
            assertFalse(v.val(date1, ">2020-06-01"));

            assertTrue(v.val(date1, ">=2020-01-01"));
            assertTrue(v.val(date1, ">=2020-05-01"));
            assertFalse(v.val(date1, ">=2020-06-01"));

            assertTrue(v.val(date1, "<2020-06-01"));
            assertFalse(v.val(date1, "<2020-01-01"));

            assertTrue(v.val(date1, "<=2020-06-01"));
            assertTrue(v.val(date1, "<=2020-05-01"));
            assertFalse(v.val(date1, "<=2020-01-01"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLeapYear() {
        RebbVal v = new RebbVal();
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            Date date = ft.parse("2020-05-01");
            assertTrue(v.val(date, "is leapyear"));
            assertFalse(v.val(date, "is leapday"));

            date = ft.parse("2000-02-29");
            assertTrue(v.val(date, "is leapyear"));
            assertTrue(v.val(date, "is leapday"));

            date = ft.parse("1900-02-28");
            assertFalse(v.val(date, "is leapyear"));
            assertFalse(v.val(date, "is leapday"));

            date = ft.parse("1999-02-28");
            assertFalse(v.val(date, "is leapyear"));
            assertFalse(v.val(date, "is leapday"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertTrue(v.val(v.year("2000"), "is leapyear"));
        assertFalse(v.val(v.year("2001"), "is leapyear"));

    }
}

