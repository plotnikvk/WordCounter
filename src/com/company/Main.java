package com.company;



import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {//Пробрасываем исключение, чтобы обработать ошибку чтения
                                                               //из файла
        Scanner scanner = new Scanner(new File("C:\\Users\\plotn\\IdeaProjects\\WordCounter\\src\\com\\company" +
                "\\mama.txt"));//Подключаем к сканеру файл и указываем путь к нему
        Map<String, Integer> statistics = new HashMap<>(); //Создаем поле типа Map<String, Integer>
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);//Записываем в Map слова и количество повторений
        }
        System.out.println("Cтатистика:\n"+statistics+"\n");

       System.out.println("Сортировка в алфавитном порядке:");
        Map<String,Integer>treeStatistics = new TreeMap<>(statistics);//Сортируем в алфавитном порядке по ключу
        for (String sort: treeStatistics.keySet()) {
            System.out.print("\""+sort+"\" ");
        }


        Map.Entry<String, Integer> MaxStringEntrance = null;//Находим максимальное количество повторений слов
        for (Map.Entry<String, Integer> item : statistics.entrySet()) {
            Map.Entry<String, Integer> Temp = item;
         if(MaxStringEntrance ==null){
             MaxStringEntrance = item;
         }
         else if(MaxStringEntrance.getValue().intValue() < Temp.getValue().intValue()){
             MaxStringEntrance = Temp;
         }
        }
        System.out.println("\n\nСлово с максимальным количеством повторений:\t\""+MaxStringEntrance.getKey()+"\"\nЭто слово " +
                "встречается в файле:\t"+MaxStringEntrance.getValue()+" раз");
        scanner.close();//Закрываем поток
    }
}
