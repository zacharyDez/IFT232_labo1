package labo1;

import java.util.*;

public class DessinCompose extends GeomCompose {

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

}