package com.company;

public class Inheritance {
    public static void main(String[] args) {
        A supOb = new A();
        B subOb = new B(5, 10);
        supOb.i = 10;
        supOb.j = 20;
        supOb.showij();
        subOb.i = 7; // Подкласс имеет доступ ко всем открытым членам своего суперкласса. Как и в Python
        subOb.j = 8;
        subOb.k = 9;
        subOb.showij();
        subOb.showk();
        subOb.show();
        supOb.show_param();
        subOb.show_param();
        subOb.with_param("Это k: "); // вызвать метод with_param() из класса B
        subOb.with_param(); // вызвать метод with_param() из класса A

        System.out.println("Динамическая диспетчеризация методов");
        A a = new A();
        B b = new B(10, 20);
        C c = new C();
        A r;
        r = a;
        r.callme();
        r = b;
        r.callme();
        r = c;
        r.callme();
    }

}

class A { // суперкласс
    int i, j;
    private int g; // подклассы не имеют доступа к этой переменной, т.к. она приватна

    void show_param() {
        System.out.println("i and j: " + i + " " + j);
    }

    void callme() {
        System.out.println("В методе callme() из класса A");
    }

    final void notremove() { // ключевое слово final запрещает переопределение метода
        System.out.println("Этот метод нельзя переопределить.");
    }

    void showij() {
        System.out.println("i and j: " + i + " " + j);
    }

    void with_param() {
        System.out.println("Метод суперкласса");
    }
}

final class Final { // с помощью ключевого слова final мы запрещаем наследование класса
    void call() {
        System.out.println("Этот класс нельзя наследовать");
    }
}

class B extends A { // создать подкласс путем расширения класса A
    int i, k; // этот член i скрывает член i из суперкласса A

    B(int a, int b) {
        super.i = a; // член i из класса A
        i = b; /// член i из класса B
    }

    void callme() {
        System.out.println("В методе callme() из класса B");
    }

    void show() {
        System.out.println("Член i в суперклассе: " + super.i);
        System.out.println("Член i в подклассе: " + i);
    }

    void show_param() { // вывести содержимое переменной k с помощью метода, переопределяющего метод show_param() из класса A
        super.show_param(); // здесь вызывается метод show_param() из суперкласса A
        System.out.println("k: " + k);
    }

    void with_param(String msg) {
        System.out.println(msg + k);
    }

    void showk() {
        System.out.println("k: " + k);
    }

    void sum() {
        System.out.println("i+j+k: " + (i + j + k)); // Дочерний класс имеет доступ ко всем не приватным переменным своего родительского класса
    }
}

class C extends A {
    C() {
        super();
    }
    void callme() {
        System.out.println("В методе callme() из класса C");
    }
}