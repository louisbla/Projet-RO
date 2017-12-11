package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Calcul {
    public static int[] AlgoGenetique(EnsembleTache ensembleTache)
    {
    int tempsOptimal[]=new int[ensembleTache.getnbTaches()];
    int tempOptimalBeforeChange[]=new int[ensembleTache.getnbTaches()];
    int nombreTournoi=50;
    int nombreIterationGenetique=100;
    int facteurMutation=5;
    int tabIndividus[][]= new int[nombreTournoi][ensembleTache.getnbTaches()];
    int tabEnfants[][]= new int[nombreTournoi][ensembleTache.getnbTaches()];
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
                tempOptimalBeforeChange[parcoursTab]=tempsOptimal[parcoursTab];
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
        {
            tabIndividus[tournoi][i]=tempsOptimal[i];
        }
        // on affecte ici le temps afin de ne pas le recalculer
    }

    /* a la sortie de ce tournoi nous avons donc une poputation initiale conséquente placé dans un tableau. nous
     * allons donc maintenant appliquer l'algorithme genetique grace à plusieurs crossover et mutation.
      * Nous remplacerons les pire parents par les meilleurs enfants.  on inclus également un coefficient de mutation
      * aléatoire, ce dernier nous permettra de sortir d'un eventuel minimum local*/

    int cassure1; // on initialise deux cassure qui prendront des valeures aléatoire afin de combiner d'eventuels parents
    int cassure2;
    int placeElementAChanger1;
    int placeElementAChanger2;
    int placeElementAChanger3;
    for(int genetique=0;genetique<nombreIterationGenetique;genetique++)
    {
     cassure1=ThreadLocalRandom.current().nextInt(0, (ensembleTache.getnbTaches()/2)-1);
     cassure2=ThreadLocalRandom.current().nextInt((ensembleTache.getnbTaches()/2)+1, ensembleTache.getnbTaches());
     for(int compteur=0;compteur<nombreTournoi;compteur++)
     {
         //On choisit au hasard des element qui vont composer l'enfant voulu
         placeElementAChanger1=ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
         placeElementAChanger2=ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
         placeElementAChanger3=ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
         // Ensuite on remplis le tableau d'enfant avec les elements pris au hasard
         for(int compteurCasssure1=0; compteurCasssure1<cassure1;compteurCasssure1++)
         {
             tabEnfants[compteur][compteurCasssure1]=tabIndividus[placeElementAChanger1][compteurCasssure1];
         }
         for(int compteurCasssure2=cassure1; compteurCasssure2<cassure2;compteurCasssure2++)
         {
             tabEnfants[compteur][compteurCasssure2]=tabIndividus[placeElementAChanger2][compteurCasssure2];
         }
         for(int compteurFinTaches=cassure2;compteurFinTaches<ensembleTache.getnbTaches();compteurFinTaches++)
         {
             tabEnfants[compteur][compteurFinTaches]=tabIndividus[placeElementAChanger3][compteurFinTaches];
         }
     }

     /*on va ensuite trier les valeurs obtenus en prenant en comptes les parents et les enfants. On gardera
     * la même taille de population donc on éliminera les 100 individus les moins bons pour ne garder que les
     * meilleurs */

    }

        return tempsOptimal;
    }
}
