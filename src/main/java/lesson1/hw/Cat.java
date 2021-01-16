package lesson1.hw;

public class Cat implements Activity {

    private final String name;
    private static int counter = 0;

    public Cat() {
        counter++;
        name = "lesson1.Cat#" + counter;
    }

    @Override
    public void jump(int height) {
        System.out.println(name + " jump to " + height + " meters");

    }

    @Override
    public int getJumpLimit() {
        return 100;
    }

    @Override
    public void run(int distance) {
        System.out.println(name + " run " + distance + " meters");
    }

    @Override
    public int getRunLimit() {
        return 100;
    }

    @Override
    public String getName() {
        return name;
    }
}
