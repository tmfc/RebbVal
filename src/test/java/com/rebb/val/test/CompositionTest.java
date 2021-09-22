package com.rebb.val.test;

import com.rebb.val.DemoCustomValidator;
import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompositionTest {

    @Test
    public void testUnaryTests() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(10000, ">10 and <1000 or =10000"));
        assertTrue(v.val(1000, ">10 and <100000 and !=10000"));
        assertFalse(v.val(1000, ">10 and <100 or =10000"));
        assertTrue(v.val(1000, ">100 or <10 or =10000"));
    }

    @Test
    public void testConjunction() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(100, ">10 and <1000"));
        assertFalse(v.val(100, ">10 and <100"));
    }

    @Test
    public void testDisjunction() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(70, ">60 or <10"));
        assertTrue(v.val(5, ">60 or <10"));
        assertFalse(v.val(30, ">60 or <10"));
    }

    @Test
    public void testNot()
    {
        RebbVal v = new RebbVal();
        assertFalse(v.val(100, "<10"));
        assertTrue(v.val(100, "not (<10)"));
        assertTrue(v.val(100, "not <10"));
    }

    @Test
    public void testCustomFunction()
    {
        RebbVal v = new RebbVal();
        v.registerCustomValidator("Demo", DemoCustomValidator.class);
        assertTrue(v.val("Demo","is Demo"));
        assertFalse(v.val("Not Demo","is Demo"));
    }

    public static void main(String[] args) throws Exception {
//        not，将任意表达式用not()包起来，即可取反
//        v.val(10,"not (>10)");

//        array
//        v.val(1, "in [1,2,3]");
//        TODO
//        v.val([1,2], "inAny [1,3,5]");
//        v.val(new int[]{1,2,3}, "is unique");
//        v.val(new int[]{1,2,3}, "=[1,2,3]");

//        boolean
//        v.val(true, "is true"); // is false
//        v.val(1, "is true");
//        v.val(0, "is false");

//        comparisons
//        v.val(10, "between 10 and 20");
//        v.val(10,"=100");
//        v.val(10,"<100"); // > / >= / <=
//        v.val(10,"[10..20]"); //(10..20]/[10..20)/

//        datetime
//        v.val("2020", "is leapyear");
//        v.val("2020-2-29", "is leapday");

//        datetime comparisons
//        v.val("2020-05-10", "between 2020-01-01 and 2020-12-31");
//        v.val("2020-2-29", "[2020-01-01..2020-12-31]");
//        v.val("2020-2-29", "< 2020-12-31"); // >, >=, <=

//        age
//        v.val("1980-1-1", "older than 18");
//        v.val("2000-1-1", "younger than 18");

//        Identifications
//        v.val("35-209900-176148-1","is IMEI");
//        v.val("978-0-596-52068-7","is ISBN");
//        v.val("00:11:22:33:44:55","is MAC");
//        v.val("110100199909093245","is ID"); //is 身份证 TODO
//        v.val("G12345678","is passport"); //is 中国护照 TODO

//        Internet
//        v.val("google.com", "is domain");
//        v.val("hello@gmail.com", "is email");
//        v.val("8.8.8.8", "is ip"); // is ipv4
//        v.val("192.168.1.1", "is private_ip");
//        v.val("2001:0db8:85a3:08d3:1319:8a2e:0370:7334", "is ipv6");
//        v.val("http://example.com", "is url");

//        Localization
//        v.val("100101", "is gbcode");
//        v.val("201200", "is postal"); TODO

//        String
//        v.val("This string", "=\"This string\"");
//        v.val("This string", "start with \"This\"");
//        v.val("This string", "ends with \"string\"");
//        v.val("string", "in \"a longer string\"");
//        v.val("a long string", "contains \"string\"");
//        v.val("string", "not empty");
//        v.val("string", "max length 15");
//        v.val("100%", "is percentage");
//        v.val("base64===", "is base64");
//        v.val("123.45", "is number");
//        v.val("-10","is int");
//        v.val("-10.1","is float");
//        v.val("0x123def", "is hex number");
//        v.val("#FFEEDD", "is hex color");
//        v.val("13800138000", "match //d+/"); match a regex
//        v.val("021-59595959", "is phone");
//        v.val("13800138000", "is mobile");
//        v.val("eb3115e5-bd16-4939-ab12-2b95745a30f3", "is UUID");
//        TODO
//        v.val("a test string", "has whitespace");
//        v.val("name", "is alpha");
//        v.val("VI","is roman");

    }
}

