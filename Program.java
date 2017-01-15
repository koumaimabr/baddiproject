package afnTOafd;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Scanner lectureClavier = new Scanner(System.in);
        Afd exemple1 = new Afd();
        Afntoafd exemple2 = new Afntoafd();

        int choix;
        boolean test = true;
        exemple1.menuAlphabet();

        do {
            System.out.print("enter votre choix:   ");
            choix = lectureClavier.nextInt();
            switch (choix) {
                case 1:
                    exemple1.ajouterSymbole();
                    break;
                case 2:
                    exemple1.supprimerSymbole();
                    break;
                case 3:
                    exemple1.affichageAlphabet();
                    break;
                case 4:
                    System.out.println(exemple1.tailleAlphabet());
                    break;
                case 5:
                    test = false;
                    break;
            }
        } while (test == true);


        exemple1.menuEtat();
        test = true;
        do {
            System.out.print("enter votre choix:   ");
            choix = lectureClavier.nextInt();
            switch (choix) {
                case 1:
                    exemple1.ajouterEtats();
                    break;
                    //case 2: exemple1.supprimeretat();break;
                case 2:
                    exemple1.affichageEtats();
                    break;
                case 3:
                    System.out.println(exemple1.tailleEtats());
                    break;
                case 4:
                    test = false;
                    break;
            }
        } while (test == true);

        exemple1.saisirEtatFinaux();
        exemple1.affichageEtatsInitial();
        exemple1.fonctionTrans();
        //exemple1.afficherFonctionTransition();

       // exemple2.testEpsilonTransition(exemple1);
       // exemple2.transfert(exemple1);
        exemple2.afficherFonctionTransition();


    }

}