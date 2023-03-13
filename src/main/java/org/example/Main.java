package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Functions functions = null;
        System.out.println("Proszę wybrać funkcję:");
        int chooseFunction = scan.nextInt();
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
            functions = new Functions(chooseDoubleLow, chooseDoubleHigh, chooseFunction, chooseStop, chooseEps);
        } else if (chooseStop == 2) {
            System.out.println("Proszę podać ilość iteracji:");
            chooseIte = scan.nextInt();
            functions = new Functions(chooseDoubleLow, chooseDoubleHigh, chooseFunction, chooseStop, chooseIte);
        }
        double res = functions.bis();
        System.out.println(res);
        Functions f = new Functions(-6,6,1,2,200);
        System.out.println(f.bis());
        Functions f2 = new Functions(-6,6,1,1,0.000000000001);
        System.out.println(f2.bis());
    }
}