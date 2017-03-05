import java.util.LinkedList;

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




public class Person {

	public LinkedList<Vertex> currentpath;
	private final Graph graph;
	private Rectangle rect;

	PathTransition pathTransition = new PathTransition();

	private boolean focused = false;
	private boolean unfocusflag = false;

	private int pathPoint = 0;




	public Person(Graph graph, int start, int dest){
		this.graph = graph;

		RunAlgorithm alg = new RunAlgorithm(graph);
	    alg.execute(graph.getVertexes().get(start));
	    LinkedList<Vertex> path = alg.getPath(graph.getVertexes().get(dest));

	    rect = new Rectangle (graph.getVertexes().get(0).getx(), graph.getVertexes().get(0).gety(), 15, 15);
	    rect.setArcHeight(15);
	    rect.setArcWidth(15);
	    rect.setFill(Color.VIOLET);

	    currentpath = path;
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
									unfocus();
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
		rect.setFill(Color.VIOLET);
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

