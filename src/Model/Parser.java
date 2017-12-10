package Model;
import java.io.*;
import java.util.*;

public class Parser {
    //Déclaration des variables
    private int nbTaches;
    private int tabTmpTraitement[];
    private int tabTmpDepart[];
    private int tabTmpReglages[][];
    private static String CheminFichier;

    public Parser(int nbTacheLu)
    {
        nbTaches=nbTacheLu;
        tabTmpTraitement= new int[nbTacheLu];
        tabTmpDepart=new int[nbTacheLu];
        tabTmpReglages=new int[nbTacheLu][nbTacheLu];
    }
    //Déclaration des getter
    public int getnbTaches()
    {
        return nbTaches;
    }

    public int[] gettabTmpTraitement()
    {
        return tabTmpTraitement;
    }
    public int gettabTmpTraitement(int i)
    {
        return tabTmpTraitement[i];
    }

    public int[] gettabTmpDepart()
    {
        return tabTmpDepart;
    }
    public int gettabTmpDepart(int i)
    {
        return tabTmpDepart[i];
    }

    public int[][] gettabTmpReglages()
    {
        return tabTmpReglages;
    }
    public int gettabTmpReglages(int i, int j)
    {
        return tabTmpReglages[i][j];
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

    public void settabTmpTraitement(int[] newTabTmpTraitement)
    {
        tabTmpTraitement=newTabTmpTraitement;
    }
    public void settabTmpTraitement(int i, int newVal)
    {
        tabTmpTraitement[i]=newVal;
    }

    public void settabTmpDepart(int[] newTabTmpDepart)
    {
        tabTmpDepart=newTabTmpDepart;
    }
    public void settabTmpDepart(int i, int newVal)
    {
        tabTmpDepart[i]=newVal;
    }

    public void settabTmpReglages(int[][] newTabTmpReglages)
    {
        tabTmpReglages=newTabTmpReglages;
    }
    public void settabTmpReglages(int i, int j, int newVal)
    {
        tabTmpReglages[i][j]=newVal;
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
                settabTmpTraitement(i, bufferVal);
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
                settabTmpDepart(i, bufferVal);
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

            for (int i = 0; i < getnbTaches(); i++) {
                StringTokenizer Tok = new StringTokenizer(sCurrentLine);
                sCurrentLine = br.readLine();
                for (int j = 0; j < getnbTaches(); j++) {
                    bufferVal = Integer.parseInt(Tok.nextToken());
                    settabTmpReglages(i, j, bufferVal);
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
