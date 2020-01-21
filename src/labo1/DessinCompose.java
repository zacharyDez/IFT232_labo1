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

    public DessinCompose(){
        nbDessins=0;
        dessins = new ArrayList<Dessin>();
    }

    @Override
    public void dessiner(Graphics2D graph){
        for(int i=0; i<dessins.size(); i++){
            dessins.get(i).dessiner(graph);
        }
    }

    @Override
    public void lire(Scanner reader){
        nbDessins = reader.nextInt();
        for(int i=0; i<nbDessins; i++){
            try {
                Dessin d = dessinsTypes.get(reader.nextInt());
                d.lire(reader);
                dessins.add(d);

                // check if dessin already in list
                // calls specific dessin equals methods
                // must only compare same types
                try{
                    if(!dessins.contains(d)){
                        dessins.add(d);
                    }
                } catch (ClassCastException e){};

            } catch (NoSuchElementException e){
                nbDessins = i+1;
                break;
            }
        }
    }

    public String toString(){
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