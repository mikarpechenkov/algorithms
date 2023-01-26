package com.algorithm.thridlab.dynamicprogramming;

import com.algorithm.thridlab.dynamicprogramming.graph.Edge;
import com.algorithm.thridlab.dynamicprogramming.graph.Graph;
import com.algorithm.thridlab.dynamicprogramming.graph.Node;

import java.util.LinkedList;

public class StartDynamicProgramming {
    public static void main(String[] args) {
        Node startNode = new Node(1, 0);
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(3, startNode, new Node(2)));
        edges.add(new Edge(8, startNode, new Node(3)));
        edges.add(new Edge(4, startNode, new Node(4)));
        edges.add(new Edge(4, new Node(2), new Node(3)));
        edges.add(new Edge(10, new Node(4), new Node(3)));
        edges.add(new Edge(9, new Node(4), new Node(5)));
        edges.add(new Edge(7, new Node(3), new Node(5)));
        edges.add(new Edge(2, new Node(5), new Node(7)));
        edges.add(new Edge(8, new Node(3), new Node(7)));
        edges.add(new Edge(4, new Node(6), new Node(7)));
        edges.add(new Edge(6, new Node(3), new Node(6)));
        edges.add(new Edge(6, new Node(2), new Node(6)));
        DynamicProgramming dynamicProgramming = new DynamicProgramming(new Graph(edges), startNode);
        dynamicProgramming.findMinimumPathToEachVertices();
        System.out.println("\nМЕТОД ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ\n" + dynamicProgramming.toString() + "\n");
    }
}
