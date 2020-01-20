package labo1;

import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NuagePoints extends Dessin {
    private ArrayList<Point> points;
    private int nbPoints;

    public NuagePoints() {
        nbPoints = 0;
        points = new ArrayList<Point>();
    }

    @Override
    public void dessiner(Graphics2D graph) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).dessiner(graph);
        }
    }

    @Override
    public void lire(Scanner reader) {
        nbPoints = reader.nextInt();
        for (int i = 0; i < nbPoints; i++) {
            try {
                Point p = new Point();

                try {
                    p.lire(reader);
                    if(!points.contains(p)) {
                        points.add(p);
                    }
                } catch (NoSuchElementException e){
                    nbPoints = i+1;
                    break;
                }

            } catch (NoSuchElementException e) {
                // reinitialiser bon nombre de pts
                nbPoints = i+1;
                break;
            }
        }
    }

    public String toString() {
        String msg = "";
        for (int i = 0; i < nbPoints; i++) {
            try {
                msg += points.get(i).toString() + "\n";
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return msg;
    }

    public int getNbPoints(){
        return nbPoints;
    }

    protected Point getPoint(int index){
        return points.get(index);
    }

}

