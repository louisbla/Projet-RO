package Model;

import java.util.ArrayList;
import java.util.Collections;

public class RechercheTabous {
    int bestResult;  //Contient la fonction objectif de la meilleure solution.
    static int[] bestSolution; //représente la meilleure solution trouvée depuis le lancement de l'algo

    int[] activSolution; //représente la solution actuelle
    static ArrayList<int[]> listTabou = new ArrayList<>();  //représente l'ensemble des solutions tabous


    public static int[] AlgorithmeTabou(EnsembleTache ensembleTache){
        int nbTaches = ensembleTache.getnbTaches();
        //int[] ordre = randomOrderTab(nbTaches);
        int[] ordre = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        int nbRep = 0;

        do {
            int[][] tabChgmtCouts = getChgmtCouts(ensembleTache, ordre);

            //recherche du meilleur coeff
            int i = 0;
            int j = 1;
            for (int k = 0; k < nbTaches; k++) {
                for (int l = 0; l < nbTaches; l++) {
                    if(k != l) {
                        if (!listTabou.contains(switchTwoTasks(ordre,k,l))) {
                            if (tabChgmtCouts[i][j] < tabChgmtCouts[k][l]) {
                                i = k;
                                j = l;
                            }
                        }
                    }
                }
            }
            if(tabChgmtCouts[i][j] < 0){
                System.out.println("optimum local atteint au bout de " + nbRep + " iterations");
                listTabou.add(ordre);
                ordre = switchTwoTasks(ordre, i, j);
            }
            else {
                listTabou.add(ordre);
                ordre = switchTwoTasks(ordre, i,j);
                bestSolution = ordre.clone();
            }


            nbRep++;
        }while(nbRep < 1000);










        return bestSolution;
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
