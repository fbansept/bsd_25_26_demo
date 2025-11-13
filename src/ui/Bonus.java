package ui;

import java.awt.*;

public class Bonus extends Cercle {

    public Bonus(int x, int y) {
        super(x, y, 10, Color.ORANGE);
    }

    public void deplacer(){
        y += 5;
    }
    
}
