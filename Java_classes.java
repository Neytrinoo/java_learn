package com.company;

public class Java_classes {
    static int a = 3;
    static int b; // статические переменные a и b

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static { // Этот блок выполняется сразу при старте программы. Называется статическим блоком
        System.out.println("Статический блок инициализирован.");
        b = a * 4;
    }

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
        for (int i = 0; i < 10; i++) mystack1.push(i);
        for (int i = 10; i < 20; i++) mystack2.push(i);
        System.out.println("Содержимое стека mystack1:");
        for (int i = 0; i < 10; i++)
            System.out.println(mystack1.pop());

        System.out.println("Содержимое стека mystack2:");
        for (int i = 0; i < 10; i++)
            System.out.println(mystack2.pop());


        System.out.println("Перегрузка методов");
        Overload ob = new Overload();
        double result;
        ob.test();
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.25);
        System.out.println("Результат вызовва ob.test(123.55) " + result);

        System.out.println("Перегрузка конструктора");
        mybox = new Box();
        mybox3 = new Box(10, 20, 15);
        mybox4 = new Box(7); // вызовется конструктор для double, т.к. для одного int типа у нас конструктора нет, а Java может преобразовать int в double.


        System.out.println("Применение побхектов в качестве параметров");
        Test ob1 = new Test(100, 22);
        Test ob2 = new Test(100, 22);
        Test ob3 = new Test(-1, 5);
        System.out.println("ob1 == ob2: " + ob1.equalTo(ob2));
        System.out.println("ob1 == ob3: " + ob1.equalTo(ob3));
        Box mybox5 = new Box(mybox3);
        System.out.println(mybox5.return_volume());
        System.out.println("Значения ob2.a и ob2.b до вызова метода meth: " + ob2.a + " " + ob2.b);
        ob1.meth(ob2);
        System.out.println("Значения ob2.a и ob2.b после вызова метода meth: " + ob2.a + " " + ob2.b);
        ob2 = ob1.incrByTen();
        System.out.println(ob2.a + " " + ob2.b);
        ob2 = ob2.incrByTen();
        System.out.println(ob2.a + " " + ob2.b);

        System.out.println("Рекурсия");
        Factorial fact1 = new Factorial();
        System.out.println("Факториал 10 равен " + fact1.fact(10));

        // ob1.c = 0 - ОШИБКА. Т.к. c - приватный член класса
        ob1.setC(0); // - Вот так верно
        System.out.println(ob1.getC());

        meth(42); // Мы можем вызвать static метод без объявления объекта, т.к. на то он и static йопта
        StaticDemo.callme(); // Обращение к статическому методу другого класса делается также без объявления нового экземпляра класса
        System.out.println("b = " + StaticDemo.b); // К статической переменной также можно обращаться через имя_класса.имя_переменной

        Length array1 = new Length();
        array1.print_length();

        System.out.println("Вложенные классы");
        Outer outer = new Outer();
        outer.test();


        System.out.println("Подробнее про класс String");
        String strOb1 = "Первая строка";
        String strOb2 = "Вторая строка";
        String strOb3 = strOb1;
        System.out.println("Длина строки strOb1: " + strOb1.length());
        System.out.println("Символ по индексу 3 в строке strOb1: " + strOb1.charAt(3));
        if (strOb1.equals(strOb2))
            System.out.println("strOb1 == strOb2");
        else System.out.println("strOb1 != strOb2");
        if (strOb1.equals(strOb3))
            System.out.println("strOb1 == strOb3");
        else System.out.println("strOb1 != strOb3");

        String str[] = {"один", "два", "три"};
        for(String i: str) System.out.println(i);

        System.out.println("Переменное количество аргументов");
        VarArgs.vaTest(12,23,445,12);
        VarArgs.vaTest(12);
        // VarArgs.vaTest(); - возникнет неоднозначность, т.к. мы перегрузили метод переменной длины. И пустой массив может быть преобразован к любому из перегружаемых типов


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

    Box() { // Перегружаем конструктор. Вызовется, если при объявлении нового объекта в конструктор не передадут параметры
        width = -1;
        height = -1;
        depth = -1;
    }

    Box(Box ob) { // Конструктор, который в качестве параметра принимает другой объект класса Box
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double len) {
        width = height = depth = len;
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

class VarArgs {
    static void vaTest(int ... v) { // Тут v - это неявный массив. v действительно является массивом, но благодаря такому синтаксису ... при вызове метода мы передаем в него не массив,
        // а последовательность аргументов. Наряду с параметром переменной длины в методе могут быть и обычные параметры. Только параметр переменной длины всегда должен указываться в конце.
        // Также в методе должен быть только один параметр переменной длины. Двух не допускается
        System.out.println("Количество аргументов: " + v.length + " Содержимое: ");
        for (int x: v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(boolean ... v) { // Методы с параметрами переменной длины также можно перегружать
        System.out.println("Количество аргументов: " + v.length + " Содержимое: ");
        for (boolean x: v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(double ... v) {
        System.out.println("Количество аргументов: " + v.length + " Содержимое: ");
        for (double x: v)
            System.out.print(x + " ");
        System.out.println();
    }
}

class Length {
    int a1[] = new int[10];
    int a2[] = {3, 5, 7, 1, 8, 99, 44, -10};
    int a3[] = {4, 3, 2, 1};

    void print_length() {
        System.out.println("Длина a1 = " + a1.length); // У массивов есть длина. Вызывается через статическую переменную length. Т.к. массивы - это объекты, то и доступ к переменным через точку
        System.out.println("Длина a2 = " + a2.length);
        System.out.println("Длина a3 = " + a3.length);
    }
}

class StaticDemo {
    static int a = 3; // Статик может быть и private. Тогда оно не будет доступно за пределами класса
    static int b; // статические переменные a и b

    static void callme() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static { // Этот блок выполняется сразу при старте программы. Называется статическим блоком
        System.out.println("Статический блок инициализирован.");
        b = a * 4;
    }
}

class Outer {
    int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    class Inner { // Вложенный класс класса Outer. Является членом класса Outer.
        void display() {
            System.out.println("вывод: outer_x = " + outer_x); // Имеет доступ ко всем переменным класса Outer. Но класс Outer не имеет доступа к переменным класса Inner напрямую,
            // без объявления класса
        }
    }
}

class Test {
    int a;
    public int b;
    private int c; // Приватный член класса Test. Доступен только в теле класса


    void setC(int i) { // Задание значения приватному члену c данного класса
        c = i;
    }

    int getC() { // Получение значения c
        return c;
    }

    Test(int i, int j) { // Тут i и j - это совершенно новые значения. Их изменение в теле метода не оказывает влияние на внешние переменные, которые мы сюда передаем.
        a = i;
        b = j;
    }

    boolean equalTo(Test o) {
        return (o.a == a && o.b == b);
    }

    void meth(Test o) { // В этом методе операции, выполняемые над передаваемым аргументом Test o будут оказывать воздействие и на внешний объект, который мы в этот метод передали.
        // Т.к. здесь Test o - это всего лишь ссылка на объект, который мы сюда передаем
        o.a *= 2;
        o.b /= 2;
    }

    Test incrByTen() { // Метод, который возвращает новый объект класса Test
        Test temp = new Test(a + 10, b);
        return temp;
    }
}

class Overload {
    // Перегрузка методов. Один и тот же метод в классе можно писать несколько раз. При этом должны отличаться количество передаваемых параметров и/или их тип.
    void test() {
        System.out.println("Параметров нема");
    }

    void test(int a) {
        System.out.println("a: " + a);
    }

    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    double test(double a) {
        System.out.println("double a: " + a);
        return a * a;
    }
}

class Factorial {
    int fact(int n) {
        int result;
        if (n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}