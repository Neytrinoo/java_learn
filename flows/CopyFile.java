package com.company.flows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;
        String file1, file2;
        file1 = "G:\\learn java\\src\\com\\company\\flows\\text1.txt";
        file2 = "G:\\learn java\\src\\com\\company\\flows\\text2.txt";

        // try(файлы ввода_вывода) - будут закрыты по завершению блока try, не нужно использовать close()
        try (FileInputStream fin = new FileInputStream(file1);
             FileOutputStream fout = new FileOutputStream(file2)) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

    }
}
