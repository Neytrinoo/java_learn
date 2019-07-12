package com.company.enumerations;

public class ClassesSimpleTypes {
    public static void main(String[] args) {
        Character a = Character.valueOf('ы'); // Получение примитивного типа char как объекта с помощью класса Character.
        // Можно также использовать конструктор класса Character, но он не рекомендован к употреблению. начиная с JDK 9
        System.out.println(a);
        Integer iOb = new Integer(100);
        int i = iOb.intValue();
        System.out.println(i + " " + iOb);
        Integer iOb2 = 100; // Автоупаковка значения типа int в экземпляр класса Integer. Примитивный тип инкапсулируется(автоупаковывается) в экземпляр класса Integer.
        int b = iOb2; // распаковка объекта iOb2 в переменную примитивного типа int.

        Boolean bol = true; // автоупаковка/распаковка логического значения типа boolean
        if (bol) System.out.println("bol равно true"); // Обхект bol автоматически распаковывается, когда он употребляется в условном операторе if

        Character ch = 'x'; // Упаковать объект типа char
        char ch2 = ch; // Распаковка значения типа char
        System.out.println("ch2 равно " + ch2);
    }
}
