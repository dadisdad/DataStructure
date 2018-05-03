package com.dadisdad.java.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dadisdad
 * @date 2018/4/26
 */
public class GMap {

    private int capacity;

    private int nodeCount;

    private int[] matrix;

    private Node[] nodeArray;

    private Edge[] edges;

    private static final int DEFAULT_CAPACITY = 16;

    public GMap() {
        this(DEFAULT_CAPACITY);
    }

    public GMap(int capacity) {
        this.capacity = capacity;
        this.nodeCount = 0;
        this.nodeArray = new Node[capacity];
        this.matrix = new int[capacity * capacity];
        edges = new Edge[capacity - 1];
    }

    public boolean addNode(Node node) {
        if (node == null) {
            return false;
        }
        nodeArray[nodeCount] = node;
        nodeCount++;
        return true;
    }

    public void resetNode() {
        for (int i = 0; i < nodeCount; i++) {
            nodeArray[i].isVisited = false;
        }
    }

    public boolean setValueToMatrixForDirectedGraph(int row, int col, int val) {
        if (row < 0 || row >= capacity) {
            return false;
        }
        if (col < 0 || col >= capacity) {
            return false;
        }
        matrix[row * capacity + col] = val;
        return true;
    }

    public boolean setValueToMatrixForUndirectedGraph(int row, int col, int val) {
        if (row < 0 || row >= capacity) {
            return false;
        }
        if (col < 0 || col >= capacity) {
            return false;
        }
        matrix[row * capacity + col] = val;
        matrix[col * capacity + row] = val;
        return true;
    }

    public int getValueFromMatrix(int row, int col) {
        if (row < 0 || row >= capacity) {
            throw new IllegalStateException();
        }
        if (col < 0 || col >= capacity) {
            throw new IllegalStateException();
        }
        int val = matrix[row * capacity + col];
        return val;
    }

    public void printMatrix() {
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                System.out.print(matrix[i * capacity + j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 深度优先遍历
     *
     * @param nodeIndex
     */
    public void depthFirstTraverse(int nodeIndex) {
        System.out.print(nodeArray[nodeIndex].data + "    ");
        nodeArray[nodeIndex].isVisited = true;

        for (int i = 0; i < capacity; i++) {
            int value = getValueFromMatrix(nodeIndex, i);
            if (value != 0) {
                if (!nodeArray[i].isVisited) {
                    depthFirstTraverse(i);
                }
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param nodeIndex
     */
    public void breathFirstTraverse(int nodeIndex) {
        System.out.print(nodeArray[nodeIndex].data + "    ");
        nodeArray[nodeIndex].isVisited = true;

        List<Integer> indexs = new ArrayList<>();
        indexs.add(nodeIndex);
        breathFirstTraverseImpl(indexs);

    }

    private void breathFirstTraverseImpl(List<Integer> vec) {
        List<Integer> curVec = new ArrayList<>();

        int size = vec.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < capacity; j++) {
                int value = getValueFromMatrix(vec.get(i), j);
                if (value != 0) {
                    if (!nodeArray[j].isVisited) {
                        System.out.print(nodeArray[j].data + "    ");
                        nodeArray[j].isVisited = true;
                        curVec.add(j);
                    }
                }
            }
        }

        if (curVec.size() != 0) {
            breathFirstTraverseImpl(curVec);
        }
    }

    /**
     * 普里姆算法
     *
     * @param nodeIndex
     */
    public void primTree(int nodeIndex) {
        int value = 0;
        int edgeCount = 0;
        List<Integer> nodeIndexs = new ArrayList<>();
        List<Edge> edgeList = new ArrayList<>();
        System.out.println(nodeArray[nodeIndex].data);
        nodeIndexs.add(nodeIndex);
        nodeArray[nodeIndex].isVisited = true;
        while (edgeCount < capacity - 1) {
            int temp = nodeIndexs.get(nodeIndexs.size() - 1);
            for (int i = 0; i < capacity; i++) {
                value = getValueFromMatrix(temp, i);
                if (value != 0 && !nodeArray[i].isVisited) {
                    Edge edge = new Edge(temp, i, value);
                    edgeList.add(edge);
                }
            }

            int edgeIndex = getMinEdge(edgeList);
            edgeList.get(edgeIndex).isSelected = true;

            System.out.println(edgeList.get(edgeIndex).nodeIndexA + "-----" + edgeList.get(edgeIndex).nodeIndexB + "  " + edgeList.get(edgeIndex).weightValue);
            edges[edgeCount] = edgeList.get(edgeIndex);
            edgeCount++;

            int nextNodeIndex = edgeList.get(edgeIndex).nodeIndexB;
            nodeIndexs.add(nextNodeIndex);
            nodeArray[nextNodeIndex].isVisited = true;
            System.out.println(nodeArray[nextNodeIndex].data);
        }
    }

    private int getMinEdge(List<Edge> edges) {
        int minWeight = edges.get(0).weightValue;
        int edgeIndex = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (!edges.get(i).isSelected && edges.get(i).weightValue < minWeight) {
                minWeight = edges.get(i).weightValue;
                edgeIndex = i;
            }
        }

        return edgeIndex;
    }

    public void kruskalTree(){

    }
}
