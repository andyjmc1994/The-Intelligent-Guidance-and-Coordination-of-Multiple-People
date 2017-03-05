import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;


public class MainSimulation extends Application
{
	private List<Vertex> verts;
	private List<Edge> edges;
	static public List<PersonPlus> people;
	static Group root = new Group();
	static boolean simStopped = false;
	double time = 0;
	private int imagetoggle = 0;


   @Override
   public void start(Stage primaryStage) {
	  verts = new ArrayList<Vertex>();
	  people = new ArrayList<PersonPlus>();
	  addEdges2();
	  Graph graph = new Graph(verts, edges);

	  //Draws all the graph nodes and edges to the javaFX scene
	  for(int i=0; i<verts.size(); i++){
		  Circle c1 = new Circle(verts.get(i).getx(),verts.get(i).gety(), 10);
		  Text label = new Text(verts.get(i).getx()+10,verts.get(i).gety(), Integer.toString(i));
		  root.getChildren().addAll(c1, label);
	  }

	  //Combo drop down box for changing speed of simulation
	  ComboBox<String> myComboBox = new ComboBox<String>();
	   myComboBox.getItems().addAll("0.25X","0.5X","1X","1.5X","2X", "5X", "10X");
	   myComboBox.setValue("1X");
	   myComboBox.setLayoutX(700);
	   myComboBox.valueProperty().addListener(new ChangeListener<String>() {
		   @Override
		   public void changed(ObservableValue ov, String t, String t1) {
			   for (PersonPlus person : people) {
	        	  person.speed(t1);
			   }
		   }
	   });

	   //finds the bottlenecked vertexes
	   LinkedList<Vertex> bottlenecks = new LinkedList<Vertex>();
	   for (Vertex vertex : graph.getVertexes()){
		   if (vertex.isBottleN()){
			   bottlenecks.add(vertex);
		   }
	   }

	   //task thread that keeps track of time and updates the clock
	   Task<Void> dynamicTimeTask = new Task<Void>() {
		   @Override
		   protected Void call() throws Exception {
			   while (true) {
				   if (simStopped == false){
					   for (Vertex vertex : bottlenecks){
						   vertex.updatetimeblock(time*10);
					   }
					   Math.round ((time * 10000.0) / 10000.0);
					   updateMessage(Double.toString(time)+" Minutes");
		    			try {
		    				Thread.sleep(100);
		    			} catch (InterruptedException ex) {
		    				break;
		    			}
		    			switch (myComboBox.getValue()) {
						case "0.25X":
							time = time+ 0.125;
							break;
						case "0.5X":
							time = time+0.25;
							break;
						case "1X":
							time = time+0.5;
							break;
						case "1.5X":
							time = time+0.75;
							break;
						case "2X":
							time = time+1;
							break;
						case "5X":
							time = time+2.5;
							break;
						case "10X":
							time = time+5;
							break;
		    			}
				   	}
			   }
		   return null;
		   }
	    };

	    Button stepfwd = new Button("STEP");
	    stepfwd.setDisable(true);
		
	  //task thread for the simulation of new people entering the airport.
	  Task<Integer> task = new Task<Integer>() {
		    @Override protected Integer call() throws Exception {
		        int iterations;
		        for (iterations = 0; iterations < Integer.MAX_VALUE; iterations++) {
		            if (isCancelled()) {
		               break;
		            }
		    		System.out.print("");
		            if (simStopped == false){
		            	Random src = new Random();
						Random dst = new Random();
						Random deptime = new Random();
						PersonPlus person = new PersonPlus(graph, src.nextInt(4 - 0 + 1) + 0,dst.nextInt(16 - 12 + 1) + 12, deptime.nextInt(2000 - 1100 + 1) + 1100);
						person.speed(myComboBox.getValue());
						MainSimulation.people.add(person);
						Rectangle rect = person.Animate();
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								MainSimulation.root.getChildren().add(rect);
							}
						});
						rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
					         @Override
					         public void handle(MouseEvent t) {
					        	 for (PersonPlus person : MainSimulation.people) {
					        		 person.unfocus();
					        		 person.pauseAnim();
					        	 }
					        	 simStopped = true;
					        	 person.focus();
					        	 stepfwd.setDisable(false);
					         	}
					        });
						try {
							switch (myComboBox.getValue()) {
							case "0.25X":
								Thread.sleep(4000);
								break;
							case "0.5X":
								Thread.sleep(2000);
								break;
							case "1X":
								Thread.sleep(1000);
								break;
							case "1.5X":
								Thread.sleep(750);
								break;
							case "2X":
								Thread.sleep(500);
								break;
							case "5X":
								Thread.sleep(200);
								break;
							case "10X":
								Thread.sleep(100);
								break;
							}
						} catch(InterruptedException ex) {
							    Thread.currentThread().interrupt();
					}
		           }
		           
		          }
		        
			return iterations;
			
		    }
		};

		//time label, gets update with current time from the dynamicTimeTask
		Label label = new Label();
		label.setLayoutX(820);
		label.setLayoutY(-20);
	    label.textProperty().bind(dynamicTimeTask.messageProperty());
	    Thread t2 = new Thread(dynamicTimeTask);


	    Button playbutton = new Button("Play");
		Button pausebutton = new Button("Pause");
		
		pausebutton.setDisable(true);
		playbutton.setDisable(true);


		//start button for starting the simulation
	    Button button1 = new Button("Start");
	    button1.setLayoutX(0);
		  button1.setOnAction((event) -> {
			  t2.start();
			  pausebutton.setDisable(false);
			  button1.setDisable(true);
			  new Thread(task).start();

			});


	  Button button2 = new Button("1 Person");
