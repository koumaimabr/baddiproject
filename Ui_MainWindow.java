/* **************************************************************************** */
/*                                                                              */
/*             PROJET : CONVERSION D'UN AFN EN UN AFD ET/OU LE MINIMISER        */
/*                                                                              */
/* **************************************************************************** */

package afnTOafd;
import java.util.*;

import com.trolltech.qt.gui.* ;

import com.trolltech.qt.core.*;

public class Ui_MainWindow extends QMainWindow
{
	public static Afn exemple1;
	public static Afntoafd exemple2;
	public static Afd resultatFinal;
	
	/***********************************************************************************
	 *                               DECLARATIONS
	 ***********************************************************************************/
	
	// declaration des variables, buttons, widgets ..etc pour la MainWindow
	public static QMainWindow initWindow;
    public static QWidget centralwidgetMainWin;
    public static QWidget verticalLayoutWidgetMainWin;
    public static QVBoxLayout verticalLayoutMainWin;
    public static QPushButton convertAndMinimizeNfaButton;
    public static QPushButton displayDFAButton;
    public static QPushButton minimizeDfaButton;
    public static QPushButton quitterButtonMainWin;
    public static QPushButton AboutUsButton;
    public static QTextBrowser textBrowserMainWindow;
    public static QMenuBar menubarMainWin;
    public static QStatusBar statusbarMainWin;
    
    // declaration des variables .. etc pour la deuxieme window (saisir symbole ... etc)
    public QWidget centralwidgetCheckboxes1;
    public QWidget verticalLayoutWidgetCheckboxes1;
    public QVBoxLayout verticalLayoutCheckboxes1;
    public QPushButton addSymbol;
    public QPushButton removeSymbol;
    public QPushButton displayAlphabet;
    public QPushButton displayAlphabetSize;
    public QTextBrowser textBrowserCheckboxes1;
    public QPushButton quitButtonCheckboxes1;
    public QPushButton nextButtonCheckboxes1;
    public QPushButton quitButton1;
    
    //fin de checkboxes1 declarations
    
    // Declarations pour le "add symbols" dialog box (pour ajouter un nouveau symbole)
    
    public QPushButton quitButtonAddSymbolBox;
    public QPushButton addSymbolPopUpBoxButton;
    public QLineEdit enterSymbolEditBox;
    public QLabel saisirSymboleLabel;
    public QLabel errorSymbolAlreadyExist;
    public QDialog addSymbolDialogBox;
    public boolean errorSymbolShown = false;
    

    // Declarations pour le "del symbols" dialog box (pour supprimer un symbole)
    
    public QPushButton quitButtonDelSymbolBox;
    public QPushButton delSymbolPopUpBoxButton;
    public QComboBox delSymbolComboBox;
    public QLabel delSymbolLabel;
    public QLabel errorSymbolsEmpty;
    public QDialog delSymbolDialogBox;
    
    // Le message box qui apparait quand l'utilisateur essaye de supprimer un symbole
    // alors qu'il n'a pas encore saisi de symboles
    
    public QMessageBox warnSymbolEmpty;
    public QMessageBox warnSymbolNull; 
    
    // Message box pour afficher l'alphabet   
    public QMessageBox displayAlphabetMsgBox;
    
    // Message box pour afficher la taille de l'alphabet   
    public QMessageBox displayAlphabetSizeMsgBox;

    // fin de Add symbol diolog box declarations
    
    //States window, la fenetre qui permet d'ajouter les etats
    public QWidget centralwidgetStatesWindow;
    public QWidget verticalLayoutWidgetStatesWin;
    public QVBoxLayout verticalLayoutStatesWindow;
    public QPushButton addState;
    public QPushButton displayStates;
    public QPushButton displayStatesSize;
    public QTextBrowser textBrowserStatesWindow;
    public QPushButton quitButtonStatesWindow;
    public QPushButton nextButtonStatesWindow; 
    
    // Afficher une erreur si l'utilisateur clique sur "suivant" sans saisir aucun symbol  
    public QMessageBox displayErrorNoSymbolEnteredMsgBox;
   
    // (la fenêtre qui permet de choisir le nombre des états finaux
    
    public QWidget centralwidgetFinalStateWindow;
    public QTextBrowser textBrowserFinalStateWindow;
    public QPushButton quitButtonFinalStateWindow;
    public QPushButton nextButtonFinalStateWindow;
    public QTextBrowser enterNumberOfFinalStates;
    public QSpinBox finalStatesNumber;
    
    //Afficher les etats
    public QMessageBox displayStatesMessageBox;
    
    //Afficher une erreur si l'utilisateur clique sur "Afficher les etat" sans saisir aucun etat
    public QMessageBox displayStatesErrorMessageBox;
    
    // Afficher une erreur si l'utilisateur clique sur "suivant" sans saisir les etats  
    public QMessageBox displayErrorNoStateEnteredMsgBox;
    
    // Afficher la taille des états
    public QMessageBox displayStatesSizeMessageBox;
    
    // Le dialog box pour ajouter un etat
    public QPushButton AddStatesCancelBoxButton;
    public QPushButton AddStatesBoxConfirmButton;
    public QSpinBox AddStatesDialogBoxSpinBox;
    public QLabel addStatesDialogBoxlabel;
    public QTextEdit addStatesDialogBoxTextEdit;
    public QDialog AddStatesDialogBox ;
    
    //Fin de la final state window
    
    //Box pour selectionner les etats finaux 
    public QDialog enterFinalStatesDialogBox;
    public QComboBox enterFinalStatesComboBox;
    public QLabel enterStatesLabelText;
    public QPushButton enterFinalStatesCloseButton;
    public QPushButton enterFInalStatesNextButton;
	private int iterFinalStates = 1;

    // Premiere partie de la fonction  de transition
	
