package com.company;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Triangle t = Persistance.load();

        System.out.println(t.description());

        Persistance.save(t);
    }
}
