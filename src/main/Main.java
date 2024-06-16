package main;

import main.java.Arabic;
import main.java.Rome;

import java.util.Scanner;

import static main.java.utils.Parsing.pars;

public class Main {

    public static String calc(String input) throws Exception {

        String[] numArray = pars(input);
        String result;
        if (numArray[3].equals("R")) {
            result = new Rome().calculate(numArray);
        } else {
            result = new Arabic().calculate(numArray);
        }

        return result;

    }


    public static void main(String[] args) throws Exception {

        Scanner console = new Scanner(System.in);
        System.out.println("Input:");
        String inputString = console.nextLine();

        System.out.println("Output:\n"+calc(inputString));

    }


}