package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class RechercheTabous {
    static ArrayList<Integer> bestSolution = new ArrayList<>(); //représente la meilleure solution trouvée depuis le lancement de l'algo

    static ArrayList<ArrayList<Integer>> listTabou = new ArrayList<>();  //représente l'ensemble des solutions tabous


    public static ArrayList<Integer> AlgorithmeTabou(EnsembleTache ensembleTache){
        int nbTaches = ensembleTache.getnbTaches();
        //int[] ordre = randomOrderTab(nbTaches);
        ArrayList<Integer> ordre = new ArrayList<>();
        ordre.add(1);
        ordre.add(2);
        ordre.add(3);
        ordre.add(4);
        ordre.add(5);
        ordre.add(6);
        ordre.add(7);
        ordre.add(8);
        ordre.add(9);
        ordre.add(10);
        ordre.add(11);
        ordre.add(12);
        ordre.add(13);
        ordre.add(14);
        ordre.add(15);

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
            if(tabChgmtCouts[i][j] < 0){//si l'optimum local est atteint
                listTabou.add(ordre);
                ordre = switchTwoTasks(ordre, i, j);
            }
            else {
                listTabou.add(ordre);
                ordre = switchTwoTasks(ordre, i,j);
                bestSolution.clear();
                for (int k = 0; k < ordre.size(); k++) {
                    bestSolution.add(ordre.get(k));
                }
            }


            nbRep++;
        }while(nbRep < 1000);










        return bestSolution;
    }


    public static int[][] getChgmtCouts(EnsembleTache ensembleTache, ArrayList<Integer> ordre) {
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


    private static ArrayList<Integer> switchTwoTasks(ArrayList<Integer> tab, int i, int j){
        ArrayList<Integer> newTab = new ArrayList<>(tab);
        newTab.set(j, tab.get(i));
        newTab.set(i, tab.get(j));

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
