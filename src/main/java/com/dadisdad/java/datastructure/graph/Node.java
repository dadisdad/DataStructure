package com.dadisdad.java.datastructure.graph;

/**
 * @author dadisdad
 * @date 2018/4/26
 */
public class Node {

    char data;

    boolean isVisited;

    public Node(char data) {
        this.data = data;
        isVisited = false;
    }

    public char getData() {
        return data;
    }
}
