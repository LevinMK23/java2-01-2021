package lesson3;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsIntro {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        l.add(3, 11);
        System.out.println(l);
        IntArrayList il = new IntArrayList();
        for (int i = 0; i < 10; i++) {
            il.add(i+1);
        }
        il.add(5, 11);
        for (int value : il) {
            System.out.print(value + " ");
        }
        System.out.println();

        IntLinkedList ill = new IntLinkedList();
        for (int i = 0; i < 10; i++) {
            ill.add(i+1);
        }
        ill.add(5, 11);
        for (int value : ill) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
