package com.st809.interview.graphs.weigheddigraph;

public class DirectedEdge {
    private int to;
    private int from;
    private double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DirectedEdge)) {
            return false;
        }

        DirectedEdge that = (DirectedEdge) o;

        if (from != that.from) {
            return false;
        }
        if (to != that.to) {
            return false;
        }
        if (Double.compare(that.weight, weight) != 0) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = to;
        result = 31 * result + from;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
