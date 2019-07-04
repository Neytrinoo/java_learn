package com.company;

public class LearnExceptions {
    public static void main(String[] args) {
        int d, a;
        try {
//            d = 0;
//            a = 42 / d;
//            System.out.println("Это не будет выведено");
            a = args.length;
            d = 42 / a;
            int c[] = {1};
            c[42] = 99;
        } catch (ArithmeticException e) { // Тут catch - Это как except в Python
            System.out.println("Деление на ноль");
            System.out.println("Исключение: " + e); // Вывод исключения на экран
        } catch (ArrayIndexOutOfBoundsException e) { // Можно указывать несколько блоков Catch для разных исключений
            System.out.println("Ошибка индексации за пределами массива " + e);
        }
        System.out.println("После оператора catch");
    }
}
