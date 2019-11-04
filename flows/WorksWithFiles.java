package com.company.flows;

import java.io.*;

public class WorksWithFiles {
    public static void main(String[] args) throws IOException{
        int i;
        FileInputStream fin;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String filename = br.readLine();
        try {
            fin = new FileInputStream("G:\\learn java\\src\\com\\company\\flows\\text1.txt"); // открываем файл на чтение, args[0] - аргумент из командной строки, содержащий имя файла
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            System.out.println(e);
            return;
        }

        try {
            do{
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            } while(i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }

        try {
            fin.close();
        }catch (IOException e) {
            System.out.println("Ошибка закрытия файла");
        }
    }
}
