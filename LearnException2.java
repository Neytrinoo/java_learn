package com.company;

public class LearnException2 {
    public static void main(String[] args) {
//        try {
//            demoproc();
//        } catch (NullPointerException e) {
//            System.out.println("Повторный перехват: " + e);
//        }
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Исключение перехвачено");
        }
        procB();
        procC();
        try {
            compute(1);
            compute(10);
            compute(20);
        } catch (MyException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
    static void compute(int a) throws MyException {
        System.out.println("Вызван метод compute("+ a + ")");
        if (a > 10) throw new MyException(a);
        System.out.println("Нормальное завершение");
    }
    static void demoproc() {
        try {
            throw new NullPointerException("Демонстрация"); // Вызываем исключение. throw аналогично raise в Python
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в теле метода demoproc().");
            throw e; // Повторно вызываем исключение для передачи его в вызывающий метод
        }
    }
    static void procA() {
        try{
            System.out.println("В теле метода procA()");
            throw new RuntimeException("демонстрация");
        } finally { // finally будет выполнен, даже если вызывается исключение
            System.out.println("Блок оператора finally в методе procA()");
        }
    }
    static void procB() {
        try {
            System.out.println("В теле метода procB()");
            return;
        } finally { // finally все равно будет выполнен, даже если в try есть return
            System.out.println("Блок оператора finally в методе procB()");
        }
    }

    static void procC() {
        try {
            System.out.println("В теле метода procC()");
        } finally { // finally все равно будет выполнен, даже если ошибки отсутствуют
            System.out.println("Блок оператора finally в методе procC()");
        }
    }
}

class ThrowsDemo {
    static void throwOne() throws IllegalAccessException{ // Обязательно нужно указать throws и генерируемые в методе исключения, которые не относятся к классам Error и RuntimeException
        System.out.println("В теле метода thorOne();");
        throw new IllegalAccessException("демонстрация");
    }
}

class MyException extends Exception { // создаем специальный тип исключения. Свое исключение
    private int detail;
    MyException(int a) {
        detail = a;
    }
    public String toString() {
        return "MyException[" + detail + "]";
    }

}
