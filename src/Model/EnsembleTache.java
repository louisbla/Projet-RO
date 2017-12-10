package Model;

public class EnsembleTache {
    private int nbTaches;
    private int tabTmpTraitement[];
    private int tabTmpDepart[];
    private int tabTmpReglages[][];

    //Getters and setters
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







}
