package com.dadisdad.java.datastructure.graph;

/**
 *       A
 *     /  \
 *    B   D
 *   / \ / \
 *  C  F G-H
 *   \/
 *   E
 *
 *
 *      A  B   C   D   E   F   G   H
 * A       1       1
 * B    1      1           1
 * C       1           1   1
 * D    1                      1   1
 * E           1           1
 * F       1           1
 * G               1               1
 * H               1           1
 * @author dadisdad
 * @date 2018/4/28
 */
public class GMapTest {

    public static void main(String[] args) {
        GMap map = new GMap(6);

        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');

        map.addNode(a);
        map.addNode(b);
        map.addNode(c);
        map.addNode(d);
        map.addNode(e);
        map.addNode(f);

        map.setValueToMatrixForUndirectedGraph(0,1, 6);
        map.setValueToMatrixForUndirectedGraph(0,4, 5);
        map.setValueToMatrixForUndirectedGraph(0,5, 1);
        map.setValueToMatrixForUndirectedGraph(1,2, 3);
        map.setValueToMatrixForUndirectedGraph(1,5, 2);
        map.setValueToMatrixForUndirectedGraph(2,5, 8);
        map.setValueToMatrixForUndirectedGraph(2,3, 7);
        map.setValueToMatrixForUndirectedGraph(3,5, 4);
        map.setValueToMatrixForUndirectedGraph(3,2, 2);
        map.setValueToMatrixForUndirectedGraph(4,5, 9);

        map.printMatrix();

        map.depthFirstTraverse(0);
        map.resetNode();
        System.out.println();
        map.breathFirstTraverse(0);
        System.out.println();

        map.resetNode();
        map.primTree(0);
    }
}
