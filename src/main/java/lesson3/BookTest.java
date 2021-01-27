package lesson3;

public class BookTest {

    static void addContacts() {
        PhoneBook phoneBook = PhoneBook.getInstance();
        phoneBook.addContact("Ivan", "892212411");
        phoneBook.addContact("Ivan", "892212412");
        phoneBook.addContact("Ivan", "892212413");
        phoneBook.addContact("Petr", "5555555");
    }

    static void printContacts() {
        PhoneBook phoneBook = PhoneBook.getInstance();
        System.out.println(phoneBook.getContacts("Ivan"));
        System.out.println(phoneBook.getContacts("Petr"));
    }

    public static void main(String[] args) {
        addContacts();
        printContacts();
    }
}
