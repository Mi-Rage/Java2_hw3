import java.util.ArrayList;

/**
 * Класс Person для создания телефонной книги *
 * phoneNumber и eMail - это значения для ключа в списке HashMap в PhoneBook
 * Для одной фамиии можно создать неограниченно телефонов и эл. адресов
 * Объекту ничего не надо уметь кроме как иметь эти поля.
 */
public class Person {

    private ArrayList<String> phoneNumber = new ArrayList<>();
    private ArrayList<String> eMail = new ArrayList<>();

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.add(phoneNumber);
    }

    public ArrayList<String> geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail.add(eMail);
    }
}
