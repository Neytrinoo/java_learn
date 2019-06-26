package com.company;

public class Java_classes {
    public static void main(String[] args) {
        double vol;
        Box mybox; // добавляем ссылку на объект. Просто ссылка на область памяти, которая зарезервирована для этого объекта
        mybox = new Box(); // выделяем память для объекта Box
        mybox.width = 10; // присвоение значений переменным экземпляра аналогично Python. Через точку
        mybox.height = 20;
        mybox.depth = 15;
        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Объем равен " + vol);

        Box b1 = new Box();
        Box b2 = b1; // b1 и b2 ссылаются на один и тот же объект класса Box. Поэтому при изменении одного изменится и другой
        b1.width = 10;
        System.out.println(b2.width); // 10.0
    }
}

class Box {
    double width;
    double height;
    double depth;
}