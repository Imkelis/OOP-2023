package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float smoothedAmplitude = 0;

    Circle[] circles;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings()
    {
        size(1024, 1000, P3D);
    }

    public void setup()
    {
        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        circles = new Circle[50];
        for (int i = 0; i < circles.length; i++) {
            float x = random(width);
            float y = random(height);
            float size = random(20, 50);
            circles[i] = new Circle(x, y, size);
        }
    }

    public void draw()
    {
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        // Calculate sum and average of the samples
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        switch (mode) {
            case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);
                }
                break;
            case 1:
                background(0);
                for (Circle circle : circles) {
                    circle.update(smoothedAmplitude);
                    circle.display(smoothedAmplitude);
                }
                break;
        }
    }

    class Circle {
        float x;
        float y;
        float size;
        float angle;

        Circle(float x, float y, float size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.angle = random(TWO_PI);
        }

        void update(float amplitude) {
            float speed = map(amplitude, 0, 1, 0, 5);
            angle += speed;
        }

        void display(float amplitude) {
            float hue = map(amplitude, 0, 1, 0, 255);
            fill(hue, 255, 255);
            noStroke();
            float d = size + map(sin(angle), -1, 1, -10, 10);
            ellipse(x, y, d, d);

    } 
}
}       
