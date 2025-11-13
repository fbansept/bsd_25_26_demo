package ui;

import java.awt.*;

public class Cercle extends Sprite {
    
    protected int diametre;
    
    public Cercle(int x, int y, int diametre, Color couleur) {
        super(x, y, couleur);
        this.diametre = diametre;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        //afficher le rond
        dessin.setColor(couleur);
        dessin.fillOval(x, y,diametre,diametre);
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
