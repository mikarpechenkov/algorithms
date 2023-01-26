package ru.miet.algorithm.secondlab.graph;

import org.jetbrains.annotations.NotNull;
import ru.miet.algorithm.secondlab.graph.kruskalonly.SystemOfSets;

import java.util.Collections;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> edges;
    private LinkedList<Node> nodes;

    public Graph() {
        edges = new LinkedList<>();
        nodes=new LinkedList<>();
    }

    public LinkedList<Node> getNodes() {
        calculateNodes();
        return nodes;
    }

    private void calculateNodes() {
        edges.forEach(el -> {
            if (!nodes.contains(el.firstVertx())) nodes.add(el.firstVertx());
            if (!nodes.contains(el.secondVertex())) nodes.add(el.secondVertex());
        });
    }

    public Graph(LinkedList<Edge> edges) {
        this.edges=new LinkedList<>(edges);
        this.nodes=new LinkedList<>();
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void add(@NotNull Graph graph) {
        graph.getEdges().forEach(element -> edges.add(element));
    }

    public void add(Edge edge) {
        this.edges.add(edge);
    }

    public double getWeight() {
        double weight = 0.0;
        for (Edge el : edges)
            weight += el.edgeWeight();
        return weight;
    }

    @Override
    public String toString() {
        StringBuffer graphString = new StringBuffer("");
        edges.forEach(el -> graphString.append("Вершина 1: " + el.firstVertx() + "; Вершина 2: " + el.secondVertex() + "; Вес ребра: " + el.edgeWeight() + "\n"));
        return graphString.toString();
    }

    public void sort() {
        Collections.sort(edges);
    }

    //По сути итоговый метод (для Крускала), использует все наши классы
    public Graph findMinimumSpanningTreeByKruskal() {
        sort();
        SystemOfSets disjointsSets = new SystemOfSets();
        for (Edge edge : edges)
            disjointsSets.addEdgeInSetForKruskal(edge);
        return disjointsSets.getSets().getFirst().getSetGraph();
    }

    //Для минимизации метода Прима
    public Graph findMinimumSpanningTreeByPrima() {
        sort();
        calculateNodes();
        LinkedList<Node> addedNodes = new LinkedList<>();
        LinkedList<Edge> allEdges = new LinkedList<>(edges);
        LinkedList<Edge> addedEdges = new LinkedList<>();
        addedNodes.add(nodes.getFirst());
        while (!addedNodes.containsAll(nodes))
            for (Edge edge : allEdges)
                if ((addedNodes.contains(edge.firstVertx()) && !addedNodes.contains(edge.secondVertex())) ||
                        (!addedNodes.contains(edge.firstVertx()) && addedNodes.contains(edge.secondVertex()))) {
                    if (addedNodes.contains(edge.firstVertx()))
                        addedNodes.add(edge.secondVertex());
                    else
                        addedNodes.add(edge.firstVertx());
                    addedEdges.add(edge);
                    allEdges.remove(edge);
                    break;
                }
        return new Graph(addedEdges);
    }
}
