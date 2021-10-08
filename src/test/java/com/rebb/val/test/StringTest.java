package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {


    @Test
    public void testStringEqual()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("a string","='a string'"));
        assertFalse(v.val("not a string","='a string'"));
    }

    @Test
    public void testStringCompare()
    {
        RebbVal v = new RebbVal();
        assertFalse(v.val("a string",">'a string'"));
        assertEquals("a string >'a string' failed(Unsupported Operation)", v.getErrors().get(0));
        assertFalse(v.val("not a string","<'a string'"));
        assertEquals("not a string <'a string' failed(Unsupported Operation)", v.getErrors().get(0));
    }

    @Test
    public void testStringPosition()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("This string", "starts with 'This'"));
        assertTrue(v.val("This string", "ends with 'string'"));
        assertFalse(v.val("This string", "starts with 'This very long string'"));
        assertFalse(v.val("This string", "ends with 'a very long string'"));
    }

    @Test
    public void testStringIn()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("string", "in 'a longer string'"));
    }

    @Test
    public void testStringContains()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("a longer string", "contains 'string'"));
    }
    @Test
    public void testStringNotEmpty()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("a string", "not empty"));
        assertFalse(v.val("", "not empty"));
    }
    @Test
    public void testStringMaxLength()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("a string", "max length 15"));
        assertFalse(v.val("a very looooooooooooooong string", "max length 15"));
    }

    @Test
    public void testStringPercentage()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("100%", "is percentage"));
        assertTrue(v.val("99.9%", "is percentage"));
        assertFalse(v.val("1000%", "is percentage"));
        assertTrue(v.val("-10.01%", "is percentage"));
    }

    @Test
    public void testStringBase64()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("YW55IGNhcm5hbCBwbGVhcw==", "is base64"));
        assertTrue(v.val("YW55IGNhcm5hbCBwbGVhc3U=", "is base64"));
        assertTrue(v.val("YW55IGNhcm5hbCBwbGVhc3Vy", "is base64"));
        assertFalse(v.val("YW5@IGNhcm5hbCBwbGVhcw==", "is base64"));
        assertFalse(v.val("YW55IGNhc=5hbCBwbGVhcw==", "is base64"));
        assertFalse(v.val("YW55IGNhcm5hbCBwbGVhc3V", "is base64"));
        assertFalse(v.val("YW55IGNhcm5hbCBwbGVh=", "is base64"));
        assertFalse(v.val("YW55IGNhcm5hbCBwbGVhc===", "is base64"));
    }

    @Test
    public void testStringNumber()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("100", "is number"));
        assertTrue(v.val("100.12", "is number"));
        assertTrue(v.val("-100", "is number"));
        assertTrue(v.val("123.", "is number"));
        assertTrue(v.val("-110.123", "is number"));
        assertTrue(v.val("3.1415926", "is number"));
        assertTrue(v.val("3e30", "is number"));
        assertTrue(v.val("-1.2e12", "is number"));
        assertTrue(v.val("1.0E-12", "is number"));
        assertTrue(v.val(".01", "is number"));
        assertFalse(v.val(".0.1", "is number"));
        assertFalse(v.val("123abc", "is number"));
    }

    @Test
    public void testStringInt()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("100", "is int"));
        assertFalse(v.val("100.12", "is int"));
        assertTrue(v.val("-100", "is int"));
        assertFalse(v.val("-110.123", "is int"));
        assertFalse(v.val("3.1415926", "is int"));
        assertFalse(v.val("3e30", "is int"));
        assertFalse(v.val(".0.1", "is int"));
        assertFalse(v.val("123abc", "is int"));
    }

    @Test
    public void testStringFloat()
    {
        RebbVal v = new RebbVal();
        assertFalse(v.val("100", "is float"));
        assertTrue(v.val("100.12", "is float"));
        assertTrue(v.val("111.", "is float"));
        assertFalse(v.val("-100", "is float"));
        assertTrue(v.val("-110.123", "is float"));
        assertTrue(v.val("3.1415926", "is float"));
        assertFalse(v.val("3e30", "is float"));
        assertFalse(v.val(".0.1", "is float"));
        assertFalse(v.val("123abc", "is float"));
    }

    @Test
    public void testHexColor()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("#aaa", "is hex color"));
        assertTrue(v.val("#aaab", "is hex color"));
        assertTrue(v.val("#000000", "is hex color"));
        assertTrue(v.val("#ffffffff", "is hex color"));
        assertFalse(v.val("fff", "is hex color"));
        assertFalse(v.val("ffff", "is hex color"));
        assertFalse(v.val("bcdefg", "is hex color"));
    }

    @Test
    public void testHexNumber()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("0xaaa", "is hex number"));
        assertTrue(v.val("0Xaaab", "is hex number"));
        assertTrue(v.val("0X000000", "is hex number"));
        assertTrue(v.val("0xffffffff", "is hex number"));
        assertTrue(v.val("fff", "is hex number"));
        assertTrue(v.val("ffff", "is hex number"));
        assertFalse(v.val("bcdefg", "is hex number"));
    }

    @Test
    public void testPhone()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("021-59595959", "is phone"));
        assertTrue(v.val("0577-1234567", "is phone"));
        assertFalse(v.val("01234-123123123", "is phone"));
        assertFalse(v.val("58910293", "is phone"));
    }

    @Test
    public void testMobile()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("13800138000", "is mobile"));
        assertTrue(v.val("13113113111", "is mobile"));
        assertFalse(v.val("12132132123", "is mobile"));
        assertFalse(v.val("021-59595959", "is mobile"));
    }

    @Test
    public void testMatch()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("123", "match /^\\d+$/"));
        assertFalse(v.val("abc123", "match /^\\d+$/"));
    }
}

