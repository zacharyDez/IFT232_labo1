package labo1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NuagePoints extends GeomCompose {

    @Override
    public void lire(Scanner reader) {
        // doit verifier que nextInt n'est pas negatif avant de creer prochain points
        // cas d'exception lorsque nbre de points declare dans fichier excede nbre points actuels
        Pattern negInt = Pattern.compile("-+[1-4]");
        nbDessins = reader.nextInt();
        for (int i = 0; i < nbDessins; i++) {
            if (!reader.hasNext(negInt)) {
                try {
                    Point p = new Point();
                    p.lire(reader);
                    if (!dessins.contains(p)) {
                        dessins.add(p);
                    }
                } catch (NoSuchElementException e) {
                    // reinitialiser bon nombre de pts
                    nbDessins = i + 1;
                    break;
                }
            }
        }
    }

    public int getNbPoints() {
        return nbDessins;
    }

    protected Point getPoint(int index) {
        return (Point) dessins.get(index);
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
        if (pts.getNbPoints() != nbDessins) {
            return false;
        }

        for (int i = 0; i < nbDessins; i++) {
            boolean ptInArray = dessins.contains(pts.getPoint(i));
            if (!ptInArray) {
                return false;
            }
        }

        return true;
    }

}

