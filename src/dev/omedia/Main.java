package dev.omedia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setFirstNumber(5.8);
        sc.setSecondNumber(4.4);
        System.out.println(sc.getDivisionResult());
        Carpet carpet = new Carpet(8);
        Floor floor = new Floor(10,12);
        Calculator calc = new Calculator(floor, carpet);
        System.out.println(calc.getTotalCost());
    }
}