    public QWidget centralwidgetTransitionFct1;
    public QTextBrowser textBrowser;
    public QPushButton quitButtonTransitionFct1;
    public QPushButton nextButtonTransitionFct1;
    public QLabel labelFonctionTransition;
    public QRadioButton checkboxEmptyState;
    public QRadioButton checkboxMultipleStates;
    public QSpinBox howManyStatesTransFct;
    
    
    /*************************************************************************************
     ************************  La Main Window du programme     ***************************
     *************************************************************************************/
    
   //fonction de la mainWindow
    public Ui_MainWindow()
    {
    	//The main window (la premiere fênetre)

        setObjectName("MainWindow");
        // taille
        resize(new QSize(800, 600).expandedTo(this.minimumSizeHint()));
        centralwidgetMainWin = new QWidget(this);
        centralwidgetMainWin.setObjectName("centralwidgetMainWin");
        verticalLayoutWidgetMainWin = new QWidget(centralwidgetMainWin);
        verticalLayoutWidgetMainWin.setObjectName("verticalLayoutWidgetMainWin");
        verticalLayoutWidgetMainWin.setGeometry(new QRect(160, 150, 491, 311));
        verticalLayoutMainWin = new QVBoxLayout(verticalLayoutWidgetMainWin);
        verticalLayoutMainWin.setObjectName("verticalLayoutMainWin");
        convertAndMinimizeNfaButton = new QPushButton(verticalLayoutWidgetMainWin);
        convertAndMinimizeNfaButton.setObjectName("convertAndMinimizeNfaButton");
        
        
        verticalLayoutMainWin.addWidget(convertAndMinimizeNfaButton);
        
        
        displayDFAButton = new QPushButton(verticalLayoutWidgetMainWin);
        
        displayDFAButton.setObjectName("displayDFAButton");

        verticalLayoutMainWin.addWidget(displayDFAButton);

        minimizeDfaButton = new QPushButton(verticalLayoutWidgetMainWin);
        minimizeDfaButton.setObjectName("minimizeDfaButton");

        verticalLayoutMainWin.addWidget(minimizeDfaButton);

        quitterButtonMainWin = new QPushButton(verticalLayoutWidgetMainWin);
        quitterButtonMainWin.setObjectName("quitterButtonMainWin");

        verticalLayoutMainWin.addWidget(quitterButtonMainWin);

        AboutUsButton = new QPushButton(centralwidgetMainWin);
        AboutUsButton.setObjectName("AboutUsButton");
        AboutUsButton.setGeometry(new QRect(660, 490, 121, 28));
        
       //Les informations du header
        textBrowserMainWindow = new QTextBrowser(centralwidgetMainWin);
        textBrowserMainWindow.setObjectName("textBrowserMainWindow");
        textBrowserMainWindow.setGeometry(new QRect(30, 20, 741, 101));
       
        //Attacher le widget à la fênetre
        
        setCentralWidget(centralwidgetMainWin);
        menubarMainWin = new QMenuBar(this);
        menubarMainWin.setObjectName("menubarMainWin");
        menubarMainWin.setGeometry(new QRect(0, 0, 800, 28));
        setMenuBar(menubarMainWin);
        statusbarMainWin = new QStatusBar(this);
        statusbarMainWin.setObjectName("statusbarMainWin");
        setStatusBar(statusbarMainWin);
        
        //Ajouter le texte au bouttons ..etc, de la MainWindow
        retranslateUi(this);
        
        //quitter
        quitterButtonMainWin.pressed.connect(this, "close()");
        convertAndMinimizeNfaButton.clicked.connect(this, "setupCheckboxes1()"); 
        

        connectSlotsByName();
        show();
    } 

