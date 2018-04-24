package com.dadisdad.java.datastructure.tree;

/**
 * @author dadisdad
 * @date 2018/4/24
 */
public class ArrayTreeDemo {

    public static void main(String[] args) {
        ArrayTree<Integer> tree = new ArrayTree<>();

        tree.initRoot(1);
        tree.addNode(0,Direction.LEFT,2);
        tree.addNode(0,Direction.RIGHT,3);
        tree.addNode(1,Direction.LEFT,4);
        tree.addNode(1,Direction.RIGHT,5);
        tree.addNode(2,Direction.LEFT,6);
        tree.addNode(2,Direction.RIGHT,7);

        tree.traverse();

        System.out.println(tree.searchNode(4));

        System.out.println(tree.deleteNode(5));

        tree.traverse();
    }
}
