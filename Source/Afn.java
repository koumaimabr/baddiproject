package afnTOafd;
import java.util.*;
public class Afn{
	public ArrayList <Character> alphabet;
	public ArrayList <String> etats;
	public ArrayList <String> etatsFinaux;
	public String [][] fonctionTransition;
	public String etatInitial;
	public int nombreEtatFinaux;

	Scanner lectureClavier=new Scanner(System.in);
	//////////////////////constructeur ///////////////////////////////////////////////////////////////////
	public Afn(){

		alphabet= new ArrayList <Character> ();
		etats= new ArrayList <String> () ;
		etatsFinaux= new ArrayList <String>() ;
	}
	
	public void ajouterSymbole(char a)
	{
		alphabet.add(new Character(a));

	}
	
	public void ajouterEtats(int a) {
        
        String e;

        //System.out.print("donnez le nombre des états que vous souhaitez utilisés \n dans ce afd, par la suite on vous généra les noms de ce états comme suit en respectant l'ordre : q0,q1,q2,q3,....tel que q0 est \n l'état initial;cette démarche simplifie l'étude par la suite:    ");
        //a = lectureClavier.nextInt();

        for (int i = 0; i < a; i++) {
            e = "q" + i;
            etats.add(e);
        }

    }
	
	
	public String affichageAlphabet(){
		String affichAlphabet ="";
		int taille = tailleAlphabet();
		for(int i=0;i<taille;i++){
			affichAlphabet += alphabet.get(i)+" ";
		}
		return affichAlphabet;
	}
	
	//////////////////////alphabet /////////////////////////////////////////////////////////////////////
	public void ajouterSymbole(){
		char a;int z;
		System.out.print("donner un symbole de type charactère:   ");
		a=lectureClavier.next().charAt(0);
		if(tailleAlphabet()!=0){
			z=alphabet.indexOf(a);
			if(z !=-1){
			 System.out.println("ce sympole existe deja, le  charactère est refusé");}
			
			else{alphabet.add(new Character(a));
			System.out.println("votre symbole ajouté est :   "+a);}
				}
			else{
		alphabet.add(new Character(a));
		System.out.println("votre symbole ajouté est :   "+a);}
		
	}

	public void supprimerSymbole(){
	    int num;char choix;
	    System.out.println("Saisir le symbole que vous voulez supprimer :");
	    choix=lectureClavier.next().charAt(0);
	    Character ch=new Character(choix);
		num=alphabet.indexOf(ch);
		if(num >= 0){
		alphabet.remove(num);
		System.out.println("la suppression est faite avec succés ");
		}
		else
		System.out.println("ce charactère n'existe pas ");
	}

	public int tailleAlphabet(){
		return alphabet.size();
	}

	/*public void affichageAlphabet(){
		 int taille=tailleAlphabet();
		 for(int i=0;i<taille;i++){
			 System.out.print(alphabet.get(i)+"\t");
		 }
	}*/

	public void menuAlphabet(){
		System.out.println("choix 1: ajouter symbole");
		System.out.println("choix 2: supprimer symbole");
		System.out.println("choix 3: afficher alphabet");
		System.out.println("choix 4: afficher taille alphabet");
		System.out.println("choix 5: sortir de ce menu");
	}
	//////////////////////////Etats
	public void menuEtat(){
		System.out.println("choix 1: ajouterun état:    ");
		//System.out.println("choix 2: supprimer etat:    ");
		System.out.println("choix 2: afficher etat:     ");
		System.out.println("choix 3: afficher taille etats");
		System.out.println("choix 4: sortir de ce menu ");
	}

	public void ajouterEtats(){
		int  a;String e;
	   
		System.out.print("donnez le nombre des états que vous souhaitez utilisés \n dans ce afd, par la suite on vous généra les noms de ce états comme suit en respectant l'ordre : q0,q1,q2,q3,....tel que q0 est \n l'état initial;cette démarche simplifie l'étude par la suite:    ");
		a=lectureClavier.nextInt();
		//nombre devrait etre >1

		for(int i=0;i<a;i++){
		e="q"+i;	
		etats.add(e);
		}
		
	}

	public void supprimeretat(){
	    int num;
	    String choix;
	    System.out.print("saisir l'état : ");
	    choix=lectureClavier.nextLine();
	    num=alphabet.indexOf(choix);
	    if(num != -1)
		alphabet.remove(num);
	    else 
	    	System.out.print("cette état n'existe pas ");	
		
	}

