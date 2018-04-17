package com.dadisdad.java.datastructure.list;

/**
 * @author dadisdad
 * @date 2018/4/17
 */
public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList.isEmpty());
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.visit();
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.indexOf(7));
        linkedList.addFirst(0);
        linkedList.visit();
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.lastIndexOf(7));
        linkedList.remove();
        linkedList.visit();
        linkedList.remove(3);
        linkedList.visit();
        linkedList.remove(new Integer(5));
        linkedList.visit();

        linkedList.add(4,10);
        linkedList.visit();

        linkedList.set(2,13);
        linkedList.visit();
        System.out.println(linkedList.get(4));

        linkedList.clear();
        System.out.println(linkedList.isEmpty());
    }
}
