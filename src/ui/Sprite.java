package ui;

import java.awt.*;

public abstract class Sprite {
    protected int x;
    protected int y;
    protected Color couleur;
    
    public Sprite(Color couleur) {
        x = 0;
        y = 0;
        this.couleur = couleur;
    }

    public Sprite(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }

    public abstract void dessiner(Graphics2D dessin);
    
    
    
}
