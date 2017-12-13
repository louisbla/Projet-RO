package Model;
import java.util.concurrent.ThreadLocalRandom;

public class AlgorithmeGenetique {
    public static int[] AlgoGenetique(EnsembleTache ensembleTache)
    {
        /*Les trois variables ci dessous permettent de configurer notre algorithme génétique
         * en définissant la taille des tournois, le nombre de mutations et le facteur de mutation */
        int nombreTournoi=100; // une population de 100 individus suffit largement
        int adversaireParTournoi=100;
        int nombreIterationGenetique=1000;
        int facteurMutation=20;

        /* on déclare ensuite les tableaux que nous allons utiliser */
        int tempsOptimal[]=new int[ensembleTache.getnbTaches()];
        int tempOptimalBeforeChange[]=new int[ensembleTache.getnbTaches()];
        int tabIndividus[][]= new int[nombreTournoi][ensembleTache.getnbTaches()];
        int tabEnfants[][]= new int[nombreTournoi][ensembleTache.getnbTaches()];
        int tableauParentEnfant[][]= new int[nombreTournoi*2][ensembleTache.getnbTaches()];
        int tabTampon[]= new int[ensembleTache.getnbTaches()];

        int tempVal; // une variable tampon
        int random; // une variable qui va etre utilisé pour les brassages dans le tournoi

        /* les variables qui suivent servent lors du brassage des gènes
         * elles prendront toutes des valeurs aléatoires */
        int cassure1; // les cassures serviront à decouper les gènes parents
        int cassure2;
        int placeElementAChanger1; // Les palces sont les individus parents qui vont composer l'individu enfant
        int placeElementAChanger2;
        int placeElementAChanger3;
        int indentation; // va nous servir pour comparer les différentes taches savoir si elles sont deja dans l'individus enfant


        for(int tournoi=0; tournoi<nombreTournoi;tournoi++)
        {
            for(int i=0;i< ensembleTache.getnbTaches();i++)
            {
                tempsOptimal[i]=i+1; // pour chaque tournoi on repart de l'ordre de base
            }
            // pour chaque tournoi on selectionne adversaireParTournoi éléments au hasard, on ne gardera que le meilleur à chaque fois
            for(int selection=0;selection<adversaireParTournoi;selection++)
            {
                for(int parcoursTab=0;parcoursTab<ensembleTache.getnbTaches();parcoursTab++)
                {
                    tempOptimalBeforeChange[parcoursTab]=tempsOptimal[parcoursTab];
                }
                for(int i=0;i<ensembleTache.getnbTaches();i++)
                {
                    //brassage aléatoire: on échange au hasard deux valeurs dans le tableau et ce nbTaches fois
                    random= ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
                    tempVal=tempsOptimal[random];
                    tempsOptimal[random]=tempsOptimal[i];
                    tempsOptimal[i]=tempVal;
                }
                if(ensembleTache.calculerTempTraitement(tempsOptimal)>ensembleTache.calculerTempTraitement(tempOptimalBeforeChange))
                {
                    // si l'element est moins bon que le précédent, on ne le garde pas
                    for(int i=0;i<ensembleTache.getnbTaches();i++)
                        tempsOptimal[i]=tempOptimalBeforeChange[i];
                }
            }
            for(int i=0;i<ensembleTache.getnbTaches();i++)
            {
                tabIndividus[tournoi][i]=tempsOptimal[i];
            }
        }

        /* a la sortie de ce tournoi nous avons donc une poputation initiale conséquente placé dans un tableau. nous
         * allons donc maintenant appliquer l'algorithme genetique grace à plusieurs crossover et mutation.
          * Nous remplacerons les pire parents par les meilleurs enfants.  on inclus également un coefficient de mutation
          * aléatoire, ce dernier nous permettra de sortir d'un eventuel minimum local*/


        for(int genetique=0;genetique<nombreIterationGenetique;genetique++)
        {
             cassure1=ThreadLocalRandom.current().nextInt(1, (ensembleTache.getnbTaches()/2)-1);
             cassure2=ThreadLocalRandom.current().nextInt((ensembleTache.getnbTaches()/2)+1, ensembleTache.getnbTaches()-2);

             for(int compteur=0;compteur<nombreTournoi;compteur++)
             {
                 //On choisit au hasard des element qui vont composer l'enfant voulu
                 placeElementAChanger1=ThreadLocalRandom.current().nextInt(0, nombreTournoi);
                 placeElementAChanger2=ThreadLocalRandom.current().nextInt(0, nombreTournoi);
                 placeElementAChanger3=ThreadLocalRandom.current().nextInt(0, nombreTournoi);

                 // Ensuite on remplis le tableau d'enfant avec les elements pris au hasard
                 for(int compteurCasssure1=0; compteurCasssure1<cassure1;compteurCasssure1++)
                 {
                     tabEnfants[compteur][compteurCasssure1]=tabIndividus[placeElementAChanger1][compteurCasssure1];
                 }
                 indentation=0;
                 for(int compteurCasssure2=cassure1; compteurCasssure2<cassure2;compteurCasssure2++)
                 {

                     for(int verifDoublon=0;verifDoublon<cassure1;verifDoublon++)
                     {
                         // n va utiliser un % au cas ou on devrait retourner au debut du tableau chercher la valeur suivante
                        if(tabEnfants[compteur][verifDoublon]==tabIndividus[placeElementAChanger2][(compteurCasssure2+indentation)%(ensembleTache.getnbTaches())])
                        {
                            // si on trouve un doublon, on passe au chiffre d'apres et on retest depuis le début
                            indentation++;
                            verifDoublon=-1;
                        }
                     }
                     tabEnfants[compteur][compteurCasssure2]=tabIndividus[placeElementAChanger2][(compteurCasssure2+indentation)%(ensembleTache.getnbTaches())];
                 }
                 indentation=0;
                 for(int compteurFinTaches=cassure2;compteurFinTaches<ensembleTache.getnbTaches();compteurFinTaches++)
                 {

                     for(int verifDoublon=0;verifDoublon<cassure2;verifDoublon++)
                     {
                     // n va utiliser un % au cas ou on devrait retourner au debut du tableau chercher la valeur suivante
                         if(tabEnfants[compteur][verifDoublon]==tabIndividus[placeElementAChanger3][(compteurFinTaches+indentation)%(ensembleTache.getnbTaches())])
                         {
                             indentation++;
                             verifDoublon=-1; // car quand on va sortir de l'iteration de boucle verifDoubon va augmenter a 0
                         }
                     }
                     tabEnfants[compteur][compteurFinTaches]=tabIndividus[placeElementAChanger3][(compteurFinTaches+indentation)%(ensembleTache.getnbTaches())];
                 }
             }

             /*on va ensuite trier les valeurs obtenus en prenant en comptes les parents et les enfants. On gardera
             * la même taille de population donc on éliminera les 100 individus les moins bons pour ne garder que les
             * meilleurs */

             for(int i=0;i<nombreTournoi;i++)
             {
                 for (int j = 0; j < ensembleTache.getnbTaches(); j++) {
                     tableauParentEnfant[i][j] = tabIndividus[i][j];
                     tableauParentEnfant[nombreTournoi+i][j]=tabEnfants[i][j];
                 }
             }

            /* on procede ici à un tri à bulle afin de trier nos individus parents et enfants
            * pour ne placer dans le nouveau tableau individu que les meilleurs*/
            for(int i=0;i<nombreTournoi*2;i++)
            {
                for(int j=0;j<nombreTournoi*2-1;j++)
                {
                    if(ensembleTache.calculerTempTraitement(tableauParentEnfant[j])>ensembleTache.calculerTempTraitement(tableauParentEnfant[j+1]))
                    {
                        for(int k=0;k<ensembleTache.getnbTaches();k++)
                        {
                            tabTampon[k]=tableauParentEnfant[j][k];
                            tableauParentEnfant[j][k]=tableauParentEnfant[j+1][k];
                            tableauParentEnfant[j+1][k]=tabTampon[k];
                        }
                    }
                }
            }
                //on modifie ensuite le tableau individu pour lui affecter les meilleurs individus triés precédement
                for(int i=0;i<nombreTournoi;i++)
                {
                    for(int j=0;j<ensembleTache.getnbTaches();j++)
                    {
                        tabIndividus[i][j]=tableauParentEnfant[i][j];;
                    }
                }
                /* ensuite on va effectuer une mutation sur un individu au hasard,
                 * cela va nous permettre de sortir d'un éventuel minimum local grace a la variable
                 * facteurMutation on défini combien de mutations peuvent survenir*/
                for(int mutation=0; mutation<facteurMutation;mutation++)
                {
                    int individuMutable=ThreadLocalRandom.current().nextInt(1, nombreTournoi); // on ne mute pas le meilleur element
                    int j=ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
                    int k=ThreadLocalRandom.current().nextInt(0, ensembleTache.getnbTaches());
                    int tampon=tabIndividus[individuMutable][j];
                    tabIndividus[individuMutable][j]=tabIndividus[individuMutable][k];
                    tabIndividus[individuMutable][k]=tampon;
                }
        }
        return tabIndividus[0]; // on retourne le meilleur individus de la table individus
    }
}
