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
        //Valeurs de base pour l'algorithme génétique
        int nombreTournoi=100;
        int nombreIterationGenetique=10000;
        int facteurMutation=20;
        int nombreIte;

        long tempsDepart=System.currentTimeMillis();
        EnsembleTache ensembleTache = new EnsembleTache();
        Parser.setCheminFichier("PROB605.TXT"); // correspond à l'argument du fichier
        Parser parse= new Parser(Parser.lireNbTaches());
        ensembleTache.setnbTaches(Parser.lireNbTaches());
        ensembleTache.settabTmpDepart(parse.lireTmpDepart());
        ensembleTache.settabTmpReglages(parse.lireTmpReglages());
        ensembleTache.settabTmpTraitement(parse.lireTmpTraitement());

        Scanner reader = new Scanner(System.in);
        System.out.println("Taper 1 pour utiliser la recherche tabou");
        System.out.println("Taper 2 pour utiliser l'algorithe genetique");
        n = reader.nextInt();

        if(n==1)
        {
            System.out.println("veuillez entrer le nombre d'iterations (10 000 est un bon debut)");
            nombreIte = reader.nextInt();
            ArrayList<Integer> bestSol;
            bestSol = RechercheTabous.AlgorithmeTabou(ensembleTache, nombreIte);

            System.out.println("cout optimal " + ensembleTache.calculerTempTraitement(bestSol) + " avec l'ordre: " + bestSol);
            System.out.println("La meilleur solution a été trouvée en " + (RechercheTabous.nbIterationsPourBest+1) + " itérations");
        }

        if(n==2)
        {
            System.out.println("veuillez entrer la taille de la population");
            nombreTournoi = reader.nextInt();
            System.out.println("veuillez entrer le nombre d'itérations genetiqeus");
            nombreIterationGenetique = reader.nextInt();
            System.out.println("veuillez entrer le nombre de mutation par itérations");
            facteurMutation = reader.nextInt();
            int[] tempOpti= AlgorithmeGenetique.AlgoGenetique(ensembleTache, nombreTournoi, nombreIterationGenetique, facteurMutation);
            System.out.print("temps optimal: " +ensembleTache.calculerTempTraitement(tempOpti)+" avec l'ordre: ");
            for(int i=0; i<Parser.lireNbTaches(); i++)
            {
                System.out.print(tempOpti[i]+" ");
            }
            System.out.println();
            long tempsExec=(System.currentTimeMillis()-tempsDepart);
            System.out.println("Temps d'execution: "+tempsExec+ " Millisecondes");
        }




    }
}


