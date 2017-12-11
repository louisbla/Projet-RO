package Model;

import java.util.ArrayList;
import java.util.Collections;

public class RechercheTabous {
    int bestResult;  //Contient la fonction objectif de la meilleure solution.
    int[] bestSolution; //représente la meilleure solution trouvée depuis le lancement de l'algo

    int[] activSolution; //représente la solution actuelle
    ArrayList<int[]> listTabou;  //représente l'ensemble des solutions tabous


    public static int[] AlgorithmeTabou(EnsembleTache ensembleTache){
        int nbTaches = ensembleTache.getnbTaches();
        int[] ordre = randomOrderTab(nbTaches);

        int[][] tabChgmtCouts = getChgmtCouts(ensembleTache, ordre);

        switchTwoTasks(ordre, 1,2);








        return null;
    }

    public static int[][] getChgmtCouts(EnsembleTache ensembleTache, int[] ordre) {
        int nbTaches = ensembleTache.getnbTaches();
        int coutActuel = ensembleTache.calculerTempTraitement(ordre);

        //Creation du tableau des changement de couts
        int[][] chgmtCouts = new int[nbTaches][nbTaches];
        for(int i=0; i < nbTaches; i++){
            for(int j=0; j < nbTaches; j++){
                chgmtCouts[i][j] = coutActuel - ensembleTache.calculerTempTraitement(switchTwoTasks(ordre, i, j));
            }
        }
        return chgmtCouts;
    }

    private static int[] switchTwoTasks(int[] tab, int i, int j){
        int[] newTab = tab.clone();
        newTab[j] = tab[i];
        newTab[i] = tab[j];

        return newTab;
    }

    private static int[] randomOrderTab(int nbTaches) {
        int[] result = new int[nbTaches];

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < nbTaches; i++){
            list.add(i+1);
        }
        Collections.shuffle(list);

        for(int i=0; i < nbTaches; i++){
            result[i] = list.get(i);
        }

        return result;
    }


}
