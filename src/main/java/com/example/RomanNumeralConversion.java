package com.example;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class RomanNumeralConversion {

    private enum Numerals {
        M(1000),
        D(500),
        C(100),
        L(50),
        X(10),
        V(5),
        I(1);

        private int _value;

        Numerals(int value) {
            _value = value;
        }

        public int getValue() {
            return _value;
        }

        static Numerals[] getDigitGroupForPowerOfTen(int exponent) {
            switch(exponent) {
                case 3: return new Numerals[]{M, null, null};
                case 2: return new Numerals[]{C, D, M};
                case 1: return new Numerals[]{X, L, C};
                case 0: return new Numerals[]{I, V, X};
            }
            throw new IllegalArgumentException("illegal argument, must be in [0, 3]");
        }
    }

    public static int convertFromRomanNumerals(String romanNumerals) {
        return 1;
    }

    public static String convertToRomanNumerals(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("must be in [1, 3999]");
        }
        List<Integer> digits = toDigits(number);
        List<Integer> reverseDigits = Lists.reverse(digits);
        List<String> reverseResult = new ArrayList<>();
        for (int powerOfTen = 0; powerOfTen < 4; powerOfTen++) {
            int digit = reverseDigits.get(powerOfTen);
            if (digit == 0) {
                reverseResult.add("");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int[] grouping = groupingForDigit(digit);
            Numerals[] digitGroup = Numerals.getDigitGroupForPowerOfTen(powerOfTen);
            for (int groupingKey : grouping) {
                sb.append(digitGroup[groupingKey]);
            }
            reverseResult.add(sb.toString());
        }
        return Lists.reverse(reverseResult).stream().collect(joining());
    }

    private static int[] groupingForDigit(int digit) {
        switch (digit) {
            case 1: return new int[]{0};
            case 2: return new int[]{0, 0};
            case 3: return new int[]{0, 0, 0};
            case 4: return new int[]{0, 1};
            case 5: return new int[]{1};
            case 6: return new int[]{1, 0};
            case 7: return new int[]{1, 0, 0};
            case 8: return new int[]{1, 0, 0, 0};
            case 9: return new int[]{0, 2};
            default: throw new IllegalArgumentException("invalid digit, must be in [1, 9] at this point");
        }
    }

    private static List<Integer> toDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        int temp = number;
        int maxExp = 3;
        int powerOfTen = 1000;
        for (int exponent = maxExp; exponent >= 0; exponent--) {
            int divResult = temp / powerOfTen;
            digits.add(divResult);
            temp -= powerOfTen * divResult;
            powerOfTen /= 10;
        }
        return digits;
    }
}
