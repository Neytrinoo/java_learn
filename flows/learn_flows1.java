package com.company.flows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class learn_flows1 {
    public static void main(String[] args) throws IOException {
        // в переменную br будет записан поток ввода символов, связанный с консолью через стандартный поток ввода System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        System.out.println("Введите символы, \n'q' - для выхода.");
        do {
            c = (char) br.read(); //читает посимвольно
            System.out.println(c);
        } while (c != 'q');

        String str;
        System.out.println("Теперь введите строки текста.");
        System.out.println("Введите 'стоп' для завершения.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("стоп"));
    }
}