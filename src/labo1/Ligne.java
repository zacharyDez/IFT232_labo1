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
    public Ligne(Point pA, Point pB){
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

    public String toString(){
        return p1.toString()+"->"+p2.toString();
    }

}