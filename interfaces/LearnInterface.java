package com.company.interfaces;

import java.util.Random;

public class LearnInterface {
    public static void main(String[] args) {
        Callback c = new Client(); // Переменной c присвоен экземпляр класса Client, насмотря на то, что он объявлена с типом интерфейся Callback.
        c.callback(42); // Переменной c доступны все методы интерфейса, но не доступны методы класса, которые не объявлены в интерфейсе.
        // c.nonIfaceMeth() - Ошибка, т.к. nonIfaceMeth - это метод класса, не объявленный в интерфейсе
        AnotherClient ob = new AnotherClient();
        c = ob; // теперь переменная c ссылается на объект типа AnotherClient
        c.callback(42); // Вызовется реализация метода callback в классе AnotherClient. Полиморфная возможность ссылки на интерфейс.

        A.NestedIF nif = new B(); // использовать ссылку на вложенный интерфейс
        if (nif.isNotNegative(10)) System.out.println("Число 10 неотрицательное");
        if (nif.isNotNegative(-12)) System.out.println("Это не будет выведено");

        System.out.println("Реализация нескольких видов стеков с использованием одного интерфейся");
        FixedStack mystack1 = new FixedStack(5);
        FixedStack mystack2 = new FixedStack(8);
        for (int i = 0; i < 5; i++) mystack1.push(i);
        for (int i = 0; i < 8; i++) mystack2.push(i);

        System.out.println("Стек в mystack3:");
        for (int i = 0; i < 5; i++) System.out.println(mystack1.pop());

        System.out.println("Стек в mystack4:");
        for (int i = 0; i < 8; i++) System.out.println(mystack2.pop());

        DynStack mystack3 = new DynStack(12);
        DynStack mystack4 = new DynStack(20);
        for (int i = 0; i < 12; i++) mystack3.push(i);
        for (int i = 0; i < 20; i++) mystack4.push(i);

        System.out.println("Стек в mystack3:");
        for (int i = 0; i < 12; i++) System.out.println(mystack3.pop());

        System.out.println("Стек в mystack4:");
        for (int i = 0; i < 20; i++) System.out.println(mystack4.pop());

        IntStack mystack;
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);

        mystack = ds;
        for (int i = 0; i < 12; i++) mystack.push(i);

        mystack = fs;
        for (int i = 0; i < 8; i++) mystack.push(i);

        mystack = ds;
        System.out.println("Значения в динамическом стеке");
        for (int i = 0; i < 12; i++) System.out.println(mystack.pop());

        mystack = fs;
        System.out.println("Значения в фиксированном стеке: ");
        for (int i = 0; i < 8; i++) System.out.println(mystack.pop());

        Question q = new Question();
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());

        System.out.println("Наследование интерфейсов");
        MyClass ob3 = new MyClass();
        ob3.meth1();
        ob3.meth2();
        ob3.meth3();
    }
}


interface Callback { // Интерфейс Callback. В интерфейсах содержатся методы и переменные. Раньше методы нельзя было реализовывать, их реализация предоставлялась классам,
    // имплементирующим этот интерфейс. Но теперь методы можно реализовывать. Но пока мы этого делать не будем.
    // В классах, имплементирующих интерфейс, должны быть реализованы все методы интерфейса. При этом у них обязательно должен быть модификатор public
    void callback(int param);
}

class Client implements Callback {
    public void callback(int p) { // метод интерфейса. Обязательно public
        System.out.println("Метод callback(), вызываемый со значением " + p);
    }

    void nonIfaceMeth() {
        System.out.println("В классах, реализующих интерфейсы, могут определяться и другие члены.");
    }
}

class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("Еще один вариант метода callback()");
        System.out.println("p в квадрате равно " + (p * p));
    }
}

class A {
    public interface NestedIF {
        boolean isNotNegative(int x);
    }
}

class B implements A.NestedIF { // Класс B реализует вложенный в класс A интерфейс NestedIF
    public boolean isNotNegative(int x) {
        return x >= 0;
    }
}

