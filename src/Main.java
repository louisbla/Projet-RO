import Model.EnsembleTache;
import View.Affichage;
import Model.Parser;
import Model.Calcul;
import Model.EnsembleTache;

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
        Parser.setCheminFichier("PROB401.TXT");
        Parser parse= new Parser(Parser.lireNbTaches());



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
        System.out.println();
        for(int i=0; i<15; i++)
        {
            for(int j=0;j<15;j++)
            {
                System.out.print(ensembleTache.gettabTmpReglages(i,j)+" ");
            }
            System.out.println();

        }

        int tempsOpti=Calcul.AlgoGenetique(ensembleTache.getnbTaches() ,ensembleTache.gettabTmpTraitement(),ensembleTache.gettabTmpDepart(),ensembleTache.gettabTmpReglages());
        System.out.println(" le temps optimal est: " + tempsOpti);
        int[] ordre = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println("temps : " + ensembleTache.calculerTempTraitement(ordre));

    }
}


