
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class RunAlgTest {
	private List<Vertex> verts;
	private List<Edge> edges;


	@Test
	public void testGetDistance() {
		verts = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		Graph graph = new Graph(verts, edges);
		Vertex location = new Vertex(Integer.toString(0));
	    verts.add(location);
	    location = new Vertex(Integer.toString(1));
	    verts.add(location);
	    location = new Vertex(Integer.toString(2));
	    verts.add(location);
	    Edge edge = new Edge("", verts.get(0), verts.get(1), 40);
	    edges.add(edge);
	    edge = new Edge("", verts.get(0), verts.get(2), 99);
	    edges.add(edge);
	    edge = new Edge("", verts.get(1), verts.get(2), 1);
	    edges.add(edge);
	    RunAlgorithm algorithm = new RunAlgorithm(graph);
	    assertEquals(40,algorithm.getDistance(graph.getVertexes().get(0), graph.getVertexes().get(1)));
	    assertEquals(99,algorithm.getDistance(graph.getVertexes().get(0), graph.getVertexes().get(2)));
	    assertEquals(1,algorithm.getDistance(graph.getVertexes().get(1), graph.getVertexes().get(2)));


	}

	@Test
	public void testGetAdjoining() {
		verts = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		Graph graph = new Graph(verts, edges);
		Vertex location = new Vertex(Integer.toString(0));
	    verts.add(location);
	    location = new Vertex(Integer.toString(1));
	    verts.add(location);
	    location = new Vertex(Integer.toString(2));
	    verts.add(location);
	    Edge edge = new Edge("", verts.get(0), verts.get(1), 40);
	    edges.add(edge);
	    edge = new Edge("", verts.get(0), verts.get(2), 99);
	    edges.add(edge);
	    edge = new Edge("", verts.get(1), verts.get(2), 1);
	    edges.add(edge);
	    RunAlgorithm algorithm = new RunAlgorithm(graph);

	    List<Vertex> joined = new ArrayList<Vertex>();
	    joined.add(verts.get(1));
	    joined.add(verts.get(2));
		assertEquals(joined,algorithm.getAnyAdjoin(graph.getVertexes().get(0)));

	}


	@Test
	public void testGetPathweight() {
		verts = new ArrayList<Vertex>();
		LinkedList<Vertex>verts1 = new LinkedList<Vertex>();
		edges = new ArrayList<Edge>();
		Graph graph = new Graph(verts1, edges);
		Vertex location = new Vertex(Integer.toString(0));
	    verts1.add(location);
	    location = new Vertex(Integer.toString(1));
	    verts1.add(location);
	    location = new Vertex(Integer.toString(2));
	    verts1.add(location);
	    Edge edge = new Edge("", verts1.get(0), verts1.get(1), 86);
	    edges.add(edge);
	    edge = new Edge("", verts1.get(1), verts1.get(2), 21);
	    edges.add(edge);
	    RunAlgorithm algorithm = new RunAlgorithm(graph);
	    assertEquals(107,algorithm.getPathweight(verts1));
	}
	
	@Test
	public void testcleverPath() {
		//PersonPlus person = new PersonPlus();
	}

}
