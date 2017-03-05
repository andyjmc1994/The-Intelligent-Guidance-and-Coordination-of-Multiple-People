import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PersonPlus {

	public LinkedList<Vertex> currentpath;
	private final Graph graph;
	private Rectangle rect;
	PathTransition pathTransition = new PathTransition();
	private boolean focused = false;
	private boolean unfocusflag = false;
	private int pathPoint = 0;




	public PersonPlus(Graph graph, int start, int dest, int depTime){
		this.graph = graph;

	    RunAlgorithm alg = new RunAlgorithm(graph);
	    alg.execute(graph.getVertexes().get(dest));
	    LinkedList<Vertex> path = alg.getPath(graph.getVertexes().get(start));

	    RunAlgorithm balg = new RunAlgorithm(graph);
	    LinkedList<Vertex> smallpath = new LinkedList<Vertex>();

	    int spareTime = depTime - alg.getPathweight(path);

	    Vertex temp = new Vertex("");
	    for (Vertex vertex : path){
	    	if (vertex.isBottleN()){

	    		balg = new RunAlgorithm(graph);
	    		balg.execute(vertex);
	    		smallpath = balg.getPath(graph.getVertexes().get(start));
	    		temp = vertex;

	    	}

	    }

	    int temst = (spareTime/4);
	    while (temst > 0){
	    	smallpath = cleverPath(smallpath, balg, balg.getPathweight(smallpath)+temst);
	    	if (temp.isAvailable(balg.getPathweight(smallpath))){
	    		break;
	    	}
	    	temst = temst - 25;
	    }

	    path = alg.getPath(temp);
	    path = cleverPath(path, alg, alg.getPathweight(smallpath)+((spareTime/4)*3));
	    path.removeLast();
	    path = new LinkedList<Vertex>(path);
	    path.addAll(smallpath);
	    Collections.reverse(path);

	    rect = new Rectangle (graph.getVertexes().get(0).getx(), graph.getVertexes().get(0).gety(), 15, 15);
	    rect.setArcHeight(15);
	    rect.setArcWidth(15);
	    rect.setFill(Color.GOLD);

	    currentpath = path;
   	}

	public LinkedList<Vertex> cleverPath(LinkedList<Vertex> path, RunAlgorithm alg, int depTime){
		    List<Vertex> visited = new ArrayList<Vertex>();
		    List<Vertex> joinedVertexs = new ArrayList<Vertex>();
		    Vertex worstVertex = new Vertex("");
		    int currentweight = 0;
		    int visitedweight = 0;
		    int y = 1;
		    while (y < path.size()-1){
			    visited.add(path.get(path.size()-y));
			    joinedVertexs = alg.getAnyAdjoin(path.get(path.size()-y));
			    currentweight = 0;
			    worstVertex = joinedVertexs.get(0);
			    for (Vertex vertex : joinedVertexs){
			    	int x = alg.getPathweight(alg.getPath(vertex));
			    	if (x > currentweight && !visited.contains(vertex) && !vertex.isService()){
			    		currentweight = x;
			    		worstVertex = vertex;
			    	}
			    }
			    visitedweight = visitedweight + alg.getDistance(path.get(path.size()-y),worstVertex);
			    if (currentweight + visitedweight < depTime && currentweight != 0){
			    	path = new LinkedList<Vertex>(alg.getPath(worstVertex));
			    	Collections.reverse(visited);
				    path.addAll(visited);
				    Collections.reverse(visited);
			    }
			    else{
			    	break;
			    }
			    y++;
		    }
		    return path;
	}

	public LinkedList<Vertex> getPath(){
		return currentpath;
	}

	public Rectangle Animate(){
	      Path path = new Path();
	      path.getElements().add (new MoveTo (currentpath.get(pathPoint).getx(), currentpath.get(pathPoint).gety()));
	      path.getElements().add(new LineTo(currentpath.get(pathPoint+1).getx(), currentpath.get(pathPoint+1).gety()));

	      pathTransition.setDuration(Duration.millis(getDistance(currentpath.get(0),currentpath.get(1))*20));


	      pathTransition.setNode(rect);
	      pathTransition.setPath(path);
	      pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
	      pathTransition.setCycleCount((int) 1);
	      pathTransition.play();

	      pathTransition.onFinishedProperty().set(new EventHandler<ActionEvent>() {


				@Override
				public void handle(ActionEvent event) {

						if (pathPoint > (currentpath.size() - 3)){
							if (pathPoint < currentpath.size()){
								pathPoint++;
							}
							if(focused == true){
								for (PersonPlus person : MainSimulation.people) {
									person.unfocus();
								}
							}
						}
						else {
								pathPoint++;
							if(focused == false){
								Animate();
							}
							else{
								Platform.runLater(new Runnable() {
						             @Override
						             public void run() {
						            	 MainSimulation.simStopped = true;
						             }
						         });
								for (PersonPlus person : MainSimulation.people) {
									person.pauseAnim();
								}

							}
						}
					if (pathPoint == (currentpath.size() - 1)){

				    	  Group group = (Group) rect.getParent();
				    	  Platform.runLater(new Runnable() {
				              @Override
				              public void run() {
				            	  group.getChildren().remove(rect);
				              }
				          });
				      }
				}
		      });
	      return rect;
	}

	private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : graph.getEdges()) {
            if (edge.getFrom().equals(node)
                    && edge.getTo().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }


	public void pauseAnim(){
		pathTransition.pause();
	}
	public void playAnim(){
		pathTransition.play();
	}

	public void focus(){
		focused = true;
		rect.setFill(Color.RED);
	}

	public void unfocus(){
		if (focused){
			unfocusflag = true;
		}
		focused= false;
		rect.setFill(Color.GOLD);
	}


	public void stepfwd(){
		 Platform.runLater(new Runnable() {
             @Override
             public void run() {
            	 MainSimulation.simStopped = false;
             }
         });
			if (focused == true||unfocusflag == true){
					unfocusflag  = false;
					Animate();
				}
			else{
					playAnim();
			}
	}

	public void stepbwd(){
		pathTransition.setRate(-1);
				playAnim();

	}


	//sets the speed of the Person
	public void speed(String speedString){
		switch (speedString) {
		case "0.25X":
			pathTransition.setRate(0.25);
			break;
		case "0.5X":
			pathTransition.setRate(0.5);
			break;
		case "1X":
			pathTransition.setRate(1);
			break;
		case "1.5":
			pathTransition.setRate(1.5);
			break;
		case "2X":
			pathTransition.setRate(2);
			break;
		case "5X":
			pathTransition.setRate(5);
			break;
		case "10X":
			pathTransition.setRate(10);
			break;
		}
	}

}

