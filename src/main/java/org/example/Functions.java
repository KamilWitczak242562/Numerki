package org.example;

import java.lang.reflect.Method;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Functions {
    private double a;
    private double b;
    private double epsilon;
    private int stop;
    private int ite;
    private Func function;

    public Functions(double a, double b, Func function, int stop, double epsilon) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
        this.function = function;
        this.stop = stop;
    }

    public Functions(double a, double b, Func function, int stop, int ite) {
        this.a = a;
        this.b = b;
        this.function = function;
        this.stop = stop;
        this.ite = ite;
    }

    public double bis() {
        double sr;
        int kroki = 0;
        sr = (a + b) / 2;
        if (stop == 1) {
            while (abs(function.operation(sr)) > epsilon) {
                sr = (a + b) / 2;
                if (function.operation(b) * function.operation(sr) < 0) {
                    a = sr;
                } else if (function.operation(a) * function.operation(sr) < 0) {
                    b = sr;
                }
            }
        } else if (stop == 2) {
            while (kroki != ite) {
                sr = (a + b) / 2;
                if (function.operation(b) * function.operation(sr) < 0) {
                    a = sr;
                } else if (function.operation(a) * function.operation(sr) < 0) {
                    b = sr;
                }
                kroki++;
            }
        }
        return sr;
}

    public double tan() {
        double sr;
        int kroki = 0;
        sr = a;
        if (stop == 1) {
            while (abs(function.operation(sr)) > epsilon) {
                sr -= function.operation(sr) / function.derivative(sr);
            }
        } else if (stop == 2) {
            while (kroki != ite) {
                sr -= function.operation(sr) / function.derivative(sr);
                kroki++;
            }
        }
        return sr;
    }

}
