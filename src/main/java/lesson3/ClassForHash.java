package lesson3;

import java.util.Objects;

public class ClassForHash {

    int x, y;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassForHash)) {
            return false;
        }
        ClassForHash that = (ClassForHash) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return 17 * x + 31 * y;
    }
}
