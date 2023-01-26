package com.algorithm.thirdlab.dijkstra;

import com.algorithm.thirdlab.dijkstra.graph.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Dijkstra {
    private final Graph graph;
    private final Node startNode;
    private LinkedList<Node> queue;
    private LinkedList<Node> finishedNodes;

    public Dijkstra(Graph graph, Node startNode) {
        this.graph = graph;
        this.startNode = startNode;
        writeNodes();
        finishedNodes = new LinkedList<>();
    }

    public LinkedList<Node> getFinishedNodes() {
        return finishedNodes;
    }

    public void findMinimumPathToEachVertices() {
        while (!queue.isEmpty()) {
            //Мы должны определить минимальную из оставшихся вершин
            Node currentRoot = queue.stream()
                    .min(new MinimalPathComparator())
                    .orElseThrow(NoSuchElementException::new);
            graph.getEdges().forEach(edge -> {
                Node connectedNode;
                if ((connectedNode = edge.getConnectedWith(currentRoot)) != null && !finishedNodes.contains(connectedNode))
                    queue.get(queue.indexOf(connectedNode))
                            .setMinimumPathAndSuitableParent(currentRoot.getMinimumPathToThis() + edge.weight(), currentRoot);
            });
            finishedNodes.add(currentRoot);
            queue.remove(currentRoot);
        }
    }

    private void writeNodes() {
        if (queue == null)
            queue = new LinkedList<>();
        graph.getEdges().forEach(edge -> {
            if (!queue.contains(edge.firstNode()))
                queue.add(edge.firstNode());
            if (!queue.contains(edge.secondNode()))
                queue.add(edge.secondNode());
        });
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("КРАТЧАЙШИЕ РАССТОЯНИЯ ОТ " + startNode + " ДО ВСЕХ ОСТАЛЬНЫХ:\n");
        finishedNodes.forEach(node -> stringBuffer.append(node.toString())
                .append("; минимальное расстояние: ")
                .append(node.getMinimumPathToThis())
                .append(";\n"));
        return stringBuffer.toString();
    }
}
