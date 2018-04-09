package com.dadisdad.java.datastructure.stack;

/**
 * @author 10308
 * @date 2018/4/9
 */
public class PatternMatch {

    public static void main(String[] args) {
        MyStack<Character> pStack = new MyStack<>(30);
        MyStack<Character> needStack = new MyStack<>(30);

        char[] str = "[[()]".toCharArray();
        char currentNeed = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != currentNeed) {
                pStack.push(str[i]);
                switch (str[i]) {
                    case '[':
                        if (currentNeed != 0) {
                            needStack.push(currentNeed);
                        }
                        currentNeed = ']';
                        break;
                    case '(':
                        if (currentNeed != 0) {
                            needStack.push(currentNeed);
                        }
                        currentNeed = ')';
                        break;
                    default:
                        break;
                }
            } else {
                pStack.pop();
                if (!needStack.isEmpty()) {
                    currentNeed = needStack.pop();
                } else {
                    currentNeed = 0;
                }
            }
        }
        if (pStack.isEmpty()) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }
}
