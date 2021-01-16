package lesson1.hw;

public class Wall implements Obstacle {

    int height = (int) (Math.random() * 100 + 1);

    @Override
    public boolean take(Activity person) {
        if (person.getJumpLimit() > height) {
            person.jump(height);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
