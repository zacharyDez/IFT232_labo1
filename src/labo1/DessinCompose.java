package labo1;

import java.awt.*;
import java.util.*;

public class DessinCompose extends Dessin {
    private ArrayList<Dessin> dessins;
    private int nbDessins;

    // creer un nouveau objet dont le type est defini
    // selon une valeur de -1 a -4
    private Map<Integer, Dessin> dessinsTypes = new HashMap<Integer, Dessin>() {{
        put(-1, new Point());
        put(-2, new Ligne());
        put(-3, new NuagePoints());
        put(-4, new Polygone());
    }};

    /*
    on doit seulement comparer le meme type de dessin
    comparer un enfant de dessin avec un autre type d'enfant force
    l'objet comparer a etre caster dans celui de base.

    Ceci leve une erreur lorsque le type ne correspond pas.
    */
    private ArrayList<Dessin> filterDessinByType(Dessin d) {

        ArrayList<Dessin> filteredDessins = new ArrayList<Dessin>();

        for (int j = 0; j < dessins.size(); j++) {
            Dessin toCheckDessin = dessins.get(j);
            if (toCheckDessin.getClass() == d.getClass()) {
                filteredDessins.add(toCheckDessin);
            }
        }

        return filteredDessins;

    }


    public DessinCompose() {
        nbDessins = 0;
        dessins = new ArrayList<Dessin>();
    }

    @Override
    public void dessiner(Graphics2D graph) {
        for (int i = 0; i < dessins.size(); i++) {
            dessins.get(i).dessiner(graph);
        }
    }

    @Override
    public void lire(Scanner reader) {

        nbDessins = reader.nextInt();

        for (int i = 0; i < nbDessins; i++) {
            try {
                Dessin d = dessinsTypes.get(reader.nextInt());
                d.lire(reader);

                // appel method equals specific au dessin sur la liste des dessins
                if (!filterDessinByType(d).contains(d)) {
                    dessins.add(d);
                }

            } catch (NoSuchElementException e) {
                nbDessins = i + 1;
                break;
            }
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