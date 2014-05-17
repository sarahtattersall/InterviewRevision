package com.st809.interview.skeina.graphs;

import java.util.HashMap;
import java.util.Map;

public class ShortestPath {

    public static void prim(Graph g, int start) {
        Map<Integer, Boolean> inTree = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parents = new HashMap<>();
        for (int vertex : g.verticies()) {
            inTree.put(vertex, false);
            distance.put(vertex, Integer.MAX_VALUE);
            parents.put(vertex, -1);
        }

        distance.put(start, 0);

        int vertex = start;
        while(!inTree.get(vertex)) {
            inTree.put(vertex, true);

            EdgeNode node = g.edges(vertex);
            while (node != null) {
                int other = node.y;
                int weight = node.weight;

                if (distance.get(other) > weight && !inTree.get(other)) {
                    distance.put(other, weight);
                    parents.put(other, vertex);
                }
                node = node.next;
            }

            //vertex = 1;
            int dist = Integer.MAX_VALUE;
            for (int v : g.verticies()) {
                if (!inTree.get(v) && dist > distance.get(v)) {
                    dist = distance.get(v);
                    vertex = v;
                }
            }
        }
    }

    public static void dijkstra(Graph g, int start, int finish) {
        Map<Integer, Boolean> inTree = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parents = new HashMap<>();
        for (int vertex : g.verticies()) {
            inTree.put(vertex, false);
            distance.put(vertex, Integer.MAX_VALUE);
            parents.put(vertex, -1);
        }

        distance.put(start, 0);

        int vertex = start;
        while(!inTree.get(vertex)) {
            inTree.put(vertex, true);

            EdgeNode node = g.edges(vertex);
            while (node != null) {
                int other = node.y;
                int weight = node.weight;

                if (distance.get(other) > distance.get(vertex) + weight) {
                    distance.put(other, weight + distance.get(other));
                    parents.put(other, vertex);
                }
                node = node.next;
            }

            //vertex = 1;
            int dist = Integer.MAX_VALUE;
            for (int v : g.verticies()) {
                if (!inTree.get(v) && dist > distance.get(v)) {
                    dist = distance.get(v);
                    vertex = v;
                }
            }
        }
    }

}
