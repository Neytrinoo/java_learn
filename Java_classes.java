package com.company;

public class Java_classes {

    public static void main(String[] args) {
        double vol;
        Box mybox; // добавляем ссылку на объект. Просто ссылка на область памяти, которая зарезервирована для этого объекта
        mybox = new Box(1, 2, 2); // выделяем память для объекта Box
        mybox.width = 10; // присвоение значений переменным экземпляра аналогично Python. Через точку
        mybox.height = 20;
        mybox.depth = 15;
        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Объем равен " + vol);


        Box b1 = new Box(10, 20, 30);
        Box b2 = b1; // b1 и b2 ссылаются на один и тот же объект класса Box. Поэтому при изменении одного изменится и другой
        b1.width = 10;
        System.out.println(b2.width); // 10.0

        mybox.volume();
        double box_volume = mybox.return_volume();
        System.out.println(box_volume);

        Box mybox3 = new Box(3, 6, 9);
        mybox3.setDim(3, 6, 9);
        System.out.println(mybox3.return_volume());

        Box mybox4 = new Box(1, 4, 8); //Объявление класса и передача в его конструктор Box() значений. Если в классе нет явно объявленного конструктора,
        // Java по умолчанию создает ему пустой конструктор
        System.out.println("Объем новой коробочки равен " + mybox4.return_volume());


        System.out.println("Класс Stack");
        Stack mystack1 = new Stack();
        Stack mystack2 = new Stack();
        for (int i=0; i < 10; i++) mystack1.push(i);
        for (int i=10; i < 20; i++) mystack2.push(i);
        System.out.println("Содержимое стека mystack1:");
        for (int i = 0; i < 10; i++)
            System.out.println(mystack1.pop());

        System.out.println("Содержимое стека mystack2:");
        for (int i = 0; i < 10; i++)
            System.out.println(mystack2.pop());
    }


}

class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) { // Конструктор класса Box. Его имя должно совпадать с именем класса. Замена методу setDim()
        this.width = w; // Здесь можно пользоваться ключевым словом this(аналог self в Python), но это избыточно.
        height = h;
        depth = d;
    }

    void volume() {
        System.out.println("Объем равен " + width * height * depth); // тут перед переменными объекта не нужно указывать никаких ключевых слов, как, например, self в Python
    }

    double return_volume() { // метод возвращает double, поэтому мы пишем перед именем double. Если же метод ничего не возвращает, пишем void, как в случае с методом volume()
        return width * height * depth;
    }

    void setDim(double width, double height, double depth) { // метод с передаваемыми аргументами параметрам. width,height,depth - параметры, а переданные им значения - аргументы
        this.width = width; // Тут уже не получиться обойтись без ключевого слова this, т.к. названия параметров совпадают с названиями переменных класса. this.width - ссылается на переменную класса
        // для каждого конкретного экземпляра
        this.height = height;
        this.depth = depth;
    }
}

class Stack { // реализация стека. Пример стека: стопка тарелок
    int stck[] = new int[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos == 9)
            System.out.println("Стек заполнен.");
        else
            stck[++tos] = item;
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}