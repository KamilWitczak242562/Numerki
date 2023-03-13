package org.example;

import static java.lang.Math.pow;

public class Functions {
    private double a;
    private double b;
    double epsilon;

    int funkcja;

    int stop;

    int ite;


    public Functions(double a, double b, int funkcja, int stop, double epsilon) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
        this.funkcja = funkcja;
        this.stop = stop;
    }

    public Functions(double a, double b, int funkcja, int stop, int ite) {
        this.a = a;
        this.b = b;
        this.funkcja = funkcja;
        this.stop = stop;
        this.ite = ite;
    }

    public double f(double x) {
        return pow(x, 3) + pow(x, 2) - 3;
    }

    public double bis() {
        double sr;
        int kroki = 0;
        if (f(a) * f(b) < 0) {
            sr = a;
            if (stop == 1) {
                while ((b - a) > epsilon) {
                    sr = (a + b) / 2;
                    if (f(a) * f(sr) < 0) {
                        b = sr;
                    } else if (f(b) * f(sr) < 0) {
                        a = sr;
                    } else break;
                }
            } else if (stop == 2) {
                while (kroki != ite) {
                    sr = (a + b) / 2;
                    if (f(a) * f(sr) < 0) {
                        b = sr;
                    } else if (f(b) * f(sr) < 0) {
                        a = sr;
                    } else break;
                    kroki++;
                }
            }
        } else {
            sr = 0;
        }
        return sr;
    }
}
