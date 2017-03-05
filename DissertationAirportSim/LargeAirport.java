import java.util.List;
import javafx.scene.Group;
import javafx.scene.shape.Line;

//class that creates out Airport, both visually and the ascosiated graph
public class LargeAirport {
	List<Edge> edges;
	List<Vertex> verts;
	Group root;


	public LargeAirport(List<Edge> edges, List<Vertex> verts,Group root) {
		this.edges = edges;
		this.verts = verts;
		this.root = root;
    }


	//creates all the Vertex and Edge objects that make
	//up out Airport and adds them to the corresponding lists
	public void Create(){
		for (int i = 0; i < 51; i++) {
		      Vertex location = new Vertex(Integer.toString(i));
		      verts.add(location);

		    }

		//entrance
	   	verts.get(0).setxy(50, 570);
	    verts.get(1).setxy(238,570);
	    verts.get(2).setxy(425, 570);
	    verts.get(3).setxy(613, 570);
	    verts.get(4).setxy(800, 570);
	    //check in
	    verts.get(5).setxy(50, 420);
	    verts.get(6).setxy(238,420);
	    verts.get(7).setxy(425, 420);
	    verts.get(8).setxy(613, 420);
	    verts.get(9).setxy(800, 420);
	    verts.get(41).setxy(50, 410);
	    verts.get(41).setbools(false, true);
	    verts.get(42).setxy(238,410);
	    verts.get(42).setbools(false, true);
	    verts.get(43).setxy(425, 410);
	    verts.get(43).setbools(false, true);
	    verts.get(44).setxy(613, 410);
	    verts.get(44).setbools(false, true);
	    verts.get(45).setxy(800, 410);
	    verts.get(45).setbools(false, true);
	    //security
	    verts.get(10).setxy(332, 340);
	    verts.get(10).setbools(false, true);
	    verts.get(11).setxy(520,340);
	    verts.get(11).setbools(false, true);
	    verts.get(39).setxy(332, 330);
	    verts.get(39).setbools(true, true);
	    verts.get(40).setxy(520, 330);
	    verts.get(40).setbools(true, true);
	    //departure
	    verts.get(12).setxy(50, 40);
	    verts.get(12).setbools(false, true);
	    verts.get(13).setxy(238,40);
	    verts.get(13).setbools(false, true);
	    verts.get(14).setxy(425, 40);
	    verts.get(14).setbools(false, true);
	    verts.get(15).setxy(613, 40);
	    verts.get(15).setbools(false, true);
	    verts.get(16).setxy(800, 40);
	    verts.get(46).setxy(50, 50);
	    verts.get(46).setbools(false, true);
	    verts.get(47).setxy(238,50);
	    verts.get(47).setbools(false, true);
	    verts.get(48).setxy(425, 50);
	    verts.get(48).setbools(false, true);
	    verts.get(49).setxy(613, 50);
	    verts.get(49).setbools(false, true);
	    verts.get(50).setxy(800, 50);
	    verts.get(50).setbools(false, true);
	    //middle checkin excursions
	    verts.get(17).setxy(144, 460);
	    verts.get(18).setxy(332, 460);
	    verts.get(19).setxy(520, 460);
	    verts.get(20).setxy(703, 460);
	    //side excursions left
	    verts.get(21).setxy(0, 490);
	    verts.get(22).setxy(0, 410);
	    verts.get(23).setxy(55, 350);
	    //side excursions right
	    verts.get(24).setxy(850, 490);
	    verts.get(25).setxy(850, 410);
	    verts.get(26).setxy(795, 350);
	    //main shops left
	    verts.get(27).setxy(80, 100);
	    verts.get(28).setxy(80, 170);
	    verts.get(29).setxy(80, 240);
	    verts.get(30).setxy(320, 100);
	    verts.get(31).setxy(320, 170);
	    verts.get(32).setxy(320, 240);
	    //main shops right
	    verts.get(33).setxy(530, 100);
	    verts.get(34).setxy(530, 170);
	    verts.get(35).setxy(530, 240);
	    verts.get(36).setxy(770, 100);
	    verts.get(37).setxy(770, 170);
	    verts.get(38).setxy(770, 240);



	    //now add all of the edges, there is alot.
	    Line line = new Line();
	    addEdge("V1", 0, 1, 101);
	    addEdge("V4", 1, 0, 101);
	    line = new Line(verts.get(0).getx(), verts.get(0).gety(),   verts.get(1).getx(),   verts.get(1).gety());
	    root.getChildren().addAll(line);
	    addEdge("V2", 0, 5, 121);
	    addEdge("V2", 5, 0, 121);
	    line = new Line(verts.get(0).getx(), verts.get(0).gety(),   verts.get(5).getx(),   verts.get(5).gety());
	    root.getChildren().addAll(line);
	    addEdge("V3", 0, 6, 144);
	    addEdge("V3", 6, 0, 144);
	    line = new Line(verts.get(0).getx(), verts.get(0).gety(),   verts.get(6).getx(),   verts.get(6).gety());
	    root.getChildren().addAll(line);


	    addEdge("V4", 1, 2, 106);
	    addEdge("V4", 2, 1, 106);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(2).getx(),   verts.get(2).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 1, 6, 113);
	    addEdge("V1", 6, 1, 113);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(6).getx(),   verts.get(6).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 1, 7, 134);
	    addEdge("V1", 7, 1, 134);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(7).getx(),   verts.get(7).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 1, 5, 137);
	    addEdge("V4", 5, 1, 137);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(5).getx(),   verts.get(5).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 2, 3, 96);
	    addEdge("V4", 3, 2, 96);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(3).getx(),   verts.get(3).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 2, 7, 112);
	    addEdge("V1", 7, 2, 112);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(7).getx(),   verts.get(7).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 2, 8, 150);
	    addEdge("V1", 8, 2, 150);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(8).getx(),   verts.get(8).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 2, 6, 110);
	    addEdge("V4", 6, 2, 110);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(6).getx(),   verts.get(6).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 3, 4, 101);
	    addEdge("V4", 4, 3, 101);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(4).getx(),   verts.get(4).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 3, 8, 114);
	    addEdge("V1", 8, 3, 114);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(8).getx(),   verts.get(8).gety());
	    root.getChildren().addAll(line);
	    addEdge("V1", 3, 9, 125);
	    addEdge("V1", 9, 3, 125);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(9).getx(),   verts.get(9).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 3, 7, 138);
	    addEdge("V4", 7, 3, 138);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(7).getx(),   verts.get(7).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 4, 9, 90);
	    addEdge("V4", 9, 4, 90);
	    line = new Line(verts.get(4).getx(), verts.get(4).gety(),   verts.get(9).getx(),   verts.get(9).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 4, 8, 112);
	    addEdge("V4", 8, 4, 112);
	    line = new Line(verts.get(4).getx(), verts.get(4).gety(),   verts.get(8).getx(),   verts.get(8).gety());
	    root.getChildren().addAll(line);


	    //check in to security
	    addEdge("V4", 41, 10, 180);
	    addEdge("V4", 10, 41, 180);
	    line = new Line(verts.get(10).getx(), verts.get(10).gety(),   verts.get(41).getx(),   verts.get(41).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 5, 41, 100);
	    addEdge("V4", 41, 5, 100);
	    line = new Line(verts.get(5).getx(), verts.get(5).gety(),   verts.get(41).getx(),   verts.get(41).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 6, 42, 100);
	    addEdge("V4", 42, 6, 100);
	    line = new Line(verts.get(6).getx(), verts.get(6).gety(),   verts.get(42).getx(),   verts.get(42).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 42, 10, 70);
	    addEdge("V4", 10, 42, 100);
	    line = new Line(verts.get(42).getx(), verts.get(42).gety(),   verts.get(10).getx(),   verts.get(10).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 7, 43, 100);
	    addEdge("V4", 43, 7, 100);
	    line = new Line(verts.get(7).getx(), verts.get(7).gety(),   verts.get(43).getx(),   verts.get(43).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 43, 10, 64);
	    addEdge("V4", 10, 43, 64);
	    line = new Line(verts.get(43).getx(), verts.get(43).gety(),   verts.get(10).getx(),   verts.get(10).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 43, 11, 70);
	    addEdge("V4", 11, 43, 70);
	    line = new Line(verts.get(43).getx(), verts.get(43).gety(),   verts.get(11).getx(),   verts.get(11).gety());
	    root.getChildren().addAll(line);


	    addEdge("V4", 8, 44, 100);
	    addEdge("V4", 44, 8, 100);
	    line = new Line(verts.get(8).getx(), verts.get(8).gety(),   verts.get(44).getx(),   verts.get(44).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 44, 11, 86);
	    addEdge("V4", 11, 44, 86);
	    line = new Line(verts.get(44).getx(), verts.get(44).gety(),   verts.get(11).getx(),   verts.get(11).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 9, 45, 100);
	    addEdge("V4", 45, 9, 100);
	    line = new Line(verts.get(9).getx(), verts.get(9).gety(),   verts.get(45).getx(),   verts.get(45).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 45, 11, 135);
	    addEdge("V4", 11, 45, 135);
	    line = new Line(verts.get(45).getx(), verts.get(45).gety(),   verts.get(11).getx(),   verts.get(11).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 39, 46, 276);
	    addEdge("V4", 46, 39, 276);
	    line = new Line(verts.get(39).getx(), verts.get(39).gety(),   verts.get(46).getx(),   verts.get(46).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 39, 47, 240);
	    addEdge("V4", 47, 39, 276);
	    line = new Line(verts.get(39).getx(), verts.get(39).gety(),   verts.get(47).getx(),   verts.get(47).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 39, 48, 254);
	    addEdge("V4", 48, 39, 254);
	    line = new Line(verts.get(39).getx(), verts.get(39).gety(),   verts.get(48).getx(),   verts.get(48).gety());
	    root.getChildren().addAll(line);


	    addEdge("V4", 40, 48, 250);
	    addEdge("V4", 48, 40, 250);
	    line = new Line(verts.get(40).getx(), verts.get(40).gety(),   verts.get(48).getx(),   verts.get(48).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 40, 49, 258);
	    addEdge("V4", 49, 40, 258);
	    line = new Line(verts.get(40).getx(), verts.get(40).gety(),   verts.get(49).getx(),   verts.get(49).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 40, 50, 287);
	    addEdge("V4", 50, 40, 287);
	    line = new Line(verts.get(40).getx(), verts.get(40).gety(),   verts.get(50).getx(),   verts.get(50).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 0, 17, 75);
	    addEdge("V4", 17, 0, 75);
	    line = new Line(verts.get(0).getx(), verts.get(0).gety(),   verts.get(17).getx(),   verts.get(17).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 1, 17, 81);
	    addEdge("V4", 17, 1, 81);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(17).getx(),   verts.get(17).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 5, 17, 64);
	    addEdge("V4", 17, 5, 64);
	    line = new Line(verts.get(5).getx(), verts.get(5).gety(),   verts.get(17).getx(),   verts.get(17).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 6, 17, 70);
	    addEdge("V4", 17, 6, 70);
	    line = new Line(verts.get(6).getx(), verts.get(6).gety(),   verts.get(17).getx(),   verts.get(17).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 1, 18, 84);
	    addEdge("V4", 18, 1, 84);
	    line = new Line(verts.get(1).getx(), verts.get(1).gety(),   verts.get(18).getx(),   verts.get(18).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 2, 18, 66);
	    addEdge("V4", 18, 2, 66);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(18).getx(),   verts.get(18).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 6, 17, 78);
	    addEdge("V4", 17, 6, 78);
	    line = new Line(verts.get(6).getx(), verts.get(6).gety(),   verts.get(18).getx(),   verts.get(18).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 7, 18, 90);
	    addEdge("V4", 18, 7, 90);
	    line = new Line(verts.get(7).getx(), verts.get(7).gety(),   verts.get(18).getx(),   verts.get(18).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 2, 19, 75);
	    addEdge("V4", 19, 2, 75);
	    line = new Line(verts.get(2).getx(), verts.get(2).gety(),   verts.get(19).getx(),   verts.get(19).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 3, 19, 84);
	    addEdge("V4", 19, 3, 84);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(19).getx(),   verts.get(19).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 7, 19, 86);
	    addEdge("V4", 19, 7, 86);
	    line = new Line(verts.get(7).getx(), verts.get(7).gety(),   verts.get(19).getx(),   verts.get(19).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 8, 19, 68);
	    addEdge("V4", 19, 8, 68);
	    line = new Line(verts.get(8).getx(), verts.get(8).gety(),   verts.get(19).getx(),   verts.get(19).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 3, 20, 79);
	    addEdge("V4", 20, 3, 79);
	    line = new Line(verts.get(3).getx(), verts.get(3).gety(),   verts.get(20).getx(),   verts.get(20).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 4, 20, 86);
	    addEdge("V4", 20, 4, 86);
	    line = new Line(verts.get(4).getx(), verts.get(4).gety(),   verts.get(20).getx(),   verts.get(20).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 8, 20, 78);
	    addEdge("V4", 20, 8, 78);
	    line = new Line(verts.get(8).getx(), verts.get(8).gety(),   verts.get(20).getx(),   verts.get(20).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 9, 20, 85);
	    addEdge("V4", 20, 9, 85);
	    line = new Line(verts.get(9).getx(), verts.get(9).gety(),   verts.get(20).getx(),   verts.get(20).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 0, 21, 70);
	    addEdge("V4", 21, 0, 70);
	    line = new Line(verts.get(0).getx(), verts.get(0).gety(),   verts.get(21).getx(),   verts.get(21).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 17, 21, 120);
	    addEdge("V4", 21, 17, 120);
	    line = new Line(verts.get(17).getx(), verts.get(17).gety(),   verts.get(21).getx(),   verts.get(21).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 5, 21, 54);
	    addEdge("V4", 21, 5, 54);
	    line = new Line(verts.get(5).getx(), verts.get(5).gety(),   verts.get(21).getx(),   verts.get(21).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 21, 22, 53);
	    addEdge("V4", 22, 21, 53);
	    line = new Line(verts.get(21).getx(), verts.get(21).gety(),   verts.get(22).getx(),   verts.get(22).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 5, 22, 58);
	    addEdge("V4", 22, 5, 58);
	    line = new Line(verts.get(5).getx(), verts.get(5).gety(),   verts.get(22).getx(),   verts.get(22).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 23, 22, 64);
	    addEdge("V4", 22, 23, 64);
	    line = new Line(verts.get(23).getx(), verts.get(23).gety(),   verts.get(22).getx(),   verts.get(22).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 23, 5, 50);
	    addEdge("V4", 5, 23, 50);
	    line = new Line(verts.get(23).getx(), verts.get(23).gety(),   verts.get(5).getx(),   verts.get(5).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 23, 17, 104);
	    addEdge("V4", 17, 23, 104);
	    line = new Line(verts.get(23).getx(), verts.get(23).gety(),   verts.get(17).getx(),   verts.get(17).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 23, 6, 84);
	    addEdge("V4", 6, 23, 84);
	    line = new Line(verts.get(23).getx(), verts.get(23).gety(),   verts.get(6).getx(),   verts.get(6).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 4, 24, 60);
	    addEdge("V4", 24, 4, 60);
	    line = new Line(verts.get(4).getx(), verts.get(4).gety(),   verts.get(24).getx(),   verts.get(24).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 20, 24, 96);
	    addEdge("V4", 24, 20, 96);
	    line = new Line(verts.get(20).getx(), verts.get(20).gety(),   verts.get(24).getx(),   verts.get(24).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 25, 24, 56);
	    addEdge("V4", 24, 25, 56);
	    line = new Line(verts.get(25).getx(), verts.get(25).gety(),   verts.get(24).getx(),   verts.get(24).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 25, 9, 43);
	    addEdge("V4", 9, 25, 43);
	    line = new Line(verts.get(25).getx(), verts.get(25).gety(),   verts.get(9).getx(),   verts.get(9).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 25, 26, 58);
	    addEdge("V4", 26, 25, 58);
	    line = new Line(verts.get(25).getx(), verts.get(25).gety(),   verts.get(26).getx(),   verts.get(26).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 9, 26, 54);
	    addEdge("V4", 26, 9, 54);
	    line = new Line(verts.get(9).getx(), verts.get(9).gety(),   verts.get(26).getx(),   verts.get(26).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 20, 26, 97);
	    addEdge("V4", 26, 20, 97);
	    line = new Line(verts.get(20).getx(), verts.get(20).gety(),   verts.get(26).getx(),   verts.get(26).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 8, 26, 134);
	    addEdge("V4", 26, 8, 134);
	    line = new Line(verts.get(8).getx(), verts.get(8).gety(),   verts.get(26).getx(),   verts.get(26).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 10, 39, 100);
	    addEdge("V4", 39, 10, 100);
	    line = new Line(verts.get(10).getx(), verts.get(10).gety(),   verts.get(39).getx(),   verts.get(39).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 39, 29, 124);
	    addEdge("V4", 29, 39, 124);
	    line = new Line(verts.get(39).getx(), verts.get(39).gety(),   verts.get(29).getx(),   verts.get(29).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 39, 32, 94);
	    addEdge("V4", 32, 39, 94);

	    line = new Line(verts.get(39).getx(), verts.get(39).gety(),   verts.get(32).getx(),   verts.get(32).gety());

	    root.getChildren().addAll(line);

	    addEdge("V4", 11, 40, 100);
	    addEdge("V4", 40, 11, 100);
	    line = new Line(verts.get(11).getx(), verts.get(11).gety(),   verts.get(40).getx(),   verts.get(40).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 40, 35, 87);
	    addEdge("V4", 35, 40, 87);
	    line = new Line(verts.get(40).getx(), verts.get(40).gety(),   verts.get(35).getx(),   verts.get(35).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 40, 38, 134);
	    addEdge("V4", 38, 40, 100);
	    line = new Line(verts.get(40).getx(), verts.get(40).gety(),   verts.get(38).getx(),   verts.get(38).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 29, 32, 124);
	    addEdge("V4", 32, 29, 124);
	    line = new Line(verts.get(29).getx(), verts.get(29).gety(),   verts.get(32).getx(),   verts.get(32).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 29, 28, 120);
	    addEdge("V4", 28, 29, 120);
	    line = new Line(verts.get(29).getx(), verts.get(29).gety(),   verts.get(28).getx(),   verts.get(28).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 29, 31, 134);
	    addEdge("V4", 31, 29, 134);
	    line = new Line(verts.get(29).getx(), verts.get(29).gety(),   verts.get(31).getx(),   verts.get(31).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 28, 31, 124);
	    addEdge("V4", 31, 28, 124);
	    line = new Line(verts.get(28).getx(), verts.get(28).gety(),   verts.get(31).getx(),   verts.get(31).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 28, 32, 125);
	    addEdge("V4", 32, 28, 125);
	    line = new Line(verts.get(28).getx(), verts.get(28).gety(),   verts.get(32).getx(),   verts.get(32).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 28, 30, 124);
	    addEdge("V4", 30, 28, 124);
	    line = new Line(verts.get(28).getx(), verts.get(28).gety(),   verts.get(30).getx(),   verts.get(30).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 28, 27, 114);
	    addEdge("V4", 27, 28, 114);
	    line = new Line(verts.get(28).getx(), verts.get(28).gety(),   verts.get(27).getx(),   verts.get(27).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 27, 30, 143);
	    addEdge("V4", 30, 27, 143);
	    line = new Line(verts.get(27).getx(), verts.get(27).gety(),   verts.get(30).getx(),   verts.get(30).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 27, 31, 134);
	    addEdge("V4", 31, 27, 134);
	    line = new Line(verts.get(27).getx(), verts.get(27).gety(),   verts.get(31).getx(),   verts.get(31).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 27, 46, 43);
	    addEdge("V4", 46, 27, 43);
	    line = new Line(verts.get(27).getx(), verts.get(27).gety(),   verts.get(46).getx(),   verts.get(46).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 27, 47, 90);
	    addEdge("V4", 47, 27, 90);
	    line = new Line(verts.get(27).getx(), verts.get(27).gety(),   verts.get(47).getx(),   verts.get(47).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 32, 34, 133);
	    addEdge("V4", 34, 32, 133);
	    line = new Line(verts.get(32).getx(), verts.get(32).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 32, 35, 123);
	    addEdge("V4", 35, 32, 123);
	    line = new Line(verts.get(32).getx(), verts.get(32).gety(),   verts.get(35).getx(),   verts.get(35).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 32, 31, 121);
	    addEdge("V4", 31, 32, 121);
	    line = new Line(verts.get(32).getx(), verts.get(32).gety(),   verts.get(31).getx(),   verts.get(31).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 31, 35, 143);
	    addEdge("V4", 35, 31, 143);
	    line = new Line(verts.get(31).getx(), verts.get(31).gety(),   verts.get(35).getx(),   verts.get(35).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 31, 34, 126);
	    addEdge("V4", 34, 31, 126);
	    line = new Line(verts.get(31).getx(), verts.get(31).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 31, 33, 114);
	    addEdge("V4", 33, 31, 114);
	    line = new Line(verts.get(31).getx(), verts.get(31).gety(),   verts.get(33).getx(),   verts.get(33).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 31, 30, 64);
	    addEdge("V4", 30, 31, 64);
	    line = new Line(verts.get(31).getx(), verts.get(31).gety(),   verts.get(30).getx(),   verts.get(30).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 30, 34, 114);
	    addEdge("V4", 34, 30, 114);
	    line = new Line(verts.get(34).getx(), verts.get(34).gety(),   verts.get(30).getx(),   verts.get(30).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 30, 33, 144);
	    addEdge("V4", 33, 30, 144);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(30).getx(),   verts.get(30).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 30, 47, 32);
	    addEdge("V4", 47, 30, 32);
	    line = new Line(verts.get(30).getx(), verts.get(30).gety(),   verts.get(47).getx(),   verts.get(47).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 30, 48, 44);
	    addEdge("V4", 48, 30, 44);
	    line = new Line(verts.get(30).getx(), verts.get(30).gety(),   verts.get(48).getx(),   verts.get(48).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 35, 38, 154);
	    addEdge("V4", 38, 35, 154);
	    line = new Line(verts.get(35).getx(), verts.get(35).gety(),   verts.get(38).getx(),   verts.get(38).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 35, 37, 124);
	    addEdge("V4", 37, 35, 124);
	    line = new Line(verts.get(35).getx(), verts.get(35).gety(),   verts.get(37).getx(),   verts.get(37).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 35, 34, 94);
	    addEdge("V4", 34, 35, 94);
	    line = new Line(verts.get(35).getx(), verts.get(35).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 38, 34, 114);
	    addEdge("V4", 34, 38, 114);
	    line = new Line(verts.get(38).getx(), verts.get(38).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 37, 34, 144);
	    addEdge("V4", 34, 37, 144);
	    line = new Line(verts.get(37).getx(), verts.get(37).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 36, 34, 110);
	    addEdge("V4", 34, 36, 110);
	    line = new Line(verts.get(36).getx(), verts.get(36).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 33, 34, 76);
	    addEdge("V4", 34, 33, 76);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(34).getx(),   verts.get(34).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 33, 37, 153);
	    addEdge("V4", 37, 33, 153);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(37).getx(),   verts.get(37).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 33, 36, 122);
	    addEdge("V4", 36, 33, 122);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(36).getx(),   verts.get(36).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 33, 48, 39);
	    addEdge("V4", 48, 33, 39);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(48).getx(),   verts.get(48).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 33, 49, 45);
	    addEdge("V4", 49, 33, 45);
	    line = new Line(verts.get(33).getx(), verts.get(33).gety(),   verts.get(49).getx(),   verts.get(49).gety());
	    root.getChildren().addAll(line);

	    addEdge("V4", 38, 37, 111);
	    addEdge("V4", 37, 38, 111);
	    line = new Line(verts.get(37).getx(), verts.get(37).gety(),   verts.get(38).getx(),   verts.get(38).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 37, 36, 135);
	    addEdge("V4", 36, 37, 134);
	    line = new Line(verts.get(36).getx(), verts.get(36).gety(),   verts.get(37).getx(),   verts.get(37).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 36, 50, 56);
	    addEdge("V4", 50, 36, 56);
	    line = new Line(verts.get(36).getx(), verts.get(36).gety(),   verts.get(50).getx(),   verts.get(50).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 36, 49, 78);
	    addEdge("V4", 49, 36, 78);
	    line = new Line(verts.get(36).getx(), verts.get(36).gety(),   verts.get(49).getx(),   verts.get(49).gety());
	    root.getChildren().addAll(line);
	    addEdge("V4", 46, 12, 100);
	    addEdge("V4", 12, 46, 100);
	    addEdge("V4", 47, 13, 100);
	    addEdge("V4", 13, 47, 100);
	    addEdge("V4", 48, 14, 100);
	    addEdge("V4", 14, 48, 100);
	    addEdge("V4", 49, 15, 100);
	    addEdge("V4", 15, 49, 100);
	    addEdge("V4", 16, 50, 100);
	    addEdge("V4", 50, 16, 100);
	}

	  //method creates an Edge object with the specified source
	  //and location vertexes and adds to the list of edges
	  private void addEdge(String Id, int sourceLocNo, int destLocNo,
		      int duration) {
		    Edge edge = new Edge(Id,verts.get(sourceLocNo), verts.get(destLocNo), duration);
		    edges.add(edge);
	  }


}
