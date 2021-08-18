package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValNumberTest {

    @Test
    public void testNumberBetween()
    {
        RebbVal v = new RebbVal();
        String condition = "between 10 and 20";
        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 between 10 and 20 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(8.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("8.8 between 10 and 20 failed",v.getErrors().get(0));

        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());

    }

    @Test
    public void testNumberInterval()
    {
        RebbVal v = new RebbVal();
        String condition = "[5..20]";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 [5..20] failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(0.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("0.8 [5..20] failed",v.getErrors().get(0));

        assertTrue(v.val(5.1,"(5..20]"));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(5, "(5..20]"));
        assertEquals(1,v.getErrors().size());
        assertEquals("5 (5..20] failed",v.getErrors().get(0));

        assertFalse(v.val(20,"[5..20)"));
        assertEquals(1,v.getErrors().size());
        assertEquals("20 [5..20) failed",v.getErrors().get(0));

        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberEqual()
    {
        RebbVal v = new RebbVal();
        String condition = "=10";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 =10 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(8.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("8.8 =10 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberNotEqual()
    {
        RebbVal v = new RebbVal();
        String condition = "!=10";

        // string
        assertFalse(v.val("100", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("100 !=10 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(100.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(10,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 !=10 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(100.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(100, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(100L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberLT()
    {
        RebbVal v = new RebbVal();
        String condition = "<100";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 <100 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(188.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("188.8 <100 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberLTE()
    {
        RebbVal v = new RebbVal();
        String condition = "<=100";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 <=100 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(188.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("188.8 <=100 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberGT()
    {
        RebbVal v = new RebbVal();
        String condition = ">1";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 >1 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(0.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("0.8 >1 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }

    @Test
    public void testNumberGTE()
    {
        RebbVal v = new RebbVal();
        String condition = ">=10";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 >=10 failed(Object type not supported)",v.getErrors().get(0));

        // double
        assertTrue(v.val(10.0,condition));
        assertEquals(0,v.getErrors().size());

        assertFalse(v.val(8.8,condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("8.8 >=10 failed",v.getErrors().get(0));


        // float
        assertTrue(v.val(10.0f,condition));
        assertEquals(0,v.getErrors().size());

        // integer
        assertTrue(v.val(10, condition));
        assertEquals(0,v.getErrors().size());

        // long
        assertTrue(v.val(10L, condition));
        assertEquals(0,v.getErrors().size());
    }
}

