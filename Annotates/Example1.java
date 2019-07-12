package com.company.Annotates;

import java.lang.annotation.*;
import java.lang.reflect.*;

@MyMarker
@MyAnno(str = "Пример аннотации класса", val = 47) // Аннотирование метода
@What(description = "Аннотация тестового класса")
public class Example1 {
    public static void main(String[] args) {
        myMeth("as", 14);
    }

    @MySingle(100)
    @MyAnno(str = "Пример аннотации", val = 100) // Аннотирование метода
    @What(description = "Аннотация тестового метода")
    @RepeatAnno()
    @RepeatAnno(str = "Объявил аннотацию второй раз", val = 1000)
    public static void myMeth(String str, int i) {
        Example1 ob = new Example1();
        try {
            Class<?> c = ob.getClass(); // Получаем объект типа Class, представляющий данный класс
            Method m = c.getMethod("myMeth", String.class, int.class); // Получаем объект типа Method, представляющий данный метод. Также, если у метода есть параметры, указываем их типы
            MyAnno anno = c.getAnnotation(MyAnno.class); // Получаем аннотацию для метода данного класса
            System.out.println(anno.str() + " " + anno.val()); // Выводим значения членов аннотации
            Annotation annos[] = ob.getClass().getAnnotations(); // Получаем массив анотаций для текущего класса Example1
            for (Annotation a : annos)
                System.out.println(a);
            System.out.println();
            System.out.println(ob.getClass().isAnnotationPresent(MyMarker.class) ? "Маркерная аннотация присутствует" : "Маркерной аннотации нет");
            Method m2 = ob.getClass().getMethod("myMeth", String.class, int.class);
            annos = m2.getAnnotations();
            System.out.println("Все аннотации для метода myMeth():");
            for (Annotation a : annos) {
                System.out.println(a);
            }

            Annotation[] repeatannos = m2.getAnnotationsByType(RepeatAnno.class);
            System.out.println("Количество повторяющихся аннотаций RepeatAnno:" + "\n" + repeatannos.length);
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
        // Задается правило удержания аннотации RUNTIME
@interface MyAnno { // Объявление аннотации
    String str(); // str() и val() объявлены как методы, но фактически являются полями

    String about() default "А я знаю?"; // С помощью слова default мы можем установить значение поля аннотации по умолчанию,

    // и оно примет это значение, если не будет переопределено при вызове анотации для метода или класса
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {
} // Маркерная аннотация. Не имеет тела, служит только для пометки методов или классов

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value(); // одночленная аннотация. Если в аннотации один член и он назван value(), то при анотировании этой аннотацией можно не указывать имя этого члена, а прсото писать его значение
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ArrRepeatAnnos.class)
@interface RepeatAnno { // Повторяющаяся аннотация. Ее можно использовать несколько раз для одного и того же аннотируемого объекта или метода...
    String str() default "Повторяющаяся аннотация";

    int val() default 400;
}

@Retention(RetentionPolicy.RUNTIME)
        // Это контейнерная аннотация. Предназначена, чтобы анотировать повторяющуюся аннотацию
@interface ArrRepeatAnnos {
    RepeatAnno[] value(); // В данном случае служит аннотатором для аннотации RepeatAnno
}