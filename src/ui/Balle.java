package ui;

import java.awt.*;

public class Balle {

    private int x;
    private int y;
    private int vitesseX;
    private int vitesseY;
    private int diametre;
    private Color couleur = Color.BLUE;

    public Balle(int x, int y, int vitesseX, int vitesseY, int diametre, Color couleur) {
        this.x = x;
        this.y = y;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.diametre = diametre;
        this.couleur = couleur;
    }

    public Balle() {
        this.diametre = (int)(Math.random() * 40) + 10;
        this.x = (int)(Math.random() * (CasseBrique.LARGEUR - this.diametre * 2)) + this.diametre;
        this.y = (int)(Math.random() * (CasseBrique.HAUTEUR - this.diametre * 2)) + this.diametre;
        this.vitesseX = (int)(Math.random() * 10) - 5;
        this.vitesseY = (int)(Math.random() * 10) - 5;

        this.vitesseX = vitesseX == 0 ? -1 : vitesseX;
        this.vitesseY = vitesseY == 0 ? -1 : vitesseY;

        this.couleur = new Color(
                (int)(Math.random() * 210) + 20,
                (int)(Math.random() * 210) + 20,
                (int)(Math.random() * 210) + 20);
    }

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

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
