package lesson3;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

public class IntLinkedList implements Iterable<Integer> {

    private int size;
    private Node head;
    private Node tail;
    private Node iteratorNode;

    public IntLinkedList() {
    }

    public void add(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public void add(int index, int value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // _ _ _ _ _
        Node next = head;
        for (int i = 0; i < index; i++) {
            next = next.next;
        }
        Node node = new Node(value);
        Node prev = next.prev;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
        size++;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {

        iteratorNode = head;

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iteratorNode != null;
            }

            @Override
            public Integer next() {
                int current = iteratorNode.value;
                iteratorNode = iteratorNode.next;
                return current;
            }
        };
    }

    private class Node {

        int value;
        Node next, prev;

        public Node(int value) {
            this.value = value;
        }
    }
}
