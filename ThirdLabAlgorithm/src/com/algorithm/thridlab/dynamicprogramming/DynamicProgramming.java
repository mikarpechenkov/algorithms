package com.algorithm.thridlab.dynamicprogramming;

import com.algorithm.thridlab.dynamicprogramming.graph.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DynamicProgramming {
    private final Graph graph;
    private final Node startNode;
    private HashMap<Node, Integer> queue = new HashMap<>();
    //Здесь будет храниться ключи (Node, минимальное расстояние до которых еще неизвестно) и значения (Количество нерассмотренных родителей)
    private LinkedList<Node> finishedNodes = new LinkedList<>();

    public DynamicProgramming(@NotNull Graph graph, Node startNode) {
        this.graph = graph;
        this.startNode = startNode;
        //формируем список тех вершин, для которых необходимо знать расстояние и
        //записываем во все вершины, кроме стартового, информацию о родительских вершинах
        addParentsToNodes();
        finishedNodes.add(startNode);
    }


    public void findMinimumPathToEachVertices() {
        //теперь начинаем поиск расстояния
        while (!queue.isEmpty()) {
            for (Iterator<Map.Entry<Node, Integer>> iterator = queue.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Node, Integer> entry = iterator.next();
                for (Edge edge : graph.getEdges())
                    if (entry.getKey().equals(edge.toNode()) && finishedNodes.contains(edge.fromNode())) { //если путь до предыдущей вершины известен
                        entry.getKey().setMinimumPathAndSuitableParent(
                                edge.weight() + finishedNodes.get(finishedNodes.indexOf(edge.fromNode())).getMinimumPathToThis(),
                                finishedNodes.get(finishedNodes.indexOf(edge.fromNode())));
                        entry.setValue(entry.getValue() - 1);
                        if (entry.getValue() == 0) {
                            finishedNodes.add(entry.getKey());
                            iterator.remove();
                        }
                    }
            }
        }
    }

    public HashMap<Node, Integer> getQueue() {
        return queue;
    }

    public LinkedList<Node> getFinishedNodes() {
        return finishedNodes;
    }

    private void addParentsToNodes() {
        graph.getEdges().stream().filter(edge -> !startNode.equals(edge.toNode()))
                .forEach(edge -> {
                    queue.computeIfPresent(edge.toNode(), (k, v) -> v + 1);
                    queue.computeIfAbsent(edge.toNode(), k -> 1);
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

