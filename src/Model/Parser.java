package Model;
import java.io.*;
import java.util.*;

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
        BufferedReader br= null;
        FileReader fr = null;
        int nbTacheReturn=0;

        try
        {
            fr = new FileReader(CheminFichier);
            br = new BufferedReader(fr);
            String sCurrentLine;
           sCurrentLine= br.readLine();
            String numberOnly= sCurrentLine.replaceAll("[^0-9]", "");
           nbTacheReturn= Integer.parseInt(numberOnly); }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return nbTacheReturn;
    }

    public int[] lireTmpTraitement()
    {
        BufferedReader br= null;
        FileReader fr = null;
        int bufferVal;

        int[] result = new int[getnbTaches()];

        try
        {
            fr = new FileReader(CheminFichier);
            br = new BufferedReader(fr);
            String sCurrentLine;
            sCurrentLine= br.readLine(); // on lit la premiere ligne
            sCurrentLine= br.readLine(); // on récupère la seconde
            StringTokenizer Tok = new StringTokenizer(sCurrentLine);
            for(int i=0; i< getnbTaches();i++)
            {
                bufferVal= Integer.parseInt(Tok.nextToken());
                result[i] = bufferVal;
            }
            //String numberOnly= sCurrentLine.replaceAll("[^0-9]", "");
           //nbTaches=Integer.parseInt(numberOnly);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int[] lireTmpDepart()
    {
        BufferedReader br= null;
        FileReader fr = null;
        int bufferVal;

        int[] result = new int[getnbTaches()];

        try
        {
            fr = new FileReader(CheminFichier);
            br = new BufferedReader(fr);
            String sCurrentLine;
            sCurrentLine= br.readLine(); // on lit la premiere ligne
            sCurrentLine= br.readLine(); // on passe la ligne des temps de traitement
            sCurrentLine= br.readLine(); // on récupère la troisieme ligne
            StringTokenizer Tok = new StringTokenizer(sCurrentLine);
            for(int i=0; i< getnbTaches();i++)
            {
                bufferVal= Integer.parseInt(Tok.nextToken());
                result[i] = bufferVal;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int[][] lireTmpReglages() {
        BufferedReader br = null;
        FileReader fr = null;
        int bufferVal;

        int[][] result = new int[getnbTaches()][getnbTaches()];

        try {
            fr = new FileReader(CheminFichier);
            br = new BufferedReader(fr);
            String sCurrentLine;
            sCurrentLine = br.readLine(); // on lit la premiere ligne
            sCurrentLine = br.readLine(); // on passe la ligne des temps de traitement
            sCurrentLine = br.readLine(); // passe la ligne de temps de depart
            sCurrentLine = br.readLine();

            for (int i = 0; i < getnbTaches(); i++) {
                StringTokenizer Tok = new StringTokenizer(sCurrentLine);
                sCurrentLine = br.readLine();
                for (int j = 0; j < getnbTaches(); j++) {
                    bufferVal = Integer.parseInt(Tok.nextToken());
                    result[i][j] = bufferVal;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
