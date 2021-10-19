package tech.rebb.val.test;

import tech.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class IdentificationTest {

    @Test
    public void testIMEI() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("35-209900-176148-1","is IMEI"));
        assertTrue(v.val("352099001761481","is IMEI"));
        assertFalse(v.val("35-209900-176148-2", "is IMEI"));
    }

    @Test
    public void testIMEISV() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("35-209900-176148-12","is IMEISV"));
        assertTrue(v.val("3520990017614812","is IMEISV"));
        assertFalse(v.val("35-209900-176148-2", "is IMEISV"));
    }

    @Test
    public void testISBN() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("978-0-596-52068-7","is ISBN"));
        assertTrue(v.val("9787510892844","is ISBN"));
        assertFalse(v.val("35-209900-176148-2", "is ISBN"));
    }

    @Test
    public void testUUID()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("eb3115e5-bd16-4939-ab12-2b95745a30f3", "is UUID"));
        assertFalse(v.val("13113113111", "is UUID"));
    }

    @Test
    public void testMac() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("00:11:22:33:44:55", "is MAC"));
        assertTrue(v.val("00-11-22-33-44-55", "is MAC"));
        assertFalse(v.val("00:11:22:33:44:GG", "is MAC"));
    }

    @Test
    public void testID()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("140303192005236131","is ID"));
        assertFalse(v.val("110100199909093245","is ID"));
        assertFalse(v.val("110100199902313244","is ID"));
    }
}