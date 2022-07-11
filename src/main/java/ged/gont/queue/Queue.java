package ged.gont.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private int rear;
    private int front;
    private int size;
    private T[] values;

    @SuppressWarnings("unchecked")
    public Queue(final int size) {
        rear = 0;
        front = 0;
        this.size = size;
        values = (T[]) new Object[size];
    }

    public void enqueue(final T value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue size exceed");
        }
        values[rear++] = value;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return values[front++];
    }

    public boolean isEmpty() {

        return front == rear;
    }

    public boolean isFull() {
        return rear == this.size;
    }

}
