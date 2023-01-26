package com.algorithm.thirdlab.dijkstra.graph;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Node implements Comparable<Node>{
    private final int weight;
    private int minimumPathToThis;
    private Node suitableParent;

    public Node(int weight) {
        this.weight = weight;
        this.minimumPathToThis = Integer.MAX_VALUE;
    }

    public Node(int weight, int minimumPathToThis) {
        this.weight = weight;
        this.minimumPathToThis = minimumPathToThis;
    }

    public int getWeight() {
        return weight;
    }

    public int getMinimumPathToThis() {
        return minimumPathToThis;
    }

    public Node getSuitableParent() {
        return suitableParent;
    }

    public void setSuitableParent(@NotNull Node suitableParent) {
        this.suitableParent = suitableParent;
    }

    public void setMinimumPathToThis(int minimumPathToThis) {
        if (minimumPathToThis < this.minimumPathToThis)
            this.minimumPathToThis = minimumPathToThis;
    }

    public void setMinimumPathAndSuitableParent(int minimumPathToThis, Node suitableParent) {
        if (minimumPathToThis < this.minimumPathToThis) {
            this.minimumPathToThis = minimumPathToThis;
            setSuitableParent(suitableParent);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return this.weight == ((Node) obj).weight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (suitableParent != null)
            stringBuilder.append(suitableParent).append("->");
        stringBuilder.append(Integer.toString(weight));
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return Integer.compare(this.weight,o.weight);
    }
}


