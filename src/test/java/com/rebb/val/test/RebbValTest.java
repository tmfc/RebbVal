package com.rebb.val.test;

import com.rebb.val.DemoCustomValidator;
import com.rebb.val.RebbVal;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RebbValTest {

    @Test
    public void testUnaryTests() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(10000, ">10 and <1000 or =10000"));
        assertFalse(v.val(1000, ">10 and <100 or =10000"));
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
    public void testNumberBetween()
    {
        RebbVal v = new RebbVal();
        String condition = "between 10 and 20";
        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 between 10 and 20 failed(Unsupported object type)",v.getErrors().get(0));

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
        assertEquals("10 [5..20] failed(Unsupported object type)",v.getErrors().get(0));

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
        assertEquals("10 =10 failed(Unsupported object type)",v.getErrors().get(0));

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
    public void testNumberLT()
    {
        RebbVal v = new RebbVal();
        String condition = "<100";

        // string
        assertFalse(v.val("10", condition));
        assertEquals(1,v.getErrors().size());
        assertEquals("10 <100 failed(Unsupported object type)",v.getErrors().get(0));

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
        assertEquals("10 <=100 failed(Unsupported object type)",v.getErrors().get(0));

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
        assertEquals("10 >1 failed(Unsupported object type)",v.getErrors().get(0));

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
        assertEquals("10 >=10 failed(Unsupported object type)",v.getErrors().get(0));

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


    @Test
    public void testDateBetween()
    {
        RebbVal v = new RebbVal();
        String condition = "between 2020-01-01 and 2021-01-01";

        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
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
    public void testDateInterval()
    {
        RebbVal v = new RebbVal();
        String condition = "[2020-01-01 .. 2021-01-01]";

        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
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
    public void testDateCompare() {
        RebbVal v = new RebbVal();

        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = ft.parse("2020-05-01");
//            Date date2 = ft.parse("2021-05-01");
            assertTrue(v.val(date1, ">2020-01-01"));
            assertFalse(v.val(date1, "<=2020-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

    @Test
    public void testBooleanValue() {
        RebbVal v = new RebbVal();
        assertTrue(v.val(true,"is true"));
        assertTrue(v.val(false,"is false"));

        assertTrue(v.val(1,"is true"));
        assertTrue(v.val(0,"is false"));
    }

    @Test
    public void testLeapYear() {
        RebbVal v = new RebbVal();
        try {
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
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
    }

    @Test
    public void testDomain() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("google.com", "is domain"));
        assertTrue(v.val("www.baidu.com", "is domain"));
        assertFalse(v.val("fdsads", "is domain"));
    }
    @Test
    public void testEmail() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("abc@gmail.com", "is email"));
        assertTrue(v.val("13800138000@139.com", "is email"));
        assertFalse(v.val("fdsads", "is email"));
    }
    @Test
    public void testIpv4() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("8.8.8.8", "is ipv4"));
        assertTrue(v.val("192.168.1.1", "is ipv4"));
        assertFalse(v.val("266.1.3.4", "is ipv4"));
    }

    @Test
    public void testIpv6() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("::", "is ipv6"));
        assertTrue(v.val("::123", "is ipv6"));
        assertTrue(v.val("::123:456", "is ipv6"));
        assertTrue(v.val("::123:456:789", "is ipv6"));
        assertTrue(v.val("::123:456:789:abc:def:6666", "is ipv6"));
        assertFalse(v.val("::123:456:789:abc:def:6666:7", "is ipv6"));

        assertTrue(v.val("123::456", "is ipv6"));
        assertTrue(v.val("123::456:789:abc", "is ipv6"));
        assertTrue(v.val("123::456:789:abc:def:6", "is ipv6"));
        assertFalse(v.val("123::456:789:abc:def:6:7", "is ipv6"));

        assertTrue(v.val("123:456::789", "is ipv6"));
        assertTrue(v.val("123:456::789:abc", "is ipv6"));
        assertTrue(v.val("123:456::789:abc:def:6666", "is ipv6"));
        assertFalse(v.val("123:456::789:abc:def:6666:7", "is ipv6"));

        assertTrue(v.val("123:456:789::abc", "is ipv6"));
        assertTrue(v.val("123:456:789::abc:def", "is ipv6"));
        assertTrue(v.val("123:456:789::abc:def:6666", "is ipv6"));
        assertFalse(v.val("123:456:789::abc:def:6666:7", "is ipv6"));

        assertTrue(v.val("123:456:789:abc::def", "is ipv6"));
        assertTrue(v.val("123:456:789:abc::def:6666", "is ipv6"));
        assertFalse(v.val("123:456:789:abc::def:6666:7", "is ipv6"));

        assertTrue(v.val("123:456:789:abc:def::6666", "is ipv6"));
        assertFalse(v.val("123:456:789:abc:def::6666:7", "is ipv6"));

        assertTrue(v.val("123:456:789:abc:def:6666::", "is ipv6"));
        assertTrue(v.val("123:456:789:abc:def::", "is ipv6"));
        assertTrue(v.val("123:456:789:abc::", "is ipv6"));
        assertTrue(v.val("123:456:789::", "is ipv6"));
        assertTrue(v.val("123:456::", "is ipv6"));
        assertTrue(v.val("123::", "is ipv6"));

        assertTrue(v.val("123::456:789:abc:def:6666", "is ipv6"));
        assertFalse(v.val("123:456:789:abc:def:6666:7", "is ipv6"));
        assertFalse(v.val("123::456::abc", "is ipv6"));

        assertTrue(v.val("2001:0db8:85a3:08d3:1319:8a2e:0370:7334", "is ipv6"));
    }

    @Test
    public void testPrivateIp() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("127.0.0.1", "is private_ip"));
        assertTrue(v.val("10.1.1.1", "is private_ip"));
        assertTrue(v.val("172.18.100.1", "is private_ip"));
        assertTrue(v.val("192.168.2.100", "is private_ip"));
        assertFalse(v.val("8.8.8.8", "is private_ip"));
        assertTrue(v.val("FEC0:0001::", "is private_ip"));
        assertFalse(v.val("123:456:789:abc:def:6666::", "is private_ip"));
    }

    @Test
    public void testUrl() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("https://www.google.com", "is url"));
        assertTrue(v.val("http://www.example.com/to/path?param1=foo&param2=bar", "is url"));
        assertFalse(v.val("somebody@somedomain.com", "is url"));
    }

    @Test
    public void testMac() {
        RebbVal v = new RebbVal();
        assertTrue(v.val("00:11:22:33:44:55", "is MAC"));
        assertTrue(v.val("00-11-22-33-44-55", "is MAC"));
        assertFalse(v.val("00:11:22:33:44:GG", "is MAC"));
    }

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
    public void testCustomFunction()
    {
        RebbVal v = new RebbVal();
        v.registerCustomValidator("Demo", DemoCustomValidator.class);
        assertTrue(v.val("Demo","is Demo"));
        assertFalse(v.val("Not Demo","is Demo"));
    }

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
    public void testInArray()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val(1, "in [1, 2, 3]"));
        assertFalse(v.val(8, "in [1, 2, 3]"));
        assertTrue(v.val(8, "not in [1, 2, 3]"));
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
    public void testMatch()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("123", "match /^\\d+$/"));
        assertFalse(v.val("abc123", "match /^\\d+$/"));
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
    public void testUUID()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("eb3115e5-bd16-4939-ab12-2b95745a30f3", "is UUID"));
        assertFalse(v.val("13113113111", "is UUID"));
    }

    @Test
    public void testGBCode()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("110101", "is gbcode"));
        assertFalse(v.val("100100", "is gbcode"));
        assertFalse(v.val("13113113111", "is gbcode"));
    }
    @Test
    public void testID()
    {
        RebbVal v = new RebbVal();
        assertTrue(v.val("140303192005236131","is ID"));
        assertFalse(v.val("110100199909093245","is ID"));

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

