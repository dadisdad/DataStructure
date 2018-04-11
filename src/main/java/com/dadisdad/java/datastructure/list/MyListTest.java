package com.dadisdad.java.datastructure.list;

/**
 * @author 10308
 * @date 2018/4/11
 */
public class MyListTest {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println(list.length());
        System.out.println(list.isEmpty());

        list.add(1);
        System.out.println(list.length());
        System.out.println(list.isEmpty());

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.length());
        list.visit();
        list.set(3, 7);
        list.visit();

        list.add(2, 9);
        list.visit();

        list.delete(3);
        list.visit();

        System.out.println(list.previous(2));
        System.out.println(list.next(7));
        System.out.println(list.get(3));
        System.out.println(list.index(9));

        list.clear();
        list.visit();
    }
}
