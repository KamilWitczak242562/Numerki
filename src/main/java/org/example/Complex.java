package org.example;

import static java.lang.Math.*;

public class Complex implements Func{
    @Override
    public double operation(double x) {
        return exp(sin(x)) - 2;
    }

    @Override
    public double derivative(double x) {
        return exp(sin(x)) * cos(x);
    }

    @Override
    public String funcToString() {
        return "e^sin(x) - 2";
    }
}
