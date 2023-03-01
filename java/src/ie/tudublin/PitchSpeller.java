package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class PitchSpeller extends PApplet{




    public String spell(float frequency)
    {
        float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f,
            659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
        String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};
    
        int closestIndex = 0;
        float closestDiff = abs(frequency - frequencies[0]);
    
        // Find the index of the closest frequency
        for (int i = 1; i < frequencies.length; i++) {
            float diff = abs(frequency - frequencies[i]);
            if (diff < closestDiff) {
                closestIndex = i;
                closestDiff = diff;
            }
        }
    
        // Return the spelling of the closest frequency
        return spellings[closestIndex];
    }


}