package lesson1.hw;

public class Test {

    public static void main(String[] args) {

        Activity[] persons = {
                new Person(40, 30),
                new Person(50, 50),
                new Person(100, 100),
                new Cat(),
                new Cat()
        };

        Jumper cat = new Cat();
        Runner cat1 = new Cat();

        for (Activity person : persons) {
            person.take(new Wall(), new Road(), new Wall(), new Wall());
        }
    }
}
