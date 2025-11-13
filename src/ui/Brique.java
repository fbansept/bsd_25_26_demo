package ui;

import java.awt.*;

public class Brique extends Rectangle {

    protected int pointVie = 3;

    public Brique(int x, int y, int largeur, int hauteur, Color couleur) {
        super(x, y, largeur, hauteur, couleur);
    }

    public void collision() {
        pointVie --;
        couleur = couleur.darker();
    }

    public int getPointVie() {
        return pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }
}
