package com.dadisdad.java.datastructure.graph;

/**
 * 边
 *
 * @author dadisdad
 * @date 2018/5/2
 */
public class Edge {

    public int nodeIndexA;
    public int nodeIndexB;
    public int weightValue;

    public boolean isSelected;

    public Edge() {
    }

    public Edge(int nodeIndexA, int nodeIndexB, int weightValue) {
        this.nodeIndexA = nodeIndexA;
        this.nodeIndexB = nodeIndexB;
        this.weightValue = weightValue;
        isSelected = false;
    }
}
