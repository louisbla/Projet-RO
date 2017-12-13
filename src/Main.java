import Model.*;
import Model.EnsembleTache;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        int n=0;

        long tempsDepart=System.currentTimeMillis();
        EnsembleTache ensembleTache = new EnsembleTache();
        Parser.setCheminFichier("PROB401.TXT");
        Parser parse= new Parser(Parser.lireNbTaches());
        ensembleTache.setnbTaches(Parser.lireNbTaches());
        ensembleTache.settabTmpDepart(parse.lireTmpDepart());
        ensembleTache.settabTmpReglages(parse.lireTmpReglages());
        ensembleTache.settabTmpTraitement(parse.lireTmpTraitement());

        Scanner reader = new Scanner(System.in);
        System.out.println("Taper 1 pour utiliser la recherche tabou");
        System.out.println("Taper 2 pour utiliser l'algorithe genetique");
        while(n!=1 || n!=2)
        {
            n = reader.nextInt();
        }

        if(n==1)
        {

            ArrayList<Integer> bestSol = new ArrayList<>();
            bestSol = RechercheTabous.AlgorithmeTabou(ensembleTache);

            System.out.println("rech tab : " + ensembleTache.calculerTempTraitement(bestSol) + " avec " + bestSol);
            System.out.println("La meilleur solution a été trouvée en " + (RechercheTabous.nbIterationsPourBest+1) + " itérations");
            System.out.println("Mais " + (RechercheTabous.nbRepSansAmelioration+1) + " itérations dans la derniere generation aleatoire");
        }

        if(n==2)
        {
            int[] tempOpti= AlgorithmeGenetique.AlgoGenetique(ensembleTache);
            System.out.println(ensembleTache.calculerTempTraitement(tempOpti));
            for(int i=0; i<15; i++)
            {
                System.out.print(tempOpti[i]+" ");
            }
            System.out.println();
            long tempsExec=(System.currentTimeMillis()-tempsDepart);
            System.out.println("Temps d'execution: "+tempsExec+ " Millisecondes");
        }




    }
}


