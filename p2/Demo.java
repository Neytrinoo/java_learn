package com.company.p2;

public class Demo {
    public static void main(String[] args) {
        Protection2 ob1 = new Protection2();
        OtherPackage ob2 = new OtherPackage();

        MyIFmp obj = new MyIFmp();
        System.out.println(obj.getNumber());
        System.out.println(obj.getString()); // Из объекта можно вызвать метод его интерфейса, реализованного по умолчанию
    }
}
