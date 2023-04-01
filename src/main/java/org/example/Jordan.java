package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jordan {
    private double[][] matrix;

    public Jordan(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[] jordanMethod() {
        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            double max = Math.abs(matrix[k][k]);
            int maxRow = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(matrix[i][k]) > max) {
                    max = Math.abs(matrix[i][k]);
                    maxRow = i;
                }
            }
            if (maxRow != k) {
                double[] temp = matrix[k];
                matrix[k] = matrix[maxRow];
                matrix[maxRow] = temp;
            }
            for (int j = k + 1; j <= n; j++) {
                matrix[k][j] /= matrix[k][k];
            }
            matrix[k][k] = 1;
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = matrix[i][k];
                    for (int j = k + 1; j <= n; j++) {
                        matrix[i][j] -= factor * matrix[k][j];
                    }
                    matrix[i][k] = 0;
                }
            }
        }

        double[] solution = new double[n];
        for (int i = 0; i < n; i++) {
            solution[i] = matrix[i][n];
        }
        return solution;
    }
}