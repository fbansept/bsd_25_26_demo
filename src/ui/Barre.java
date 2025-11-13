package ui;

import java.awt.*;

public class Barre extends Rectangle {

//    private int largeur;
//    private int hauteur;
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

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
}
