package com.company.flows;

public class InstanseOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        if (a instanceof A) System.out.println("a является экземпляром A");
        if (b instanceof B) System.out.println("b является экземпляром B");
        if (c instanceof C) System.out.println("c является экземпляром C");
        if (c instanceof A) System.out.println("c можно привести к типу A");
        if (a instanceof C) System.out.println("a можно привести к типу C");
        System.out.println();

        A ob;
        ob = d; // ссылка на объект d
        System.out.println("ob теперь ссылается на d");
        if (ob instanceof D) System.out.println("b является экземпляром D");

        System.out.println();

        ob = c;
        System.out.println("ob теперь ссылается на c");

        if (ob instanceof D) System.out.println("ob ожно привести к типу D");
        else System.out.println("ob нельзя привести к типу D");
        if (ob instanceof A) System.out.println("ob ожно привести к типу A");

        System.out.println();

        // все объекты можно привести к типу Object
        if(a instanceof Object) System.out.println("a можно привести к типу Object");
    }
}

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}