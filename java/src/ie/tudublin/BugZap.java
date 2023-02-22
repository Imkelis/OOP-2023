package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(255,mouseX,0);

	
		
	}

	
	public void draw()
	{	
		fill(500, 200, 0);
		noStroke();
		circle(255, 330, 400);

		fill(0, 50, 200);
		ellipse(255, 255, 500, mouseX);

		

	}

}
