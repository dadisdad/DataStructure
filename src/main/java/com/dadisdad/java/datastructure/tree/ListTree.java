package com.dadisdad.java.datastructure.tree;

/**
 * @author dadisdad
 * @date 2018/4/23
 */
public class ListTree {

    private TreeNode root;

    private ListTree() {
    }

    public ListTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode searchNode(int nodeIndex) {
        return root.searchNode(nodeIndex);
    }

    public boolean addNode(int nodeIndex, Direction direction, TreeNode node) {
        TreeNode temp = searchNode(nodeIndex);
        if (temp == null) {
            return false;
        }
        switch (direction) {
            case LEFT:
                temp.lChild = node;
                break;
            case RIGHT:
                temp.rChild = node;
                break;
            default:
                break;
        }
        node.parent = temp;
        return true;
    }

    public void deleteNode(int nodeIndex) {
        TreeNode node = searchNode(nodeIndex);
        if (node == null) {
            throw new IllegalStateException();
        }
        node.deleteNode();
    }

    public void destory() {
        root.deleteNode();
    }

    public void preOrder() {
        root.preOrder();
        System.out.println();
    }

    public void midOrder() {
        root.midOrder();
        System.out.println();
    }

    public void postOrder() {
        root.postOrder();
        System.out.println();
    }
}
