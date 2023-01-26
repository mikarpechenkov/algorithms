package com.algorithm.thirdlab.dijkstra.graph;

public record Edge(int weight, Node firstNode, Node secondNode) implements Comparable<Edge> {

    public Node getConnectedWith(Node pendingNode) {
        if (firstNode.equals(pendingNode))
            return secondNode;
        else if (secondNode.equals(pendingNode))
            return firstNode;
        return null;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}