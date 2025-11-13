package ui;

public class Collision {
    
    public static boolean test (Cercle cercle, Rectangle rectangle) {
        int centreX = cercle.getX() + cercle.getDiametre() / 2;
        int centreY = cercle.getY() + cercle.getDiametre() / 2;

        //si il y a collision
        return centreX > rectangle.getX()
                && centreX < rectangle.getX() + rectangle.getLargeur()
                && centreY > rectangle.getY()
                && centreY < rectangle.getY() + rectangle.getHauteur(); 
    }
}
