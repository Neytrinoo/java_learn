package com.company.flows;

//статический импорт. позволяет вызывать статические методы классов без указания класса. Т.е. вместо Math.sqrt() будет просто sqrt()
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;


public class AssertDemo {
    static int val = 3;

    static int getnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;

        for(int i=0; i < 10; i++) {
            n = getnum();
            assert n > 0 : "n отрицательное!"; // проверка, что n положительно. если нет - генерируется исключение типа AssertionError.
            // Будет работать только в случае задания параметра -ea при запуске программы
            System.out.println("n равно " + n);
        }

    }
}
