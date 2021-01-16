package lesson1.hw;

public class Road implements Obstacle {

    int length = (int) (Math.random() * 100 + 1);

    @Override
    public boolean take(Activity activity) {
        if (activity.getRunLimit() > length) {
            activity.run(length);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                '}';
    }
}
