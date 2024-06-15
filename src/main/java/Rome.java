package main.java;

import java.util.HashMap;
import java.util.Map;

public class Rome {

    private static boolean correctInput(String symbol) {

        String[] romeNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (String romeNum : romeNums) {
            if (romeNum.equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static String conventToResult(int num) {
        Map<Integer, String> romMap = new HashMap<>();
        romMap.put(1, "I");
        romMap.put(4, "IV");
        romMap.put(5, "V");
        romMap.put(9, "IX");
        romMap.put(10, "X");
        romMap.put(40, "XL");
        romMap.put(50, "L");
        romMap.put(90, "XC");
        romMap.put(100, "C");

        StringBuilder result = new StringBuilder();
        for (int value : new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1}) {
            while (num >= value) {
                result.append(romMap.get(value));
                num -= value;
            }
        }
        return result.toString();
    }


    private int convertRomeToInt(String num) {

        Map<Character, Integer> romNumbers = new HashMap<>();
        romNumbers.put('I', 1);
        romNumbers.put('V', 5);
        romNumbers.put('X', 10);

        int arabicNumber = 0;
        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);
            if (i < num.length() - 1) {
                char nextChar = num.charAt(i + 1);
                if (romNumbers.get(current) >= romNumbers.get(nextChar)) {
                    arabicNumber += romNumbers.get(current);
                } else {
                    arabicNumber -= romNumbers.get(current);
                }
            } else {
                arabicNumber += romNumbers.get(current);
            }
        }

        return arabicNumber;

    }

    public String calculate(String[] inputValue) throws Exception {

        int value1 = 0;
        int value2 = 0;

        if (correctInput(inputValue[0]) && correctInput(inputValue[2])) {
            value1 = convertRomeToInt(inputValue[0]);
            value2 = convertRomeToInt(inputValue[2]);
        } else {
            throw new Exception("введено римское число из неверного диапазона или не существует такого римского числа");
        }

        String operation = inputValue[1];

        if ((value1 > 0 && value1 < 11) && (value2 > 0 && value2 < 11)) {
            switch (operation) {
                case "+":
                    return conventToResult(sum(value1, value2));
                case "-":
                    if (value1 == value2) {
                        throw new Exception("в римской системе нет нуля");

                    } else if (!(value2 < value1)) {
                        throw new Exception("в римской системе нет отрицательных чисел");
                    } else {
                        return conventToResult(sub(value1, value2));
                    }
                case "*":
                    return conventToResult(mul(value1, value2));
                case "/":
                    return conventToResult(div(value1, value2));
                default:
                    break;
            }

        }
        throw new Exception("Введено число из неверного диапазона");
    }

    private int sum(int value1, int value2) {
        return value1 + value2;
    }


    private int sub(int value1, int value2) {
        return value1 - value2;
    }


    private int mul(int value1, int value2) {
        return value1 * value2;
    }


    private int div(int value1, int value2) {

        int result;

        try {
            result = value1 / value2;
            return result;
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0");
            return 0;
        }
    }
}