package com.company.multithreading;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("Один");
        NewThread3 ob2 = new NewThread3("Два");
        NewThread4 ob3 = NewThread4.createAndStart(); // Вызываем фабричный метод. Он возвращает нам объект класса NewThread4. Аналогично созданию экземляра NewThread3 выше
        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            Thread.sleep(1000);
            ob2.mysuspend();
            System.out.println("Приостановка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }

        try {
            System.out.println("ОЖидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}

class NewThread3 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread3(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        suspendFlag = false;
        t.start();
    }

    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait(); // Реализация функции приостановки выполнения процесса. Данный способ гарантирует синхронизацию всех данных между потоками
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван.");
        }
        System.out.println(name + " завершен.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}


class NewThread4 implements Runnable {
    Thread t;

    NewThread4(String name) {
        t = new Thread(this, name); // Создать новый, второй поток исполнения
        System.out.println("Дочерний поток исполнения создан: " + t);
        t.start(); // Запустить поток исполнения
    }

    public void run() { // Точка входа во второй поток исполнения
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен");
    }

    public static NewThread4 createAndStart() { // Метод, который возвращает объект своего класса, называется фабричным. Так, при создании не нужно указывать new Name()..., а просто вызвать этот
        // статичный метод.
        NewThread4 myThrd = new NewThread4("Сас");
        myThrd.t.start();
        return myThrd;
    }
}