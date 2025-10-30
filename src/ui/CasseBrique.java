package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 300;
    public static final int HAUTEUR = 500;

    private final int decalageVerticalBarreDefilement = 35;
    private final int decalageHorizontalBarreDefilement = 15;

    private Barre barre;
    private Balle[] listeBalle = new Balle[1];
    
    // délarer un tableau de 24 briques

    private boolean toucheGauche = false;
    private boolean toucheDroite = false;

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

       // document.addEventistener("mousedown", Fonction)

        frame.addKeyListener(this);

        Container panneau = frame.getContentPane();
        panneau.add(this);

        frame.setVisible(true);
        this.createBufferStrategy(2);

        demarrer();
    }

    public void demarrer(){

        // initialise la liste de briques 4 lignes sur 6 colonnes
        
        try {

            listeBalle[0] = new Balle(LARGEUR / 2, HAUTEUR / 2, 1 , 4, 30, Color.RED);

            barre = new Barre(
                    LARGEUR / 2 - 50, 
                    HAUTEUR - 100, 
                    100, 
                    30, 
                    Color.BLUE,
                    5);

            while (true) {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();


                //---background----
                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                //---barre---
                if(toucheGauche){
                    barre.deplacementGauche();
                } else if(toucheDroite) {
                    barre.deplacementDroite();
                }

                barre.dessiner(dessin);

                //---balle---
                for(Balle balle : listeBalle) {
                    balle.deplacer();
                    balle.dessiner(dessin);
                    balle.testCollision(barre);
                }
                
                //on affiche les briques et on test leur collision

                //fin affichage
                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60);
            }
        } catch (InterruptedException e) {
            System.out.println("Le programme s'est arrêté");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            toucheGauche = true;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            toucheDroite = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            toucheGauche = false;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            toucheDroite = false;
        }
    }

}
