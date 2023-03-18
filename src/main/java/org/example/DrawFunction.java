package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.text.DecimalFormat;

public class DrawFunction extends JFrame {

    private double lower;
    private double higher;
    private Func func;
    private double resBis;
    private double resTan;

    private DecimalFormat df = new DecimalFormat("0.000");

    public DrawFunction(double lower, double higher, Func func, double resBis, double resTan) {
        this.lower = lower;
        this.higher = higher;
        this.func = func;
        this.resBis = resBis;
        this.resTan = resTan;
        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {

        var series = new XYSeries(func.funcToString());
        for (double i = lower; i < higher; i += 0.01d) {
            series.add(i, func.operation(i));
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Function",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        ValueMarker marker = new ValueMarker(0);
        marker.setPaint(Color.black);
        marker.setStroke(new java.awt.BasicStroke(2.5f));

        plot.addDomainMarker(marker);
        plot.addRangeMarker(marker);

        XYTextAnnotation resB = new XYTextAnnotation("Wynik bisekcji: " + df.format(resBis), resBis, -6);
        XYTextAnnotation resT = new XYTextAnnotation("Wynik stycznych: " + df.format(resTan), resTan, 6);
        resB.setFont(new Font("Serif", Font.PLAIN, 12));
        resT.setFont(new Font("Serif", Font.PLAIN, 12));
        resB.setTextAnchor(TextAnchor.BASELINE_CENTER);
        resT.setTextAnchor(TextAnchor.BASELINE_CENTER);
        plot.addAnnotation(resB);
        plot.addAnnotation(resT);

        chart.setTitle(new TextTitle("Function",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );
        return chart;
    }
}
