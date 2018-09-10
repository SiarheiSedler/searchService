package com.turvo.search.demo.junit;

import com.turvo.search.demo.model.DirectedEdge;
import com.turvo.search.demo.model.EdgeWeightedDigraph;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class EdgeWeightedDigraphTest {
    private EdgeWeightedDigraph initGraph(){
        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(8);
        edgeWeightedDigraph.addEdge(new DirectedEdge(4, 5, 6));
        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 4, 6));
        edgeWeightedDigraph.addEdge(new DirectedEdge(4, 7, 13));
        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 7, 12));
        edgeWeightedDigraph.addEdge(new DirectedEdge(7, 5, 12));

        edgeWeightedDigraph.addEdge(new DirectedEdge(5, 1, 3));
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 4, 8));
        edgeWeightedDigraph.addEdge(new DirectedEdge(0, 2, 1));
        edgeWeightedDigraph.addEdge(new DirectedEdge(7, 3, 7));
        edgeWeightedDigraph.addEdge(new DirectedEdge(1, 3, 6));

        edgeWeightedDigraph.addEdge(new DirectedEdge(2, 7, 18));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 2, 21));
        edgeWeightedDigraph.addEdge(new DirectedEdge(3, 6, 16));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 0, 34));
        edgeWeightedDigraph.addEdge(new DirectedEdge(6, 4, 72));

        return edgeWeightedDigraph;
    }

    @Test
    public void adjMethodTest(){
        int[] POINT_0 = {2,4};
        int[] POINT_1 = {3};
        int[] POINT_2 = {7};
        int[] POINT_3 = {6};
        int[] POINT_4 = {5,7};
        int[] POINT_5 = {4,7,1};
        int[] POINT_6 = {2,4,0};
        int[] POINT_7 = {5,3};
        EdgeWeightedDigraph graph = initGraph();
        Iterable<DirectedEdge> adj = graph.adj(0);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_0, directedEdge.to())));

        adj = graph.adj(1);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_1, directedEdge.to())));

        adj = graph.adj(2);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_2, directedEdge.to())));

        adj = graph.adj(3);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_3, directedEdge.to())));

        adj = graph.adj(4);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_4, directedEdge.to())));

        adj = graph.adj(5);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_5, directedEdge.to())));

        adj = graph.adj(6);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_6, directedEdge.to())));

        adj = graph.adj(7);
        adj.forEach(directedEdge -> assertTrue(checkPointIfExists(POINT_7, directedEdge.to())));
    }

    private boolean checkPointIfExists(int[] mass, int value){
        for(int i =0; i < mass.length; i++){
            if(mass[i] == value){
                return true;
            }
        }
        return false;
    }
}
