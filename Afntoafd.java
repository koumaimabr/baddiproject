
package afnTOafd;

import java.util.*;

public class Afntoafd  {
	private char a;
	private String fon[][];
	private int ligneGlobale;
	private int ligne;
	private int col;
	private int ligneTest;
	private int colTest;
	private  String fn[];

	public void testEpsilonTransition(Afn schema){
		if (schema.testEpsilon()==true)
			a='o'; //pas epsilon transition
		
		else
			a='f';
	}
	public void afficherFonctionTransition(){

	for(int i=0;i<fon.length;i++){
	for(int j=0;j<fon[0].length;j++){
		System.out.print(fon[i][j]+"\t");
	}
	System.out.println("");	
	}
	}
	public void transfert(Afn schema){
		ArrayList <String> temp;
	if(a=='o'){ //sans epsilon transition
		/*
		fon=new String[4][3];/////////////§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
			fon[0][0]=" ";
			for (int i=1;i<=schema.alphabet.size();i++)
				fon[0][i]=schema.alphabet.get(i-1).toString();
			fon[1][0]="{q0}";
	        ligneTest=1;
			colTest=1;
			ligne=1;
			col=1;
			for(int j=0;j<schema.alphabet.size();j++){ 
				fon[ligne][col]=schema.fonctionTransition[0][j];
				col++;
				}
			ligne++;col=0;
			ligneGlobale=2;
			do{
			if(ligneGlobale==2)
			remplirligne(schema.alphabet.size());
			
		
		if (fon[ligneGlobale][0]== null)	{
			System.out.println("rien");
		}
		
		
			//transformer chaine array list 
			 temp = new ArrayList <String> ();
			for(int l=0;l<schema.etats.size();l++){
				String c=schema.etats.get(l);
				if(fon[ligneGlobale][0].contains(c)==true){
					temp.add(c);
				}
			}

			remplircolonne(temp,schema);
			remplirligne(schema.alphabet.size());
		

			//}while(fon[ligneGlobale][0]!= null);
			}while(ligneGlobale<=3);
			*/
		}
	else{ 
           //avec epsilon transition
   //calcul epsilon-fermeture
		fn =new String[schema.etats.size()];
		for(int i =0;i<schema.etats.size();i++){
			String e=schema.etats.get(i);
			fn[i]=e;
				if(schema.fonctionTransition[i][schema.alphabet.size()]!="vide"){
					String z=schema.fonctionTransition[i][schema.alphabet.size()];
		      	fn[i]+=z;
		}
				
				for(int j=0;j<schema.etats.size();j++){
					for (int l=0;l<schema.etats.size();l++){
						if ( l!=j){
							if(fn[l].contains(schema.etats.get(j))){
								fn[l]+=fn[j];
							}
								
						}
					}
				}
				int et=0;
				do{
					
				ArrayList <String> t=new ArrayList <String> ();
				for(int l=0;l<schema.etats.size();l++){
					String c=schema.etats.get(l);
					if(fn[et].contains(c)==true){
						t.add(c);
					}
				}
				String chaine="{";
				for(int l=0;l<t.size();l++){
					chaine=chaine+t.get(l);
					if(l!=t.size()-1)
					chaine=chaine+",";
					else
						chaine=chaine+"}";	
				}	
				
				fn[et]=chaine;
				et++;
				}while( et<schema.etats.size());
					
		fon=new String[5][3];//cas particulier
		fon[0][0]=" ";
		for (int z=1;z<schema.alphabet.size();z++)
			fon[0][z]=schema.alphabet.get(z-1).toString();
		fon[1][0]=fn[0];
		ligneTest=1;
		colTest=1;
		ligne=1;
		col=1;
		ligneGlobale=1;
		
		do{	
		//transformer chaine array list 
		temp=new ArrayList <String> ();
		for (int l=0;l<schema.etats.size();l++){
			String c=schema.etats.get(l);
			if(fon[ligneGlobale][0].contains(c)==true){
				temp.add(c);
			}
		}

		remplircolonne(temp,schema);//ligneGlobale++;col=0;
	    remplirligne(schema.alphabet.size());
	    
		 }while(ligneGlobale <= 5);
		
		
	}
		
	}}
	/*
	public void remplircolonne(ArrayList <String> tem,Afn sc){
		ArrayList <String> tp;col=1;
		for(int j=0;j<sc.alphabet.size();j++){
		for(int i=0;i<tem.size();i++){
			String  a= tem.get(i).substring(1,2);
			int z= Integer.parseInt(a);
			if(i==0)
			fon[ligneGlobale][col]=sc.fonctionTransition[z][j];	
			else
				fon[ligneGlobale][col]+=sc.fonctionTransition[z][j];	
		}

		
		tp=new ArrayList <String> ();
		for(int l=0;l<sc.etats.size();l++){
			String c=sc.etats.get(l);
			if(fon[ligneGlobale][col].contains(c)==true){
				tp.add(c);
			}
		}
		String chaine="{";
		for(int l=0;l<tp.size();l++){
			chaine=chaine+tp.get(l);
			if(l!=tp.size()-1)
			chaine=chaine+",";
			else
				chaine=chaine+"}";	
		}
		fon[ligneGlobale][col]=chaine;
		col++;
	}
		
		ligneGlobale++;col=0;
	}
	*/
	public void remplircolonne(ArrayList <String> tem,Afn sc){
	if(tem.get(0)=="vide"){
		col=1;
		for(int j=0;j<sc.alphabet.size();j++){
			fon[ligneGlobale][col]="vide";
			col++;
		}
	    }
	else{ArrayList <String> tp;col=1;
	
	for(int j=0;j<sc.alphabet.size();j++){
	for(int i=0;i<tem.size();i++){
		String  a= tem.get(i).substring(1,2);
		int z= Integer.parseInt(a);
		if(i==0){
			fon[ligneGlobale][col]=sc.fonctionTransition[z][j];
		}
		else{
			fon[ligneGlobale][col]+=sc.fonctionTransition[z][j];
			}
	}
	boolean testVide=true;
	for(int l=0;l<sc.etats.size();l++){
		String c=sc.etats.get(l);
		if(fon[ligneGlobale][col].contains(c)==true){
			             testVide=false;
		}
	}
	if(testVide==true) fon[ligneGlobale][col] = "vide";
	if(fon[ligneGlobale][col] != "vide"){
	if(a =='f'){
		ArrayList <String> ta=new ArrayList <String> ();
		for(int l=0;l<sc.etats.size();l++){
			String c=sc.etats.get(l);
			if(fon[ligneGlobale][col].contains(c)==true){
				              fon[ligneGlobale][col]+=fn[l];

			}
		}
	}

	tp=new ArrayList <String> ();
	for(int l=0;l<sc.etats.size();l++){
		String c=sc.etats.get(l);
		if(fon[ligneGlobale][col].contains(c)==true){
			tp.add(c);
		}
	}
	String chaine="{";
	for(int l=0;l<tp.size();l++){
		chaine=chaine+tp.get(l);
		if(l!=tp.size()-1)
		chaine=chaine+",";
		else
			chaine=chaine+"}";	
	}
	fon[ligneGlobale][col]=chaine;
	col++;
}
	}
	
	ligneGlobale++;col=0;}
		
	}
		

	public void remplirligne(int taille){
		int tailleGlobaleParcours=1;boolean test;
		do{	
			test=true;
		
		for(int m=1;m<ligne;m++){
		if(fon[ligneTest][colTest].equals(fon[m][0])==true){
			test=false;}
		}
			
			if(test==true){
			fon[ligne][col]=fon[ligneTest][colTest];ligne++;}
			
			if(colTest==taille){
			ligneTest++;colTest=1;	
		                       }
			else {
				colTest++   ;                              
		         }
		tailleGlobaleParcours++;
		}while(tailleGlobaleParcours<=taille);
	}
	
	
}
