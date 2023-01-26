package com.algorithm.thirdlab.dijkstra.graph;

import java.util.Comparator;

public class MinimalPathComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getMinimumPathToThis(), o2.getMinimumPathToThis());
    }
}