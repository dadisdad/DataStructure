package com.dadisdad.java.datastructure.stack;

/**
 * @author 10308
 * @date 2018/4/9
 */
public class MyStack<E> {

    private int size;

    private int top;

    private Object[] entry;

    public static final int DEFAULT_SIZE = 10;

    public MyStack() {
        this(DEFAULT_SIZE);
    }

    public MyStack(int size) {
        this.size = size;
        entry = new Object[size];
        this.top = 0;
    }

    public boolean isEmpty() {
        return 0 == top;
    }

    public boolean isFull() {
        return top == size;
    }

    public void clear() {
        top = 0;
    }

    public int length() {
        return top;
    }

    public void push(E e) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        entry[top++] = e;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object obj = entry[--top];
        return (E) obj;
    }

    public void traverse(boolean isFromTop) {
        if (!isFromTop) {
            for (int i = 0; i < top; i++) {
                Object o = entry[i];
                System.out.print(o.toString());
            }
        } else {
            for (int i = top - 1; i >= 0; i--) {
                Object o = entry[i];
                System.out.print(o.toString());
            }
        }
    }
}
