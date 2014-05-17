package com.st809.interview.skeina.graphs;

public class EdgeNode {
    public final int y;
    public final int weight;
    public EdgeNode next;

    public EdgeNode(int y, int weight) {
        this.y = y;
        this.weight = weight;
    }

    public EdgeNode(int y, int weight, EdgeNode next) {
        this.y = y;
        this.weight = weight;
        this.next = next;
    }


}
