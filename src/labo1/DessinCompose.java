package labo1;

import java.util.*;


public class DessinCompose extends GeomCompose {

    @Override
    public void lire(Scanner reader) {
        // creer un nouveau objet dont le type est defini
        // selon une valeur de -1 a -4
        Map<Integer, Dessin> dessinsTypes = new HashMap<Integer, Dessin>() {{
            put(-1, new Point());
            put(-2, new Ligne());
            put(-3, new NuagePoints());
            put(-4, new Polygone());
        }};

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

}