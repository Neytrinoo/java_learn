package com.company.flows;

import java.io.PrintWriter;

public class OutputClasses {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Это строка");
        int i = -7;
        pw.println(i);
        double d = 4.5e-7;
        pw.print(d);
    }
}
