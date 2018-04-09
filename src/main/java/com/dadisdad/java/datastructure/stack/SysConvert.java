package com.dadisdad.java.datastructure.stack;

/**
 * @author 10308
 * @date 2018/4/9
 */
public class SysConvert {

    public static final int BIN = 2;
    public static final int OCT = 8;
    public static final int HEX = 16;
    public static final char[] HEXS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void toBin(int num) {
        MyStack<Integer> bins = new MyStack<>(64);
        int mod = 0;
        while (num != 0) {
            mod = num % BIN;
            bins.push(mod);
            num = num / BIN;
        }
        bins.traverse(true);
    }

    public static void toOct(int num) {
        MyStack<Integer> octs = new MyStack<>();
        int mod = 0;
        while (num != 0) {
            mod = num % OCT;
            octs.push(mod);
            num = num / OCT;
        }
        octs.traverse(true);
    }

    public static void toHex(int num) {
        MyStack<Integer> hexs = new MyStack<>();
        int mod = 0;
        while (num != 0) {
            mod = num % HEX;
            hexs.push(mod);
            num = num / HEX;
        }
        while (!hexs.isEmpty()) {
            System.out.print(HEXS[hexs.pop()]);
        }
    }

    public static void main(String[] args) {
        int num = 1024;
        toBin(num);
        System.out.println();
        toOct(num);
        System.out.println();
        toHex(num);
    }
}
