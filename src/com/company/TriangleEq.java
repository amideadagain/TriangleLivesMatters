package com.company;

public class TriangleEq {
    public double a, b, c;
    public TriangleEq()
    {
        a = 2;
        b = 2;
        c = 4;
    }
    public boolean TriangleCheck()
    {
        return ( (a = b) || (a = c) || (b = c) );
    }
}