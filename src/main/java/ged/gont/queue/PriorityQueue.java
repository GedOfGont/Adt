package ged.gont.queue;

import java.util.Comparator;

public class PriorityQueue<T> implements Comparator<T>{

    private int numElements;
    private T[] values;

    @SuppressWarnings("unchecked")
    public PriorityQueue(final int size) {
        numElements = 0;
        values = (T[]) new Object[size];
    }

    public void enqueue(final T value) {
        if (numElements == 0) {
            values[numElements] = value;
        } else {
            int i;
            for (i = numElements - 1; i >= 0; i--) {
                if (compare(value, values[i]) > 0) {
                    values[i + 1] = values[i];
                } else {
                    break;
                }
            }
            values[i + 1] = value;
        }
        numElements++;
    }
    
    public T dequeue(){
        return values[--numElements];
    }

    public boolean isEmpty(){
        return numElements == 0;
    }

    public T get(int index) {
        return values[index];
    }

    public void display() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                System.out.println(values[i]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compare(T arg0, T arg1) {
        return ((Comparable<? super T>) arg0).compareTo(arg1);
    }
}
