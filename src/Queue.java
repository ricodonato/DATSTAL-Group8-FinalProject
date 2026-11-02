import java.util.NoSuchElementException;

public class Queue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front = null;
    private Node<T> rear = null;
    private int size = 0;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    