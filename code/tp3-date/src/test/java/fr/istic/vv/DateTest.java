package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testIsValidDateInvalid() {
        assertTrue(isValidDate(1, 1, 0));
    }

    @Test
    void testIsValidDateValid() {
        assertTrue(isValidDate(1, 1, 2000));
    }

    @Test
    void testIsLeapYear400Multiple() {
        assertTrue(isLeapYear(400));
    }

    @Test
    void testIsLeapYear4But100Multiple() {
        assertTrue(isLeapYear(4));
    }

    @Test
    void testIsLeapYearInvalid() {
        assertFalse(isLeapYear(2));
    }

    @Test
    void testNextDateMidMonth() {
        Date date = new Date(21, 11, 2023);

        Date actual = date.nextDate();

        Date expected = new Date(22, 11, 2023);

        assertEquals(expected, actual);
    }

    @Test
    void testNextDateEndMonth() {
        Date date = new Date(30, 11, 2023);

        Date actual = date.nextDate();

        Date expected = new Date(1, 12, 2023);

        assertEquals(expected, actual);
    }

    @Test
    void testNextDateEndYear() {
        Date date = new Date(31, 12, 2023);

        Date actual = date.nextDate();

        Date expected = new Date(1, 1, 2024);

        assertEquals(expected, actual);
    }

    @Test
    void testPreviousDateMidMonth() {
        Date date = new Date(21, 11, 2023);

        Date actual = date.previousDate();

        Date expected = new Date(20, 11, 2023);

        assertEquals(expected, actual);
    }

    @Test
    void testPreviousDateEndMonth() {
        Date date = new Date(1, 2, 2023);

        Date actual = date.previousDate();

        Date expected = new Date(31, 1, 2023);

        assertEquals(expected, actual);
    }

    @Test
    void testPreviousDateStartYear() {
        Date date = new Date(1, 1, 2023);

        Date actual = date.previousDate();

        Date expected = new Date(31, 12, 2022);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareToYearUpperMonthLower() {
        Date date1 = new Date(1, 1, 2001);
        Date date2 = new Date(1, 2, 2000);

        int actual = date1.compareTo(date2);

        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void testCompareToSame() {
        Date date1 = new Date(1, 1, 2000);
        Date date2 = new Date(1, 1, 2000);

        int actual = date1.compareTo(date2);

        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void testCompareToDayMonthLower() {
        Date date1 = new Date(1, 1, 2000);
        Date date2 = new Date(2, 2, 2000);

        int actual = date1.compareTo(date2);

        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    void testCompareToMonthLower() {
        Date date1 = new Date(1, 1, 2000);
        Date date2 = new Date(1, 2, 2000);

        int actual = date1.compareTo(date2);

        int expected = -1;

        assertEquals(expected, actual);
    }
}