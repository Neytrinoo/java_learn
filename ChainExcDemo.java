package com.company;

public class ChainExcDemo {
    public static void main(String[] args) {
//        try {
//            demoproc();
//        } catch(NullPointerException e) {
//            System.out.println("Перехвачено исключение: " + e);
//            System.out.println("Первопричина: " + e.getCause()); // Первопричина исключения
//        }
        int a = 10, b = 0;
        int vals[] = {1, 2, 3};
        try {
            int result = a / b;
            // vals[10] = 19; Если раскоментировать эту и закоментировать строчку выше, все равно обработка исключений будет в catch, т.к. там определены сразу 2 типа исключений
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) { // Многократный перехват исключений
            System.out.println("Исключение перехвачено: " + e);
        }
    }

    static void demoproc() {
        NullPointerException e = new NullPointerException("верхний уровень");
        e.initCause(new ArithmeticException("Причина")); // Причина исключения задается с помощью метода initCause, и только один раз. Вызваться эта причина может с помощью метода getCause()
        throw e;
    }
}
