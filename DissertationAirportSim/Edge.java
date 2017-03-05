/**
 * Created by andy on 15/02/2016.
 */

//Defines an Edge of a weighted graph.
public class Edge  {

	//Each Edge is given a name, the vertexes its connected to are both stored as is its weight.
    private final String name;
    private final Vertex from;
    private final Vertex to;
    private int weight;

    //Receives all the above variables when the edge is initialized.
    public Edge(String name, Vertex from, Vertex to, int weight) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    //functions that return each of the edges 4 values at any given time.
    public String getId() {
        return name;
    }
    public Vertex getTo() {
        return to;
    }
    public Vertex getFrom() {
        return from;
    }
    public int getWeight() {
        return weight;
    }
}