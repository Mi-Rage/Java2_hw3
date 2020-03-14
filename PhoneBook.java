import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Телефонная книга
 * Сначала нужно инициализировать, т.е. ввести сколько будет записей и для каждой фамилии
 * ввести неограниченно телефонов или эл. адресов.
 * Затем можно переходить к поиску.
 */
public class PhoneBook {

    //Все данные хранятся здесь. Ключ - фамилия, значение - объект с набором
    //телефонов и эл.адресов
    private Map<String, Person> arrayData = new HashMap<>();

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        book.initBook();  //Заполним нашу книгу

        while (true) {
            System.out.println("Введите:\n1 для поиска телефонов по фамилии\n2 для поиска e-mail по фамилии\n" +
                    "3 для выхода");
            String option = scanner.next();
            switch (option) {
                case "1":
                    try {
                        book.findNumber();
                    } catch (NullPointerException e) {
                        System.out.println("Не найдена фамилия");
                    }
                    break;
                case "2":
                    try {
                        book.findMail();
                    } catch (NullPointerException e) {
                        System.out.println("Не найдена фамилия");
                    }
                    break;
                case "3":
                    return;
            }
        }
    }

    //Заполнение телефнной книги
    public void initBook() {
        Scanner scanner = new Scanner(System.in);
        int count;     //Счетчик записей в книге
        String family;
        String answer;
        System.out.println("Сколько записей в книге сделать?");
        count = scanner.nextInt();

        //Заполняем книгу
        for (int i = 0; i < count; i++) {
            Person person = new Person();           //Каждый раз создаем новый объект, который потом попадет в HashMap
            System.out.println("Введите фамилию");
            family = scanner.next();
            //Набираем сколько хотим телефонов. Выход по "exit"
            while (true) {
                System.out.println("Введите номер телефона или exit");
                answer = scanner.next();
                if (!answer.equals("exit")) {
                    person.setPhoneNumber(answer);  //Добавляем в массив телефонов объекта person новый телефон
                } else {
                    break;
                }
            }
            //Набираем сколько хотим эл. адресов. Выход по "exit"
            while (true) {
                System.out.println("Введите eMail или exit");
                answer = scanner.next();
                if (!answer.equals("exit")) {
                    person.seteMail(answer); //Добавляем в массив телефонов объекта person новый eMail
                } else {
                    break;
                }
            }
            //А здесь добавляем в наш HaspMap запись с ключом из фамилии и с value из массивов
            //телефонов и эл. адресов, принадлежащих текущему объекту
            arrayData.put(family, person);
        }

        //Для удобства запросов выведем всю телефонную книгу
        for (Map.Entry<String, Person> elem : arrayData.entrySet()) {
            System.out.println("Фамилия" + " : " + elem.getKey());
            for (String each : elem.getValue().getPhoneNumber()) {
                System.out.println("Телефон: " + each);
            }
            for (String each : elem.getValue().geteMail()) {
                System.out.println("eMail: " + each);
            }
        }
    }


    //Поиск по фамилии всех эл. адресов
    private void findMail() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поиск e-Mail по фамилии");
        System.out.println("Введите фамилию");
        String family = scanner.nextLine();
        System.out.println("Адреса e-Mail для " + family);
        for (String each : arrayData.get(family).geteMail()) { //Из общей базы получаем объект по ключу фамилии и из
            System.out.println(each);                          //объекта берём массив с эл. адресами, затем
        }                                                      //печатаем каждый
    }

    private void findNumber() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поиск номеров телефона по фамилии");
        System.out.println("Введите фамилию");
        String family = scanner.nextLine();
        System.out.println("Номера телефонов для " + family);
        for (String each : arrayData.get(family).getPhoneNumber()) {    //Из общей базы получаем объект по ключу фамилии и из
            System.out.println(each);                                   //объекта берём массив с телефонами, затем
        }                                                               //печатаем каждый
    }

}
