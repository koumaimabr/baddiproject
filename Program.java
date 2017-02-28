package afnTOafd;

public class Program {

}
	
	/*
public  static void  main(String [] args){
	Scanner lectureClavier=new Scanner(System.in);
	Afn exemple1= new Afn();
	Afntoafd exemple2= new Afntoafd();
	Afd resultatFinal= new Afd();
	Afntoafd mini= new Afntoafd();
	//Ui_MainWindow mainw = new Ui_MainWindow();
	int choix;boolean test=true;
    exemple1.menuAlphabet();
    
    do{
    	System.out.print("enter votre choix:   ");
        choix=lectureClavier.nextInt();
    switch(choix){
    case 1: exemple1.ajouterSymbole();break;
    case 2: exemple1.supprimerSymbole();break;
    case 3: exemple1.affichageAlphabet();break;
    case 4: System.out.println(exemple1.tailleAlphabet());break;
    case 5: test=false;break;
    }
    }while(test== true);
    
    
    exemple1.menuEtat();
   test=true;
    do{
    	System.out.print("enter votre choix:   ");
        choix=lectureClavier.nextInt();
    switch(choix){
    case 1: exemple1.ajouterEtats();break;
    //case 2: exemple1.supprimeretat();break;
    case 2: exemple1.affichageEtats();break;
    case 3: System.out.println(exemple1.tailleEtats());break;
    case 4: test=false;break;
    }
    }while(test== true);
    
    exemple1.saisirEtatFinaux();
    exemple1.affichageEtatsInitial();
    exemple1.fonctionTrans();
    exemple1.afficherFonctionTransition();
   
    exemple2.testEpsilonTransition(exemple1);
    exemple2.transfert(exemple1);
    exemple2.afficherFonctionTransition();
    exemple2.afficherInfoAFd(resultatFinal, exemple1);
    resultatFinal.affichageAlphabet();
    resultatFinal.affichageEtats();
    resultatFinal.affichageEtatsFinaux();
    resultatFinal.affichageEtatsInitial();
   // resultatFinal.AfficherFonctionTrans();
   // resultatFinal.afficherFonctionTransitionM();
    //mini.minimiser(resultatFinal);
   resultatFinal.eliminerEtatInaccessible();
   System.out.println("Printing elimini");
   
   print2DArray(resultatFinal.fonctionTransitionM);
   
   
   resultatFinal.minimaliser();
   System.out.println("printing after mini");
   print2DArray(resultatFinal.fonctionTransitionM);
   
}
static void print2DArray(String[][] array) {
	for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array[i].length; j++) {

			System.out.println("Placeholder[" + i + "][" + j + "] = \"" + array[i][j] + "\"" + ";");
		}
	}

}

}*/