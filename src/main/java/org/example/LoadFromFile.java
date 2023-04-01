package org.example;

import java.io.*;
import java.util.Scanner;

public class LoadFromFile {
    private final String fileName;

    public LoadFromFile(String name) {
        this.fileName = name;
    }

    public double[][] load() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        int n = line.trim().split("\\s+").length;
        double[][] matrix = new double[n][n];
        int row = 0;
        while (line != null) {
            if (row < n) {
                String[] values = line.trim().split("\\s+");
                if (values.length == n) {
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Double.parseDouble(values[col]);
                    }
                } else {
                    throw new IOException("Invalid row in input file: " + line);
                }
            }
            row++;
            line = reader.readLine();
        }
        reader.close();
        return matrix;
    }
}
