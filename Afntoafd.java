
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
	private String fn[];
	private int varVide;
	private String[][] tabMinimal;
	private ArrayList<String> accessible;
	public HashMap<String, String> minimizedStates = new HashMap<String,String>();
	

	public void minimiser(Afd finale) {

		// eliminer vide
		// ///////////////////////////////////////////////////////////////////////
		System.out.println("l'état vide est éliminé");
		// etat
		// accessible///////////////////////////////////////////////////////////////////////
		int nombreEtat = finale.tailleEtats();

		String[] tab = new String[nombreEtat];
		accessible = new ArrayList<String>();
		tab[0] = "o";
		for (int i = 1; i < nombreEtat; i++) {
			tab[i] = "n";
		}
		String testEtat = finale.etatInitial;
		int w = 0;
		for (int i = 0; i < finale.tailleAlphabet(); i++) {

			String resul = finale.fonctionTransitionM[w][i];

			if (resul.compareTo("vide") != 0) {
				// ensemble des états + ajouter une fonction
				String ind = resul.substring(1, 2);

				int ina = Integer.parseInt(ind);
				if (tab[ina].compareTo("o") != 0) {
					accessible.add(resul);
					tab[ina] = "o";
				}

			}

		}

		int tt = accessible.size();

		while (tt != 0) {
			ArrayList<String> el = new ArrayList<String>();

			for (int i = 0; i < accessible.size(); i++)
				el.add(accessible.get(i));
			accessible.clear();
			int ttt = el.size();
			for (int j = 0; j < ttt; j++) {
				testEtat = el.get(j);
				String az = testEtat.substring(1, 2);
				w = Integer.parseInt(az);
				for (int i = 0; i < finale.tailleAlphabet(); i++) {
					String resul = finale.fonctionTransitionM[w][i];
					if (resul.compareTo("vide") != 0) {
						// ensemble des états + ajouter une fonction
						String ind = resul.substring(1, 2);
						int ina = Integer.parseInt(ind);
						if (tab[ina].compareTo("o") != 0) {
							accessible.add(resul);
							tab[ina] = "o";
						}
					}
				}
			}
			tt = accessible.size();
		}
		System.out.println("L'AFFICHAGE DU TABLEAUX QUI MONTRE LES ETAS QUI SONT ACCESSIBLE ET NON ACCESSIBLE: ");

		for (int i = 0; i < tab.length; i++) {
			System.out.println(finale.etats.get(i) + ":   " + tab[i]);
		}
		////////////////////////////////////////////////////////////////////////////////

		/////////////// enlever les états non accessible
		/////////////// /////////////////////:///////////////////////////////////////////

		// for(int i=0;i<tab.length;i++){
		// if(tab[i].compareTo("o") != 0){finale.etats.remove(i);}
		// }
		///////////////////////////////////////////////////////

		////////// algo de
		////////// Moore/////////////////////////////////////////////////////////////////////////////////
		System.out.println("debut de Moore");
		int var = 0;
		String[][] kaw = new String[2 + finale.tailleAlphabet()][finale.tailleEtats() + 1];
		// 1premier
		String[] ta = new String[finale.tailleEtats()];
		if (finale.etatsFinaux.contains(finale.etats.get(0)) == true) {
			for (int i = 0; i < finale.tailleEtats(); i++) {
				if (finale.etatsFinaux.contains(finale.etats.get(i)) == true)
					ta[i] = "1";
				else
					ta[i] = "2";
			}

		} else {
			for (int i = 0; i < finale.tailleEtats(); i++) {
				if (finale.etatsFinaux.contains(finale.etats.get(i)) == false)
					ta[i] = "1";
				else
					ta[i] = "2";
			}
		}
		String varr = Integer.toString(var);
		String bil = "bilan" + varr;
		kaw[0][0] = bil;
		for (int i = 0; i < finale.tailleEtats(); i++) {
			kaw[0][i + 1] = ta[i];
		}

		for (int i = 0; i < finale.tailleAlphabet(); i++) {
			kaw[i + 1][0] = Character.toString(finale.alphabet.get(i));
		}
		var = 1;
		varr = Integer.toString(var);
		bil = "bilan" + varr;
		var++;
		kaw[1 + finale.tailleAlphabet()][0] = bil;
		// remplissage matrice
		for (int j = 0; j < finale.alphabet.size(); j++) {
			for (int k = 0; k < finale.etats.size(); k++) {
				String co = finale.fonctionTransitionM[k][j];
				if (co.compareTo("vide") != 0) {
					String azz = co.substring(1, 2);
					int ww = Integer.parseInt(azz);
					kaw[j + 1][k + 1] = ta[ww];
				} else {
					kaw[j + 1][k + 1] = "vide";
				}

			}

		}
		///// remplir Bilan
		// premier
		int casTraitement = 0;
		int me = 1;
		String meme = Integer.toString(me);
		kaw[1 + finale.tailleAlphabet()][1] = meme;
		me++;
		casTraitement++;
		// autres
		// comparer
		String gg = "";
		while (casTraitement < finale.tailleEtats()) {
			boolean test = false;
			for (int gh = 0; gh < casTraitement; gh++) {
				test = false;
				for (int ll = 0; ll < kaw.length - 1; ll++) {
					if (kaw[ll][gh + 1].compareTo(kaw[ll][casTraitement + 1]) != 0)
						test = true;
				}
				if (test == false) {
					gg = kaw[1 + finale.tailleAlphabet()][gh + 1];
					break;
				}
			}
			if (test == true) {
				meme = Integer.toString(me);
				kaw[1 + finale.tailleAlphabet()][casTraitement + 1] = meme;
				me++;
			} else {
				kaw[1 + finale.tailleAlphabet()][casTraitement + 1] = gg;
			}

			casTraitement++;
		}
		int dd = 0;
		boolean t = true;
		// comparer Bilan
		for (int h = 0; h < finale.etats.size(); h++) {
			if (kaw[0][h + 1].compareTo(kaw[1 + finale.tailleAlphabet()][h + 1]) != 0) {
				t = false;
				break;
			}
		}
		if (t == true) {
			System.out.println(" l'automate est minimisé  ");
		} else {
			System.out.println(" l'automate n'est minimisé  ");
			dd = 1;
		}
		////////// affichage matrice
		for (int i = 0; i < 2 + finale.tailleAlphabet(); i++) {
			for (int j = 0; j < finale.tailleEtats() + 1; j++) {
				System.out.print(kaw[i][j] + "\t  ");
			}
			System.out.println("");
		}

		//////////// traitement après
		//////////// Bilan/////////////////////////////////////////////////////////////////////////

		String[] kaw2;
		while (dd == 1) {
			int km = 1;
			kaw2 = new String[finale.tailleEtats()];
			for (int i = 0; i < finale.tailleEtats(); i++) {
				kaw2[i] = kaw[1 + finale.tailleAlphabet()][km];
				km++;
			}
			// for( int i=0;i<finale.tailleEtats();i++ ){
			// System.out.print(kaw2[i]+"\t");
			// }
			// System.out.println("");
			kaw[0][0] = bil;
			for (int i = 0; i < finale.tailleEtats(); i++) {
				kaw[0][i + 1] = kaw2[i];
			}
			for (int i = 0; i < finale.tailleAlphabet(); i++) {
				kaw[i + 1][0] = Character.toString(finale.alphabet.get(i));
			}

			varr = Integer.toString(var);
			bil = "bilan" + varr;
			var++;
			kaw[1 + finale.tailleAlphabet()][0] = bil;
			for (int i = 0; i < finale.tailleEtats(); i++) {
				ta[i] = kaw2[i];
			}
			// remplissage1matrice
			for (int j = 0; j < finale.alphabet.size(); j++) {
				for (int k = 0; k < finale.etats.size(); k++) {
					String co = finale.fonctionTransitionM[k][j];
					if (co.compareTo("vide") != 0) {
						String azz = co.substring(1, 2);
						int ww = Integer.parseInt(azz);
						kaw[j + 1][k + 1] = ta[ww];
					} else {
						kaw[j + 1][k + 1] = "vide";
					}

				}
			}

			///// remplir Bilan
			// premier
			casTraitement = 0;
			me = 1;
			meme = Integer.toString(me);
			kaw[1 + finale.tailleAlphabet()][1] = meme;
			me++;
			casTraitement++;
			// autres
			// comparer
			gg = "";
			while (casTraitement < finale.tailleEtats()) {
				boolean test = false;
				int gh = 0;
				while (gh < casTraitement) {
					test = false;
					for (int ll = 0; ll < kaw.length - 1; ll++) {
						// System.out.println(kaw[ll][gh+1]);
						// System.out.println(kaw[ll][casTraitement+1]);
						if (kaw[ll][gh + 1].compareTo(kaw[ll][casTraitement + 1]) != 0)
							test = true;
					}

					if (test == false) {
						gg = kaw[1 + finale.tailleAlphabet()][gh + 1];
						break;
					}
					gh++;
				}

				if (test == true) {
					meme = Integer.toString(me);
					kaw[1 + finale.tailleAlphabet()][casTraitement + 1] = meme;
					me++;
				} else {
					kaw[1 + finale.tailleAlphabet()][casTraitement + 1] = gg;
				}

				casTraitement++;
			}
			dd = 0;
			t = true;

			// comparer Bilan
			for (int h = 0; h < finale.etats.size(); h++) {
				t = true;
				if (kaw[0][h + 1].compareTo(kaw[1 + finale.tailleAlphabet()][h + 1]) != 0) {
					t = false;
					break;
				}
			}
			if (t == true) {
				System.out.println(" l'automate est minimisé  ");
			} else {
				dd = 1;
			}
			////////// affichage matrice
			for (int i = 0; i < 2 + finale.tailleAlphabet(); i++) {
				for (int j = 0; j < finale.tailleEtats() + 1; j++) {
					System.out.print(kaw[i][j] + "\t  ");
				}
				System.out.println("");
			}

		}

		// affichage kaw
		System.out.println("=====kaw====");
		for (int i = 0; i < 2 + finale.tailleAlphabet(); i++) {
			for (int j = 0; j < finale.tailleEtats() + 1; j++) {
				System.out.print(kaw[i][j] + "\t  ");
			}
			System.out.println("");
		}

		System.out.println("les états qui restent dans votre automate sont : ");
		for (int i = 0; i < finale.tailleEtats(); i++) {
			if (tab[i].compareTo("o") == 0) {
				System.out.println(finale.etats.get(i) + "=>>>>>>" + ta[i]);
				minimizedStates.put(finale.etats.get(i), ta[i]);
			}
		}

	}

	public void testEpsilonTransition(Afn schema) {
		if (schema.testEpsilon() == true)
			a = 'o'; // pas epsilon transition

		else
			a = 'f';
	}

	public String[][] getFin() {
		return fin;
	}

	public void afficherFonctionTransition() {

		for (int i = 0; i < fin.length; i++) {
			for (int j = 0; j < fin[i].length; j++) {
				System.out.print(fin[i][j] + "\t \t ");
			}
			System.out.println("");
		}
	}

	public void afficherInfoAFd(Afd oo, Afn ii) {
		for (int k = 0; k < ii.tailleAlphabet(); k++) {
			oo.alphabet.add(ii.alphabet.get(k));
		}
		int kk = 1;
		do {
			oo.etats.add(fin[kk][0]);
			kk++;
		} while (kk < fin.length);

		oo.etatInitial = fin[2][0];

		for (int k = 0; k < ii.tailleEtatsFinaux(); k++) {
			String et = ii.etatsFinaux.get(k);
			for (int kl = 2; kl < fin.length; kl++) {
				if (fin[kl][0].contains(et) == true) {
					if (oo.etatsFinaux.size() == 0)
						oo.etatsFinaux.add(fin[kl][0]);
					else {
						// vérifier qu'il n'existe pas apèrs on l'ajoute
						boolean te = true;
						for (int i = 0; i < oo.etatsFinaux.size(); i++) {
							if (fin[kl][0] == oo.etatsFinaux.get(i))
								te = false;
						}
						if (te == true)
							oo.etatsFinaux.add(fin[kl][0]);
					}

				}

			}
		}
		oo.fonctionTransition = new String[oo.tailleEtats()][oo.tailleAlphabet()];
		int po = 0;
		int pi;
		for (int mp = 1; mp < fin.length; mp++) {
			pi = 0;
			for (int mo = 1; mo < fin[mp].length; mo++) {
				oo.fonctionTransition[po][pi] = fin[mp][mo];
				pi++;
			}
			po++;
		}

	}

	public void transfert(Afn schema) {
		varVide = 0;
		ArrayList<String> temp;
		for (int mp = 0; mp < schema.etats.size(); mp++) {
			for (int mo = 0; mo < schema.alphabet.size(); mo++) {
				if (schema.fonctionTransition[mp][mo] == "vide")
					varVide = 1;
				mo = schema.alphabet.size();
			}
			mp = schema.etats.size();
		}

		if (a == 'o') { // sans epsilon transition
			fon = new String[100][schema.alphabet.size() + 1];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < schema.alphabet.size() + 1; j++) {
					fon[i][j] = "fin";
				}
			}
			fon[0][0] = " ";
			for (int i = 1; i <= schema.alphabet.size(); i++)
				fon[0][i] = schema.alphabet.get(i - 1).toString();
			for (int i = 0; i < schema.alphabet.size() + 1; i++)
				fon[1][i] = "vide";
			fon[2][0] = "{q0}";
			ligneTest = 2;
			colTest = 1;
			ligne = 2;
			col = 1;
			for (int j = 0; j < schema.alphabet.size(); j++) {
				fon[ligne][col] = schema.fonctionTransition[0][j];
				col++;
			}
			ligne++;
			col = 0;
			ligneGlobale = 3;
			remplirligne(schema.alphabet.size(), schema);// ligne vide
			while (fon[ligneGlobale][0] != "fin") {
				temp = new ArrayList<String>();
				for (int l = 0; l < schema.etats.size(); l++) {
					String c = schema.etats.get(l);
					if (fon[ligneGlobale][0].contains(c) == true) {
						temp.add(c);
					}
				}

				remplircolonne(temp, schema);
				remplirligne(schema.alphabet.size(), schema);
			}
			/*
			 * //do{ //if(fon[ligneGlobale][0]=="fin"){break;} //else{ temp =
			 * new ArrayList<String> (); for(int l=0;l<schema.etats.size();l++){
			 * String c=schema.etats.get(l);
			 * if(fon[ligneGlobale][0].contains(c)==true){ temp.add(c); } }
			 * 
			 * remplircolonne(temp,schema);
			 * //fon[ligneGlobale][0]="{"+schema.etats.get(1)+"}";
			 * remplirligne(schema.alphabet.size(), schema); temp = new
			 * ArrayList<String> (); //String c=schema.etats.get(1);
			 * //temp.add(c);
			 * 
			 * for(int l=0;l<schema.etats.size();l++){ String
			 * c=schema.etats.get(l);
			 * if(fon[ligneGlobale][0].contains(c)==true){ temp.add(c); } }
			 * remplircolonne(temp,schema);
			 * 
			 * //} //}while(ligneGlobale<100);
			 */

			fin = new String[ligneGlobale][schema.alphabet.size() + 1];
			for (int j = 0; j < ligneGlobale; j++) {
				for (int k = 0; k < schema.alphabet.size() + 1; k++) {
					fin[j][k] = fon[j][k];
				}
			}

		} else {
			// avec epsilon transition
			// calcul epsilon-fermeture
			fn = new String[schema.etats.size()];
			for (int i = 0; i < schema.etats.size(); i++) {
				String e = schema.etats.get(i);
				fn[i] = e;
				if (schema.fonctionTransition[i][schema.alphabet.size()] != "vide") {
					String z = schema.fonctionTransition[i][schema.alphabet.size()];
					fn[i] += z;
				}
			}

			for (int j = 0; j < schema.etats.size(); j++) {
				for (int l = 0; l < schema.etats.size(); l++) {
					if (l != j) {
						if (fn[l].contains(schema.etats.get(j))) {
							fn[l] += fn[j];
						}

					}
				}
			}

			for (int et = 0; et < schema.etats.size(); et++) {
				ArrayList<String> t = new ArrayList<String>();
				for (int l = 0; l < schema.etats.size(); l++) {
					String c = schema.etats.get(l);
					if (fn[et].contains(c) == true) {
						t.add(c);
					}
				}
				String chaine = "{";
				for (int l = 0; l < t.size(); l++) {
					chaine = chaine + t.get(l);
					if (l != t.size() - 1)
						chaine = chaine + ",";
					else
						chaine = chaine + "}";
				}

				fn[et] = chaine;
				et++;
			}

			fon = new String[100][schema.alphabet.size() + 1];
			for (int i = 0; i < 100; i++) {

				fon[i][0] = "fin";
			}

			fon[0][0] = " ";
			for (int z = 1; z <= schema.alphabet.size(); z++)
				fon[0][z] = schema.alphabet.get(z - 1).toString();
			if (varVide == 1 || varVide == 0) {
				for (int i = 0; i <= schema.alphabet.size(); i++)
					fon[1][i] = "vide";
			}
			fon[2][0] = fn[0];
			ligneTest = 2;
			colTest = 1;
			ligne = 2;
			col = 1;
			ligneGlobale = 2;

			while (fon[ligneGlobale][0] != "fin") {
				// do{
				// transformer chaine array list
				temp = new ArrayList<String>();

				for (int l = 0; l < schema.etats.size(); l++) {
					String c = schema.etats.get(l);

					if (fon[ligneGlobale][0].contains(c) == true) {
						temp.add(c);
					}
				}

				remplircolonne(temp, schema);// ligneGlobale++;col=0;
				if (ligneGlobale == 3)
					ligne++;
				remplirligne(schema.alphabet.size(), schema);

			} // }while(ligneGlobale < 100);
			fin = new String[ligneGlobale][schema.alphabet.size() + 1];
			for (int j = 0; j < ligneGlobale; j++) {
				for (int k = 0; k < schema.alphabet.size() + 1; k++) {
					fin[j][k] = fon[j][k];
				}
			}

		}

	}

	public void remplircolonne(ArrayList<String> tem, Afn sc) {

		ArrayList<String> tp;
		col = 1;
		if (tem.size() == 1 && a == 'o') {
			for (int j = 0; j < sc.alphabet.size(); j++) {
				String a = tem.get(0).substring(1, 2);
				int z = Integer.parseInt(a);

				fon[ligneGlobale][col] = sc.fonctionTransition[z][j];
				col++;
			}
			ligneGlobale++;
			col = 0;
		} else {

			for (int j = 0; j < sc.alphabet.size(); j++) {
				for (int i = 0; i < tem.size(); i++) {
					String a = tem.get(i).substring(1, 2);
					int z = Integer.parseInt(a);

					if (i == 0) {
						fon[ligneGlobale][col] = sc.fonctionTransition[z][j];
					} else {
						fon[ligneGlobale][col] += sc.fonctionTransition[z][j];
					}
				}

				boolean testVide = true;
				for (int l = 0; l < sc.etats.size(); l++) {
					String c = sc.etats.get(l);
					if (fon[ligneGlobale][col].contains(c) == true) {
						testVide = false;
						l = sc.etats.size();
					}
				}
				if (testVide == true)
					fon[ligneGlobale][col] = "vide";
				if (fon[ligneGlobale][col] != "vide") {
					if (a == 'f') {
						for (int l = 0; l < sc.etats.size(); l++) {
							String c = sc.etats.get(l);
							if (fon[ligneGlobale][col].contains(c) == true) {
								fon[ligneGlobale][col] += fn[l];

							}
						}
					}

					tp = new ArrayList<String>();
					for (int l = 0; l < sc.etats.size(); l++) {
						String c = sc.etats.get(l);
						if (fon[ligneGlobale][col].contains(c) == true) {
							tp.add(c);
						}
					}
					String chaine = "{";
					for (int l = 0; l < tp.size(); l++) {
						chaine = chaine + tp.get(l);
						if (l != tp.size() - 1)
							chaine = chaine + ",";
						else
							chaine = chaine + "}";
					}
					fon[ligneGlobale][col] = chaine;
				}
				col++;

			}

			ligneGlobale++;
			col = 0;
		}

	}

	public void remplirligne(int taille, Afn sc) {
		int tailleGlobaleParcours = 1;
		boolean test;
		do {
			test = true;
			/*
			 * if(fon[ligneTest][colTest]=="vide"){ test=false;} else{
			 */
			for (int m = 1; m < ligne; m++) {
				/*
				 * ArrayList <String> tp=new ArrayList <String> (); for(int
				 * l=0;l<sc.etats.size();l++){ String c=sc.etats.get(l);
				 * if(fon[ligneTest][colTest].contains(c)==true){ tp.add(c); } }
				 * 
				 * 
				 * 
				 * ArrayList <String> tt=new ArrayList <String> (); for(int
				 * l=0;l<sc.etats.size();l++){ String c=sc.etats.get(l);
				 * if(fon[m][0].contains(c)==true){ tt.add(c); } }
				 * 
				 * 
				 * if(tt.size()==tp.size()){ //
				 * if(tt.toString()==tp.toString()){ test=false;m=ligne;}
				 * 
				 * 
				 * //}
				 * 
				 * 
				 * }
				 * 
				 * }
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 */

				String a = fon[ligneTest][colTest];
				String b = fon[m][0];
				if (a.equals(b) == true && a.length() == b.length()) {

					test = false;
					m = ligne;
				}

			}

			if (test == true) {
				// if(ligne<100 && ligneTest<100 ){
				fon[ligne][0] = fon[ligneTest][colTest];
				ligne++;
				// }
			}
			if (colTest == taille) {
				ligneTest++;
				colTest = 1;
			} else {
				colTest++;
			}
			tailleGlobaleParcours++;

		} while (tailleGlobaleParcours <= taille);

	}
}
