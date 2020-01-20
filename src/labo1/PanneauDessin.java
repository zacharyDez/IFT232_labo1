package labo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Panneau qui représente une surface pour dessiner.
 * S'initialise avec un Point à dessiner.
 * Dessine le point.
 */

class PanneauDessin extends JPanel implements ActionListener {


    private static final long serialVersionUID = 1L;

    //L'objet qui sera dessiné sur la surface.
    private Dessin contenu;

    //La surface de dessin doit être créée avec un objet à dessiner.
    public PanneauDessin(Dessin d) {

        contenu = d;
    }

    /*
     * C'est ici que ça se passe!
     * Principalement un appel à la fonction de dessin
     * implantée par le contenu.
     */

    private void doDrawing(Graphics g) {

        Graphics2D graph = (Graphics2D) g;

        graph.setPaint(Color.black);

        contenu.dessiner(graph);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}