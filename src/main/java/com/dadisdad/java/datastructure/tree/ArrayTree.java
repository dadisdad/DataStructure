package com.dadisdad.java.datastructure.tree;

/**
 * @author dadisdad
 * @date 2018/4/23
 */
public class ArrayTree<E> {

    private Object[] entry;

    public static final int DEFAULT_SIZE = 15;

    private int size;

    public ArrayTree() {
        this(DEFAULT_SIZE);
    }

    public ArrayTree(int size) {
        entry = new Object[size];
        this.size = size;
    }

    /**
     * 搜索节点
     *
     * @param nodeIndex
     * @return
     */
    public E searchNode(int nodeIndex) {
        checkIndex(nodeIndex);
        return (E) entry[nodeIndex];
    }

    /**
     * 校验index
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException();
        }
    }

    /**
     * 增加节点
     *
     * @param nodeIndex
     * @param direction
     * @param e
     * @return
     */
    public boolean addNode(int nodeIndex, Direction direction, E e) {
        checkIndex(nodeIndex);
        checkIndex(nodeIndex * 2 + direction.ordinal() + 1);
        entry[nodeIndex * 2 + direction.ordinal() + 1] = e;
        return true;
    }

    /**
     * 删除节点
     *
     * @param nodeIndex
     * @return
     */
    public E deleteNode(int nodeIndex) {
        checkIndex(nodeIndex);
        if (entry[nodeIndex] == null) {
            return null;
        }
        E e = (E) entry[nodeIndex];
        entry[nodeIndex] = null;
        return e;
    }

    /**
     * 遍历树
     */
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.print(entry[i] + " ");
        }
        System.out.println();
    }

    public boolean initRoot(E root) {
        entry[0] = root;
        return true;
    }
}
