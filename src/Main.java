import Model.*;
import View.Affichage;
import Model.EnsembleTache;

import javax.swing.*;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        EnsembleTache ensembleTache = new EnsembleTache();
        Parser.setCheminFichier("PROB401.TXT");
        Parser parse= new Parser(Parser.lireNbTaches());

        ensembleTache.setnbTaches(Parser.lireNbTaches());
        ensembleTache.settabTmpDepart(parse.lireTmpDepart());
        ensembleTache.settabTmpReglages(parse.lireTmpReglages());
        ensembleTache.settabTmpTraitement(parse.lireTmpTraitement());


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

        System.out.println();
        System.out.println();

        ArrayList<Integer> bestSol = new ArrayList<>();
        bestSol = RechercheTabous.AlgorithmeTabou(ensembleTache);

        System.out.println("rech tab : " + ensembleTache.calculerTempTraitement(bestSol) + " avec " + bestSol);
        System.out.println("La meilleur solution a été trouvée en " + (RechercheTabous.nbIterationsPourBest+1) + " itérations");
        System.out.println("Mais " + (RechercheTabous.nbRepSansAmelioration+1) + " itérations dans la derniere generation aleatoire");

        int[] tempOpti= AlgorithmeGenetique.AlgoGenetique(ensembleTache);
        System.out.println(ensembleTache.calculerTempTraitement(tempOpti));

    }
}