interface IntStack { // интерфейс для реализаций стека
    void push(int item);

    int pop(); // метод pop

    default void clear() {
        System.out.println("Метод clear() не реализован.");
    }

    default int[] popNElements(int n) { // Метод с реализацией по умолчанию, возвращающий массиз из n элементов, начиная с вершины стека
        return getElements(n);
    }

    default int[] skipAndPopNElements(int skip, int n) { // Метод с реализацией по умолчанию, возвращающий из стека массив из n элементов, следующих после указанного количество пропускаемых элементов
        getElements(skip); // Пропустить указанное количество элементов в стеке
        return  getElements(n);
    }

    private int[] getElements(int n) { // Закрытый метод, возвращающий массив из n элементов, начиная с вершины стека.
        // Он недоступен не из наследуемых интерфейсов, не из классов, реализующих текущий интерфейс. Он доступен только из методов в самом этом интерфейсе
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) elements[i] = pop(); // Тут метод pop() - это вариант реализации данного метода в классе, реализующем данный интерфейс.
        // Т.е. методы skipAndPopNElements и popNElements можно использовать в любом классе, реализующем данный интерфейс.
        return elements;
    }

}

class FixedStack implements IntStack { // Реализация интерфейса intStack для стека фиксированной длины
    private int stck[];
    private int tos;

    FixedStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if (tos == stck.length - 1) System.out.println("Стек заполнен "); // использовать поле длины стека
        else stck[++tos] = item;
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен.");
            return 0;
        } else return stck[tos--];
    }
}

class DynStack implements IntStack {
    private int stck[];
    private int tos;

    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        //Если стек заполнен, выделить память под стек большего размера
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) temp[i] = stck[i];
            stck = temp;
        }
        stck[++tos] = item;
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен.");
            return 0;
        } else return stck[tos--];
    }

}

interface SharedConstants {
    int NO = 0;
    int YES = 1;
    int MAYBE = 2;
    int LATER = 3;
    int SOON = 4;
    int NEVER = 5;
}

class Question implements SharedConstants {
    private Random rand = new Random(); // класс Random из стандартной библиотеки Java. Импортирован в начале файла.

    int ask() {
        int prob = (int) (100 * rand.nextDouble()); // nextDouble() возвращает случайное значение от 0.0 до 1.0
        if (prob < 30) return NO; // В классах, реализующих какой-то интерфейс, доступны все переменные этого интерфейса
        else if (prob < 60) return YES;
        else if (prob < 75) return LATER;
        else if (prob < 98) return SOON;
        else return NEVER;
    }
}

class AskMe implements SharedConstants {
    static void answer(int result) {
        switch (result) {
            case NO:  // В классах, реализующих какой-то интерфейс, доступны все переменные этого интерфейса
                System.out.println("Нет");
                break;
            case YES:
                System.out.println("Да");
                break;
            case MAYBE:
                System.out.println("Возможно");
                break;
            case LATER:
                System.out.println("Позднее");
                break;
            case SOON:
                System.out.println("Вскоре");
                break;
            case NEVER:
                System.out.println("Никогда");
                break;
        }
    }
}

interface A1 {
    void meth1();

    void meth2();
}

interface B1 extends A1 { // Теперь интерфейс B1 включает в себя методы meth1() и meth2(), и добавляет метод meth3()
    void meth3();
}

class MyClass implements B1 { // Этот класс должен реализовать все методы из интерфейсов A1 и B1, т.к. B1 наследуется от A1
    public void meth1() {
        System.out.println("Реализация метода meth1().");
    }

    public void meth2() {
        System.out.println("Реализация метода meth2()");
    }

    public void meth3() {
        System.out.println("Реализация метода meth3()");
    }
}

interface MyIF { // ВАЖНО!!! ИМЯ ПУБЛИЧНОГО ИНТЕРФЕЙСА ДОЛЖНО СОВПАДАТЬ С ИМЕНЕМ ФАЙЛА.

}