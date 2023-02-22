package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	public void settings() {
		size(1000, 1000);
	}

	public void setup() {

		colorMode(HSB);

		background(255,255,0);
	}



	public void keyPressed() {
		
		mode = key - '0';
		println(mode);

	}

	public void draw() {
		background(0);
		fill(255);
		noStroke();

		switch (mode) {
			case 1:

			if(mouseX >500){

				fill(0,50,255);
				rect(500,0,500,1000);

			}
			if(mouseX <500){

				fill(0,50,255);
				rect(0,0,500,1000);

			}

				break;
			case 2:

				int recam = 1000 / 200;

				int i = 0;

				float recpos = 0;

				float col = 0;

				while(i <= recam){

					fill(col, 255,255);
					rect(recpos,0,1000,2000);

					i++;
					col = col + 20;
					recpos = recpos + 200;

					if(recpos >= 1000){
						recpos = 0;
					}


				}

			default:
				break;
		}
		
		
		

	}
}



