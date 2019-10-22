package ru.sbt.javaschool;

import java.util.*;

public class CollectionTask {
    /**
     * Строка, состоящая из всех строк файла. Строки
     * разделяются пробелом.
     */
    private static String text;
    /**
     * Построчное представление текстового файла
     */
    private static ArrayList<String> fileString;

    /**
     * Выполняет подсчет количества различных слов.
     * @return количество различный слов
     */
    public static int example1() {
        HashSet<String> exp = new HashSet<>(Arrays.asList(text.split(" ")));
        return exp.size();
    }

    /**
     * Выполняет сортировку различных слов сначала по длине
     * слова, потом по тексту.
     * @return строка, содержащая отсортированные слова
     */
    public static String example2() {
        Comparator<String> comparator = (s1,s2) -> Integer.compare(s1.length(),s2.length());
        TreeSet<String> exp = new TreeSet<>(comparator.thenComparing(Comparator.naturalOrder()));
        exp.addAll(Arrays.asList(text.split(" ")));
        return exp.toString();
    }

    /**
     * Выполняет подсчет количества вхождений всех слов в файле.
     * @return строка в виде "слово"="количество вхождений"
     */
    public static String example3() {
        HashMap<String, Integer> exp = new HashMap<>();
        for (String s : text.split(" ")) {
            if (exp.containsKey(s)) {
                int value = exp.get(s);
                exp.put(s,++value);
            }
            else {
                exp.put(s, 1);
            }
        }
        return exp.toString();
    }

    /**
     * Выводит строки файла в обратном порядке.
     * @return строки файла в обратном порядке
     */
    public static String example4() {
        ArrayList<String> reverseFileString = new ArrayList<>(fileString);
        Collections.reverse(reverseFileString);
        return reverseFileString.toString();
    }

    public static void main(String[] args) {
        String filename = "test.txt";
        fileString = ReadTextFile.readAllFileString(filename);
        text = String.join(" ", fileString);
        System.out.println("----------------1----------------");
        System.out.println("Число уникальных слов = " + example1());
        System.out.println("----------------2----------------");
        System.out.println(example2());
        System.out.println("----------------3----------------");
        System.out.println(example3());
        System.out.println("----------------4----------------");
        System.out.println(example4());
        System.out.println("----------------5----------------");
        ReverseIterator<String> ri = new ReverseIterator<>(fileString);
        while (ri.hasNext()) System.out.println(ri.next());
        System.out.println("----------------6----------------");
        System.out.println("Введите номер строки (\'-1\' - конец ввода):");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while ((number = scanner.nextInt()) != -1) {
            try {
                System.out.println(fileString.get(number));
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Строки с таким номером нет!");
            }
        }
        System.out.println("---------------------------------");
    }
}
