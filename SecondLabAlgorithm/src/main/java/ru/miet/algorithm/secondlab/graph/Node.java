package ru.miet.algorithm.secondlab.graph;

public record Node(double nodeWeight) {
    @Override
    public String toString() {
        return nodeWeight + " (вес вершины)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return this.nodeWeight == ((Node) obj).nodeWeight;
    }
}