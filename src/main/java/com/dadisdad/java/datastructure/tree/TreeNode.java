package com.dadisdad.java.datastructure.tree;

/**
 * @author dadisdad
 * @date 2018/4/24
 */
public class TreeNode<E> {

    int index;
    E data;
    TreeNode lChild;
    TreeNode rChild;
    TreeNode parent;

    public TreeNode() {
        index = 0;
        data = null;
        lChild = null;
        rChild = null;
        parent = null;
    }

    public TreeNode(int index, E data) {
        this.index = index;
        this.data = data;
        lChild = null;
        rChild = null;
        parent = null;
    }

    public TreeNode(int index, E data, TreeNode lChild, TreeNode rChild, TreeNode parent) {
        this.index = index;
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
        this.parent = parent;
    }

    public TreeNode searchNode(int nodeIndex) {
        TreeNode temp = null;
        if (this.index == nodeIndex) {
            return this;
        }
        if (this.lChild != null) {
            if (this.lChild.index == nodeIndex) {
                return this.lChild;
            } else {
                temp = this.lChild.searchNode(nodeIndex);
                if (temp != null) {
                    return temp;
                }
            }
        }
        if (this.rChild != null) {
            if (this.rChild.index == nodeIndex) {
                return this.rChild;
            } else {
                temp = this.rChild.searchNode(nodeIndex);
                if (temp != null) {
                    return temp;
                }
            }
        }
        return null;
    }

    public void deleteNode() {
        if (this.lChild != null) {
            this.lChild.deleteNode();
        }
        if (this.rChild != null) {
            this.rChild.deleteNode();
        }
        if (this.parent != null) {
            if (this.parent.lChild == this) {
                this.parent.lChild = null;
            } else {
                this.parent.rChild = null;
            }
        }
        this.data = null;
        this.lChild = null;
        this.rChild = null;
        this.parent = null;
    }

    public void preOrder() {
        System.out.println(this.index + " " + this.data);
        if (this.lChild != null) {
            this.lChild.preOrder();
        }
        if (this.rChild != null) {
            this.rChild.preOrder();
        }
    }

    public void midOrder() {
        if (this.lChild != null) {
            this.lChild.midOrder();
        }
        System.out.println(this.index + " " + this.data);
        if (this.rChild != null) {
            this.rChild.midOrder();
        }
    }

    public void postOrder() {
        if (this.lChild != null) {
            this.lChild.postOrder();
        }
        if (this.rChild != null) {
            this.rChild.postOrder();
        }
        System.out.println(this.index + " " + this.data);
    }
}
