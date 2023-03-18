package org.example;

public class Polynomial implements Func{

    @Override
    public double operation(double x) {
        return ourPow.pow(x, 3) + ourPow.pow(x, 2) - 3;
    }

    @Override
    public double derivative(double x) {
        return 3 * ourPow.pow(x, 2) + 2 * x;
    }

    @Override
    public String funcToString() {
        return "x^3 + x^2 - 3";
    }

}
