package main.java.utils;

public class Parsing {

    private static boolean isArabicDigit(String element) {

        char[] elements = element.toCharArray();

        for (Character elem : elements) {
            if (elem < 48 || elem > 57) {
                return false;
            }
        }

        return true;
    }

    private static boolean isOperationSign(String element) {
        return element.length() <= 1 &&
                (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/"));
    }


    private static boolean isRomeDigit(String element) {

        char[] elements = element.toUpperCase().toCharArray();

        for (Character elem : elements) {
            if (!elem.equals('I') && !elem.equals('V') && !elem.equals('X')) {
                return false;
            }
        }
        return true;
    }

    public static String[] pars(String input) {

        String[] symbolArray = input.split(" ");
        if (symbolArray.length != 3) {
            System.out.println("Вводите цифры и арифметические операции через пробел!");
            System.exit(0);

        }
        String[] resultArray = new String[4];
        if (isOperationSign(symbolArray[1])) {
            resultArray[1] = symbolArray[1];

            if (isArabicDigit(symbolArray[0]) && isArabicDigit(symbolArray[2])) {
                resultArray[0] = symbolArray[0];
                resultArray[2] = symbolArray[2];
                resultArray[3] = "A";

            } else if (isRomeDigit(symbolArray[0]) && isRomeDigit(symbolArray[2])) {
                resultArray[0] = symbolArray[0];
                resultArray[2] = symbolArray[2];
                resultArray[3] = "R";

            } else {
                System.out.println("Введено некорректное значение");
                System.exit(0);
            }
        } else {
            System.out.println("Введен неверный знак");
            System.exit(0);
        }

        return resultArray;
    }
}
