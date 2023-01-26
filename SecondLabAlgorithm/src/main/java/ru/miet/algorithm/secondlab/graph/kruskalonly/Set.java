package ru.miet.algorithm.secondlab.graph.kruskalonly;

import ru.miet.algorithm.secondlab.graph.Edge;
import ru.miet.algorithm.secondlab.graph.Graph;
import ru.miet.algorithm.secondlab.graph.Node;

import java.util.LinkedList;

public class Set {
    private Graph setGraph=new Graph();
    private LinkedList<Node> nodes=new LinkedList<>();

    public Set(Edge edge){
        setGraph.add(edge);
        nodes.add(edge.firstVertx());
        nodes.add(edge.secondVertex());
    }

    public Graph getSetGraph() {
        return setGraph;
    }

    //Объединение множеств
    public void union(Set addSet, Edge connectingEdge){
        this.setGraph.add(addSet.setGraph);
        this.nodes.addAll(addSet.nodes);
        this.setGraph.add(connectingEdge);
    }

    public void addEdge(Edge edge){
        setGraph.add(edge);
        this.nodes.add(edge.firstVertx());
        this.nodes.add(edge.secondVertex());
    }

    public boolean checkNodePresence(Node node){
        return nodes.contains(node);
    }
}
