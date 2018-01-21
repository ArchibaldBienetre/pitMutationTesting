package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

import java.util.stream.Stream;

import static com.example.RomanNumeralConversion.convertFromRomanNumerals;
import static com.example.RomanNumeralConversion.convertToRomanNumerals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralConversionTest {

    static Stream<Arguments> conversionTestData() {
        return Stream.of(
                ObjectArrayArguments.create("I", 1),
                ObjectArrayArguments.create("II", 2),
                ObjectArrayArguments.create("III", 3),
                ObjectArrayArguments.create("IV", 4),
                ObjectArrayArguments.create("V", 5),
                ObjectArrayArguments.create("VI", 6),
                ObjectArrayArguments.create("VII", 7),
                ObjectArrayArguments.create("VIII", 8),
                ObjectArrayArguments.create("IX", 9),
                ObjectArrayArguments.create("X", 10),
                ObjectArrayArguments.create("XI", 11),
                ObjectArrayArguments.create("XII", 12),
                ObjectArrayArguments.create("XIII", 13),
                ObjectArrayArguments.create("XIV", 14),
                ObjectArrayArguments.create("XV", 15),
                ObjectArrayArguments.create("XVI", 16),
                ObjectArrayArguments.create("XVII", 17),
                ObjectArrayArguments.create("XVIII", 18),
                ObjectArrayArguments.create("XIX", 19),
                ObjectArrayArguments.create("XX", 20),

                ObjectArrayArguments.create("XXXVIII", 38),
                ObjectArrayArguments.create("XXXIX", 39),
                ObjectArrayArguments.create("XL", 40),
                ObjectArrayArguments.create("XLI", 41),

                ObjectArrayArguments.create("XLVIII", 48),
                ObjectArrayArguments.create("XLIX", 49),
                ObjectArrayArguments.create("L", 50),
                ObjectArrayArguments.create("LI", 51),
                ObjectArrayArguments.create("LII", 52),

                ObjectArrayArguments.create("LXXVIII", 78),
                ObjectArrayArguments.create("LXXIX", 79),
                ObjectArrayArguments.create("LXXX", 80),
                ObjectArrayArguments.create("LXXXI", 81),
                ObjectArrayArguments.create("LXXXII", 82),

                ObjectArrayArguments.create("XCVIII", 98),
                ObjectArrayArguments.create("XCIX", 99),
                ObjectArrayArguments.create("C", 100),
                ObjectArrayArguments.create("CI", 101),
                ObjectArrayArguments.create("CII", 102),

                ObjectArrayArguments.create("CCCXCVIII", 398),
                ObjectArrayArguments.create("CCCXCIX", 399),
                ObjectArrayArguments.create("CD", 400),
                ObjectArrayArguments.create("CDI", 401),

                ObjectArrayArguments.create("CDXCVIII", 498),
                ObjectArrayArguments.create("CDXCIX", 499),
                ObjectArrayArguments.create("D", 500),
                ObjectArrayArguments.create("DI", 501),
                ObjectArrayArguments.create("DII", 502),

                ObjectArrayArguments.create("DC", 600),

                ObjectArrayArguments.create("DCCXCIX", 799),
                ObjectArrayArguments.create("DCCC", 800),


                ObjectArrayArguments.create("DCCCXCIX", 899),
                ObjectArrayArguments.create("CM", 900),

                ObjectArrayArguments.create("CMXCVIII", 998),
                ObjectArrayArguments.create("CMXCIX", 999),
                ObjectArrayArguments.create("M", 1000),
                ObjectArrayArguments.create("MI", 1001),
                ObjectArrayArguments.create("MII", 1002),

                ObjectArrayArguments.create("MDCCLXXVI", 1776),
                ObjectArrayArguments.create("MCMLIV", 1954),
                ObjectArrayArguments.create("MCMXC", 1990),
                ObjectArrayArguments.create("MMXIV", 2014),

                ObjectArrayArguments.create("MMMCMXCIX", 3999)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "conversionTestData")
    void test_convertFromRomanNumerals(String romanNumerals, int number) {
        assertEquals(number, convertFromRomanNumerals(romanNumerals));
    }

    @ParameterizedTest
    @MethodSource(names = "conversionTestData")
    void test_convertToRomanNumerals(String romanNumerals, int number) {
        assertEquals(romanNumerals, convertToRomanNumerals(number));
    }

    static Stream<Arguments> nonStandardConvertFromRomanNumeralsTestData() {
        return Stream.of(
                ObjectArrayArguments.create("IIX", 8),
                ObjectArrayArguments.create("XXXX", 40),
                ObjectArrayArguments.create("IL", 49),
                ObjectArrayArguments.create("IC", 99)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "nonStandardConvertFromRomanNumeralsTestData")
    void test_that_convertFromRomanNumerals_recognizes_non_standard_numerals(String romanNumerals, int number) {
        assertEquals(number, convertFromRomanNumerals(romanNumerals));
    }

    @Test
    void test_convertFromRomanNumerals_illegal_input() {
        assertThrows(IllegalArgumentException.class, () -> convertToRomanNumerals(4001));
        assertThrows(IllegalArgumentException.class, () -> convertToRomanNumerals(4000));
        assertThrows(IllegalArgumentException.class, () -> convertToRomanNumerals(0));
        assertThrows(IllegalArgumentException.class, () -> convertToRomanNumerals(-1));
    }

    @Test
    void test_convertToRomanNumerals_illegal_input() {
        assertThrows(IllegalArgumentException.class, () -> convertFromRomanNumerals("Z"));
        assertThrows(IllegalArgumentException.class, () -> convertFromRomanNumerals(""));
    }
}