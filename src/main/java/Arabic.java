package main.java;

public class Arabic {


    public String calculate(String[] inputValue) throws Exception {

        int value1 = Integer.parseInt(inputValue[0]);
        int value2 = Integer.parseInt(inputValue[2]);
        String operation = inputValue[1];

        if ((value1 > 0 && value1 < 11) && (value2 > 0 && value2 < 11)) {
            switch (operation) {
                case "+":
                    return String.valueOf(sum(value1, value2));
                case "-":
                    return String.valueOf(sub(value1, value2));
                case "*":
                    return String.valueOf(mul(value1, value2));
                case "/":
                    return String.valueOf(div(value1, value2));
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
        } catch (Exception e) {
            System.out.println("Деление на 0");
            return 0;
        }
    }
}
