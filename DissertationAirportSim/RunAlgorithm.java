/**
 * Created by andy on 15/02/2016.
 */

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;


//Runs the algorithm to find the shortest path from the start node and a destination node.
public class RunAlgorithm {

	//arrays to store all the edges, visited and unvisited vertexes, and the distance between points.

   // private final List<Vertex> vertexs;
    private final List<Edge> edges;
    private Set<Vertex> visitedVs;
    private Set<Vertex> unvisitedVs;
    private Map<Vertex, Vertex> previousVertexs;
    private Map<Vertex, Integer> distance;

    public RunAlgorithm(Graph graph) {
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    //runs the algorithm to find the shortest path from the start vertex
    public void execute(Vertex startVertex) {
        visitedVs = new HashSet<Vertex>();
        unvisitedVs = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        previousVertexs = new HashMap<Vertex, Vertex>();
        distance.put(startVertex, 0);
        unvisitedVs.add(startVertex);
        while (unvisitedVs.size() >= 1) {
            Vertex v = getLowest(unvisitedVs);
            visitedVs.add(v);
            unvisitedVs.remove(v);
            getLowestDistances(v);

        }
    }

    //updates the lowest distances to all the neighbouring Vertexes
    private void getLowestDistances(Vertex node) {
        List<Vertex> joinedVertexs = getAdjoining(node);
        for (Vertex target : joinedVertexs) {
            if (getLowestDistance(target) > getLowestDistance(node) + getDistance(node, target)) {
                distance.put(target, getLowestDistance(node) + getDistance(node, target));
                previousVertexs.put(target, node);
                unvisitedVs.add(target);
            }
        }
    }

    private int getLowestDistance(Vertex goingTo) {
        Integer distanceto = distance.get(goingTo);
        if (distanceto != null) {
        	return distanceto;
        }
        else {
        	return Integer.MAX_VALUE;

        }
    }

    //finds the distance between two vertexes
    public int getDistance(Vertex vertex, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getFrom().equals(vertex) && edge.getTo().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("");
    }

    //gets all the vertexes that are directly connected to a particular vertex
    public List<Vertex> getAdjoining(Vertex node) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges) {
            if (edge.getFrom().equals(node) && !visitedVs.contains(edge.getTo())) {
                neighbors.add(edge.getTo());
            }
        }
        return neighbors;
    }


    public List<Vertex> getAnyAdjoin(Vertex node) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges) {
            if (edge.getFrom().equals(node)) {
                neighbors.add(edge.getTo());
            }
        }
        return neighbors;
    }

    //finds the unvisited node with the shortest path
    private Vertex getLowest(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getLowestDistance(vertex) < getLowestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }


    public int getPathweight(LinkedList<Vertex> path){
   	int dist = 0;
     	for(int i=0; i<path.size()-1; i++){
    		dist = dist + getDistance(path.get(i), path.get(i+1));
       }
    	return dist;
    }

    //returns the shortest path to a particular vertex from the start vertex
    public LinkedList<Vertex> getPath(Vertex end) {
        LinkedList<Vertex> route = new LinkedList<Vertex>();
        Vertex step = end;
        route.add(step);
        while (previousVertexs.get(step) != null) {
            step = previousVertexs.get(step);
            route.add(step);
        }
        Collections.reverse(route);
        return route;

    }

}
