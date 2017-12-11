package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Calcul {
    public static int[] AlgoGenetique(EnsembleTache ensembleTache)
    {
    int tempsOptimal[]=new int[ensembleTache.getnbTaches()];
    int tempOptimalBeforeChange[]=new int[ensembleTache.getnbTaches()];
    int nombreTournoi=100;
    int tabIndividus[][]= new int[nombreTournoi][ensembleTache.getnbTaches()];
    int tempVal;
    int random;

    // on initialise le tableau de l'ordre de nos taches
    for(int i=0;i< ensembleTache.getnbTaches();i++)
    {
        tempsOptimal[i]=i+1;
    }

    // on a choisi ici a selection par tournoi avec un nombre de participant de 20 et une population finale de
    for(int tournoi=0; tournoi<nombreTournoi;tournoi++)
    {
        // pour chaque tournoi on selectionne 100 éléments au hasard, on ne gardera que le meilleur à chaque fois
        for(int selection=0;selection<100;selection++)
        {
            for(int parcoursTab=0;parcoursTab<ensembleTache.getnbTaches();parcoursTab++)
            {
                tempOptimalBeforeChange[parcoursTab]=tempsOptimal[parcoursTab;
            }
            for(int i=0;i<ensembleTache.getnbTaches();i++)
            {
                //brassage aléatoire: on échange au hasard deux valeurs dans le tableau et ce nbTaches fois
                random= ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
                tempVal=tempsOptimal[random];
                tempsOptimal[random]=tempsOptimal[i];
                tempsOptimal[i]=tempVal;
            }
            if(ensembleTache.calculerTempTraitement(tempsOptimal)>ensembleTache.calculerTempTraitement(tempOptimalBeforeChange))
            {
                // si l'element est moins bon que le précédent, on ne le garde pas
                for(int i=0;i<ensembleTache.getnbTaches();i++)
                    tempsOptimal[i]=tempOptimalBeforeChange[i];
            }
        }
        for(int i=0;i<ensembleTache.getnbTaches();i++)
            tabIndividus[tournoi][i]=tempsOptimal[i];
    }

    /* a la sortie de ce tournoi nous avons donc une poputation initiale conséquente placé dans un tableau. nous
     * allons donc maintenant appliquer l'algorithme genetique grace à plusieurs crossover et mutation.
      * Nous remplacerons les pire parents par les meilleurs enfants. */



        return tempsOptimal;
    }
}
