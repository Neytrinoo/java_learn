package com.company.p2;

public class OtherPackage {
    OtherPackage() {
        com.company.p1.Protection p = new com.company.p1.Protection();
        System.out.println("конструктор из другого пакета");
        // System.out.println("n = " + p.n); - доступно только дла класса Protection или его пакета
        // System.out.println("n_pri = " + p.n_pri); - доступно только для класса Protection
        // System.out.println("n_pro = " + p.n_pro); - доступно только для класса Protection, его пакета или подкласса из другого пакета. OtherPackage не является подклассом Protection
        System.out.println("n_pub = " + p.n_pub);
        // p.show(); - недоступно, т.к. метод show не публичный, а модификатор доступа по умолчанию
    }
}
