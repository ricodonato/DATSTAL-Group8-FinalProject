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
