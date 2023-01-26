package com.algorithm.thridlab.dynamicprogramming.graph;

public record Edge(int weight, Node fromNode, Node toNode) implements Comparable<Edge>{

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight,o.weight);
    }
}
