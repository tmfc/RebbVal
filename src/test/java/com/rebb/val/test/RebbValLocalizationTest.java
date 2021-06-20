package com.rebb.val.test;

import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValLocalizationTest {

    @Test
    public void testGBCode()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("110101", "is gbcode"));
        assertFalse(v.val("100100", "is gbcode"));
        assertFalse(v.val("13113113111", "is gbcode"));
    }
}

