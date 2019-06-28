package com.company.p2;

class Protection2 extends com.company.p1.Protection{
    Protection2() {
        System.out.println("конструктор, унаследованный из другого пакета");
        // System.out.println("n = " + n); - доступно только для класса Protection или для классов его пакета, т.к. n - доступ по умолчанию\
        // System.out.println("n_pri = " + n_pri); - Доступно только для класса Protection
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);

    }
}
