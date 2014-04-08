package com.st809.interview.graphs.weighted;

public class Edge implements Comparable<Edge> {
    /**
     * Edge starts at this vertex
     */
    private final int v;

    /**
     * Edge connects to this vertex
     */
    private final int w;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Edge)) {
            return false;
        }

        Edge edge = (Edge) o;

        if (v != edge.v) {
            return false;
        }
        if (w != edge.w) {
            return false;
        }
        if (Double.compare(edge.weight, weight) != 0) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = v;
        result = 31 * result + w;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Weight of edge
     */
    private final double weight;

    public Edge(int v, int w, double weight) {

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     *
     * @return weight of edge
     */
    public double weight() {
        return weight;
    }


    /**
     *
     * @param o
     * @return if this edge is bigger or smaller than o
     */
    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    /**
     *
     * @param vertex
     * @return the other vertex
     */
    public int other(int vertex) {
        if (vertex == this.v) {
            return w;
        } else if (vertex == this.w) {
            return v;
        }
        throw new RuntimeException("Inconsistent edge");
    }

    /**
     *
     * @return one of this edges verticies
     */
    public int either() {
        return v;
    }

    @Override
    public String toString() {
        return "(" + v + ", " + w + "): " + weight;
    }
}
