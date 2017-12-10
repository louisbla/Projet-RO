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



    //calcule le temps de traitement pour un ordre précis
    public int calculerTempTraitement(int[] ordre){
        //ordre représente l'ordre de passage des taches

        int tempsTotal = 0;

        //on ajoute le temps de démarrage et le temps de traitement de la premiere tache
        tempsTotal += tabTmpDepart[ordre[0] - 1];   //-1 car la tache 1 est située à la case 0
        tempsTotal += tabTmpTraitement[ordre[0] - 1];

        //Pour chaque tache suivante, on ajoute le temps de reglage, puis le temps de traitement
        for(int i=1; i < ordre.length; i++){
            tempsTotal += tabTmpReglages[ordre[i-1] - 1][ordre[i] - 1];
            tempsTotal += tabTmpTraitement[ordre[i] - 1];
        }

        return tempsTotal;
    }



}
