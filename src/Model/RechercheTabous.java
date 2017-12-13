package Model;

import java.util.ArrayList;
import java.util.Collections;

public class RechercheTabous {
    static ArrayList<Integer> bestSolution = new ArrayList<>(); //représente la meilleure solution trouvée depuis le lancement de l'algo

    private static ArrayList<ArrayList<Integer>> listTabou = new ArrayList<>();  //représente l'ensemble des solutions tabous

    public static int nbIterationsPourBest = 0;


    /* Fonction principale de l'algorithme, on lui fournit un ensemble de taches en paramètre et un nombre d'itérations.
    *  Elle nous retourne un ArrayList contenant l'ordre optimal pour avoir un temps minimum
    *  */
    public static ArrayList<Integer> AlgorithmeTabou(EnsembleTache ensembleTache, int nbIterations){
        int nbTaches = ensembleTache.getnbTaches(); //nbTaches correspond au nombre de taches

        ArrayList<Integer> ordre = randomOrderTab(nbTaches); //on génère un ordre aléatoire

        bestSolution = ordre;
        int nbRep = 0;

        long time = System.currentTimeMillis();

        //Boucle principale
        do {
            int[][] tabChgmtCouts = getChgmtCouts(ensembleTache, ordre);  //On récupère la différence de couts pour tous les voisins

            //recherche du meilleur coeff
            int i = 0;
            int j = 1;
            /*  Cette boucle while permet de s'assurer qu'on ne garde pas [0,1] si c'est le meilleur coeff et qu'il est tabou */
            while(isInListTabou(i,j)){
                j++;
            }

            for (int k = 0; k < nbTaches; k++) {
                for (int l = 0; l < nbTaches; l++) {
                    if(k != l) {
                        if (!isInListTabou(k,l)) {
                            if (tabChgmtCouts[i][j] < tabChgmtCouts[k][l]) {
                                i = k;
                                j = l;
                            }
                        }
                    }
                }
            }
            ajouterDansListeTabou(i,j); //On ajoute le mouvement effectué dans la liste tabou
            ordre = switchTwoTasks(ordre, i, j); //on effectue le mouvement


            //Si le nouvel ordre est meilleur que le meilleur, on remplace le meilleur
            if(ensembleTache.calculerTempTraitement(ordre) < ensembleTache.calculerTempTraitement(bestSolution)) {
                bestSolution.clear();
                for (int k = 0; k < ordre.size(); k++) {
                    bestSolution.add(ordre.get(k));
                    nbIterationsPourBest = nbRep + 1;
                }
            }
            nbRep++;

        }while(nbRep < nbIterations);

        return bestSolution;
    }

    /*Ajoute un duo dans la liste tabou
    * Si la liste possède déja 7 éléments, elle supprime le premier élément
    * */
    private static void ajouterDansListeTabou(int i, int j) {
        if(listTabou.size() > 7){
            listTabou.remove(0);
        }

        ArrayList<Integer> ajout = new ArrayList<>();
        ajout.add(i);
        ajout.add(j);
        listTabou.add(ajout);
    }

    /*
    * Cette fonction sert à savoir si un duo est présent dans la liste tabou
    * Elle retourne true si il est présent, false sinon
    */
    private static boolean isInListTabou(int k, int l) {
        ArrayList<Integer> verif = new ArrayList<>();
        verif.add(k);
        verif.add(l);
        ArrayList<Integer> verif2 = new ArrayList<>();
        verif2.add(l);
        verif2.add(k);
        return (listTabou.contains(verif) || listTabou.contains(verif2));
    }

    /*
    * Cette fonction permet de connaitre la difference de couts pour tous les voisins
    * Elle retourne un tableau de int à deux dimensions
    * */
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

    /*
    * Cette fonciton permet de switcher deux taches
    * Elle retourne un nouveau ArrayList<Integer> avec les deux taches inversées
    * */
    private static ArrayList<Integer> switchTwoTasks(ArrayList<Integer> tab, int i, int j){
        ArrayList<Integer> newTab = new ArrayList<>(tab);
        newTab.set(j, tab.get(i));
        newTab.set(i, tab.get(j));

        return newTab;
    }


    /*
    * Cette fonction génère un ArrayList contenant un ordre aléatoire de nbTaches tâches*/
    private static ArrayList<Integer> randomOrderTab(int nbTaches) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < nbTaches; i++){
            list.add(i+1);
        }
        Collections.shuffle(list);

        return list;
    }


}
