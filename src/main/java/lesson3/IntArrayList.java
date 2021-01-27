package lesson3;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

public class IntArrayList implements Iterable<Integer> {

    private static final int DEFAULT_CAPACITY = 100;
    private int size;
    private int iteratorPosition;
    private int capacity;
    private int[] data;

    public IntArrayList() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        data = new int[capacity];
    }

    // _ O(1)
    public void add(int value) {
        if (size >= capacity) {
            reallocate();
        }
        data[size] = value;
        size++;
    }

    // _ _ _ _ _ _ _ f(index) O(size)
    public void add(int index, int value) {
        if (size >= capacity) {
            reallocate();
        }
        // 1 2 7 3 4| 5 _ _
        // 1 2 0 3 4 5| _ _
        if (size + 1 - index >= 0) {
            System.arraycopy(data, index - 1, data, index, size + 1 - index);
        }
        data[index] = value;
        size++;
    }

    private void reallocate() {
        capacity *= 2;
        int[] tmp = new int[capacity];
        if (size >= 0) {
            System.arraycopy(data, 0, tmp, 0, size);
        }
        data = tmp;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {

        iteratorPosition = 0;

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return iteratorPosition < size;
            }

            @Override
            public Integer next() {
                return data[iteratorPosition++];
            }
        };
    }
}
