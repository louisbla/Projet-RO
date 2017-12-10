package View;

import javax.swing.*;

public class Affichage {

    public static void afficherFenetre(JFrame fenetre)
    {
        //JFRAME

        fenetre.setTitle("Algorithme d'optimisation combinatoire");
        fenetre.setSize(1280, 720);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BUTTONS


        //WINDOW CONTENANT n TACHE A EFFECTUER
        JScrollPane nbTaches = new JScrollPane();
        nbTaches.setBounds(460,50,50,50);
        fenetre.add(nbTaches);
        //SCROLL WINDOWS CONTENANT TEMPS TRAITEMENT
        JScrollPane scrPaneTmpTraitement = new JScrollPane();
        scrPaneTmpTraitement.setBounds(460,110,300,50);
        fenetre.add(scrPaneTmpTraitement);
        //SCROLL WINDOWS CONTENANT TEMPS DEPART
        JScrollPane scrPaneTmpDepart = new JScrollPane();
        scrPaneTmpDepart.setBounds(460,160,300,50);
        fenetre.add(scrPaneTmpDepart);
        //SCROLL WINDOWS CONTENANT MATRICE REGLAGE
        JScrollPane scrPaneTmpReglages = new JScrollPane();
        scrPaneTmpReglages.setBounds(50,50,400,400);
        fenetre.add(scrPaneTmpReglages);
        //SCROLL WINDOWS CONTENANT RESULTATS
        JScrollPane srcAfficherRes = new JScrollPane();
        srcAfficherRes.setBounds(770,50,450,450);
        fenetre.add(srcAfficherRes);
        //FENETRE CARAC

        fenetre.setLayout(null);
        fenetre.setVisible(true);
    }
    public static void afficherBouton(JFrame fenetre)
    {
        JButton parseSelect= new JButton("select file");
        JButton lancerCalcul= new JButton("Lauch algorithme");
        parseSelect.setBounds(990,600,100,50);
        lancerCalcul.setBounds(1100,600,150,50);
        fenetre.add(parseSelect);
        fenetre.add(lancerCalcul);
    }
}
