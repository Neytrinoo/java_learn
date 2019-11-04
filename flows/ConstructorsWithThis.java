package com.company.flows;

public class ConstructorsWithThis {
}

class MyClass {
    int a, b;

    MyClass(int i, int j) {
        a = i;
        b = j;
    }

    MyClass (int i) {
        this(i, i); // вызовется верхний конструктор
    }

    MyClass() {
        this(0); // вызовется конструктор MyClass(0), который вызовет MyClass(0, 0)
    }
}
