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
    for(int tournoi=0;tournoi<100;tournoi++)
    {
        for(int k=0;k<ensembleTache.getnbTaches();k++)
        {
            tempOptimalBeforeChange[k]=tempsOptimal[k];
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


        return tempsOptimal;
    }
}
