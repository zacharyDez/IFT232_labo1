package labo1;

import java.awt.*;
import java.util.Scanner;

public class Point extends Dessin {

    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    /*
     * Fonction qui dessine le point sur la surface 2D.
     */

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void dessiner(Graphics2D graph) {
        int x_dist = 20;
        int y_dist = 20;
        graph.drawLine(x - x_dist, y + y_dist, x + x_dist, y - y_dist);
        graph.drawLine(x - x_dist, y - y_dist, x + x_dist, y + y_dist);
    }

    /*
     * Fonction qui obtient les coordonn�es du point
     * � partir d'un flot d'entiers
     */
    @Override
    public void lire(Scanner reader) {
        x = reader.nextInt();
        y = reader.nextInt();
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // pour override, doit caster objet en type comparer
    @Override
    public boolean equals(Object o) {
        // si object comparer avec lui-meme, retourner vrai
        if (o == this) {
            return true;
        }

        // verifier si l'objet est de type point
        if (!(o instanceof Point)) {
            return false;
        }

        // cast objet a Point
        Point p = (Point) o;

        // verifier coordonnees des deux objets
        if ((x == p.x) && (y == p.y)) {
            return true;
        }

        return false;
    }

}