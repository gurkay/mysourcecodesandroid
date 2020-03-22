package com.mysourcecodesandroid;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ConverterUtil {

    private List lstFruits = new ArrayList<>();

    /**
     * Converts to celsius
     */
    public static float convertFahrenheitToCelsius(float fahrenheit) {
        float result = ((fahrenheit - 32) * 5 / 9);
        return result;
    }

    /**
     * Converts to fahrenheit
     */
    public static float convertCelsiusToFahrenheit(float celsius) {
        float result = ((celsius * 9) / 5 + 32);
        return result;
    }

    public void add(String fruit) {
        lstFruits.add(fruit);
    }

    public void remove(String fruit) {
        if (!lstFruits.contains(fruit)) {
            throw new NoSuchElementException();
        }
        lstFruits.remove(fruit);
    }

    public int size() {
        return lstFruits.size();
    }

    public void removeAll() {
        lstFruits.clear();
    }
}
