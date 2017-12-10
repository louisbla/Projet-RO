import Model.EnsembleTache;
import View.Affichage;
import Model.Parser;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        EnsembleTache ensembleTache = new EnsembleTache();
        int nbTaches=0;
        /*JFrame fenetre = new JFrame();
        Affichage.afficherFenetre(fenetre);
        Affichage.afficherBouton(fenetre);
        System.out.println("Hello world");*/
        Parser.setCheminFichier("PROB408.TXT");
        Parser parse= new Parser(Parser.lireNbTaches());
        System.out.println(Parser.lireNbTaches());

        ensembleTache.setnbTaches(Parser.lireNbTaches());
        ensembleTache.settabTmpDepart(parse.lireTmpDepart());
        ensembleTache.settabTmpReglages(parse.lireTmpReglages());
        ensembleTache.settabTmpTraitement(parse.gettabTmpTraitement());


        parse.lireTmpTraitement();
        parse.lireTmpDepart();
        parse.lireTmpReglages();
        System.out.println(parse.getnbTaches());
        for(int i=0; i<15; i++)
        {
            System.out.print(ensembleTache.gettabTmpTraitement(i)+" ");
        }
        System.out.println();
        for(int i=0; i<15; i++)
        {
            System.out.print(ensembleTache.gettabTmpDepart(i)+" ");
        }
        for(int i=0; i<15; i++)
        {
            for(int j=0;j<15;j++)
            {
                System.out.print(ensembleTache.gettabTmpReglages(i,j)+" ");
            }
            System.out.println();

        }

    }
}


