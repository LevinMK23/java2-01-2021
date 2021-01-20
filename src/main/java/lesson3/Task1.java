package lesson3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Task1 {

    // 1 1 3 1 2 3 4 5 6 7 8 9 9 9 9 9

    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(1, 1, 2, 2, 3, 3, 5, 5);
        Collections.sort(data);
        for (int i = 0; i < data.size() - 1; i++) {
            if (!data.get(i).equals(data.get(i + 1))) {
                System.out.print(data.get(i) + " ");
            }
            if (i == data.size() - 2) {
                System.out.print(data.get(i + 1) + " ");
            }
        }
        System.out.println();

        TreeSet<String> set = new TreeSet<>(
                Arrays.asList("aaa", "asf", "a")
        );
        // set.contains(5); O(logN)
        System.out.println(set);

        // set.contains(5); O(1)
        HashSet<String> hs = new HashSet<>(
                Arrays.asList("aaa", "asf", "a")
        );

        System.out.println(hs);
    }
}
