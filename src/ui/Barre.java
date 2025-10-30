package ui;

import java.awt.*;

public class Barre extends Rectangle {

    private int largeur;
    private int hauteur;
    private int vitesse;

    public Barre(int x, int y, int largeur, int hauteur, Color couleur, int vitesse) {
        super(x, y, largeur, hauteur, couleur);
        this.vitesse = vitesse;
    }

    public void deplacementGauche() {
        x -= vitesse;

        if(x < 0) {
            x = 0;
        }

       // x = Math.max(0 , x - vitesse);
    }

    public void deplacementDroite() {

        x += vitesse;

        if(x > CasseBrique.LARGEUR - largeur) {
            x = CasseBrique.LARGEUR - largeur;
        }

        //x = Math.min(x + vitesse, CasseBrique.LARGEUR - largeur);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
