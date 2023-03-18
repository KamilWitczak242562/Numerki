package org.example;

public interface ourPow {
    static double pow(double a, double b) {
        double pow = 1L;

        for (int i = 0; i < b; i++) {
            pow = pow * a;
        }

        return pow;
    }
}
