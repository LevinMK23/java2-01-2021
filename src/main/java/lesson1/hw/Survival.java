package lesson1.hw;

public interface Survival {

    String getName();

    default void take(Obstacle... obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (!obstacle.take((Activity) this)) {
                System.out.println(obstacle + " cannot be taken by " + getName());
                return;
            }
        }
        System.out.println("All obstacles was taken by " + getName());
    }
}
