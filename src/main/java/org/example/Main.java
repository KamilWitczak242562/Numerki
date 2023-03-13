package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bisekcji bisekcji = new Bisekcji(-6,6,0.00000000001, 200);
        double res = bisekcji.bis();
        System.out.println(res);
    }
}