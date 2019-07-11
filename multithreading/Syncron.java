package com.company.multithreading;

public class Syncron {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизированный");
        Caller ob3 = new Caller(target, "мир!");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        Callme2 target2 = new Callme2();
        Caller2 ob12 = new Caller2(target2, "Добро пожаловать");
        Caller2 ob22 = new Caller2(target2, "в синхронизированный");
        Caller2 ob32 = new Caller2(target2, "мир!");
        try {
            ob12.t.join();
            ob22.t.join();
            ob32.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}

class Callme {
    synchronized void call(String msg) { // Мы упорядочили доступ к методу call с помощью ключевого слова synchronized. Теперь этот метод в конкретный момент времени может
        // быть вызван только одним потоком
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Callme2 {
    synchronized void call(String msg) { // Мы упорядочили доступ к методу call с помощью ключевого слова synchronized. Теперь этот метод в конкретный момент времени может
        // быть вызван только одним потоком
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}

class Caller2 implements Runnable {
    String msg;
    Callme2 target;
    Thread t;

    public Caller2(Callme2 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target) { // Если мы не может прописать synchronized к методу класса Callme2, но нам нужно убедиться, что монитор принадлежит текущему экземпляру,
            // мы просто заключаем вызов метода в блок synchronized, а в скобках указываем объект, для которого нам нужно убедиться, что монитор его
            target.call(msg);
        }
    }
}