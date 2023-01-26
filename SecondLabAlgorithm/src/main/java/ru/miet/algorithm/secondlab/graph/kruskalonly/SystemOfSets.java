package ru.miet.algorithm.secondlab.graph.kruskalonly;

import ru.miet.algorithm.secondlab.graph.Edge;
import ru.miet.algorithm.secondlab.graph.Node;

import java.util.LinkedList;

public class SystemOfSets {
    private LinkedList<Set> sets = new LinkedList<>();

    public LinkedList<Set> getSets() {
        return sets;
    }

    private Set findSetByNode(Node searchNode) {
        for (Set el : sets)
            if (el.checkNodePresence(searchNode))
                return el;
        return null;
    }

    //самый важный метод для добавления ребра в множество (с необходимыми проверками) ля алгоритма Крускала
    public void addEdgeInSetForKruskal(Edge edge) {
        Set firstSet = findSetByNode(edge.firstVertx());
        Set secondSet = findSetByNode(edge.secondVertex());
        if (firstSet != null && secondSet == null)
            firstSet.addEdge(edge);
        else if (firstSet == null && secondSet != null)
            secondSet.addEdge(edge);
        else if (firstSet == null && secondSet == null)
            sets.add(new Set(edge));
        else if (firstSet != secondSet) {
            firstSet.union(secondSet, edge);
            sets.remove(secondSet);
        }
    }


}
