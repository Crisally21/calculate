package main.java;

import java.util.HashMap;
import java.util.Map;

public class Rome {

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

    public String calculate(String[] inputValue) {

        int value1 = convertRomeToInt(inputValue[0]);
        int value2 = convertRomeToInt(inputValue[2]);
        String operation = inputValue[1];

        if ((value1 > 0 && value1 < 11) && (value2 > 0 && value2 < 11)) {
            switch (operation) {
                case "+":
                    return String.valueOf(sum(value1, value2));
                case "-":
                    if (!(value2 > value1)){
                        return String.valueOf(sub(value1, value2));
                    } else {
                        System.out.println("В ответе не может быть отрицательное число");
                        System.exit(0);
                    }
                case "*":
                    return String.valueOf(mul(value1, value2));
                case "/":
                    return String.valueOf(div(value1, value2));
                default:
                    break;
            }

        }
        return "Введено число из неверного диапазона";
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
