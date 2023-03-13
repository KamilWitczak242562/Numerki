package org.example;

import static java.lang.Math.pow;

public class Bisekcji {
    private double a;
    private double b;
    double epsilon;
    int liczba_krokow;

    public Bisekcji(double a, double b, double epsilon, int liczba_krokow) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
        this.liczba_krokow = liczba_krokow;
    }

    public double f(double x) {
        return pow(x, 3) + pow(x, 2) - 3;
    }

    public double bis() {
        double sr = 0.00;
        int kroki = 0;
        if (f(a) * f(b) < 0) {
            sr = a;
            while ((b - a) > epsilon || kroki == liczba_krokow) {
                sr = (a + b) / 2;
                if (f(a) * f(sr) < 0) {
                    b = sr;
                } else if (f(b) * f(sr) < 0) {
                    a = sr;
                } else break;
                kroki++;
            }
        } else {
            sr = 0;
        }
        return sr;
    }
}
