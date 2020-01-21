package labo1;

import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        // doit verifier que nextInt n'est pas negatif avant de creer prochain points
        // cas d'exception lorsque nbre de points declare dans fichier excede nbre points actuels
        Pattern negInt = Pattern.compile("-+[1-4]");
        nbPoints = reader.nextInt();
        for (int i = 0; i < nbPoints; i++) {
            if (!reader.hasNext(negInt)) {
                try {
                    Point p = new Point();
                    p.lire(reader);
                    if (!points.contains(p)) {
                        points.add(p);
                    }
                } catch (NoSuchElementException e) {
                    // reinitialiser bon nombre de pts
                    nbPoints = i + 1;
                    break;
                }
            }
        }
    }

    public String toString() {
        String msg = "\n";
        for (int i = 0; i < nbPoints; i++) {
            try {
                msg += points.get(i).toString() + "\n";
            } catch (IndexOutOfBoundsException e) {
                nbPoints = i + 1;
                break;
            }
        }
        return msg;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    protected Point getPoint(int index) {
        return points.get(index);
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

        // Objet general doit etre caster en NuagePoints
        NuagePoints pts = (NuagePoints) o;

        // polygone ne sont pas egaux si leur nombrede points ne sont pas egaux
        if (pts.getNbPoints() != nbPoints) {
            return false;
        }

        for (int i = 0; i < nbPoints; i++) {
            boolean ptInArray = points.contains(pts.getPoint(i));
            if (!ptInArray) {
                return false;
            }
        }

        return true;
    }

}

