package ui;

import java.awt.*;

public class Balle extends Sprite {

    private int vitesseX;
    private int vitesseY;
    private int diametre;


    public Balle(int x, int y, int vitesseX, int vitesseY, int diametre, Color couleur) {
        super(x, y, couleur);
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.diametre = diametre;
    }

//    public Balle() {
//        this.diametre = (int)(Math.random() * 40) + 10;
//        this.x = (int)(Math.random() * (CasseBrique.LARGEUR - this.diametre * 2)) + this.diametre;
//        this.y = (int)(Math.random() * (CasseBrique.HAUTEUR - this.diametre * 2)) + this.diametre;
//        this.vitesseX = (int)(Math.random() * 10) - 5;
//        this.vitesseY = (int)(Math.random() * 10) - 5;
//
//        this.vitesseX = vitesseX == 0 ? -1 : vitesseX;
//        this.vitesseY = vitesseY == 0 ? -1 : vitesseY;
//
//        this.couleur = new Color(
//                (int)(Math.random() * 210) + 20,
//                (int)(Math.random() * 210) + 20,
//                (int)(Math.random() * 210) + 20);
//    }

    public void deplacer() {
        if(x >= CasseBrique.LARGEUR - diametre || x <= 0) {
            vitesseX = -vitesseX;
        }

        if(y >= CasseBrique.HAUTEUR - diametre || y <= 0) {
            vitesseY = -vitesseY;
        }

        x += vitesseX;
        y += vitesseY;
    }

    public void dessiner(Graphics2D dessin) {
        //afficher le rond
        dessin.setColor(couleur);
        dessin.fillOval(x, y,diametre,diametre);

    }

    public void testCollision(Rectangle cible) {
        int centreX = x + diametre / 2;
        int centreY = y + diametre / 2;

        //si il y a collision
        if(centreX > cible.getX()
                && centreX < cible.getX() + cible.getLargeur()
                && centreY > cible.getY()
                && centreY < cible.getY() + cible.getHauteur()) {

            //on test si c'est une barre ou une brique
            if(cible instanceof Barre) {
                //On rend negative la vitesse vertical (pour faire remonter la balle)
                vitesseY = -Math.abs(vitesseY);
            } else {
                Brique brique = (Brique) cible;
                
                if(brique.getPointVie() > 0) {
                    brique.collision();
                    vitesseY = -vitesseY;
                }
            }
        }
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }


}
