package labo1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class GeomCompose extends Dessin {
    protected ArrayList<Dessin> dessins;
    protected int nbDessins;

    public GeomCompose(){
        nbDessins = 0;
        dessins = new ArrayList<Dessin>();
    }

    /*
    on doit seulement comparer le meme type de dessin
    comparer un enfant de dessin avec un autre type d'enfant force
    l'objet comparer a etre caster dans celui de base.

    Ceci leve une erreur lorsque le type ne correspond pas.
    */
    protected ArrayList<Dessin> filterDessinByType(Dessin d) {

        ArrayList<Dessin> filteredDessins = new ArrayList<Dessin>();

        for (int j = 0; j < dessins.size(); j++) {
            Dessin toCheckDessin = dessins.get(j);
            if (toCheckDessin.getClass() == d.getClass()) {
                filteredDessins.add(toCheckDessin);
            }
        }

        return filteredDessins;

    }

    public abstract void lire(Scanner reader);

    public void dessiner(Graphics2D graph) {
        for (int i = 0; i < dessins.size(); i++) {
            dessins.get(i).dessiner(graph);
        }
    }

    public String toString() {
        String msg = "";

        for (int i = 0; i < nbDessins; i++) {
            try {
                msg += dessins.get(i).toString() + "\n";
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        return msg;
    }
}