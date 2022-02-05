package ged.gont.stack;

public class Stack<T> {
    
    int top = -1;
    T[] values;

    @SuppressWarnings("unchecked")
    public Stack(int size){
        values = (T[]) new Object[size];
    }

    public void push(T value){
        values[++top] = value;
    }

    public T pop(){
        return values[top--];
    }

    public T peek(){
        return values[top];
    }

    public boolean isEmtpy(){
        return top == -1;
    }

}
