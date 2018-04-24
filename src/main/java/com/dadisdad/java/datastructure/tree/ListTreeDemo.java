package com.dadisdad.java.datastructure.tree;

/**
 * @author dadisdad
 * @date 2018/4/24
 */
public class ListTreeDemo {

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(0, 0);
        ListTree tree = new ListTree(root);

        TreeNode<Integer> node1 = new TreeNode<>(1, 5);
        TreeNode<Integer> node2 = new TreeNode<>(2, 8);
        TreeNode<Integer> node3 = new TreeNode<>(3, 2);
        TreeNode<Integer> node4 = new TreeNode<>(4, 6);
        TreeNode<Integer> node5 = new TreeNode<>(5, 9);
        TreeNode<Integer> node6 = new TreeNode<>(6, 7);

        tree.addNode(0, Direction.LEFT, node1);
        tree.addNode(0, Direction.RIGHT, node2);

        tree.addNode(1, Direction.LEFT, node3);
        tree.addNode(1, Direction.RIGHT, node4);

        tree.addNode(2, Direction.LEFT, node5);
        tree.addNode(2, Direction.RIGHT, node6);

        tree.preOrder();
        tree.midOrder();
        tree.postOrder();

        tree.deleteNode(0);
        tree.preOrder();
    }
}
