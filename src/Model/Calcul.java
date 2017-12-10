package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Calcul {
    public static int[] AlgoGenetique(int nbTaches, int[] tmpTraitement, int[] tmpDepart, int[][] tmpReglages)
    {
    int tempsOptimal[]=new int[nbTaches];
    for(int i=0;i< nbTaches;i++)
    {
        tempsOptimal[i]=i+1;
    }
    int tempVal;
    int random;
    for(int i=0;i<15;i++)
    {
        random= ThreadLocalRandom.current().nextInt(0, nbTaches);
        tempVal=tempsOptimal[random];
        tempsOptimal[random]=tempsOptimal[i];
        tempsOptimal[i]=tempVal;

    }

        return tempsOptimal;
    }
}
