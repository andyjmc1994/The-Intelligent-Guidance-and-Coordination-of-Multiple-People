/**
 * Created by andy on 15/02/2016.
 */
import java.util.List;


//structure simply puts the vertexes and edges together to make a weighted graph that can be referenced.
public class Graph {

	//stores a list of vertexes and a list of edges
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    //takes the two values when the graph is initialized
    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    //functions to return a list of the vetexes or a list of the edges
    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}
