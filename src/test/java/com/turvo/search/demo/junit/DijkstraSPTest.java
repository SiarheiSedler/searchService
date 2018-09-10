package com.turvo.search.demo.junit;

import com.turvo.search.demo.utils.DijkstraSP;
import com.turvo.search.demo.model.DirectedEdge;
import com.turvo.search.demo.model.EdgeWeightedDigraph;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DijkstraSPTest {

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
    public void graphTimeTest(){
        int time = 39;
        DijkstraSP dijkstraSP = new DijkstraSP(initGraph(), 0, time);
        double[] distTo = dijkstraSP.getDistTo();
        assertNotNull(distTo);
        assertEquals(distTo.length, 8);
        for(int i = 0; i<distTo.length; i++){
            if(distTo[i] != Double.POSITIVE_INFINITY){
                assertTrue(distTo[i]<=time);
            }
        }

        time = 12;
        dijkstraSP = new DijkstraSP(initGraph(), 0, time);
        distTo = dijkstraSP.getDistTo();
        assertNotNull(distTo);
        assertEquals(distTo.length, 8);
        for(int i = 0; i<distTo.length; i++){
            if(distTo[i] != Double.POSITIVE_INFINITY){
                assertTrue(distTo[i]<=time);
            }
        }
    }

    @Test
    public void graphWorkTest(){
        int time = 39;
        int startPoint = 0;
        DijkstraSP dijkstraSP = new DijkstraSP(initGraph(), startPoint, time);
        double[] distTo = dijkstraSP.getDistTo();
        assertNotNull(distTo);
        assertEquals(distTo.length, 8);
        for(int i = 0; i<distTo.length; i++){
            if(distTo[i] != Double.POSITIVE_INFINITY){
                assertTrue(distTo[i]<=time);
            }
        }
        assertTrue(distTo[0] == 0);
        assertTrue(distTo[1] == 17);
        assertTrue(distTo[2] == 1);
        assertTrue(distTo[3] == 23);
        assertTrue(distTo[4] == 8);
        assertTrue(distTo[5] == 14);
        assertTrue(distTo[6] == 39);
        assertTrue(distTo[7] == 19);

        time = 12;
        dijkstraSP = new DijkstraSP(initGraph(), startPoint, time);
        distTo = dijkstraSP.getDistTo();
        assertNotNull(distTo);
        assertEquals(distTo.length, 8);
        for(int i = 0; i<distTo.length; i++){
            if(distTo[i] != Double.POSITIVE_INFINITY){
                assertTrue(distTo[i]<=time);
            }
        }

        assertTrue(distTo[0] == 0);
        assertTrue(distTo[1] == Double.POSITIVE_INFINITY);
        assertTrue(distTo[2] == 1);
        assertTrue(distTo[3] == Double.POSITIVE_INFINITY);
        assertTrue(distTo[4] == 8);
        assertTrue(distTo[5] == Double.POSITIVE_INFINITY);
        assertTrue(distTo[6] == Double.POSITIVE_INFINITY);
        assertTrue(distTo[7] == Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void graphParammsIsNullTest(){
        DijkstraSP dijkstraSP = new DijkstraSP(null, 0, 39);
        System.out.println("done");
    }
}
