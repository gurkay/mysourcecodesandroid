package com.mysourcecodesandroid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ConverterUtilTest {

    private ConverterUtil lstTest = new ConverterUtil();

    @Test
    public void convertFahrenheitToCelsius() {

        try {
            float input = 212;
            float output;
            float expected = 100;
            double delta = .1;

            ConverterUtil converterUtil = new ConverterUtil();
            output = converterUtil.convertFahrenheitToCelsius(input);

            assertEquals(expected, output, delta);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void convertCelsiusToFahrenheit() {
        try {
            float input = 100;
            float output;
            float expected = 212;
            double delta = .1;

            ConverterUtil converterUtil = new ConverterUtil();
            output = converterUtil.convertCelsiusToFahrenheit(input);

            assertEquals(expected, output, delta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Before
    public void init() {
        lstTest.add("Apple");
        lstTest.add("Orange");
        lstTest.add("Grapes");
    }

    @Test
    public void testSize() {
        assertEquals("Checking size of List", 3, lstTest.size());
    }

    @Test
    public void testAdd() {
        lstTest.add("Banana");
        assertEquals("Adding 1 more fruit to list", 4, lstTest.size());
    }

    @Test
    public void testRemove() {
        lstTest.remove("Orange");
        assertEquals("Removing 1 fruit from list", 2, lstTest.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveException() {
        lstTest.remove("Kiwi");
        assertEquals("Removing 1 fruit from list", 2, lstTest.size());
    }

    @After
    public void destroy() {
        lstTest.removeAll();
    }
}