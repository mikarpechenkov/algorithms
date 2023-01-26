package com.algorithm.thirdlab.dijkstra;

import com.algorithm.thirdlab.dijkstra.graph.*;

import java.util.LinkedList;

public class StartDijkstra {
    public static void main(String[] args) {
        Node startNode = new Node(1, 0);
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(null);
        nodes.add(startNode);
        for (int i = 2; i <= 8; i++)
            nodes.add(new Node(i));
        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(6, nodes.get(1), nodes.get(2)));
        edges.add(new Edge(12, nodes.get(2), nodes.get(3)));
        edges.add(new Edge(1, nodes.get(3), nodes.get(8)));
        edges.add(new Edge(2, nodes.get(8), nodes.get(7)));
        edges.add(new Edge(1, nodes.get(7), nodes.get(6)));
        edges.add(new Edge(10, nodes.get(6), nodes.get(1)));
        edges.add(new Edge(1, nodes.get(1), nodes.get(4)));
        edges.add(new Edge(1, nodes.get(2), nodes.get(4)));
        edges.add(new Edge(1, nodes.get(2), nodes.get(5)));
        edges.add(new Edge(1, nodes.get(3), nodes.get(5)));
        edges.add(new Edge(8, nodes.get(5), nodes.get(8)));
        edges.add(new Edge(5, nodes.get(5), nodes.get(7)));
        edges.add(new Edge(7, nodes.get(4), nodes.get(7)));
        edges.add(new Edge(1, nodes.get(4), nodes.get(6)));
        edges.add(new Edge(4, nodes.get(4), nodes.get(5)));
        Dijkstra dijkstra=new Dijkstra(new Graph(edges),startNode);
        dijkstra.findMinimumPathToEachVertices();
        System.out.println("\nМЕТОД ДЕЙКСТРЫ\n" + dijkstra + "\n");
    }
}
