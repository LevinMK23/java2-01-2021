package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private static PhoneBook instance;

    private final Map<String, Set<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    public Set<String> getContacts(String name) {
        return book.get(name);
    }

    public void addContact(String name, String number) {
        validate(number);
        if (!book.containsKey(name)) {
            book.put(name, new HashSet<>());
        }
        book.get(name).add(number);
    }

    private void validate(String number) {
        // 89112778833
        // +7(911)333-44-55 [\+7|8]\([0-9]{3,5}\)[0-9]{2,3}-[0-9]{2,3}-[0-9]{2,3}
        if (!number.matches("[0-9]{7,15}")) {
            throw new IllegalArgumentException(number + " not a telephone number");
        }
    }
}