    static void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "AFN to DFA programme", null));
        convertAndMinimizeNfaButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Convertir un AFN en un AFD et le minimiser", null));
        displayDFAButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un AFD", null));
        minimizeDfaButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Minimiser un AFD", null));
        quitterButtonMainWin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
        AboutUsButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00c0 propos de nous", null));
        textBrowserMainWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC"
        		+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
        		"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
        		"p, li { white-space: pre-wrap; }\n"+
        		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400;"
        		+ " font-style:normal;\">\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; "
        		+ "margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; "
        		+ "text-indent:0px;\"><br /></p>\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
        		+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" "
        		+ "font-size:12pt; text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" "
        		+ "font-size:12pt; font-weight:600; text-decoration: underline;\">AFN </span><span style=\" "
        		+ "font-size:12pt; text-decoration: underline;\">EN UN </span><span style=\" font-size:12pt;"
        		+ " font-weight:600; text-decoration: underline;\">AFD</span></p>\n"+
        		"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px;"
        		+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt;"
        		+ " font-weight:600; text-decoration: underline;\"><br /></p>\n"+
        		"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
        		+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir "
        		+ "un <span style=\" font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span>"
        		+ " et/ou le minimiser.</p></body></html>", null));
    } 
    

	/***********************************************************************************
	 **********************    FONCTION DE LA SECONDE FENÊTRE   ************************
	 ***********************************************************************************/
    
 public void setupCheckboxes1() 
 {
	//Cacher le contenu du widget central
	centralwidgetMainWin.hide();
	 
	//Creer un nouveau widget vcentral pour la deuxieme fênetre
	centralwidgetCheckboxes1 = new QWidget(this);
	 
	
     centralwidgetCheckboxes1.setObjectName("centralwidgetCheckboxes1");
     //new vertical layout pour le deuxieme widget
     verticalLayoutWidgetCheckboxes1 = new QWidget(centralwidgetCheckboxes1);
     verticalLayoutWidgetCheckboxes1.setObjectName("verticalLayoutWidgetCheckboxes1");
     verticalLayoutWidgetCheckboxes1.setGeometry(new QRect(160, 150, 491, 311));
     verticalLayoutCheckboxes1 = new QVBoxLayout(verticalLayoutWidgetCheckboxes1);
     verticalLayoutCheckboxes1.setObjectName("verticalLayoutCheckboxes1");
     
    // le boutton "Ajouter un symbol"
     addSymbol = new QPushButton(verticalLayoutWidgetCheckboxes1);
     addSymbol.setObjectName("addSymbol");

     //Ajout du boutton "ajouter un symbol" dans le Vertical Layout
     verticalLayoutCheckboxes1.addWidget(addSymbol);

     removeSymbol = new QPushButton(verticalLayoutWidgetCheckboxes1);
     removeSymbol.setObjectName("removeSymbol");

     verticalLayoutCheckboxes1.addWidget(removeSymbol);

     displayAlphabet = new QPushButton(verticalLayoutWidgetCheckboxes1);
     displayAlphabet.setObjectName("displayAlphabet");

     verticalLayoutCheckboxes1.addWidget(displayAlphabet);

     displayAlphabetSize = new QPushButton(verticalLayoutWidgetCheckboxes1);
     displayAlphabetSize.setObjectName("displayAlphabetSize");

     verticalLayoutCheckboxes1.addWidget(displayAlphabetSize);
     
     // Header de la deuxieme fenetre
     
     textBrowserCheckboxes1 = new QTextBrowser(centralwidgetCheckboxes1);
     textBrowserCheckboxes1.setObjectName("textBrowserCheckboxes1");
     textBrowserCheckboxes1.setGeometry(new QRect(30, 20, 741, 101));
     //quit button
     quitButton1 = new QPushButton(centralwidgetCheckboxes1);
     quitButton1.setObjectName("quitButton1");
     quitButton1.setGeometry(new QRect(680, 490, 82, 28));
     nextButtonCheckboxes1 = new QPushButton(centralwidgetCheckboxes1);
     nextButtonCheckboxes1.setObjectName("nextButtonCheckboxes1");
     nextButtonCheckboxes1.setGeometry(new QRect(590, 490, 82, 28));
     this.setCentralWidget(centralwidgetCheckboxes1);
        
     quitButton1.clicked.connect(this, "close()");
     addSymbol.clicked.connect(this, "addSymbolsBox()"); //Call addSymbols() quand l'utilisateur clique sur ce boutton
     displayAlphabet.clicked.connect(this, "displayAlphabetMessageBox()"); 
     displayAlphabetSize.clicked.connect(this, "displayAlphabetSizeMessageBox()"); 
     
     addSymbol.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ajouter un symbole", null));
     removeSymbol.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Supprimer un symbole", null));
     displayAlphabet.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un alphabet", null));
     displayAlphabetSize.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher la taille d'un alphabet", null));
     textBrowserCheckboxes1.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC"
     		+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
     		"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
     		"p, li { white-space: pre-wrap; }\n"+
     		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
     		+ "font-style:normal;\">\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; "
     		+ "margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br />"
     		+ "</p>\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
     		+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
     		+ " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600;"
     		+ " text-decoration: underline;\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">"
     		+ "EN UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span>"
     		+ "</p>\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; "
     		+ "margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
     		+ " text-decoration: underline;\"><br /></p>\n"+
     		"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
     		+ " -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir un <span style=\" "
     		+ "font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span> et/ou le minimiser."
     		+ "</p></body></html>", null));
     
     quitButton1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
     nextButtonCheckboxes1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));     centralwidgetCheckboxes1.show();
     removeSymbol.clicked.connect(this, "delSymbolsBox()");
     nextButtonCheckboxes1.clicked.connect(this, "setupStatesWindow()");

     centralwidgetCheckboxes1.show();
     centralwidgetCheckboxes1.connectSlotsByName();
 }

	/***********************************************************************************
	 ****************    LE DIALOG BOX POUR AJOUTER UN SYMBOLE  ************************
	 ***********************************************************************************/
 
    public void addSymbolsBox()
    {
    	
    	addSymbolDialogBox = new QDialog(centralwidgetCheckboxes1);
    	addSymbolDialogBox.setObjectName("addSymbolDialogBox");
        addSymbolDialogBox.setEnabled(true);
        addSymbolDialogBox.resize(new QSize(392, 235).expandedTo(addSymbolDialogBox.minimumSizeHint()));
        quitButtonAddSymbolBox = new QPushButton(addSymbolDialogBox);
        quitButtonAddSymbolBox.setObjectName("quitButtonAddSymbolBox");
        quitButtonAddSymbolBox.setGeometry(new QRect(290, 190, 82, 28));
        addSymbolPopUpBoxButton = new QPushButton(addSymbolDialogBox);
        addSymbolPopUpBoxButton.setObjectName("addSymbolPopUpBoxButton");
        addSymbolPopUpBoxButton.setGeometry(new QRect(200, 190, 82, 28));
        addSymbolPopUpBoxButton.setDefault(true);
        enterSymbolEditBox = new QLineEdit(addSymbolDialogBox);
        enterSymbolEditBox.setObjectName("enterSymbolEditBox");
        enterSymbolEditBox.setGeometry(new QRect(50, 90, 191, 31));
        enterSymbolEditBox.setMaxLength(1);
        saisirSymboleLabel = new QLabel(addSymbolDialogBox);
        saisirSymboleLabel.setObjectName("saisirSymboleLabel");
        saisirSymboleLabel.setGeometry(new QRect(50, 50, 281, 18));
        if (exemple1.alphabet.isEmpty()) 
        	enterSymbolEditBox.setText("a");
        	
        // errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
       //  errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        
        // errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        
        //bouttons text..etc
        addSymbolDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Ajouter un symbole", null));
        quitButtonAddSymbolBox.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Fermer", null));
        addSymbolPopUpBoxButton.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "+ Ajouter", null));
        saisirSymboleLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Veuillez saisir un symbole (un caract\u00e8re) :", null));
        errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
        errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        errorSymbolAlreadyExist.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "<html><head/><body><p><span style=\" "
        		+ "color:#cf0000;\">Erreur: ce symbole \u00e0 d\u00e9ja \u00e9t\u00e9 saisi</span></p></body></html>", null));
        errorSymbolAlreadyExist.hide();
        
        quitButtonAddSymbolBox.pressed.connect(addSymbolDialogBox, "close()");
        // errorSymbolAlreadyExist.hide();
        addSymbolDialogBox.show();
        addSymbolPopUpBoxButton.clicked.connect(this, "addSymbol()");
        addSymbolDialogBox.connectSlotsByName(); 
        
    }
    
	/***********************************************************************************
	 **********************    FONCTION POUR AJOUTER UN SYMBOLE   **********************
	 ***********************************************************************************/
    
    public void addSymbol()
    {
        if (enterSymbolEditBox.text().isEmpty() ) {
        	warnSymbolNull = new QMessageBox(addSymbolDialogBox);
        	QMessageBox.critical(addSymbolDialogBox, "Erreur", "Vous n'avez pas saisi de symboles!");
        	return;
        }
        
    	char symbolEntered;  	
        symbolEntered = new Character(enterSymbolEditBox.text().charAt(0));
        System.out.println("Vous avez saisi" +symbolEntered);
        
        // Vérifier si le symbole saisi existe déja, et afficher un erreur si c'est la cas
		if (exemple1.alphabet.indexOf(symbolEntered) > -1)
		{
			errorSymbolAlreadyExist.show();
	       errorSymbolShown = true;
		}
		else
		{
			if (errorSymbolShown) 
			{ 
				errorSymbolAlreadyExist.hide();
				errorSymbolShown = !errorSymbolShown;
			}
			
			exemple1.ajouterSymbole(symbolEntered);
	       // System.out.println(symbolEntered+ "was added");
			addSymbolDialogBox.close();
		}
        	
        
    }
    
	/***********************************************************************************
	 ********************** DIALOG BOX POUR SUPPRIMER UN SYMBOLE   *********************
	 ***********************************************************************************/
    
    public void delSymbolsBox()
    {
    	if (exemple1.alphabet.isEmpty()) 
    	{
    		warnSymbolEmpty = new QMessageBox(centralwidgetCheckboxes1);
    		QMessageBox.critical(centralwidgetCheckboxes1, "Erreur", "Vous n'avez saisi aucun symbole!");
    		return;
    	}
    	
    	delSymbolDialogBox = new QDialog(centralwidgetCheckboxes1);
    	delSymbolDialogBox.setObjectName("delSymbolDialogBox");
    	delSymbolDialogBox.setEnabled(true);
    	delSymbolDialogBox.resize(new QSize(392, 235).expandedTo(delSymbolDialogBox.minimumSizeHint()));
        quitButtonDelSymbolBox = new QPushButton(delSymbolDialogBox);
        quitButtonDelSymbolBox.setObjectName("quitButtonDelSymbolBox");
        quitButtonDelSymbolBox.setGeometry(new QRect(290, 190, 82, 28));
        delSymbolPopUpBoxButton = new QPushButton(delSymbolDialogBox);
        delSymbolPopUpBoxButton.setObjectName("delSymbolPopUpBoxButton");
        delSymbolPopUpBoxButton.setGeometry(new QRect(180, 190, 102, 28));
        delSymbolComboBox = new QComboBox(delSymbolDialogBox);
        delSymbolComboBox.setObjectName("enterSymbolEditBox");
        delSymbolComboBox.setGeometry(new QRect(50, 90, 191, 31));
        List<String> symbolsStringList = new ArrayList<String>(exemple1.alphabet.size());
        for (char tchar : exemple1.alphabet) 
        { 
        	symbolsStringList.add(String.valueOf(tchar)); 
        }
        delSymbolComboBox.insertItems(1, symbolsStringList);
        delSymbolLabel = new QLabel(delSymbolDialogBox);
        delSymbolLabel.setObjectName("saisirSymboleLabel");
        delSymbolLabel.setGeometry(new QRect(50, 50, 281, 18));
        // errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
       //  errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        
        // errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        
        //bouttons text..etc
        delSymbolDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Ajouter un symbole", null));
        quitButtonDelSymbolBox.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Fermer", null));
        delSymbolPopUpBoxButton.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "+ Ajouter", null));
        delSymbolLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Saisir un symbole pour le supprimer :", null));
        errorSymbolAlreadyExist = new QLabel(delSymbolDialogBox);
        errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
        errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
        errorSymbolAlreadyExist.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "<html><head/><body><p><span style=\" "
        		+ "color:#cf0000;\">Il n'ya plus de symboles à supprimer</span></p></body></html>", null));
        delSymbolPopUpBoxButton.setText("Supprimer");
        quitButtonDelSymbolBox.setText("Annuler");
        errorSymbolAlreadyExist.hide();
        
        quitButtonDelSymbolBox.pressed.connect(delSymbolDialogBox, "close()");
        // errorSymbolAlreadyExist.hide();
        delSymbolDialogBox.show();
        delSymbolPopUpBoxButton.clicked.connect(this, "delSymbol()");
        delSymbolDialogBox.connectSlotsByName(); 
        
    }
   
	/***********************************************************************************
	 **********************    FONCTION POUR SUPPRIMER UN SYMBOLE  *********************
	 ***********************************************************************************/
    
    public void delSymbol()
    {
    	if (delSymbolComboBox.count() < 1) {
    		errorSymbolAlreadyExist.show();
    		return;
    	}
        
    	exemple1.alphabet.remove(Character.valueOf(delSymbolComboBox.currentText().charAt(0)));
    	delSymbolComboBox.removeItem(delSymbolComboBox.currentIndex());
    	delSymbolDialogBox.close();
    	
        // Vérifier si le symbole saisi existe déja, et afficher un erreur si c'est la cas
        // errorSymbolAlreadyExist
        	   
    }
    
	/***********************************************************************************
	 **********************    FONCTION POUR AFFICHER L'ALPHABET  **********************
	 ***********************************************************************************/
    
    public void displayAlphabetMessageBox()
    {
    	String displayAlphabetText = "";
    	displayAlphabetText = "                A = { "+exemple1.affichageAlphabet()+"}                  ";

    	displayAlphabetMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		QMessageBox.information(centralwidgetCheckboxes1, "Voici l'alphabet saisi :", displayAlphabetText);
		
    }
    
    /***********************************************************************************
	 ******************   FONCTION POUR AFFICHER LA TAILLE D'UN ALPHABET ***************
	 ***********************************************************************************/
    
    public void displayAlphabetSizeMessageBox()
    {
    	String displayAlphabetSize = "La taille de votre alphabet est :  ";;

    	displayAlphabetSizeMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		QMessageBox.information(centralwidgetCheckboxes1, "Taille de l'alphabet"
				+ "si :", displayAlphabetSize+exemple1.tailleAlphabet());
		
    }
    
	/***********************************************************************************
	 **********************    FONCTION DE LA TROISIEME FENÊTRE   **********************
	 ***********************************************************************************/
    
    public void setupStatesWindow()
    {
    	// pour afficher une erreur si l'utilisateur clique sur suivant sans saisir un symbole
    	if (exemple1.alphabet.isEmpty()) 
    	{
    		displayErrorNoSymbolEnteredMsgBox = new QMessageBox(centralwidgetStatesWindow);
    		QMessageBox.critical(centralwidgetStatesWindow, "Erreur", "Vous n'avez saisi aucun symbole!");
    		return;
    	}
    	
	    //Cacher le contenu du widget de la deuxieme fenetre
		centralwidgetCheckboxes1.hide();
		 
		//Creer un nouveau widget central pour la deuxieme fênetre
		centralwidgetStatesWindow = new QWidget(this);
		
		centralwidgetStatesWindow = new QWidget(this);
	    centralwidgetStatesWindow.setObjectName("centralwidgetStatesWindow");
	    verticalLayoutWidgetStatesWin = new QWidget(centralwidgetStatesWindow);
	    verticalLayoutWidgetStatesWin.setObjectName("verticalLayoutWidgetStatesWin");
	    verticalLayoutWidgetStatesWin.setGeometry(new QRect(160, 150, 491, 311));
	    verticalLayoutStatesWindow = new QVBoxLayout(verticalLayoutWidgetStatesWin);
	    verticalLayoutStatesWindow.setObjectName("verticalLayoutStatesWindow");
	    addState = new QPushButton(verticalLayoutWidgetStatesWin);
	    addState.setObjectName("addState");
	
	    verticalLayoutStatesWindow.addWidget(addState);
	
	    displayStates = new QPushButton(verticalLayoutWidgetStatesWin);
	    displayStates.setObjectName("displayStates");
	
	    verticalLayoutStatesWindow.addWidget(displayStates);
	
	    displayStatesSize = new QPushButton(verticalLayoutWidgetStatesWin);
	    displayStatesSize.setObjectName("displayStatesSize");
	
	    verticalLayoutStatesWindow.addWidget(displayStatesSize);
	
	    textBrowserStatesWindow = new QTextBrowser(centralwidgetStatesWindow);
	    textBrowserStatesWindow.setObjectName("textBrowserStatesWindow");
	    textBrowserStatesWindow.setGeometry(new QRect(30, 20, 741, 101));
	    quitButtonStatesWindow = new QPushButton(centralwidgetStatesWindow);
	    quitButtonStatesWindow.setObjectName("quitButtonStatesWindow");
	    quitButtonStatesWindow.setGeometry(new QRect(680, 490, 82, 28));
	    nextButtonStatesWindow = new QPushButton(centralwidgetStatesWindow);
	    nextButtonStatesWindow.setObjectName("nextButtonStatesWindow");
	    nextButtonStatesWindow.setGeometry(new QRect(590, 490, 82, 28));
	    this.setCentralWidget(centralwidgetStatesWindow);
	    quitButtonStatesWindow.pressed.connect(this, "close()");
	    nextButtonStatesWindow.clicked.connect(this, "setupFinalStateWindow()");
	    addState.clicked.connect(this, "addStatesBox()");
	    displayStates.clicked.connect(this,"displayStatesMessageBox()");
	    displayStatesSize.clicked.connect(this, "displayStatesSizeMessageBox()");
	    centralwidgetStatesWindow.connectSlotsByName();
	    
	    this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
	    addState.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ajouter le nombre des \u00e9tats", null));
	    displayStates.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher les \u00e9tats", null));
	    displayStatesSize.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher la taille des"
	    + " \u00e9tats", null));
	    textBrowserStatesWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML"
	    + " PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+"<html><head><meta"
	    + " name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+"p, li { white-space: pre-wrap; }\n"+
		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">\n"+
		"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
		+ " margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br /></p>\n"+
		"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
		+ " -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt; text-decoration: underline;"
		+ "\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;"
		+ "\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">EN UN </span>"
		+ "<span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"+
		"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
		+ " margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
		+ " text-decoration: underline;\"><br /></p>\n"+"<p align=\"center\" style=\" margin-top:0px;"
		+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">"
		+ "Ce programme permet de convertir un <span style=\" font-weight:600;\">AFD</span> en un "
		+ "<span style=\" font-weight:600;\">AFD</span> et/ou le minimiser.</p></body></html>", null));
	    quitButtonStatesWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
	    nextButtonStatesWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
    }
    
	/***********************************************************************************
	 ********************** DIALOG BOX POUR AJOUTER UN ETAT   **************************
	 ***********************************************************************************/
    
    public void addStatesBox()
    {
    	AddStatesDialogBox = new QDialog(centralwidgetStatesWindow);
	    AddStatesDialogBox.setObjectName("AddStatesDialogBox");
	    AddStatesDialogBox.resize(new QSize(390, 217).expandedTo(AddStatesDialogBox.minimumSizeHint()));
	    AddStatesCancelBoxButton = new QPushButton(AddStatesDialogBox);
	    AddStatesCancelBoxButton.setObjectName("AddStatesCancelBoxButton");
	    AddStatesCancelBoxButton.setGeometry(new QRect(290, 170, 82, 28));
	    AddStatesBoxConfirmButton = new QPushButton(AddStatesDialogBox);
	    AddStatesBoxConfirmButton.setObjectName("AddStatesBoxConfirmButton");
	    AddStatesBoxConfirmButton.setGeometry(new QRect(200, 170, 82, 28));
	    AddStatesDialogBoxSpinBox = new QSpinBox(AddStatesDialogBox);
	    AddStatesDialogBoxSpinBox.setObjectName("AddStatesDialogBoxSpinBox");
	    AddStatesDialogBoxSpinBox.setGeometry(new QRect(250, 120, 52, 23));
	    AddStatesDialogBoxSpinBox.setMinimum(1);
	    
	    //Le nombre des etats finaux que l'utilisateur peut choisir ne peut pas etre supérieur au nombre des etats
	    AddStatesDialogBoxSpinBox.setMaximum(99);
	    
	    addStatesDialogBoxlabel = new QLabel(AddStatesDialogBox);
	    addStatesDialogBoxlabel.setObjectName("addStatesDialogBoxlabel");
	    addStatesDialogBoxlabel.setGeometry(new QRect(70, 120, 181, 21));
	    addStatesDialogBoxTextEdit = new QTextEdit(AddStatesDialogBox);
	    addStatesDialogBoxTextEdit.setObjectName("addStatesDialogBoxTextEdit");
	    addStatesDialogBoxTextEdit.setGeometry(new QRect(10, 10, 371, 71));
	    
	    AddStatesCancelBoxButton.pressed.connect(AddStatesDialogBox, "close()");
	    AddStatesBoxConfirmButton.clicked.connect(this, "addStates()");
	    AddStatesDialogBox.connectSlotsByName();
	    
	    
	    AddStatesDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Ajouter les états", null));
        AddStatesCancelBoxButton.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Annuler", null));
        AddStatesBoxConfirmButton.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Confirmer", null));
        addStatesDialogBoxlabel.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Saisir le nombre d'\u00e9tats", null));
        addStatesDialogBoxTextEdit.setHtml(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
        "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
		"p, li { white-space: pre-wrap; }\n"+
		"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">"
		+ "\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
		+ " -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">Veuillez saisir le nombre des"
		+ " \u00e9tats de votre automate.</span></p>\n"+"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
	    + " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">"
	    + "Les noms des \u00e9tats vont \u00eatre g\u00e9n\u00e9r\u00e9s automatiquement  (q0 , q1 , ... qn), avec q0 "
	    + "\u00e9tant l'\u00e9tat initial.</span></p></body></html>", null));
        AddStatesDialogBox.show();
    }

    /***********************************************************************************
	 **********************    FONCTION POUR AJOUTER LES ETAT **************************
	 ***********************************************************************************/
    
    public void addStates()
    {
    	
    	exemple1.ajouterEtats(AddStatesDialogBoxSpinBox.value());
    	AddStatesDialogBox.close();
    	addState.setEnabled(false);
    }
    
	/***********************************************************************************
	 **********************    FONCTION POUR AFFICHER LES ETATS  ***********************
	 ***********************************************************************************/
    
    public void displayStatesMessageBox()
    {
        if (exemple1.etats.isEmpty() ) {
        	warnSymbolNull = new QMessageBox(addSymbolDialogBox);
        	QMessageBox.critical(addSymbolDialogBox, "Erreur", "Votre automate ne contient aucun état");
        	return;
        }
        
    	String displayStatesText = "";
    	displayStatesText = "                Voici les états = { "+exemple1.affichageEtats()+" }                  ";

    	displayStatesMessageBox = new QMessageBox(centralwidgetStatesWindow);
		QMessageBox.information(centralwidgetStatesWindow, "Les états", displayStatesText);
		
    }
    
	/***********************************************************************************
	 ********************   FONCTION POUR AFFICHER LA TAILLE DES ETATS  ****************
	 ***********************************************************************************/
    
    public void displayStatesSizeMessageBox()
    {

    	String displayStatesSizeText = "";
    	displayStatesSizeText = "    Votre automate contient "+exemple1.tailleEtats()+" états    ";

    	displayStatesSizeMessageBox = new QMessageBox(centralwidgetStatesWindow);
		QMessageBox.information(centralwidgetStatesWindow, "La taille des états", displayStatesSizeText);
		
    }
    
    
    
    /***********************************************************************************
	 **********************    FONCTION DE LA 4 EME FENÊTRE   **************************
	 ***********************************************************************************/
    
    public void setupFinalStateWindow()
    {
    	// pour afficher une erreur si l'utilisateur clique sur suivant sans saisir les etats
    	if (exemple1.etats.isEmpty()) 
    	{
    		displayErrorNoStateEnteredMsgBox = new QMessageBox(centralwidgetFinalStateWindow);
    		QMessageBox.critical(centralwidgetFinalStateWindow, "Erreur", "Votre automate ne contient aucun état");
    		return;
    	}
    	
    	//Cacher le contenu du widget de la 3eme fenetre
    	  centralwidgetStatesWindow.hide();
    	 
    	//Creer un nouveau widget central pour la 4eme fênetre
    	  centralwidgetFinalStateWindow = new QWidget(this);
    	
    	  textBrowserFinalStateWindow = new QTextBrowser(centralwidgetFinalStateWindow);
          textBrowserFinalStateWindow.setObjectName("textBrowserFinalStateWindow");
          textBrowserFinalStateWindow.setGeometry(new QRect(30, 20, 741, 101));
          quitButtonFinalStateWindow = new QPushButton(centralwidgetFinalStateWindow);
          quitButtonFinalStateWindow.setObjectName("quitButtonFinalStateWindow");
          quitButtonFinalStateWindow.setGeometry(new QRect(680, 490, 82, 28));
          nextButtonFinalStateWindow = new QPushButton(centralwidgetFinalStateWindow);
          nextButtonFinalStateWindow.setObjectName("nextButtonFinalStateWindow");
          nextButtonFinalStateWindow.setGeometry(new QRect(590, 490, 82, 28));
          enterNumberOfFinalStates = new QTextBrowser(centralwidgetFinalStateWindow);
          enterNumberOfFinalStates.setObjectName("enterNumberOfFinalStates");
          enterNumberOfFinalStates.setGeometry(new QRect(160, 260, 261, 71));
          finalStatesNumber = new QSpinBox(centralwidgetFinalStateWindow);
          finalStatesNumber.setObjectName("finalStatesNumber");
          finalStatesNumber.setGeometry(new QRect(500, 260, 111, 71));
          finalStatesNumber.setMaximum(exemple1.tailleEtats());
          this.setCentralWidget(centralwidgetFinalStateWindow); 
          quitButtonFinalStateWindow.pressed.connect(this, "close()");
          nextButtonFinalStateWindow.clicked.connect(this, "selectFinalStatesBox()");
          nextButtonFinalStateWindow.clicked.connect(this,"addFinalStates()" );
 
          
          centralwidgetFinalStateWindow.connectSlotsByName();
         
          this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
          textBrowserFinalStateWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML"
          + " PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
		  "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
		  "p, li { white-space: pre-wrap; }\n"+"</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; "
		  + "font-weight:400; font-style:normal;\">" + "\n"+ "<p align=\"center\" style=\"-qt-paragraph-type:empty;"
		  + " margin-top:0px; margin-bottom:0px; " + "margin-left:0px;"+ " margin-right:0px; -qt-block-indent:0; "
		  + "text-indent:0px;\"><br /></p>\n"+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
		  + " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
		  + " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600; "
		  + "text-decoration: underline;\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">EN"
		  + " UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"+
		  "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
		  + " margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
		  + " text-decoration: underline;\"><br /></p>\n"+ "<p align=\"center\" style=\" margin-top:0px;"
		  + " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce"
		  + " programme permet de convertir un <span style=\" font-weight:600;\">AFD</span> en un <span style=\""
		  + " font-weight:600;\">AFD</span> et/ou le minimiser.</p></body></html>", null));
          quitButtonFinalStateWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
          nextButtonFinalStateWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
          enterNumberOfFinalStates.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
		  "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
		  "p, li { white-space: pre-wrap; }\n"+
		  "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">"
		  + "\n"+"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
		  + " margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br /></p>\n"+ "<p style=\" margin-top:0px;"
		  + " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"> "
		  + " Veuillez saisir le nombre d'\u00e9tats finaux:</p></body></html>", null));
		    	
    }

    /***********************************************************************************
	 ********************  FONCTION POUR AJOUTER LES ETAT FINAUX ***********************
	 ***********************************************************************************/
    
    public void addFinalStates()
    {
    	System.out.println("This value will be saved:" + finalStatesNumber.value());
    	exemple1.nombreEtatFinaux = finalStatesNumber.value();
    	AddStatesDialogBox.close();
    }
    
    /***********************************************************************************
	 ********************  DIALOG BOX POUR SELECTIONNER LES ETAT FINAUX ****************
	 ***********************************************************************************/
    
    public void selectFinalStatesBox()
    {
    	enterFinalStatesDialogBox = new QDialog(centralwidgetFinalStateWindow);
    	enterFinalStatesComboBox = new QComboBox(enterFinalStatesDialogBox);
    	enterFinalStatesComboBox.setObjectName("enterFinalStatesSpinBox");
    	enterFinalStatesComboBox.setGeometry(new QRect(260, 40, 81, 21));
        
    	enterFinalStatesComboBox.addItems(exemple1.etats);
        
        enterStatesLabelText = new QLabel(enterFinalStatesDialogBox);
        enterStatesLabelText.setObjectName("enterStatesLabelText");
        enterStatesLabelText.setGeometry(new QRect(20, 40, 221, 21));
        enterFinalStatesCloseButton = new QPushButton(enterFinalStatesDialogBox);
        enterFinalStatesCloseButton.setObjectName("enterFinalStatesCloseButton");
        enterFinalStatesCloseButton.setGeometry(new QRect(270, 90, 82, 28));
        enterFinalStatesCloseButton.setEnabled(false);
        enterFInalStatesNextButton = new QPushButton(enterFinalStatesDialogBox);
        enterFInalStatesNextButton.setObjectName("enterFInalStatesNextButton");
        enterFInalStatesNextButton.setGeometry(new QRect(180, 90, 82, 28));
        enterFinalStatesCloseButton.clicked.connect(enterFinalStatesDialogBox, "close()");
        enterFInalStatesNextButton.clicked.connect(this, "selectFinalStates()");
        nextButtonFinalStateWindow.setEnabled(false);
        
        enterFinalStatesDialogBox.connectSlotsByName();
               
        enterFinalStatesDialogBox.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Les etats finaux", null));
        enterStatesLabelText.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "S\u00e9lectionner"
        + " l'\u00e9tat final n\u00b0 1 :", null));
        
        
        
        enterFinalStatesCloseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Terminer", null));
        enterFInalStatesNextButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Suivant", null));
        enterFinalStatesDialogBox.show();
    }
    
    /***********************************************************************************
	 ********************  FONCTION POUR SELECTIONNER LES ETAT FINAUX ******************
	 ***********************************************************************************/
    
    public void selectFinalStates()
    {
    	if (iterFinalStates == exemple1.nombreEtatFinaux )
    	{
    		enterFinalStatesCloseButton.setEnabled(true);
    		enterFinalStatesDialogBox.close();
       		nextButtonFinalStateWindow.clicked.connect(this,"fonctionTransitionPart1()");
    		nextButtonFinalStateWindow.setEnabled(true);
    		enterFInalStatesNextButton.setEnabled(false);
 
    		return;
    	}
    	exemple1.etatsFinaux.add(enterFinalStatesComboBox.currentText());
    	enterFinalStatesComboBox.removeItem(enterFinalStatesComboBox.currentIndex());
    	iterFinalStates++;
    	enterStatesLabelText.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", 
    			"S\u00e9lectionner"+ " l'\u00e9tat final n\u00b0 "+ iterFinalStates +" :", null));
    }
    	
   
    /***********************************************************************************
	 *************   DIALOG BOX POUR LA FONCTION DE TRANSITION PART 1 ******************
	 ***********************************************************************************/
    
    public void fonctionTransitionPart1()
    {
    	//Cacher le contenu du widget central
    	 centralwidgetFinalStateWindow.hide();
    	 
         centralwidgetTransitionFct1 = new QWidget(centralwidgetFinalStateWindow);
         centralwidgetTransitionFct1.setObjectName("centralwidgetTransitionFct1");
         textBrowser = new QTextBrowser(centralwidgetTransitionFct1);
         textBrowser.setObjectName("textBrowser");
         textBrowser.setGeometry(new QRect(30, 20, 741, 101));
         quitButtonTransitionFct1 = new QPushButton(centralwidgetTransitionFct1);
         quitButtonTransitionFct1.setObjectName("quitButtonTransitionFct1");
         quitButtonTransitionFct1.setGeometry(new QRect(680, 490, 82, 28));
         nextButtonTransitionFct1 = new QPushButton(centralwidgetTransitionFct1);
         nextButtonTransitionFct1.setObjectName("nextButtonTransitionFct1");
         nextButtonTransitionFct1.setGeometry(new QRect(590, 490, 82, 28));
         labelFonctionTransition = new QLabel(centralwidgetTransitionFct1);
         labelFonctionTransition.setObjectName("labelFonctionTransition");
         labelFonctionTransition.setGeometry(new QRect(120, 200, 151, 31));
         labelFonctionTransition.setStyleSheet("font: 14pt \"Noto Sans\";");
         checkboxEmptyState = new QRadioButton(centralwidgetTransitionFct1);
         checkboxEmptyState.setObjectName("checkboxEmptyState");
         checkboxEmptyState.setGeometry(new QRect(120, 250, 191, 31));
         checkboxMultipleStates = new QRadioButton(centralwidgetTransitionFct1);
         checkboxMultipleStates.setObjectName("checkboxMultipleStates");
         checkboxMultipleStates.setGeometry(new QRect(120, 310, 131, 41));
         howManyStatesTransFct = new QSpinBox(centralwidgetTransitionFct1);
         howManyStatesTransFct.setObjectName("howManyStatesTransFct");
         howManyStatesTransFct.setGeometry(new QRect(240, 320, 52, 23));
         this.setCentralWidget(centralwidgetTransitionFct1);
        
         quitButtonTransitionFct1.pressed.connect(this, "close()");

         this.connectSlotsByName();
         
         this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
         textBrowser.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
		 "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
		 "p, li { white-space: pre-wrap; }\n"+
		 "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
		 + "font-style:normal;\">\n"+"<p align=\"center\" style=\"-qt-paragraph-type:empty; "
		 + "margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; "
		 + "text-indent:0px;\"><br /></p>\n"+"<p align=\"center\" style=\" margin-top:0px;"
		 + " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;"
		 + "\"><span style=\" font-size:12pt; text-decoration: underline;\">CONVERSTION D'UN </span>"
		 + "<span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFN </span>"
		 + "<span style=\" font-size:12pt; text-decoration: underline;\">EN UN </span><span style=\" "
		 + "font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"+
		 "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px;"
		 + " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; "
		 + "font-weight:600; text-decoration: underline;\"><br /></p>\n"+
		 "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px;"
		 + " margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir"
		 + " un <span style=\" font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">"
		 + "AFD</span> et/ou le minimiser.</p></body></html>", null));
         quitButtonTransitionFct1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
         nextButtonTransitionFct1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
         labelFonctionTransition.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "f(q0,0) = ?", null));
         checkboxEmptyState.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Vide", null));
         checkboxMultipleStates.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Plusieurs \u00e9tats", null));
   
         centralwidgetTransitionFct1.show();
    }
    
    /***********************************************************************************
	 *************   DIALOG BOX POUR LA FONCTION DE TRANSITION PART 2 ******************
	 ***********************************************************************************/
    
    
    
	/***********************************************************************************
	 *************************************** MAIN **************************************
	 ***********************************************************************************/
    
	public static void main(String[] args) 
	{
         exemple1 = new Afn();
         exemple2 = new Afntoafd();
         resultatFinal= new Afd();
         
		QApplication.initialize(args); 

		initWindow = new Ui_MainWindow();
		
		QApplication.execStatic(); 
		

	}

}