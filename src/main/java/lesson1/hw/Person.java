package lesson1.hw;

public class Person implements Activity {

    private final String name;
    private static int counter = 0;
    private final int jumpLimit;
    private final int runLimit;

    public Person(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        counter++;
        name = "Person#" + counter;
    }

    @Override
    public void jump(int height) {
        System.out.println(name + " jump to " + height + " meters");
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void run(int distance) {
        System.out.println(name + " run " + distance + " meters");
    }

    @Override
    public String getName() {
        return name;
    }

}
