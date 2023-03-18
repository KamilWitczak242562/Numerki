package org.example;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Trigonometric implements Func{
    @Override
    public double operation(double x) {
        return 2 * cos(x) + 1;
    }

    @Override
    public double derivative(double x) {
        return -2 * sin(x);
    }

    @Override
    public String funcToString() {
        return "2 * cos(x) + 1";
    }
}
