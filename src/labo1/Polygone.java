package labo1;

import java.awt.*;
import java.util.Scanner;

public class Polygone extends Dessin {
    private NuagePoints ptsSommets;

    public Polygone() {
        ptsSommets = new NuagePoints();
    }

    @Override
    public void dessiner(Graphics2D graph) {
        int nbPoints = ptsSommets.getNbPoints();
        // premier element doit dessiner ligne avec dernier aussi
        for (int i = 0; i < nbPoints; i++) {
            // last element will raise index out of bounds
            try {
                Ligne l = new Ligne(ptsSommets.getPoint(i), ptsSommets.getPoint(i + 1));
                l.dessiner(graph);
            } catch (IndexOutOfBoundsException e) {
                // dessiner ligne entre premier et dernier point
                Ligne l = new Ligne(ptsSommets.getPoint(i), ptsSommets.getPoint(0));
                l.dessiner(graph);
            }
        }

    }

    @Override
    public void lire(Scanner reader) {
        ptsSommets.lire(reader);
    }


    // le string d'un polygone doit presenter les lignes d'un sommet a l'autre
    public String toString() {
        int nbPoints = ptsSommets.getNbPoints();
        String msg = "";
        for (int i = 0; i < nbPoints; i++) {
            // dernier sommet doit rejoindre le premier
            // erreur generer pour le dernier element
            try {
                Ligne l = new Ligne(ptsSommets.getPoint(i), ptsSommets.getPoint(i + 1));
                msg += l.toString() + "\n";
            } catch (IndexOutOfBoundsException e) {
                Ligne l = new Ligne(ptsSommets.getPoint(i), ptsSommets.getPoint(0));
                msg += l.toString() + "\n";
            }
        }
        return msg;
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

        // cast Objet a Polygone
        Polygone p = (Polygone) o;

        // Polygone sont equivalent si leur sommets sont les memes
        return ptsSommets.equals(p.ptsSommets);
    }

}