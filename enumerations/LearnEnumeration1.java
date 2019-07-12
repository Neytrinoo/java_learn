package com.company.enumerations;

public class LearnEnumeration1 {
    public static void main(String[] args) {
        Apple ap; // Объявляется переменная ap перечислимого типа Apple
        ap = Apple.Winesap;
        System.out.println(ap);
        System.out.println(ap == Apple.RedDel); // Константы перечислимого типа можно сравнивать
        System.out.println(ap == Apple.Winesap);
        switch (ap) { // Значения перечислимого типа можно также использовать в управляющем операторе switch
            case Jonathan:
                System.out.println(Apple.Jonathan);
                break;
            case Winesap:
                System.out.println(Apple.Winesap);
                break;
        }
        System.out.println("Константы перечисляемого типа Apple:");
        for (Apple a : Apple.values()) // метод values() возвращает массив констант перечислимого типа
            System.out.println(a);
        ap = Apple.valueOf("Cortland"); // метод valueOf() получает по строке константу с таким же названием
        System.out.println(ap);
        System.out.println(ap.getPrice());
        System.out.println(ap.ordinal()); // ordinal() возвращает порядковое значение вызывающей константы. Т.е. каким по счету в перечислимом классе оно объявлено
        System.out.println(ap.equals(Apple.Cortland)); // метод equals сравнивает константы
        System.out.println(ap.compareTo(Apple.RedDel)); // возвращает разность порядкового номера ap и порядкового номера Apple.RedDel

    }


}

enum Apple { // Apple здесь - это класс. Но объявить через new его нельзя
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8); // Эти идентификаторы называются константами перечислимого типа
    private int price; // цена яблока каждого сорта

    Apple(int p) { // Конструктор вызывается для каждой константы класа Apple, ведь константы перечислимого типа фактически являются экземплярами класса Apple
        price = p;
    }

    Apple() { // Тут также можно перегружать конструкторы
        price = -1;
    }

    int getPrice() { // вызывается для конкретного экземпляра. Т.к. перечислимый тип - это фактически класс, только без возможности получить его экземпляр с помощью new.
        // А также он не может наследоваться и не может быть суперклассом
        return price;
    }
}
