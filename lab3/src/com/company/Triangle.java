package com.company;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class Triangle implements Serializable {
    private float _a;
    private float _b;
    private float _c;

    public Triangle(float a, float b, float c){
      _a = a;
      _b = b;
      _c = c;
    };

    public boolean isValid(){
        return _a + _b > _c && _a + _c > _b && _c + _b > _a && _a > 0 && _b > 0 && _c > 0;
    };

    public float getPerimeter() {
        return isValid() ? _a + _b + _c : Float.NaN;
    };

    public float getArea() {
        if (isValid())
        {
            float p = getPerimeter() / 2;
            return (float) Math.sqrt(p * (p - _a) * (p - _b) * (p - _c));
        }
        else
        {
            return Float.NaN;
        }
    };

    private float angle(float x1, float x2, float x3){
        return isValid() ? (float) Math.acos((x1*x1 + x2*x2 - x3*x3) / (2 * x1 * x2)) : Float.NaN;
    }

    // angle between a and c in rad
    public float getAlpha(){
        return angle(_a, _c, _b);
    };

    // angle between a and b in rad
    public float getBetta(){
        return angle(_a, _b, _c);
    };

    // angle between b and c in rad
    public float getGamma(){
        return angle(_b, _c, _a);
    };

    public boolean isIsosceles(){
        return isValid() ? _a == _b || _a == _c || _b == _c : false;
    };

    public String description(){
        String result = "\nDescription:\n";

        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null) {
            result += "Class: " + enclosingClass.getName();
        } else {
            result += "Class: " + getClass().getName();
        }

        result += "\ndata: {a: " + _a + ", b: " + _b + ", c:" + _c + "}";
        result += "\nIs Valid? : " + isValid();
        result += "\nAlpha: " + getAlpha() + "\nBetta: " + getBetta() + "\nGamma: " + getGamma();
        result += "\nPerimeter: " + getPerimeter();
        result += "\nArea: " + getArea();
        result += "\nIs Isosceles? : " + isIsosceles();

        return result;
    };
}
