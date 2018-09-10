package com.turvo.search.demo.model;

import com.turvo.search.demo.utils.Container;

public class EdgeWeightedDigraph {
    private static final String NEWLINE = "\n";

    private final int v;                // number of vertices in this digraph
    private int e;                      // number of edges in this digraph
    private Container<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;             // indegree[v] = indegree of vertex v

    public EdgeWeightedDigraph(int v) {
        if (v < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.v = v;
        this.e = 0;
        this.indegree = new int[v];
        adj =  new Container[v];
        for (int i = 0; i < this.v; i++)
            adj[i] = new Container<DirectedEdge>();
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= this.v)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (this.v-1));
    }

    /**
     * Adds the directed edge {@code e} to this edge-weighted digraph.
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        this.e++;
    }


    /**
     * Returns the directed edges incident from vertex {@code v}.
     */
    public Iterable<DirectedEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Container<DirectedEdge> list = new Container<DirectedEdge>();
        for (int v = 0; v < this.v; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.v + " " + this.e + NEWLINE);
        for (int v = 0; v < this.v; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}
