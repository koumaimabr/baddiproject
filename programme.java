package projet_compilationAFTtoAFD;

import java.util.Scanner;

public class programme {
	
public  static void  main(String [] args){
	AFD exemple1= new AFD();
	Scanner lecture=new Scanner(System.in);
	int choix;boolean test=true;
    exemple1.menuSymbole();
    
    do{
    	System.out.print("enter votre choix");
        choix=lecture.nextInt();
    switch(choix){
    case 1: exemple1.ajouterSymbole();break;
    //case 2: exemple1.;break;
    //case 3: exemple3.;break;
    //case 4: exemple4.;break;
    case 5: test=false;break;
    }
    }while(test== true);
    
    
    exemple1.menuEtat();
    
    do{
    	System.out.print("enter votre choix");
        choix=lecture.nextInt();
    switch(choix){
    case 1: exemple1.ajouterEtat();break;
    //case 2: exemple1.;break;
    //case 3: exemple3.;break;
    //case 4: exemple4.;break;
    case 5: test=false;break;
    }
    }while(test== true);
	
	
}
}
