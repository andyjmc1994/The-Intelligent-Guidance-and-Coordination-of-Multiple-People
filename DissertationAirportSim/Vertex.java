import java.util.Arrays;

/**
 * Created by andy on 15/02/2016.
 */

//Defines an Vertex of a weighted graph.
public class Vertex {

	//values that store the vertexes name, as well as its x and y coordinates used simply for drawing onto the screen.
    final private String name;
    private int x = 0;
    private int y = 0;

    private boolean bottleneck;
    private boolean service;
    private double lasttimeblockcount = 0;
    public double timeblockcount = 0;
    public boolean[] timeblock;



    //simply takes a name when each vertex is initialized
    public Vertex(String name) {
        this.name = name;

    }

    public void setbools(boolean bottleneck, boolean service) {
    	this.bottleneck = bottleneck;
    	if (bottleneck){
    		timeblock =  new boolean[20];
    		Arrays.fill(timeblock, Boolean.FALSE);
    	}
    	this.service = service;
    }

    public boolean isBottleN() {
    	return bottleneck;
    }

    public boolean isService() {
    	return service;
    }



    //functions to set the x and y values used for drawing to the screen
    public void setxy(int xcoord, int ycoord) {
    	x = xcoord;
    	y = ycoord;
    }

    //functions to return the vertexes values. name and location.
    public String getName() {
        return name;
    }
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }


    public boolean isAvailable(int time) {
    	double temptime = timeblockcount + time;
    	if (temptime > 500){
    		temptime = temptime - 500;
    	}
    	if (temptime > 0 && temptime <= 25 ){
    		return check(0);
    	}
    	else if (temptime > 25 && temptime <= 50 ){
    		return check(1);
    	}
    	else if (temptime > 50 && temptime <= 75 ){
    		return check(2);
    		}

    	else if (temptime > 75 && temptime <= 100 ){
    		return check(3);
    		}
    	else if (temptime > 100 && temptime <= 125 ){
    		return check(4);
    		}
    	else if (temptime > 125 && temptime <= 150 ){
    		return check(5);
    		}
    	else if (temptime > 150 && temptime <= 175 ){
    		return check(6);
    		}
    	else if (temptime > 175 && temptime <= 200 ){
    		return check(7);
    		}
    	else if (temptime > 200 && temptime <= 225 ){
    		return check(8);
    		}
    	else if (temptime > 225 && temptime <= 250 ){
    		return check(9);
    		}
    	else if (temptime > 250 && temptime <= 275 ){
    		return check(10);
    		}
    	else if (temptime > 275 && temptime <= 300 ){
    		return check(11);
    		}
    	else if (temptime > 300 && temptime <= 325 ){
    		return check(12);
    		}
    	else if (temptime > 325 && temptime <= 350 ){
    		return check(13);
    		}
    	else if (temptime > 350 && temptime <= 375 ){
    		return check(14);
    		}
    	else if (temptime > 375 && temptime <= 400 ){
    		return check(15);
    		}
    	else if (temptime > 400 && temptime <= 425 ){
    		return check(16);
    		}
    	else if (temptime > 425 && temptime <= 450 ){
    		return check(17);
    		}
    	else if (temptime > 450 && temptime <= 475 ){
    		return check(18);
    		}
    	else if (temptime > 475 && temptime <= 500 ){
    		return check(19);
    		}

    	return true;
    }

    public boolean check(int x){
    	if (timeblock[x]){
			return false;
		}
		else{
			timeblock[x] = true;
			return true;
		}
    }

    public void updatetimeblock(double x) {
    	double increase = x - lasttimeblockcount;
    	timeblockcount = timeblockcount+increase;
    	lasttimeblockcount = x;
    	if (timeblockcount > 500){
    		timeblockcount = timeblockcount - 500;
    	}
    	if (x > 0 && x <= 25 ){
    		timeblock[19] = false;
    	}
    	else if (x > 25 && x <= 50 ){
    		timeblock[0] = false;
    	}
    	else if (x > 50 && x <= 75 ){
    		timeblock[1] = false;
    		}
    	else if (x > 75 && x <= 100 ){
    		timeblock[2] = false;
    		}
    	else if (x > 100 && x <= 125 ){
    		timeblock[3] = false;
    		}
    	else if (x > 125 && x <= 150 ){
    		timeblock[4] = false;
    		}
    	else if (x > 150 && x <= 175 ){
    		timeblock[5] = false;
    		}
    	else if (x > 175 && x <= 200 ){
    		timeblock[6] = false;
    		}
    	else if (x > 200 && x <= 225 ){
    		timeblock[7] = false;
    		}
    	else if (x > 225 && x <= 250 ){
    		timeblock[8] = false;
    		}
    	else if (x > 250 && x <= 275 ){
    		timeblock[9] = false;
    		}
    	else if (x > 275 && x <= 300 ){
    		timeblock[10] = false;
    		}
    	else if (x > 300 && x <= 325 ){
    		timeblock[11] = false;
    		}
    	else if (x > 325 && x <= 350 ){
    		timeblock[12] = false;
    		}
    	else if (x > 350 && x <= 375 ){
    		timeblock[13] = false;
    		}
    	else if (x > 375 && x <= 400 ){
    		timeblock[14] = false;
    		}
    	else if (x > 400 && x <= 425 ){
    		timeblock[15] = false;
    		}
    	else if (x > 425 && x <= 450 ){
    		timeblock[16] = false;
    		}
    	else if (x > 450 && x <= 475 ){
    		timeblock[17] = false;
    		}
    	else if (x > 475 && x <= 500 ){
    		timeblock[18] = false;
    		}
    }




}