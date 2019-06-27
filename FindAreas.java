package com.company;

public class FindAreas {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(3, 4, 5);
        Figure figref;
        figref = r;
        System.out.println("Площадь равна " + figref.area());
        figref = t;
        System.out.println("Площадь равна " + figref.area());

        B1 b = new B1();
        b.callme();
        b.callmeto();
    }
}

abstract class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) { // В абстрактном классе может быть конструктор. Для того, чтобы подклассы могли его вызвать через super()
        dim1 = a;
        dim2 = b;
    }

    abstract double area();
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    double area() {
        System.out.println("В области четырехугольника");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    double dim3;

    Triangle(double a, double b, double c) {
        super(a, b);
        dim3 = c;
    }

    double area() {
        double p = (dim1 + dim2 + dim3) / 2;
        System.out.println("В области треугольника");
        return p * Math.sqrt((p - dim1) * (p - dim2) * (p - dim3));
    }
}


abstract class A1 { // Абстрактный класс нельзя создать, используя оператор new. С его методами можно взаимодействовать только через его подклассы
    abstract void callme(); // Абстрактные методы ничего не содержат. Но они обязательны для переопределения в подклассах.

    void callmeto() {
        System.out.println("Это конкретный метод.");
    }
}

class B1 extends A1 {
    void callme() {
        System.out.println("Реализация метода callme() в классе B.");
    }
}