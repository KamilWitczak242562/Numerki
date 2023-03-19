package org.example;

import static java.lang.Math.*;

public class Exponent implements Func{
    @Override
    public double operation(double x) {
        return pow(2, x) * exp(x) - 3;
    }

    @Override
    public double derivative(double x) {
        return log(2) * pow(2, x) * exp(x) + pow(2, x) * exp(x);
    }

    @Override
    public String funcToString() {
        return "2^x * e^x - 1";
    }
}
