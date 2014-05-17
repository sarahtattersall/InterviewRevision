package com.st809.interview.skeina.graphs;


import java.util.*;

/**
 * Abstract class for BFS/DFS traversal algorithms
 */
public abstract class Traverse {
    protected  Map<Integer, State> states = new HashMap<>();
    protected  Map<Integer, Integer> parent = new HashMap<>();

    public void initialise(Graph g) {
        states.clear();
        parent.clear();

        for (Integer vertex : g.verticies()) {
            states.put(vertex, State.UNDISCOVERED);
        }

    }

    public void dfs(Graph graph, int source) {
        states.put(source, State.DISCOVERED);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            states.put(vertex, State.PROCESSED);
            processEarly(vertex);
            EdgeNode edge = graph.edges(vertex);
            while (edge != null) {
                int other = edge.y;
                if (states.get(other) != State.PROCESSED || graph.isDirected()) {
                    processEdge(vertex, other);
                    // Process edge
                }
                if (states.get(other) == State.UNDISCOVERED) {
                    stack.push(other);
                    states.put(other, State.DISCOVERED);
                }
                edge = edge.next;
            }
            processLate(vertex);
        }
    }


    public Map<Integer, Integer> bfs(Graph graph, int source) {

        states.put(source, State.DISCOVERED);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            states.put(vertex, State.PROCESSED);
            processEarly(vertex);
            EdgeNode edge = graph.edges(vertex);
            while (edge != null) {
                int other = edge.y;
                if (states.get(other) != State.PROCESSED || graph.isDirected()) {
                    processEdge(vertex, other);
                    // Process edge
                }
                if (states.get(other) == State.UNDISCOVERED) {
                    queue.add(other);
                    states.put(other, State.DISCOVERED);
                    parent.put(other, vertex);
                }
                edge = edge.next;
            }
            processLate(vertex);
        }
        return parent;
    }

    protected abstract void processLate(int vertex);
    protected abstract void processEarly(int vertex);
    protected abstract void processEdge(int x, int y);

    public static void printPath(int start, int end, Map<Integer, Integer> parents) {
        if (start == end || !parents.containsKey(end)) {
            System.out.println(start);
        } else {
            printPath(start, parents.get(end), parents);
            System.out.println(end);
        }
    }



    protected static enum State {
        UNDISCOVERED, DISCOVERED, PROCESSED
    }

}
