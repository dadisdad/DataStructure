package com.dadisdad.java.datastructure.list;

/**
 * 线性表---顺序表
 *
 * @author 10308
 * @date 2018/4/10
 */
public class MyList<E> {

    /**
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    private int size;

    private Object[] entry;

    private int length;

    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int size) {
        this.size = size;
        this.entry = new Object[size];
        this.length = 0;
    }

    /**
     * 获取当前顺序表长度
     *
     * @return
     */
    public int length() {
        return this.length;
    }

    /**
     * 清空顺序表
     */
    public void clear() {
        this.length = 0;
    }

    /**
     * 判断顺序表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 获取指定位置的元素
     *
     * @param i
     * @return
     */
    public E get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IllegalStateException("illegal position of " + i);
        }
        return (E) entry[i];
    }

    /**
     * 获取元素的位置，即下标，返回第一个等于e的元素下标
     *
     * @param e
     * @return
     */
    public int index(E e) {
        for (int i = 0; i < entry.length; i++) {
            Object o = entry[i];
            if (o.equals(e)) {
                return i;
            }
        }
        throw new IllegalStateException("not found");
    }

    /**
     * 获取指定元素的前驱
     *
     * @return
     */
    public E previous(E currentEle) {
        int currentIndex = index(currentEle);
        if (currentIndex <= 0) {
            return null;
        }
        return (E) entry[currentIndex - 1];
    }

    /**
     * 获取指定元素的后继
     *
     * @param currentEle
     * @return
     */
    public E next(E currentEle) {
        int currentIndex = index(currentEle);
        if (currentIndex < 0 || currentIndex == length - 1) {
            return null;
        }
        return (E) entry[currentIndex + 1];
    }

    /**
     * 设置指定位置的元素值
     *
     * @param i
     * @param e
     * @return
     */
    public boolean set(int i, E e) {
        if (i < 0 || i > length) {
            return false;
        }
        entry[i] = e;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
     * @param i
     * @return
     */
    public E delete(int i) {
        if (i < 0 || i >= length) {
            throw new IllegalStateException("Illegal index");
        }
        E e = (E) entry[i];
        for (int j = i + 1; j < length; j++) {
            entry[j - 1] = entry[j];
        }
        length--;
        return e;
    }

    /**
     * 在末尾增加元素
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (length == size) {
            return false;
        } else {
            entry[length] = e;
            length++;
            return true;
        }
    }

    /**
     * 在指定位置增加元素
     *
     * @param e
     * @return
     */
    public boolean add(int i, E e) {
        if (i < 0 || i > length) {
            return false;
        }
        for (int j = length - 1; j >= i; j--) {
            entry[j + 1] = entry[j];
        }
        entry[i] = e;
        length++;
        return true;
    }

    /**
     * 遍历打印顺序表
     */
    public void visit() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            Object o = entry[i];
            if (i == length - 1) {
                System.out.print(o.toString());
            } else {
                System.out.print(o.toString() + ",");
            }
        }
        System.out.print("]\n");
    }
}
