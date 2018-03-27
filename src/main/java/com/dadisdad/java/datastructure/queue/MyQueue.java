package com.dadisdad.java.datastructure.queue;

/**
 * @author dadisdad
 * @date 2018/3/27
 */
public class MyQueue {

    private Object[] entry;
    private int length;
    private int capacity;

    int head;
    int tail;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.length = 0;
        this.entry = new Object[capacity];
    }

    public void clearQueue() {
        this.head = 0;
        this.tail = 0;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0 ? true : false;
    }

    public int length() {
        return this.length;
    }

    public boolean full() {
        return this.length == this.capacity ? true : false;
    }

    public boolean enQueue(Object element) {
        if (full()) {
            return false;
        }
        entry[tail] = element;
        tail = (tail + 1) % capacity;
        length++;
        return true;
    }

    public Object deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("队列空");
        }
        Object ele = entry[head];
        head = (head + 1) % capacity;
        length--;
        return ele;
    }

    public void queueTraverse() {
        for (int i = head; i < length + head; i++) {
            System.out.println(entry[i % capacity]);
        }
    }

}
