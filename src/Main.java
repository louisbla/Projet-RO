import View.Affichage;
import Model.Parser;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        int nbTaches=0;
        /*JFrame fenetre = new JFrame();
        Affichage.afficherFenetre(fenetre);
        Affichage.afficherBouton(fenetre);
        System.out.println("Hello world");*/
        Parser.setCheminFichier("C:\\Users\\edouard\\Desktop\\Cours_UQAC\\Recherche Operationnelle\\DEVOIR\\Projet\\PROB408.TXT");
        Parser parse= new Parser(Parser.lireNbTaches());
        System.out.println(Parser.lireNbTaches());
        parse.lireTmpTraitement();
        parse.lireTmpDepart();
        parse.lireTmpReglages();
        System.out.println(parse.getnbTaches());
        for(int i=0; i<15; i++)
        {
            System.out.print(parse.gettabTmpTraitement(i)+" ");
        }
        for(int i=0; i<15; i++)
        {
            System.out.print(parse.gettabTmpDepart(i)+" ");
        }
        for(int i=0; i<15; i++)
        {
            for(int j=0;j<15;j++)
            {
                System.out.print(parse.gettabTmpReglages(i,j)+" ");
            }
            System.out.println();

        }

    }
}


