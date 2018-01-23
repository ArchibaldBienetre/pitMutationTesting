package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.RomanNumeralConversion.convertFromRomanNumerals;
import static com.example.RomanNumeralConversion.convertToRomanNumerals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralConversionTest {

    static Stream<Arguments> conversionTestData() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6),
                Arguments.of("VII", 7),
                Arguments.of("VIII", 8),
                Arguments.of("IX", 9),
                Arguments.of("X", 10),
                Arguments.of("XI", 11),
                Arguments.of("XII", 12),
                Arguments.of("XIII", 13),
                Arguments.of("XIV", 14),
                Arguments.of("XV", 15),
                Arguments.of("XVI", 16),
                Arguments.of("XVII", 17),
                Arguments.of("XVIII", 18),
                Arguments.of("XIX", 19),
                Arguments.of("XX", 20),

                Arguments.of("XXXVIII", 38),
                Arguments.of("XXXIX", 39),
                Arguments.of("XL", 40),
                Arguments.of("XLI", 41),

                Arguments.of("XLVIII", 48),
                Arguments.of("XLIX", 49),
                Arguments.of("L", 50),
                Arguments.of("LI", 51),
                Arguments.of("LII", 52),

                Arguments.of("LXXVIII", 78),
                Arguments.of("LXXIX", 79),
                Arguments.of("LXXX", 80),
                Arguments.of("LXXXI", 81),
                Arguments.of("LXXXII", 82),

                Arguments.of("XCVIII", 98),
                Arguments.of("XCIX", 99),
                Arguments.of("C", 100),
                Arguments.of("CI", 101),
                Arguments.of("CII", 102),

                Arguments.of("CCCXCVIII", 398),
                Arguments.of("CCCXCIX", 399),
                Arguments.of("CD", 400),
                Arguments.of("CDI", 401),

                Arguments.of("CDXCVIII", 498),
                Arguments.of("CDXCIX", 499),
                Arguments.of("D", 500),
                Arguments.of("DI", 501),
                Arguments.of("DII", 502),

                Arguments.of("DC", 600),

                Arguments.of("DCCXCIX", 799),
                Arguments.of("DCCC", 800),


                Arguments.of("DCCCXCIX", 899),
                Arguments.of("CM", 900),

                Arguments.of("CMXCVIII", 998),
                Arguments.of("CMXCIX", 999),
                Arguments.of("M", 1000),
                Arguments.of("MI", 1001),
                Arguments.of("MII", 1002),

                Arguments.of("MDCCLXXVI", 1776),
                Arguments.of("MCMLIV", 1954),
                Arguments.of("MCMXC", 1990),
                Arguments.of("MMXIV", 2014),

                Arguments.of("MMMCMXCIX", 3999)
        );
    }

    @ParameterizedTest
    @MethodSource("conversionTestData")
    void test_convertFromRomanNumerals(String romanNumerals, int number) {
        assertEquals(number, convertFromRomanNumerals(romanNumerals));
    }

    @ParameterizedTest
    @MethodSource("conversionTestData")
    void test_convertToRomanNumerals(String romanNumerals, int number) {
        assertEquals(romanNumerals, convertToRomanNumerals(number));
    }

    static Stream<Arguments> nonStandardConvertFromRomanNumeralsTestData() {
        return Stream.of(
                Arguments.of("IIX", 8),
                Arguments.of("XXXX", 40),
                Arguments.of("IL", 49),
                Arguments.of("IC", 99)
        );
    }

    @ParameterizedTest
    @MethodSource("nonStandardConvertFromRomanNumeralsTestData")
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