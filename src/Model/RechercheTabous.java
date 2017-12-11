package Model;

import java.util.ArrayList;
import java.util.Collections;

public class RechercheTabous {
    int bestResult;  //Contient la fonction objectif de la meilleure solution.
    int[] bestSolution; //représente la meilleure solution trouvée depuis le lancement de l'algo

    int[] activSolution; //représente la solution actuelle
    ArrayList<int[]> listTabou;  //représente l'ensemble des solutions tabous


    public static int[] AlgorithmeTabou(EnsembleTache ensembleTache){
        int[] ordre = randomOrderTab(ensembleTache.getnbTaches());

        switchTwoTasks(ordre, 1,2);








        return null;
    }

    private static int[] switchTwoTasks(int[] tab, int i, int j){
        int temp = tab[j];
        tab[j] = tab[i];
        tab[i] = temp;

        return tab;
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
