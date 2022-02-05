package ged.gont.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    int top;
    int size;
    T[] values;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.size = size;
        top = -1;
        values = (T[]) new Object[size];
    }

    public void push(T value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack size is exceed");
        }
        values[++top] = value;
    }

    public T pop() {
        if (isEmtpy()) {
            throw new EmptyStackException();
        }
        return values[top--];
    }

    public T peek() {
        if (isEmtpy()) {
            throw new EmptyStackException();
        }
        return values[top];
    }

    public boolean isEmtpy() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

}
