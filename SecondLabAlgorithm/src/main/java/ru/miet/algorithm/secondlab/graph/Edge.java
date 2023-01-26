package ru.miet.algorithm.secondlab.graph;

public record Edge(Double edgeWeight, Node firstVertx, Node secondVertex) implements Comparable<Edge> {

    @Override
    public int compareTo(Edge o) {
        return this.edgeWeight.compareTo(o.edgeWeight);
    }
}
