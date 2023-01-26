package com.algorithm.thirdlab.dijkstra.graph;

import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> edges;

    public Graph(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
