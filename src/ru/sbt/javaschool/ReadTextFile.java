package ru.sbt.javaschool;

import java.io.*;
import java.util.ArrayList;

public class ReadTextFile {
    /**
     * Чтение текстового файла.
     * @param filename - путь до текстового файла
     * @return Список строк файла
     */
    public static ArrayList<String> readAllFileString(String filename) {
        ArrayList<String> exp = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                exp.add(s.trim());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
        return exp;
    }
}
