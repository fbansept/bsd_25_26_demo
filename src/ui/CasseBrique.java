package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 360;
    public static final int HAUTEUR = 500;

    private final int decalageVerticalBarreDefilement = 35;
    private final int decalageHorizontalBarreDefilement = 15;

    private Barre barre;
    private Balle[] listeBalle = new Balle[1];
    private Brique[] listeBrique = new Brique[24];

    private ArrayList<Bonus> listeBonus = new ArrayList<>();
    
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

        int largeurBrique = 50;
        int hauteurBrique = 30;
        int marge = 8;
        int indexBrique = 0;

        for(int indexColonne = 0 ; indexColonne < 6; indexColonne ++) {

            for(int indexLigne = 0 ; indexLigne < 4; indexLigne ++) {

                listeBrique[indexBrique] = new Brique(
                        marge + (marge + largeurBrique) * indexColonne,
                        marge + (marge + hauteurBrique) * indexLigne,
                        largeurBrique,
                        hauteurBrique,
                        Color.GREEN);

                indexBrique ++;
            }
        }

        
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

                    //on test la collision avec chaque brique
                    for(Brique brique : listeBrique) {
                        //si il y a une collision avec la brique et que ses PV
                        //sont passé à 0, alors on ajoute un bonus
                        if(balle.testCollision(brique) && brique.getPointVie() == 0) {
                            listeBonus.add(new Bonus(brique.getX(), brique.getY()));
                        }
                    }
                }


//                - quand un bonus apparait il peut etre de 2 types (50 /50)
//                - soit il est orange et augmenta la taille de la barre bleue
//                - soit il est rose et il ajoute une nouvelle balle
//
//                - modifier au préalable le tableau de balle pour un ArrayList
//
//                - pour les + motivé : quand la balle touche le bas de l'ecran elle revient
//                  sur la barre, et si elle touche 3 fois, recommencer à zero


                //pour eviter de supprimer un element de la liste que l'on parcours
                //on créait une liste vide qui contiendra les éléments a supprimer
                //dés que l'on aura fini de la parcourir
                ArrayList<Bonus> listeBonusAsupprimer = new ArrayList<>();

                //on affiche les bonus
                for(Bonus bonus : listeBonus) {
                    bonus.deplacer();

                    if(Collision.test(bonus, barre)){
                        barre.setLargeur(barre.getLargeur() + 10);
                        listeBonusAsupprimer.add(bonus);
                    }
                    
                    bonus.dessiner(dessin);
                }

                listeBonus.removeAll(listeBonusAsupprimer);

                //on affiche les brique uniquement si elles ont encore de PV
                for(Brique brique : listeBrique) {
                    if(brique.getPointVie() > 0) {
                        brique.dessiner(dessin);
                    }
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
