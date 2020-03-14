import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] question = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing",
                                "elit", "nam", "et", "est", "sit", "amet", "diam", "luctus", "pulvinar",
                                "id", "dolor", "nisi", "phasellus", "non", "nulla", "aliquet", "ipsum",
                                 "sit", "amet","phasellus", "non","aliquet", "elit","pulvinar", "elit"};
        //Если использовать LinkedHashMap, список слов бует упорядочен как в исходном массиве, но в ТЗ - HashMap
        HashMap<String, Integer> listOfWords = new HashMap<>();

        System.out.println("В тексте найдено " + question.length + " слов.");

        for (String s : question) {                         //Для каждого слова из исходного массива
            if (listOfWords.containsKey(s)) {               //Проверим есть ли такое слово в нашем списке
                listOfWords.put(s, listOfWords.get(s) + 1); //Если есть - увеличим счетчик совпадений
            } else {
                listOfWords.put(s, 1);                      //Или просто запишем его в список как первый раз встреченное
            }
        }

        //Вывод инфы об общем к-ве слов и списке слов
        System.out.println("Текст состоит из " + listOfWords.size() + " повторяющихся слов.");
        System.out.println("Список слов:\n" + listOfWords.keySet());

        //Сколько раз встречается каждое слово
        for (Map.Entry<String, Integer> entry : listOfWords.entrySet()){
            System.out.println("Слово \"" + entry.getKey() + "\" встретилось " + entry.getValue() + " раз.");
        }
    }
}
