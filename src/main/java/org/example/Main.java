package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj podpunkt do rozwiązania:");
        String choose = scan.nextLine();
        LoadFromFile load = new LoadFromFile(choose + ".txt");
        double[][] matrix = load.load();
        int n = matrix.length;
        int m = matrix[0].length;
        double[][] trimmedMatrix = new double[n - 1][m];
        //usuwamy ostatni wiersz z macierzy bo wczytują się dodatkowe 0
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < m; col++) {
                trimmedMatrix[row][col] = matrix[row][col];
            }
        }
        Jordan jordan = new Jordan(trimmedMatrix);
        double[] result = jordan.jordanMethod();
        for (int i = 0; i < result.length; i++) {
            System.out.println("x" + (i+1) + ": " + String.format("%.2f", result[i]));
        }
    }
}