	public int tailleEtats(){
		return etats.size();
	}

	 /*public void affichageEtats(){
		 int taille=tailleEtats();
		 for(int i=0;i<taille;i++){
			 System.out.print(etats.get(i)+"\t");
		 }
		 System.out.println();
	 }*/
	 
	 public String affichageEtats() {
	        int taille = tailleEtats();
	        String lesEtats = "";
	        for (int i = 0; i < taille; i++) {
	        	lesEtats += " "+etats.get(i);
	        }
	        return lesEtats;
	    }
	/////////////////////////////////////////Etats finaux
	public void saisirEtatFinaux(){
		String f;boolean test;int nombreEtatFinaux;
		do{
		System.out.println("Veuillez saisir le nombre d'états finaux: ");
	 nombreEtatFinaux=lectureClavier.nextInt();
	      }while(nombreEtatFinaux<=0);
		for(int i=0;i<nombreEtatFinaux;i++){
			System.out.print("Veuillez saisir le"+(1+i)+" état final: ");
		do{
			f=lectureClavier.nextLine();
			test=verifierEtat(f);
			}while(test==false);
		etatsFinaux.add(f);
	}
		System.out.print("\n");
	}

	public void affichageEtatsFinaux(){
		 int taille=tailleEtatsFinaux();
		 for(int i=0;i<taille;i++){
			 System.out.print(etatsFinaux.get(i)+"\t");
		 }
		 System.out.print("\n");
	}

	public int tailleEtatsFinaux(){
		return etatsFinaux.size();
	}
	///////////////////////////////////// Etat initial                 
	/*
	public void saisirEtatInitial(){
		String f;boolean test;
		System.out.print("Veuillez saisir l'état initial:   ");
		do{
			f=lectureClavier.nextLine();
			test=verifierEtat(f);
			}while(test==false);
		etatInitial=f;	
	}
	*/
	public String getEtatInitial(){
		etatInitial="q0";
		return etatInitial;
	}

	public void affichageEtatsInitial(){
	  System.out.println("l'état initial de votre AFD est : "+getEtatInitial());
	}
///////////////////////////////////////////fonction transition::::::
   public void fonctionTrans(){
fonctionTransition= new String[etats.size()][alphabet.size()+1];
String var;ArrayList <String> tab;int r;int y;
for(int i=0;i<etats.size();i++){
String q=etats.get(i);
for(int j=0;j<alphabet.size()+1;j++){
if(j==alphabet.size()){
System.out.println("donnez le résultat de ("+q+",'epsilon')");
System.out.println("choisissez soit 'vide' ou 'un ou plusieurs états' ");
}
else{
char a=alphabet.get(j);
System.out.println("donnez le résultat de ("+q+","+a+")");
System.out.println("choisissez soit 'vide' ou 'un ou plusieurs états', veuillez saisir 1 ou 2  : ");
}
int re=lectureClavier.nextInt();
if(re == 1){
fonctionTransition[i][j]="vide";
}
if(re == 2){
 tab=new ArrayList <String> ();
System.out.println("saisir le nombre d'états");
 r=lectureClavier.nextInt();
System.out.println("donnez le résultat de cette transition état par état :   ");
for(int l=1;l<=r;l++){
System.out.print("donnez le "+l+" état :   ");
do{
var=lectureClavier.nextLine();
 y =etats.indexOf(var);
}while(y==-1);
tab.add(var);
}
String chaine="{";
for(int l=0;l<tab.size();l++){
if(l <tab.size()-1)
chaine=chaine+tab.get(l)+",";
else
chaine=chaine+tab.get(l)+"}";	
}
fonctionTransition[i][j]=chaine;
}
}
}
}
public boolean testEpsilon(){
boolean test=true;int j=alphabet.size();/////////////////////////////////////////////////////////////////:
for(int i=0;i<etats.size();i++){
if(fonctionTransition[i][j]!= "vide"){
test=false;i=etats.size();	}
}
return test;
}

public void afficherFonctionTransition(){
	System.out.print("\t");
	affichageAlphabet();
	System.out.print("\n");
for(int i=0;i<etats.size();i++){
	System.out.print(etats.get(i)+"\t");
for(int j=0;j<alphabet.size()+1;j++){

System.out.print(fonctionTransition[i][j]);
System.out.print("\t");
}
System.out.println("");	
}
}
///////////////////////////////////////////:

private boolean verifierEtat(String f) {
int position=etats.indexOf(f);
if(position==-1)return false;
else 
return true;
}
	

}
