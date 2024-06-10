package main;

import main.java.Arabic;
import main.java.Rome;

import java.util.Scanner;

import static main.java.utils.Parsing.pars;

public class Calculate {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Input:");
        String inputString = console.nextLine();

        String[] numArray = pars(inputString);
        String result;
        if (numArray[3].equals("R")) {
            result = new Rome().calculate(numArray);
        } else {
            result = new Arabic().calculate(numArray);
        }
        System.out.println(result);

    }


}