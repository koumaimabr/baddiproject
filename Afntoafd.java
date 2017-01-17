
package afnTOafd;

import java.util.*;

public class Afntoafd {
	private char a;
	private String fon[][];
	private String fin[][];
	private int ligneGlobale;
	private int ligne;
	private int col;
	private int ligneTest;
	private int colTest;
	private  String fn[];
	private int varVide;

	public void testEpsilonTransition(Afn schema){
		if (schema.testEpsilon()==true)
			a='o'; //pas epsilon transition
		
		else
			a='f';
	}
	public void afficherFonctionTransition(){

	for(int i=0;i<fin.length;i++){
	for(int j=0;j<fin[0].length;j++){
		System.out.print(fin[i][j]+"\t \t ");
	}
	System.out.println("");	
	}
	}
	public void afficherInfoAFd(Afd oo,Afn ii){
		for(int k=0;k<ii.tailleAlphabet();k++){
	      oo.alphabet.add(ii.alphabet.get(k));
	                                          }
			int kk=1;
			do{
		    oo.etats.add(fin[kk][0]);
		    kk++;
			}while(kk<fin.length) ;  
			
		oo.etatInitial=fin[2][0];
		
		for(int k=0;k<ii.tailleEtatsFinaux();k++){
		    String et=ii.etatsFinaux.get(k);
		    for(int kl=2;kl<fin.length;kl++){
			  if(fin[kl][0].contains(et)==true)  oo.etatsFinaux.add(fin[kl][0]);
		     }
		}
		oo.fonctionTransition=new String[oo.tailleEtats()][oo.tailleAlphabet()];
	int po=0;int pi;
		for(int mp=1;mp<fin.length;mp++){
			pi=0;
			for(int mo=1;mo<fin[mp].length;mo++){
				oo.fonctionTransition[po][pi]=fin[mp][mo] ;
				pi++;
			}
	po++;
			} 
			
		
		}
	public void transfert(Afn schema){
		varVide=0;
		ArrayList <String> temp;
		for(int mp=0;mp<schema.etats.size();mp++){
		for(int mo=0;mo<schema.alphabet.size();mo++){
           if (schema.fonctionTransition[mp][mo]=="vide")
        	   varVide=1;mo=schema.alphabet.size();
		}
		mp=schema.etats.size();
		}
	
	if(a=='o'){ //sans epsilon transition
		fon=new String[100][schema.alphabet.size()+1];
		
		for(int i=0;i<100;i++){fon[i][0]="fin";}
			fon[0][0]=" ";
			for (int i=1;i<=schema.alphabet.size();i++)
				fon[0][i]=schema.alphabet.get(i-1).toString();
			if(varVide==1 || varVide==0 ){for (int i=0;i<=schema.alphabet.size();i++)
				fon[1][i]="vide";}
			fon[2][0]="{q0}";
	        ligneTest=2;
			colTest=1;
			ligne=2;
			col=1;
			for(int j=0;j<schema.alphabet.size();j++){ 
				fon[ligne][col]=schema.fonctionTransition[0][j];
				col++;
				}
			ligne++;col=0;
			ligneGlobale=3;
			remplirligne(schema.alphabet.size());//ligne vide
			do{
				if(fon[ligneGlobale][0]=="fin"){break;}
			 temp = new ArrayList<String> ();
			for(int l=0;l<schema.etats.size();l++){
				String c=schema.etats.get(l);
				if(fon[ligneGlobale][0].contains(c)==true){
					temp.add(c);
				}
			}
			
			remplircolonne(temp,schema);
			remplirligne(schema.alphabet.size());
			
			
			}while(ligneGlobale<100);
			fin= new String[ligneGlobale][schema.alphabet.size()+1];
			for (int j=0;j<ligneGlobale;j++){
				for(int k=0;k<schema.alphabet.size()+1;k++){
					fin[j][k]=fon[j][k];
				}
			}
		
		}
	else{ 
           //avec epsilon transition
   //calcul epsilon-fermeture
		fn =new String[schema.etats.size()];
		for(int i=0;i<schema.etats.size();i++){
			String e=schema.etats.get(i);
			fn[i]=e;
				if(schema.fonctionTransition[i][schema.alphabet.size()]!="vide"){
					String z=schema.fonctionTransition[i][schema.alphabet.size()];
		      	fn[i]+=z;
				                                                               }
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
					
		fon=new String[100][schema.alphabet.size()+1];
		for(int i=0;i<100;i++){
		fon[i][0]="fin";}
		fon[0][0]=" ";
		for (int z=1;z<=schema.alphabet.size();z++)
			fon[0][z]=schema.alphabet.get(z-1).toString();
		if(varVide==1 || varVide==0 ){for (int i=0;i<=schema.alphabet.size();i++)
			fon[1][i]="vide";}
		fon[2][0]=fn[0];
		ligneTest=2;
		colTest=1;
		ligne=2;
		col=1;
		ligneGlobale=2;
		
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
		if(ligneGlobale==3)ligne++;
	    remplirligne(schema.alphabet.size());
	    if(fon[ligneGlobale][0]=="fin"){break;}
		 }while(ligneGlobale < 100);
		fin= new String[ligneGlobale][schema.alphabet.size()+1];
		for (int j=0;j<ligneGlobale;j++){
			for(int k=0;k<schema.alphabet.size()+1;k++){
				fin[j][k]=fon[j][k];
			}
		}
		
		
	}
		
	}
	
	public void remplircolonne(ArrayList <String> tem,Afn sc){
 
		
		
		ArrayList <String> tp;col=1;
	
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
		

		

	public void remplirligne(int taille){
		int tailleGlobaleParcours=1;boolean test;
		do{	
			test=true;
			for(int m=1;m<ligne;m++){
				if(fon[ligneTest][colTest].equals(fon[m][0])==true){
					test=false;}
				}
					
					if(test==true){
					fon[ligne][0]=fon[ligneTest][colTest];ligne++;}
					
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
