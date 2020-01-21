package labo1;

import java.awt.*;
import java.util.Scanner;

public class Ligne extends Dessin {
    private Point p1;
    private Point p2;

    public Ligne() {
        p1 = new Point();
        p2 = new Point();
    }

    // deuxieme constructor utiliser notamment pour polygone
    public Ligne(Point pA, Point pB) {
        p1 = pA;
        p2 = pB;
    }

    @Override
    public void dessiner(Graphics2D graph) {
        graph.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    @Override
    public void lire(Scanner reader) {
        p1.lire(reader);
        p2.lire(reader);
    }

    public String toString() {
        return p1.toString() + "->" + p2.toString();
    }

    @Override
    public boolean equals(Object o) {
        // si object comparer avec lui-meme, retourner vrai
        if (o == this) {
            return true;
        }

        // verifier si l'objet est de type point
        if (!(o instanceof Ligne)) {
            return false;
        }

        // cast Object to Point
        Ligne l = (Ligne) o;

        // verifier coordonnees des deux objets
        // point equals override to check coordinates of points
        // line is still equal if origin and destination points are different
        if ((p1.equals(l.p1) && p2.equals(l.p2)) || (p1.equals(l.p2) && p2.equals(l.p1))) {
            return true;
        }
        return false;
    }

}