/*	  button2.setOnAction((event) -> {
		  PersonPlus person = new PersonPlus(graph,0,16,0);
		  person.speed(myComboBox.getValue());
		  people.add(person);
		  Rectangle rect = person.Animate();
		  root.getChildren().addAll(rect);
		  rect.setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {
	            	button2.setDisable(true);


	            	for (PersonPlus person : people) {
	            		person.unfocus();
	            		person.pauseAnim();



	            	}
	            	System.out.println("stim");

	            //	person.focus();
	            }
	        });

		});
*/


	  //pause button for pausing the animation
	  pausebutton.setLayoutX(100);
	  pausebutton.setOnAction((event) -> {
		  playbutton.setDisable(false);
		  myComboBox.setDisable(true);
		  simStopped = true;
		  button2.setDisable(true);
		  pausebutton.setDisable(true);
		  for (PersonPlus person : people) {
			  person.pauseAnim();
		  }
	  });

	  //play button for playing the animation.
	  playbutton.setLayoutX(160);
	  playbutton.setOnAction((event) -> {
		  stepfwd.setDisable(true);
		  button2.setDisable(true);
		  playbutton.setDisable(true);
		  pausebutton.setDisable(false);
		  myComboBox.setDisable(false);
		  for (PersonPlus person : people) {
			  person.unfocus();
			  person.playAnim();
		}
	  });

	  //button to step foreward when simulation is paused
	  stepfwd.setLayoutX(206);
	  stepfwd.setOnAction((event) -> {
		  for (PersonPlus person : people) {
			  person.stepfwd();
		}
	  });


	  //loads the background airport image and sets its properties
	  Image image = new Image("LargeAirport.png");
      ImageView iv1 = new ImageView();
      iv1.setLayoutX(-25);
      iv1.setLayoutY(29);
      iv1.setImage(image);
      root.getChildren().add(iv1);
      imagetoggle = 1;

      //button toggles between the different image modes
      Button image1 = new Button("toggle image");
	  image1.setLayoutX(800);
	  image1.setOnAction((event) -> {
		  if (imagetoggle == 0){
			  root.getChildren().remove(iv1);
			  root.getChildren().add(root.getChildren().size() - people.size(),iv1);
			  imagetoggle++;
		  }
		  else if (imagetoggle == 1){
			  root.getChildren().remove(iv1);
			  imagetoggle++;
		  }
		  else{
			  root.getChildren().add(0,iv1);
			  imagetoggle = 0;
		  }
	  });



	  //add most of the buttons and items as JavaFX leaf nodes
	  root.getChildren().addAll(button1, pausebutton, playbutton, stepfwd, myComboBox, image1, label);
      root.setTranslateX(50);
      root.setTranslateY(50);
      //set the JavaFX scene
      Scene scene = new Scene(root, 1000, 650, Color.WHITE);
      primaryStage.setTitle("Routing Simulation");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   //method to creates the Large Airport
   public void addEdges2() {
	   edges = new ArrayList<Edge>();
	   LargeAirport airport = new LargeAirport(edges,verts,root);
	   airport.Create();

   }
}