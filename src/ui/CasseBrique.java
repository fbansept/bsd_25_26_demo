package ui;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    public static final int LARGEUR = 1900;
    public static final int HAUTEUR = 1500;

    private final int decalageVerticalBarreDefilement = 35;
    private final int decalageHorizontalBarreDefilement = 15;

    public CasseBrique()  {

        JFrame frame = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0, 0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        frame.pack();
        frame.setSize(
                LARGEUR + decalageHorizontalBarreDefilement,
                HAUTEUR + decalageVerticalBarreDefilement);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.requestFocus();

        Container panneau = frame.getContentPane();
        panneau.add(this);

        frame.setVisible(true);
        this.createBufferStrategy(2);

        demarrer();
    }

    public void demarrer(){

        try {

//            Balle balle = new Balle(
//                    LARGEUR / 2,
//                    HAUTEUR / 2,
//                    3,
//                    2,
//                    50,
//                    Color.GREEN);

            Balle[] listeBalle = new Balle[5000];

            for(int i = 0; i<5000; i++){
                listeBalle[i] = new Balle();
            }

            while (true) {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                //debut affichage

                //afficher background
                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                for(Balle balle : listeBalle) {
                    balle.deplacer();
                    balle.dessiner(dessin);
                }


                //fin affichage
                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60);
            }
        } catch (InterruptedException e) {
            System.out.println("Le programme s'est arrêté");
        }

    }

}
