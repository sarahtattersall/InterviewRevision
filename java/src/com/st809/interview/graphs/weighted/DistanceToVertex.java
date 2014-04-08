package com.st809.interview.graphs.weighted;

/**
 * Node for Priority Queue that sorts verticies based on their distance
 */
public class DistanceToVertex implements Comparable<DistanceToVertex> {
    public int vertex;
    public double distance;


    public DistanceToVertex(int vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public DistanceToVertex(int vertex) {
        this.vertex = vertex;
        this.distance = 0;
    }


    @Override
    public int compareTo(DistanceToVertex o) {
        return Double.compare(distance, o.distance);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DistanceToVertex)) {
            return false;
        }

        DistanceToVertex that = (DistanceToVertex) o;

        if (vertex != that.vertex) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return vertex;
    }
}
