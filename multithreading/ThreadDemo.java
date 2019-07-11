package com.company.multithreading;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // Получаем ссылку на главный(текущий) поток через статический метод класса Thread
        System.out.println("Текущий поток исполнения: " + t);
        t.setName("My Thread"); // Изменили имя текущего потока исполнения
        System.out.println("После изменения имени потока: " + t);
        NewThread ob1 = new NewThread("Поток номер 1"); // Создаем новый поток
        NewThread ob2 = new NewThread("Поток номер 2"); // Создаем новый поток
        NewThread ob3 = new NewThread("Поток номер 3"); // Можно создать много потоков одного и того же класса
        System.out.println("Поток 1 запущен: " + ob1.t.isAlive());
        System.out.println("Поток 2 запущен: " + ob2.t.isAlive());
        System.out.println("Поток 3 запущен: " + ob3.t.isAlive());
        try {
            ob1.t.join(); // Метод join() Ожидает, когда поток перестанет выполнятся. На это время главный поток останавливается
            ob2.t.join();
            ob3.t.join();
            for(int n = 5; n > 0; n--) {
                System.out.println("Главный поток: " + n);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e) { // метод sleep может сгенерировать исключение типа InterruptException, если в каком-нибудь другом потоке исполнения потребуется прервать ожидающий поток.
            // Поэтому нужно обязательно его обработать.
            System.out.println("Главный поток исполнения прерван");
        }
        System.out.println("Поток 1 запущен: " + ob1.t.isAlive());
        System.out.println("Поток 2 запущен: " + ob2.t.isAlive());
        System.out.println("Поток 3 запущен: " + ob3.t.isAlive());
    }
}

//Создать второй поток исполнения
class NewThread implements Runnable {
    Thread t;
    NewThread(String name) {
        t = new Thread(this, name); // Создать новый, второй поток исполнения
        System.out.println("Дочерний поток исполнения создан: " + t);
        t.start(); // Запустить поток исполнения
    }
    public void run() { // Точка входа во второй поток исполнения
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен");
    }
}

class NewThread2 extends Thread { // Третий поток исполнения, расширяющий уже класс Thread. Действия потока аналогичны действиям NewThread, различаются только реализуемые интерфейсы
    NewThread2(String name) {
        // создать новый поток исполнения
        super(name);
        System.out.println("Дочерний поток: " + this);
        start(); // запустить поток на исполнение
    }

    public void run() { // Точка входа в данный поток исполнения
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток2: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток2 прерван.");
        }
        System.out.println("Дочерний поток2 завершен");
    }
}
