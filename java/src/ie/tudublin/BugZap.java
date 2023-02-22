package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX = 5;
	float playerY = 5;
	float playerWidth = 10;

	public void settings()
	{
		size(1000, 800);
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 255, 255);

	}

	void drawPlayer(float x, float y, float w){

		fill(0, 0, 0);
		stroke(50,50,80);
		rect(500, 400, 15, 50);
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}

	public void draw()
	{	
		background(255, 255, 255);
		drawPlayer(1000,1000,600);
	}

}
