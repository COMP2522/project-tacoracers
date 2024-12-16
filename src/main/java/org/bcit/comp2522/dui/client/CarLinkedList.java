package org.bcit.comp2522.dui.client;

import java.util.function.Consumer;

/**
 * The type Car linked list.
 *
 * @param <T> the type parameter
 */
public class CarLinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * Instantiates a new Car linked list.
     */
    public CarLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add.
     *
     * @param data the data
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Get t.
     *
     * @param index the index
     * @return the t
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Remove.
     *
     * @param data the data
     */
    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    /**
     * For each.
     *
     * @param action the action
     */
    public void forEach(Consumer<T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return size;
    }
}
