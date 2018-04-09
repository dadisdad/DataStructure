package com.dadisdad.java.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 10308
 * @date 2018/4/9
 */
public class MyStackTest {

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        //System.out.println(stack.isEmpty());
        //System.out.println(stack.isFull());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        //stack.push("f");
        //System.out.println(stack.isEmpty());
        //System.out.println(stack.isFull());
        stack.traverse(false);
        stack.traverse(true);
        System.out.println(stack.pop());
        System.out.println(stack.length());
    }
}
