package Model;
import java.io.*;
import java.util.Scanner;

public class Parser {
    //Déclaration des variables
    private int nbTaches;
    private static String CheminFichier;

    public Parser(int nbTacheLu)
    {
        nbTaches=nbTacheLu;
    }
    //Déclaration des getter
    public int getnbTaches()
    {
        return nbTaches;
    }
    public String getCheminFichier()
    {
        return CheminFichier;
    }

    //Déclaration des setters
    public void setnbTaches(int newNbTahes)
    {
        nbTaches=newNbTahes;
    }
    public static void setCheminFichier(String newCheminFichier)
    {
        CheminFichier=newCheminFichier;
    }

    // fonction du parseur

    public static int lireNbTaches()
    {
        Scanner scan;
        File file = new File(CheminFichier);
        int nbTacheReturn=0;
        try
        {
            scan = new Scanner(file);
            nbTacheReturn = scan.nextInt();
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return nbTacheReturn;
    }

    public int[] lireTmpTraitement()
    {
        Scanner scan;
        int nbtaches;
        File file = new File(CheminFichier);
        int[] result = new int[getnbTaches()];
        try
        {
            scan = new Scanner(file);
            nbtaches = scan.nextInt(); // on passe la lecture du nb tache
            for(int i=0;i<nbtaches;i++)
            {
                result[i] = scan.nextInt();
            }
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public int[] lireTmpDepart()
    {
        Scanner scan;
        int nbtaches;
        int tmp;
        File file = new File(CheminFichier);
        int[] result = new int[getnbTaches()];
        try
        {
            scan = new Scanner(file);
            nbtaches = scan.nextInt(); // on passe la lecture du nb tache
            for(int i=0;i<nbtaches;i++)
            {
                tmp= scan.nextInt();
            }
            for(int i=0;i<nbtaches;i++)
            {
                result[i] = scan.nextInt();
            }
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public int[][] lireTmpReglages() {
        Scanner scan;
        int nbtaches;
        int tmp;
        File file = new File(CheminFichier);
        int[][] result = new int[getnbTaches()][getnbTaches()];
        try
        {
            scan = new Scanner(file);
            nbtaches = scan.nextInt(); // on passe la lecture du nb tache
            for(int i=0;i<nbtaches*2;i++)
            {
                tmp= scan.nextInt();
            }
            for(int i=0;i<nbtaches;i++)
            {
                for(int j=0;j<nbtaches;j++)
                {
                    result[i][j] = scan.nextInt();
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
