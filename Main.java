package com.company;

public class Main {

    public static void main(String[] args) {
        int num;
        num = 100;
        System.out.println("Это переменная num: " + num);
        num *= 2;
        System.out.print("Значение переменной num * 2 равно ");
        System.out.println(num);
        int x, y;
        x = 10;
        y = 20;
        if (x < y) System.out.println("x lost than y");
        x *= 2;
        if (x == y) System.out.println("But now x equal y");
        x *= 2;
        if (x > y) System.out.println("Not now now x more than y");
        if (x == y) System.out.println("You won't see it");

        /*
            Продемонстрировать применение цикла for.
            Присвоить исходному файлу имя "Forтest.java"
        */
        for (x = 0; x < 10; x++) System.out.println("Значение x: " + x);

        for (x = 0; x < 1; x++) {
            System.out.println("Значение x: " + x);
        }
        for (int k = 0; k < 4; k++) System.out.println("Значение какашки: " + k); // k - локальная переменная, недоступная вне цикла
        double pi, r, s;
        r = 10.8;
        pi = 3.1416;
        s = pi * r * r;
        // радиус окружности
        // приблизительное значение числа пи
        // вычислить площадь круга
        System.out.println("Плoщaдь круга равна " + s);

        char ch1, ch2;
        ch1 = 88;
        ch2 = 'Y'; // char'ы указываются в одинарных кавычках
        System.out.print("ch1 and ch2: ");
        System.out.println(ch1 + " " + ch2);
        //Символьные переменные ведут себя как целочисленные значения
        System.out.println("ch1 содержит " + ch1);
        ch1++;
        System.out.println("ch1 теперь содержит " + ch1);

        boolean b;
        b = false;
        System.out.println("b equal " + b);
        b = true;
        System.out.println("b equal " + b);
        //значения типа boolean может управляться оператором if
        if (b) System.out.println("This code are doing");
        b = false;
        if (b) System.out.println("This code aren't doing");
        // результат сравнения - значение типа boolean
        System.out.println("10 > 9 равно " + (10 > 9));

        x = 123_456_789; // при компиляции знаки подчеркивания игнорируются
        double num2 = 9_423_497.1_0_9;
        System.out.println(x + " " + num2);

        double a1 = 3.0, b1 = 4.0; // a1 and b1 объявляются константами
        double c1 = Math.sqrt(a1 * a1 + b1 * b1); // c1 объявляется динамически. Math - встроенный клас, у которого есть метод sqrt - вычисление квадратного корня
        
        System.out.println("Гипотенуза равна " + c1);
    }
}
