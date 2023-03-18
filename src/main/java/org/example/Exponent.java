package org.example;

import static java.lang.Math.exp;
import static java.lang.Math.log;

public class Exponent implements Func{
    @Override
    public double operation(double x) {
        return ourPow.pow(2, x) * exp(x) - 1;
    }

    @Override
    public double derivative(double x) {
        return log(2) * ourPow.pow(2, x) * exp(x) + ourPow.pow(2, x) * exp(x);
    }

    @Override
    public String funcToString() {
        return "2^x * e^x - 1";
    }
}
