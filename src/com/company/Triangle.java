package com.company;

public class Triangle {
    private int a, b, c;
    public double P, S, A, B, C;
    public Triangle()
    {
        a = 3;
        b = 4;
        c = 5;
    }
    public boolean ExistTriangle()
    {
        return ((a + b < c) || (b + c > a) || (c + a > b));
    }
    public double Perimetr()
    {
        P = a + b + c;
        return P;
    }
    public double Square()
    {
        S = ((P * (P - a) * (P - c) * (P - b))* ((P * (P - a) * (P - c) * (P - b))));
        return S;

    }
    public double Degree1()
    {
        A = Math.acos(Math.pow(b, 2)) + Math.pow(c, 2) - Math.pow(a, 2) / (2 * b * c);
        return A;
    }
    public double Degree2()
    {
        B = Math.acos(Math.pow(a, 2)) + Math.pow(c, 2) - Math.pow(b, 2) / (2 * a * c);
        return B;
    }
    public double Degree3()
    {
        C = Math.acos(Math.pow(b, 2)) + Math.pow(a, 2) - Math.pow(c, 2) / (2 * b * c);
        return C;
    }
    public void WriteTr()
    {
        System.out.println("a" + a + "b" + b + "c" + c + "Perimetr" + Perimetr() + " " + Square() + " " + Degree1() + " " + Degree2() + " " + Degree3());
    }
}