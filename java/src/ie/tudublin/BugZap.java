package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX = 500;
	float playerY = 400;
	float playerWidth = 15;
	float playerHeight = 50;

	public void settings()
	{
		size(1000, 800);
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 255, 255);

	}

	void drawPlayer(float x, float y, float w, float h){

		fill(0, 0, 0);
		stroke(50,50,80);
		rect(x, y, w, h);
	}

	public void keyPressed()
	{

		float lp = 1;

		if (keyCode == LEFT)
		{
				lp = 2;
				if (playerX >= 15){
				playerX = playerX - 20;
				}
		}
		if (keyCode == RIGHT)
		{
			lp = 1;
			if (playerX <= 975){
				playerX = playerX + 20;
				}
			}
		if (key == ' ')
		{
			if(lp == 1){
			line(playerX, playerY, playerX - 220, 400);
			}

			if(lp == 2){
				line(playerX, playerY, playerX + 220, 400);
				}
		}
	}

	public void draw()
	{	
		background(255, 255, 255);
		drawPlayer(playerX, playerY, playerWidth, playerHeight);
	}

}
