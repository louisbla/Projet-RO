package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Calcul {
    public static int[] AlgoGenetique(EnsembleTache ensembleTache)
    {
    int tempsOptimal[]=new int[ensembleTache.getnbTaches()];
    int tempOptimalBeforeChange[]=new int[ensembleTache.getnbTaches()];;
    for(int i=0;i< ensembleTache.getnbTaches();i++)
    {
        tempsOptimal[i]=i+1;
    }
    int tempVal;
    int random;
    // on a choisi ici a selection par tournoi avec un nombre de participant de 20 et une population finale de
    for(int tournoi=0; tournoi<20;tournoi++)
    {
        for(int selection=0;selection<20;selection++)
        {
            for(int parcoursTab=0;parcoursTab<ensembleTache.getnbTaches();parcoursTab++)
            {
                tempOptimalBeforeChange[parcoursTab]=tempsOptimal[parcoursTab;
            }
            for(int i=0;i<ensembleTache.getnbTaches();i++)
            {
                random= ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
                tempVal=tempsOptimal[random];
                tempsOptimal[random]=tempsOptimal[i];
                tempsOptimal[i]=tempVal;
            }
            if(ensembleTache.calculerTempTraitement(tempsOptimal)>ensembleTache.calculerTempTraitement(tempOptimalBeforeChange))
            {
                for(int i=0;i<ensembleTache.getnbTaches();i++)
                    tempsOptimal[i]=tempOptimalBeforeChange[i];
            }
        }
    }



        return tempsOptimal;
    }
}
