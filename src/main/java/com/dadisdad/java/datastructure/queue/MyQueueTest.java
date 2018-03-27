package com.dadisdad.java.datastructure.queue;

/**
 * @author dadisdad
 * @date 2018/3/27
 */
public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue demo=new MyQueue(5);
        demo.enQueue("a");
        demo.enQueue("b");
        demo.enQueue("v");
        demo.enQueue("d");
        demo.enQueue("dsa");
        demo.enQueue("qwe");
        demo.queueTraverse();
        System.out.println(demo.deQueue());
        System.out.println(demo.deQueue());
        demo.enQueue("lk");
        demo.enQueue("ut");
        demo.queueTraverse();
        System.out.println(demo.length());
    }
}
