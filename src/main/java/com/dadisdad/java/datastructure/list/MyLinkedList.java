package com.dadisdad.java.datastructure.list;

import java.util.NoSuchElementException;

/**
 * @author dadisdad
 * @date 2018/4/17
 */
public class MyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;

    private Node<E> last;

    private int size = 0;

    public MyLinkedList() {
    }

    /**
     * 获取大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 清空链表
     */
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向头部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 向尾部添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 在某个元素之前插入元素
     *
     * @param e
     * @param node
     */
    private void addBefore(E e, Node<E> node) {
        Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, e, node);
        node.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    /**
     * 定位i位置的元素
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 向指定位置插入元素
     *
     * @param i
     * @param e
     */
    public void add(int i, E e) {
        if (i >= size) {
            addLast(e);
        } else {
            addBefore(e, node(i));
        }
    }

    /**
     * 插入元素，默认向尾部插入
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * @param node
     * @return
     */
    private E unlink(Node<E> node) {
        E element = node.data;
        Node<E> pred = node.prev;
        Node<E> next = node.next;

        if (pred == null) {
            first = next;
        } else {
            pred.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = pred;
        } else {
            next.prev = pred;
            node.next = null;
        }
        node.data = null;
        size--;
        return element;
    }

    /**
     * 删除一个元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定位置元素
     *
     * @param i
     * @return
     */
    public boolean remove(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        } else {
            unlink(node(i));
            return true;
        }
    }

    /**
     * 删除元素，默认从头节点删除
     *
     * @return
     */
    public E remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return unlink(first);
    }

    /**
     * 获取指定位置元素
     *
     * @param i
     * @return
     */
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return node(i).data;
    }

    /**
     * 为指定位置元素设置新的值
     *
     * @param i
     * @param e
     * @return
     */
    public E set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = node(i);
        E oldValue = node.data;
        node.data = e;
        return oldValue;
    }

    /**
     * 定位某个元素的首次出现位置
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 定位某个元素最后出现的位置
     *
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.data == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.data)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    public void visit(){
        for (Node<E> x = first; x != null; x = x.next) {
            System.out.print(x.data+" ");
            if (x.next == null){
                System.out.println();
            }
        }
    }
}
