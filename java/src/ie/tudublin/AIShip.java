package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;


public class AIShip extends Ship {
    private ArrayList<PVector> path;
    private int currentPointIndex;

    public AIShip(float x, float y, float size, int c, PApplet p, ArrayList<PVector> path) {
        super(x, y, size, c, p);
        this.path = path;
        this.currentPointIndex = 0;
    }

    public void move() {
        if (path.size() > 0) {
            PVector currentPoint = path.get(currentPointIndex);
            float dx = currentPoint.x - pos.x;
            float dy = currentPoint.y - pos.y;
            float distanceToCurrentPoint = PApplet.sqrt(dx * dx + dy * dy);

            if (distanceToCurrentPoint < 5) {
                // switch to the next point in the path
                currentPointIndex = (currentPointIndex + 1) % path.size();
            } else {
                // move towards the current point
                float angle = PApplet.atan2(dy, dx);
                rot = angle;
                pos.x += forward.x;
                pos.y += forward.y;
            }
        }
    }
}