package org.example;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Func func = null;
        Functions functions = null;
        System.out.println("Proszę wybrać funkcję:");
        System.out.println("1. Wielomian");
        System.out.println("2. Trygonometryczna");
        System.out.println("3. Wykładnicza");
        System.out.println("4. Złożona");
        int chooseFunction = scan.nextInt();
        switch (chooseFunction) {
            case 1:
                func = new Polynomial();
                break;
            case 2:
                func = new Trigonometric();
                break;
            case 3:
                func = new Exponent();
                break;
            case 4:
                func = new Complex();
                break;
        }
        System.out.println("Proszę podać dolny przedział:");
        double chooseDoubleLow = scan.nextDouble();
        System.out.println("Proszę podać górny przedział:");
        double chooseDoubleHigh = scan.nextDouble();
        System.out.println("Proszę wybrać kryterium stopu:");
        System.out.println("1. Dokładność");
        System.out.println("2. Liczba iteracji");
        int chooseStop = scan.nextInt();
        double chooseEps;
        int chooseIte;
        if (chooseStop == 1) {
            System.out.println("Proszę podać epsilon:");
            chooseEps = scan.nextDouble();
            functions = new Functions(chooseDoubleLow, chooseDoubleHigh, func, chooseStop, chooseEps);
        } else if (chooseStop == 2) {
            System.out.println("Proszę podać ilość iteracji:");
            chooseIte = scan.nextInt();
            functions = new Functions(chooseDoubleLow, chooseDoubleHigh, func, chooseStop, chooseIte);
        }
        double resBis = functions.bis();
        System.out.println("Wyniki metodą bisekcji: " + resBis);
        double resTan = functions.tan();
        System.out.println("Wyniki metodą stycznych: " + resTan);

        Func finalFunc = func;
        EventQueue.invokeLater(() -> {
            var fun = new DrawFunction(chooseDoubleLow, chooseDoubleHigh, finalFunc, resBis, resTan);
            fun.setVisible(true);
        });
    }
}