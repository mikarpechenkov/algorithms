package ru.miet.algorithm.secondlab;

import ru.miet.algorithm.secondlab.graph.Edge;
import ru.miet.algorithm.secondlab.graph.Graph;
import ru.miet.algorithm.secondlab.graph.Node;

import java.util.LinkedList;

//Вариант 1
public class KruskalAndPrima {

    public static void main(String[] args) {
        LinkedList<Edge>edges=new LinkedList<>();
        edges.add(new Edge(6.0,new Node(1.0),new Node(2.0)));
        edges.add(new Edge(12.0,new Node(2.0),new Node(3.0)));
        edges.add(new Edge(1.0,new Node(3.0),new Node(8.0)));
        edges.add(new Edge(2.0,new Node(8.0),new Node(7.0)));
        edges.add(new Edge(5.0,new Node(7.0),new Node(6.0)));
        edges.add(new Edge(10.0,new Node(6.0),new Node(1.0)));
        edges.add(new Edge(1.0,new Node(1.0),new Node(4.0)));
        edges.add(new Edge(4.0,new Node(4.0),new Node(5.0)));
        edges.add(new Edge(1.0,new Node(2.0),new Node(4.0)));
        edges.add(new Edge(1.0,new Node(2.0),new Node(5.0)));
        edges.add(new Edge(1.0,new Node(3.0),new Node(5.0)));
        edges.add(new Edge(8.0,new Node(5.0),new Node(8.0)));
        edges.add(new Edge(5.0,new Node(7.0),new Node(5.0)));
        edges.add(new Edge(7.0,new Node(4.0),new Node(7.0)));
        edges.add(new Edge(1.0,new Node(6.0),new Node(4.0)));

        Graph originalGraph=new Graph(edges);
        System.out.println("Остовное дерево графа методом Крускала:\n");
        System.out.println(originalGraph.findMinimumSpanningTreeByKruskal()+"\n");
        System.out.println("Остовное дерево графа методом Прима: \n");
        System.out.println(originalGraph.findMinimumSpanningTreeByPrima()+"\n");
    }
}
