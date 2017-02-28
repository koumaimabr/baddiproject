/* **************************************************************************** */
/*                                                                              */
/*             PROJET : CONVERSION D'UN AFN EN UN AFD ET/OU LE MINIMISER        */
/*                                                                              */
/* **************************************************************************** */

package afnTOafd;

import java.util.*;

import com.trolltech.qt.gui.*;

import com.trolltech.qt.core.*;
// import com.trolltech.qt.core.Qt.WidgetAttribute;

public class Ui_MainWindow extends QMainWindow {
	private static Afn exemple1;
	private static Afntoafd exemple2;
	private static Afd resultatFinal;
	private static Afntoafd mini;
	/***********************************************************************************
	 * DECLARATIONS
	 ***********************************************************************************/
	// declaration des variables, buttons, widgets ..etc pour la MainWindow
	public static QMainWindow qInitMainWindow;
	private QWidget qMWCentralWidget;
	public static QWidget verticalLayoutWidgetMainWin;
	public static QVBoxLayout verticalLayoutMainWin;
	public static QPushButton convertAndMinimizeNfaButton;
	public static QPushButton displayDFAButton;
	public static QPushButton minimizeDfaButton;
	public static QPushButton quitterButtonMainWin;
	public static QPushButton AboutUsButton;
	public static QTextBrowser textEditMainWindow;
	public static QMenuBar menubarMainWin;
	public static QStatusBar statusbarMainWin;
	// private QProgressBar statusProgressBar;
	// declaration des variables .. etc pour la deuxieme window (saisir symbole
	// ... etc)
	public QWidget centralwidgetCheckboxes1;
	public QWidget verticalLayoutWidgetCheckboxes1;
	public QVBoxLayout verticalLayoutCheckboxes1;
	public QPushButton addSymbol;
	public QPushButton removeSymbol;
	public QPushButton displayAlphabet;
	public QPushButton displayAlphabetSize;
	public QTextBrowser textEditCheckboxes1;
	public QPushButton quitButtonCheckboxes1;
	public QPushButton nextButtonCheckboxes1;
	public QPushButton quitButton1;

	// fin de checkboxes1 declarations

	// Declarations pour le "add symbols" dialog box (pour ajouter un nouveau
	// symbole)

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

	// Le message box qui apparait quand l'utilisateur essaye de supprimer un
	// symbole
	// alors qu'il n'a pas encore saisi de symboles

	public QMessageBox warnSymbolEmpty;
	public QMessageBox warnSymbolNull;

	// Message box pour afficher l'alphabet
	public QMessageBox displayAlphabetMsgBox;

	// Message box pour afficher la taille de l'alphabet
	public QMessageBox displayAlphabetSizeMsgBox;

	// fin de Add symbol diolog box declarations

	// States window, la fenetre qui permet d'ajouter les etats
	public QWidget centralwidgetStatesWindow;
	public QWidget verticalLayoutWidgetStatesWin;
	public QVBoxLayout verticalLayoutStatesWindow;
	public QPushButton addState;
	public QPushButton displayStates;
	public QPushButton displayStatesSize;
	public QTextBrowser textEditStatesWindow;
	public QPushButton quitButtonStatesWindow;
	public QPushButton nextButtonStatesWindow;

	// Afficher une erreur si l'utilisateur clique sur "suivant" sans saisir
	// aucun symbol
	public QMessageBox displayErrorNoSymbolEnteredMsgBox;

	// (la fenêtre qui permet de choisir le nombre des états finaux

	public QWidget centralwidgetFinalStateWindow;
	public QTextBrowser textEditFinalStateWindow;
	public QPushButton quitButtonFinalStateWindow;
	public QPushButton nextButtonFinalStateWindow;
	public QTextBrowser textEditEnterNumberOfFinalStates;
	public QSpinBox finalStatesNumber;

	// Afficher les etats
	public QMessageBox displayStatesMessageBox;

	// Afficher une erreur si l'utilisateur clique sur "Afficher les etat" sans
	// saisir aucun etat
	public QMessageBox displayStatesErrorMessageBox;

	// Afficher une erreur si l'utilisateur clique sur "suivant" sans saisir les
	// etats
	public QMessageBox displayErrorNoStateEnteredMsgBox;

	// Afficher la taille des états
	public QMessageBox displayStatesSizeMessageBox;

	// Le dialog box pour ajouter un etat
	public QPushButton AddStatesCancelBoxButton;
	public QPushButton AddStatesBoxConfirmButton;
	public QSpinBox AddStatesDialogBoxSpinBox;
	public QLabel addStatesDialogBoxlabel;
	public QTextBrowser textEditAddStatesDialogBox;
	public QDialog AddStatesDialogBox;

	// Fin de la final state window

	// Box pour selectionner les etats finaux
	public QDialog enterFinalStatesDialogBox;
	public QComboBox enterFinalStatesComboBox;
	public QLabel enterStatesLabelText;
	public QPushButton enterFinalStatesCloseButton;
	public QPushButton enterFInalStatesNextButton;
	private int iterFinalStates = 1;

	// Premiere partie de la fonction de transition

	public QWidget centralwidgetTransitionFct1;
	public QTextBrowser textEditFonctionTransitionPart1Box;
	public QPushButton quitButtonTransitionFct1;
	public QPushButton nextButtonTransitionFct1;
	public QLabel labelFonctionTransition;
	public QRadioButton checkboxEmptyState;
	public QRadioButton checkboxMultipleStates;
	public QSpinBox howManyStatesTransFct;

	// push button qui apparait quand l'utilisateur selectionne "plusieurs
	// etats"
	public QPushButton enterEachFinalStateNextButton;
	public QComboBox enterEachFinalStateComboBox;
	public QTextBrowser textEditEnterEachFinalState;
	public QLabel enterEachFinalStateLabel;
	public QDialog enterEachFinalStateDialogBox;

	private int counterTransitionPathStates = 0; // counter for fonction string
													// array for states
	private int countertransitionPathSymbols = 0; // counter for fonction string
													// array for symbols
													//private int transitionPathChoice; // 1 for start entering AFN paths.
													// 2 for entering AFD paths. [Edit: Replace with displayDFA boolean variables.

	private int counterMultiplePathsValue;
	private int counterMultiplePathsIndex;
	private String joinedMultipleStates;
	private String labelCurrentPathFunction;
	private int counterMultiplePathsIteration;

	// La derniere fênetre
	public QWidget centralwidgetResultsWindow;
	public QTextBrowser textBrowserResultsWindow;
	public QPushButton finalResultAFDButton;
	public QPushButton finalResultMinimalAFDButton;
	public QPushButton quitButtonFinalResult;
	public QPushButton aFNSaisiFinalResultButton;
	public QTextBrowser textBrowerFinalResult;
	public QTextBrowser finalResultEmptyTextArea;
	public QFrame lineResultsWindow;

	// Variable for renamed Final states
	private HashSet<String> renamedFinalStates = new HashSet<String>();
	private HashSet<String> renamedStates = new HashSet<String>();
	private HashSet<String> renamedMinimizedFinalStates = new HashSet<String>();

	// Variables for Result Tables
	QTableWidget resultTable;
	QTableWidget showAFNTable;
	// QTableWidget showAFNInforTable;
	QTableWidget minResultTable;
	// boolean variables, so a QObject isnt closed before being created
	boolean vB_resultTable = false, vB_showAFNTable = false, vB_minResultTable = false;

	private boolean vB_displayDFA = false;
	private boolean vB_displayMinDFA = false;

	/*************************************************************************************
	 ************************ La Main Window du programme ***************************
	 *************************************************************************************/

	// fonction de la mainWindow
	public Ui_MainWindow() {
		

		// The main window (la premiere fênetre)

		setObjectName("MainWindow");
		// taille
		//resize(new QSize(800, 600);
		setFixedSize(new QSize(800, 600));
		
		QDesktopWidget mainWindowQApp = QApplication.desktop();
		QRect cent = mainWindowQApp.screenGeometry();
		QPoint centP = cent.center();
		move(centP.x()-400, centP.y()-300);
		//move(mainWindowQApp.screen(0).width()/2, mainWindowQApp.screen(0).height()/2);
		qMWCentralWidget = new QWidget(this);
		qMWCentralWidget.setObjectName("centralwidgetMainWin");
		qMWCentralWidget.setGeometry(0, 0, 800, 550);
		verticalLayoutWidgetMainWin = new QWidget(qMWCentralWidget);
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

		AboutUsButton = new QPushButton(qMWCentralWidget);
		AboutUsButton.setObjectName("AboutUsButton");
		AboutUsButton.setGeometry(new QRect(660, 490, 121, 28));
		AboutUsButton.clicked.connect(this, "aboutUs()");
		// Les informations du header
		textEditMainWindow = new QTextBrowser(qMWCentralWidget);
		textEditMainWindow.setObjectName("textBrowserMainWindow");
		textEditMainWindow.setGeometry(new QRect(30, 20, 741, 101));

		// Attacher le widget à la fênetre

		setCentralWidget(qMWCentralWidget);
		/*menubarMainWin = new QMenuBar(this);
		menubarMainWin.setObjectName("menubarMainWin");
		menubarMainWin.setGeometry(new QRect(0, 0, 800, 28));
		setMenuBar(menubarMainWin);
		statusbarMainWin = new QStatusBar(this);
		statusbarMainWin.setObjectName("statusbarMainWin");
		statusbarMainWin.showMessage("Testing");
		setStatusBar(statusbarMainWin);
		statusProgressBar = new QProgressBar();
		statusProgressBar.setMinimum(1);
		statusProgressBar.setMaximum(10);
		statusProgressBar.setValue(1);
		statusbarMainWin.addPermanentWidget(statusProgressBar);
		
		///////////////////////////////////// Add debug button
*/		///////////////////////////////////// ////////////////////////////
		displayDFAButton.clicked.connect(this, "enterDFA()");
		minimizeDfaButton.clicked.connect(this, "enterDFAMin()");
		
		/*QPushButton debugButton = new QPushButton(verticalLayoutWidgetMainWin);
		debugButton.setText("Debug DFA");
		verticalLayoutMainWin.addWidget(debugButton);

		QPushButton debugButtonNFA = new QPushButton(verticalLayoutWidgetMainWin);

		debugButtonNFA.setText("Debug NFA");
		verticalLayoutMainWin.addWidget(debugButtonNFA);

		debugButton.clicked.connect(this, "debug()");
		debugButtonNFA.clicked.connect(this, "debugNFA()");*/

		// Ajouter le texte au bouttons ..etc, de la MainWindow
		retranslateUi(this);

		// quitter
		quitterButtonMainWin.pressed.connect(this, "close()");
		convertAndMinimizeNfaButton.clicked.connect(this, "setupCheckboxes1()");

		connectSlotsByName();
		show();

	}

	static void retranslateUi(QMainWindow MainWindow) {
		MainWindow.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "AFN to DFA programme", null));
		convertAndMinimizeNfaButton.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"Convertir un AFN en un AFD et le minimiser", null));
		displayDFAButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un AFD", null));
		minimizeDfaButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Minimiser un AFD", null));
		quitterButtonMainWin.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
		AboutUsButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00c0 propos de nous", null));
		textEditMainWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML PUBLIC"
						+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400;"
						+ " font-style:normal;\">\n" + "<p align=\"center\" style=\"-qt-paragraph-type:empty; "
						+ "margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; "
						+ "text-indent:0px;\"><br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
						+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" "
						+ "font-size:12pt; text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" "
						+ "font-size:12pt; font-weight:600; text-decoration: underline;\">AFN </span><span style=\" "
						+ "font-size:12pt; text-decoration: underline;\">EN UN </span><span style=\" font-size:12pt;"
						+ " font-weight:600; text-decoration: underline;\">AFD</span></p>\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px;"
						+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt;"
						+ " font-weight:600; text-decoration: underline;\"><br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
						+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir "
						+ "un <span style=\" font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span>"
						+ " et/ou le minimiser.</p></body></html>",
				null));
		textEditMainWindow.setDisabled(true);

		// textEditMainWindow.setTextInteractionFlags(Qt.TextInteractionFlag.NoTextInteraction);
		// for future refernce, as it was difficult to figuure out how to set
		// flags.
		textEditMainWindow.setDisabled(true);
	}

	/***********************************************************************************
	 ********************** FONCTION DE LA SECONDE FENÊTRE ************************
	 ***********************************************************************************/
	 void aboutUs(){
		QDialog dialogAbout = new QDialog(qMWCentralWidget);
		dialogAbout.resize(new QSize(414, 339).expandedTo(dialogAbout.minimumSizeHint()));
		QTextBrowser textAbout = new QTextBrowser(dialogAbout);
		textAbout.setGeometry(new QRect(0, 0, 411, 271));
		QPushButton buttonAbout = new QPushButton(dialogAbout);
		buttonAbout.setText("Ok");
		buttonAbout.setAutoDefault(true);
		buttonAbout.setGeometry(new QRect(150, 290, 131, 31));
		buttonAbout.clicked.connect(dialogAbout, "close()");
		dialogAbout.setWindowTitle("About");
		// QMessageBox.information(qMWCentralWidget, "A propos", 
				textAbout.setHtml("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14pt; font-weight:600; color:#008080;\">Cette application permet de convertir un AFN en un AFD minimal</span></p>\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14px;\"><br /></span><span style=\" font-size:14px; font-weight:600;\">R\u00e9alis\u00e9e par:</span></p>\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14px;\">Benameur Ouissal</span></p>\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14px;\">Kabbouri Oumaima</span></p>\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14px;\">Boughriba Charaf Eddine</span></p>\n"+
"<p style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">\u00a0</p>\n"+
"<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br /></p>\n"+
"<p align=\"center\" style=\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:14px; font-style:italic;\">Encadr\u00e9 par : M. Y. Baddi</span></p></body></html>");
		dialogAbout.show();
	}
	public void setupCheckboxes1() {
//		statusProgressBar.setValue(2);
		// transitionPathChoice = 1; // User wanted AFN-AFD conversion, so set the
		// variable for it

		// Cacher le contenu du widget central
		qMWCentralWidget.hide();

		// Creer un nouveau widget vcentral pour la deuxieme fênetre
		centralwidgetCheckboxes1 = new QWidget(this);

		centralwidgetCheckboxes1.setObjectName("centralwidgetCheckboxes1");
		// new vertical layout pour le deuxieme widget
		verticalLayoutWidgetCheckboxes1 = new QWidget(centralwidgetCheckboxes1);
		verticalLayoutWidgetCheckboxes1.setObjectName("verticalLayoutWidgetCheckboxes1");
		verticalLayoutWidgetCheckboxes1.setGeometry(new QRect(160, 150, 491, 311));
		verticalLayoutCheckboxes1 = new QVBoxLayout(verticalLayoutWidgetCheckboxes1);
		verticalLayoutCheckboxes1.setObjectName("verticalLayoutCheckboxes1");

		// le boutton "Ajouter un symbol"
		addSymbol = new QPushButton(verticalLayoutWidgetCheckboxes1);
		addSymbol.setObjectName("addSymbol");

		// Ajout du boutton "ajouter un symbol" dans le Vertical Layout
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

		textEditCheckboxes1 = new QTextBrowser(centralwidgetCheckboxes1);
		textEditCheckboxes1.setObjectName("textBrowserCheckboxes1");
		textEditCheckboxes1.setGeometry(new QRect(30, 20, 741, 101));
		// quit button
		quitButton1 = new QPushButton(centralwidgetCheckboxes1);
		quitButton1.setObjectName("quitButton1");
		quitButton1.setGeometry(new QRect(680, 490, 82, 28));
		nextButtonCheckboxes1 = new QPushButton(centralwidgetCheckboxes1);
		nextButtonCheckboxes1.setObjectName("nextButtonCheckboxes1");
		nextButtonCheckboxes1.setGeometry(new QRect(590, 490, 82, 28));
		this.setCentralWidget(centralwidgetCheckboxes1);

		quitButton1.clicked.connect(this, "close()");
		addSymbol.clicked.connect(this, "addSymbolsBox()"); // Call addSymbols()
															// quand
															// l'utilisateur
															// clique sur ce
															// boutton
		displayAlphabet.clicked.connect(this, "displayAlphabetMessageBox()");
		displayAlphabetSize.clicked.connect(this, "displayAlphabetSizeMessageBox()");

		addSymbol.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ajouter un symbole", null));
		removeSymbol
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Supprimer un symbole", null));
		displayAlphabet
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher un alphabet", null));
		displayAlphabetSize.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"Afficher la taille d'un alphabet", null));
		textEditCheckboxes1.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML PUBLIC"
						+ " \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
						+ "font-style:normal;\">\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; "
						+ "margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br />"
						+ "</p>\n" + "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; "
						+ "margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
						+ " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600;"
						+ " text-decoration: underline;\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">"
						+ "EN UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span>"
						+ "</p>\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; "
						+ "margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
						+ " text-decoration: underline;\"><br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
						+ " -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir un <span style=\" "
						+ "font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">AFD</span> et/ou le minimiser."
						+ "</p></body></html>",
				null));
		textEditCheckboxes1.setDisabled(true);
		quitButton1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
		nextButtonCheckboxes1
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
		centralwidgetCheckboxes1.show();
		removeSymbol.clicked.connect(this, "delSymbolsBox()");
		nextButtonCheckboxes1.clicked.connect(this, "setupStatesWindow()");

		centralwidgetCheckboxes1.show();
		centralwidgetCheckboxes1.connectSlotsByName();
	}

	/***********************************************************************************
	 **************** LE DIALOG BOX POUR AJOUTER UN SYMBOLE ************************
	 ***********************************************************************************/

	public void addSymbolsBox() {
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
		if (!vB_displayDFA && !vB_displayMinDFA) {
			if (exemple1.alphabet.isEmpty()) {
				enterSymbolEditBox.setText("a");
			}
		} else {

			if (resultatFinal.alphabet.isEmpty()) {
				enterSymbolEditBox.setText("a");
			}
		}

		// errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
		// errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");

		// errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));

		// bouttons text..etc
		addSymbolDialogBox.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Ajouter un symbole", null));
		quitButtonAddSymbolBox
				.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "Fermer", null));
		addSymbolPopUpBoxButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox", "+ Ajouter", null));
		saisirSymboleLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox",
				"Veuillez saisir un symbole (un caract\u00e8re) :", null));
		errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
		errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
		errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
		errorSymbolAlreadyExist.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox",
				"<html><head/><body><p><span style=\" "
						+ "color:#cf0000;\">Erreur: ce symbole \u00e0 d\u00e9ja \u00e9t\u00e9 saisi</span></p></body></html>",
				null));
		errorSymbolAlreadyExist.hide();

		quitButtonAddSymbolBox.pressed.connect(addSymbolDialogBox, "close()");
		// errorSymbolAlreadyExist.hide();
		addSymbolDialogBox.show();
		enterSymbolEditBox.setFocus();
		addSymbolPopUpBoxButton.clicked.connect(this, "addSymbol()");
		addSymbolDialogBox.connectSlotsByName();

	}

	/***********************************************************************************
	 ********************** FONCTION POUR AJOUTER UN SYMBOLE **********************
	 ***********************************************************************************/

	public void addSymbol() {
		if (enterSymbolEditBox.text().isEmpty()) {
			warnSymbolNull = new QMessageBox(addSymbolDialogBox);
			QMessageBox.critical(addSymbolDialogBox, "Erreur", "Vous n'avez pas saisi de symboles!");
			return;
		}

		if (enterSymbolEditBox.text().equals("q")) {
			warnSymbolNull = new QMessageBox(addSymbolDialogBox);
			QMessageBox.critical(addSymbolDialogBox, "Erreur", "Vous ne pouvez pas sélectionner \"q\" comme symbole!. Veuillez entrer un autre");
			return;
		}
		
		char symbolEntered;
		symbolEntered = new Character(enterSymbolEditBox.text().charAt(0));

		// Vérifier si le symbole saisi existe déja, et afficher un erreur si
		// c'est la cas
		if (!vB_displayDFA && !vB_displayMinDFA) {
			if (exemple1.alphabet.indexOf(symbolEntered) > -1) {
				errorSymbolAlreadyExist.show();
				errorSymbolShown = true;
			} else {
				if (errorSymbolShown) {
					errorSymbolAlreadyExist.hide();
					errorSymbolShown = !errorSymbolShown;
				}

				exemple1.ajouterSymbole(symbolEntered);
				addSymbolDialogBox.close();
			}
		} else {
			if (resultatFinal.alphabet.indexOf(symbolEntered) > -1) {
				errorSymbolAlreadyExist.show();
				errorSymbolShown = true;
			} else {
				if (errorSymbolShown) {
					errorSymbolAlreadyExist.hide();
					errorSymbolShown = !errorSymbolShown;
				}

				resultatFinal.alphabet.add(symbolEntered);
				addSymbolDialogBox.close();
			}
		}

	}

	/***********************************************************************************
	 ********************** DIALOG BOX POUR SUPPRIMER UN SYMBOLE *********************
	 ***********************************************************************************/

	public void delSymbolsBox() {
		if (!vB_displayDFA && !vB_displayMinDFA) {

			if (exemple1.alphabet.isEmpty()) {
				warnSymbolEmpty = new QMessageBox(centralwidgetCheckboxes1);
				QMessageBox.critical(centralwidgetCheckboxes1, "Erreur", "Vous n'avez saisi aucun symbole!");
				return;
			}
		} else {
			if (resultatFinal.alphabet.isEmpty()) {
				warnSymbolEmpty = new QMessageBox(centralwidgetCheckboxes1);
				QMessageBox.critical(centralwidgetCheckboxes1, "Erreur", "Vous n'avez saisi aucun symbole!");
				return;
			}

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
		if (!vB_displayDFA && !vB_displayMinDFA) {
			List<String> symbolsStringList = new ArrayList<String>(exemple1.alphabet.size());
			for (char tchar : exemple1.alphabet) {
				symbolsStringList.add(String.valueOf(tchar));
			}
			delSymbolComboBox.insertItems(1, symbolsStringList);
		} else {
			List<String> symbolsStringList = new ArrayList<String>(resultatFinal.alphabet.size());
			for (char tchar : resultatFinal.alphabet) {
				symbolsStringList.add(String.valueOf(tchar));
			}
			delSymbolComboBox.insertItems(1, symbolsStringList);
		}
		delSymbolLabel = new QLabel(delSymbolDialogBox);
		delSymbolLabel.setObjectName("saisirSymboleLabel");
		delSymbolLabel.setGeometry(new QRect(50, 50, 281, 18));
		// errorSymbolAlreadyExist = new QLabel(addSymbolDialogBox);
		// errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");

		// errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));

		// bouttons text..etc
		delSymbolDialogBox.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Ajouter un symbole", null));
		quitButtonDelSymbolBox
				.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "Fermer", null));
		delSymbolPopUpBoxButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox", "+ Ajouter", null));
		delSymbolLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("delSymbolDialogBox",
				"Saisir un symbole pour le supprimer :", null));
		errorSymbolAlreadyExist = new QLabel(delSymbolDialogBox);
		errorSymbolAlreadyExist.setObjectName("errorSymbolAlreadyExist");
		errorSymbolAlreadyExist.setGeometry(new QRect(50, 140, 311, 18));
		errorSymbolAlreadyExist
				.setText(com.trolltech.qt.core.QCoreApplication.translate("addSymbolDialogBox",
						"<html><head/><body><p><span style=\" "
								+ "color:#cf0000;\">Il n'ya plus de symboles à supprimer</span></p></body></html>",
						null));
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
	 ********************** FONCTION POUR SUPPRIMER UN SYMBOLE *********************
	 ***********************************************************************************/

	public void delSymbol() {
		if (delSymbolComboBox.count() < 1) {
			errorSymbolAlreadyExist.show();
			return;
		}

		if (!vB_displayDFA && !vB_displayMinDFA) {
			exemple1.alphabet.remove(Character.valueOf(delSymbolComboBox.currentText().charAt(0)));
		} else {
			resultatFinal.alphabet.remove(Character.valueOf(delSymbolComboBox.currentText().charAt(0)));

		}

		delSymbolComboBox.removeItem(delSymbolComboBox.currentIndex());
		delSymbolDialogBox.close();

		// Vérifier si le symbole saisi existe déja, et afficher un erreur si
		// c'est la cas
		// errorSymbolAlreadyExist

	}

	/***********************************************************************************
	 ********************** FONCTION POUR AFFICHER L'ALPHABET **********************
	 ***********************************************************************************/

	public void displayAlphabetMessageBox() {
		String displayAlphabetText = "";
		if (!vB_displayDFA && !vB_displayMinDFA) {
			displayAlphabetText = "                A = { " + exemple1.affichageAlphabet() + "}                  ";
		} else {
			displayAlphabetText += "                A = { ";
			for (int i = 0; i < resultatFinal.alphabet.size(); i++) {
				displayAlphabetText += resultatFinal.alphabet.get(i) + " ";
			}
			displayAlphabetText += "}                  ";

		}

		displayAlphabetMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		QMessageBox.information(centralwidgetCheckboxes1, "Voici l'alphabet saisi :", displayAlphabetText);

	}

	/***********************************************************************************
	 ****************** FONCTION POUR AFFICHER LA TAILLE D'UN ALPHABET ***************
	 ***********************************************************************************/

	public void displayAlphabetSizeMessageBox() {
		String displayAlphabetSize = "La taille de votre alphabet est :  ";

		displayAlphabetSizeMsgBox = new QMessageBox(centralwidgetCheckboxes1);
		if (!vB_displayDFA && !vB_displayMinDFA) {
			QMessageBox.information(centralwidgetCheckboxes1, "Taille de l'alphabet" + "si :",
					displayAlphabetSize + exemple1.tailleAlphabet());
		} else {
			QMessageBox.information(centralwidgetCheckboxes1, "Taille de l'alphabet" + "si :",
					displayAlphabetSize + resultatFinal.alphabet.size());
		}

	}

	/***********************************************************************************
	 ********************** FONCTION DE LA TROISIEME FENÊTRE **********************
	 ***********************************************************************************/

	public void setupStatesWindow() {
		// pour afficher une erreur si l'utilisateur clique sur suivant sans
		// saisir un symbole
		if (!vB_displayDFA && !vB_displayMinDFA) {
			if (exemple1.alphabet.isEmpty()) {
				displayErrorNoSymbolEnteredMsgBox = new QMessageBox(centralwidgetStatesWindow);
				QMessageBox.critical(centralwidgetStatesWindow, "Erreur", "Vous n'avez saisi aucun symbole!");
				return;
			}
		} else {
			if (resultatFinal.alphabet.isEmpty()) {
				displayErrorNoSymbolEnteredMsgBox = new QMessageBox(centralwidgetStatesWindow);
				QMessageBox.critical(centralwidgetStatesWindow, "Erreur", "Vous n'avez saisi aucun symbole!");
				return;
			}
		}

		// Cacher le contenu du widget de la deuxieme fenetre
		centralwidgetCheckboxes1.hide();

		// Creer un nouveau widget central pour la deuxieme fênetre
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

		textEditStatesWindow = new QTextBrowser(centralwidgetStatesWindow);
		textEditStatesWindow.setObjectName("textBrowserStatesWindow");
		textEditStatesWindow.setGeometry(new QRect(30, 20, 741, 101));
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
		displayStates.clicked.connect(this, "displayStatesMessageBox()");
		displayStatesSize.clicked.connect(this, "displayStatesSizeMessageBox()");
		centralwidgetStatesWindow.connectSlotsByName();

		this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
		addState.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"Ajouter le nombre des \u00e9tats", null));
		displayStates.setText(
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Afficher les \u00e9tats", null));
		displayStatesSize.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"Afficher la taille des" + " \u00e9tats", null));
		textEditStatesWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML"
						+ " PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta" + " name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
						+ " -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt; text-decoration: underline;"
						+ "\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;"
						+ "\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">EN UN </span>"
						+ "<span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
						+ " text-decoration: underline;\"><br /></p>\n" + "<p align=\"center\" style=\" margin-top:0px;"
						+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">"
						+ "Ce programme permet de convertir un <span style=\" font-weight:600;\">AFD</span> en un "
						+ "<span style=\" font-weight:600;\">AFD</span> et/ou le minimiser.</p></body></html>",
				null));
		textEditStatesWindow.setDisabled(true);
		quitButtonStatesWindow.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
		nextButtonStatesWindow
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
	}

	/***********************************************************************************
	 ********************** DIALOG BOX POUR AJOUTER UN ETAT **************************
	 ***********************************************************************************/

	public void addStatesBox() {
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

		// Le nombre des etats finaux que l'utilisateur peut choisir ne peut pas
		// etre supérieur au nombre des etats
		AddStatesDialogBoxSpinBox.setMaximum(99);

		addStatesDialogBoxlabel = new QLabel(AddStatesDialogBox);
		addStatesDialogBoxlabel.setObjectName("addStatesDialogBoxlabel");
		addStatesDialogBoxlabel.setGeometry(new QRect(70, 120, 181, 21));
		textEditAddStatesDialogBox = new QTextBrowser(AddStatesDialogBox);
		textEditAddStatesDialogBox.setObjectName("addStatesDialogBoxTextEdit");
		textEditAddStatesDialogBox.setGeometry(new QRect(10, 10, 371, 71));

		AddStatesCancelBoxButton.pressed.connect(AddStatesDialogBox, "close()");
		AddStatesBoxConfirmButton.clicked.connect(this, "addStates()");
		AddStatesDialogBox.connectSlotsByName();

		AddStatesDialogBox.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Ajouter les états", null));
		AddStatesCancelBoxButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Annuler", null));
		AddStatesBoxConfirmButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox", "Confirmer", null));
		addStatesDialogBoxlabel.setText(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox",
				"Saisir le nombre d'\u00e9tats", null));
		textEditAddStatesDialogBox.setHtml(com.trolltech.qt.core.QCoreApplication.translate("AddStatesDialogBox",
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">"
						+ "\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px;"
						+ " -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">Veuillez saisir le nombre des"
						+ " \u00e9tats de votre automate.</span></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
						+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">"
						+ "Les noms des \u00e9tats vont \u00eatre g\u00e9n\u00e9r\u00e9s automatiquement  (q0 , q1 , ... qn), avec q0 "
						+ "\u00e9tant l'\u00e9tat initial.</span></p></body></html>",
				null));
		textEditAddStatesDialogBox.setDisabled(true);
		AddStatesDialogBox.show();
	}

	/***********************************************************************************
	 ********************** FONCTION POUR AJOUTER LES ETAT **************************
	 ***********************************************************************************/

	public void addStates() {

		if (!vB_displayDFA && !vB_displayMinDFA) {
			exemple1.ajouterEtats(AddStatesDialogBoxSpinBox.value());
		} else {
			resultatFinal.ajouterEtats(AddStatesDialogBoxSpinBox.value());

		}
		AddStatesDialogBox.close();
		addState.setEnabled(false);
	}

	/***********************************************************************************
	 ********************** FONCTION POUR AFFICHER LES ETATS ***********************
	 ***********************************************************************************/

	public void displayStatesMessageBox() {
		if (!vB_displayDFA && !vB_displayMinDFA) {

			if (exemple1.etats.isEmpty()) {
				warnSymbolNull = new QMessageBox(addSymbolDialogBox);
				QMessageBox.critical(addSymbolDialogBox, "Erreur", "Votre automate ne contient aucun état");
				return;
			}
		} else {
			if (resultatFinal.etats.isEmpty()) {
				warnSymbolNull = new QMessageBox(addSymbolDialogBox);
				QMessageBox.critical(addSymbolDialogBox, "Erreur", "Votre automate ne contient aucun état");
				return;
			}
		}

		String displayStatesText = "";
		if (!vB_displayDFA && !vB_displayMinDFA) {

			displayStatesText = "                Voici les états = { " + exemple1.affichageEtats()
					+ " }                  ";
		} else {
			displayStatesText = "                Voici les états = { " + resultatFinal.affichageEtats()
					+ " }                  ";

		}

		displayStatesMessageBox = new QMessageBox(centralwidgetStatesWindow);
		QMessageBox.information(centralwidgetStatesWindow, "Les états", displayStatesText);

	}

	/***********************************************************************************
	 ******************** FONCTION POUR AFFICHER LA TAILLE DES ETATS ****************
	 ***********************************************************************************/

	public void displayStatesSizeMessageBox() {

		String displayStatesSizeText = "";

		if (!vB_displayDFA && !vB_displayMinDFA) {
			displayStatesSizeText = "    Votre automate contient " + exemple1.tailleEtats() + " états    ";
		} else {
			displayStatesSizeText = "    Votre automate contient " + resultatFinal.etats.size() + " états    ";

		}

		displayStatesSizeMessageBox = new QMessageBox(centralwidgetStatesWindow);
		QMessageBox.information(centralwidgetStatesWindow, "La taille des états", displayStatesSizeText);

	}

	/***********************************************************************************
	 ********************** FONCTION DE LA 4 EME FENÊTRE **************************
	 ***********************************************************************************/

	public void setupFinalStateWindow() {
		// pour afficher une erreur si l'utilisateur clique sur suivant sans
		// saisir les etats
		if (!vB_displayDFA && !vB_displayMinDFA) {

			if (exemple1.etats.isEmpty()) {
				displayErrorNoStateEnteredMsgBox = new QMessageBox(centralwidgetFinalStateWindow);
				QMessageBox.critical(centralwidgetFinalStateWindow, "Erreur", "Votre automate ne contient aucun état");
				return;
			}
		} else {
			if (resultatFinal.etats.isEmpty()) {
				displayErrorNoStateEnteredMsgBox = new QMessageBox(centralwidgetFinalStateWindow);
				QMessageBox.critical(centralwidgetFinalStateWindow, "Erreur", "Votre automate ne contient aucun état");
				return;
			}
		}

		// Cacher le contenu du widget de la 3eme fenetre
		centralwidgetStatesWindow.hide();

		// Creer un nouveau widget central pour la 4eme fênetre
		centralwidgetFinalStateWindow = new QWidget(this);

		textEditFinalStateWindow = new QTextBrowser(centralwidgetFinalStateWindow);
		textEditFinalStateWindow.setObjectName("textBrowserFinalStateWindow");
		textEditFinalStateWindow.setGeometry(new QRect(30, 20, 741, 101));
		quitButtonFinalStateWindow = new QPushButton(centralwidgetFinalStateWindow);
		quitButtonFinalStateWindow.setObjectName("quitButtonFinalStateWindow");
		quitButtonFinalStateWindow.setGeometry(new QRect(680, 490, 82, 28));
		nextButtonFinalStateWindow = new QPushButton(centralwidgetFinalStateWindow);
		nextButtonFinalStateWindow.setObjectName("nextButtonFinalStateWindow");
		nextButtonFinalStateWindow.setGeometry(new QRect(590, 490, 82, 28));
		textEditEnterNumberOfFinalStates = new QTextBrowser(centralwidgetFinalStateWindow);
		textEditEnterNumberOfFinalStates.setObjectName("enterNumberOfFinalStates");
		textEditEnterNumberOfFinalStates.setGeometry(new QRect(160, 260, 261, 71));
		finalStatesNumber = new QSpinBox(centralwidgetFinalStateWindow);
		finalStatesNumber.setObjectName("finalStatesNumber");
		finalStatesNumber.setGeometry(new QRect(500, 260, 111, 71));
		if (!vB_displayDFA && !vB_displayMinDFA) {
			finalStatesNumber.setMaximum(exemple1.tailleEtats());
		}

		finalStatesNumber.setMinimum(1);
		this.setCentralWidget(centralwidgetFinalStateWindow);
		quitButtonFinalStateWindow.pressed.connect(this, "close()");
		nextButtonFinalStateWindow.clicked.connect(this, "selectFinalStatesBox()");
		// nextButtonFinalStateWindow.clicked.connect(this,"addFinalStates()" );
		// //Red

		centralwidgetFinalStateWindow.connectSlotsByName();

		this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
		textEditFinalStateWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "<!DOCTYPE HTML"
				+ " PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
				+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
				+ "p, li { white-space: pre-wrap; }\n"
				+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; "
				+ "font-weight:400; font-style:normal;\">" + "\n"
				+ "<p align=\"center\" style=\"-qt-paragraph-type:empty;" + " margin-top:0px; margin-bottom:0px; "
				+ "margin-left:0px;" + " margin-right:0px; -qt-block-indent:0; " + "text-indent:0px;\"><br /></p>\n"
				+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
				+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
				+ " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; font-weight:600; "
				+ "text-decoration: underline;\">AFN </span><span style=\" font-size:12pt; text-decoration: underline;\">EN"
				+ " UN </span><span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"
				+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
				+ " margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
				+ " text-decoration: underline;\"><br /></p>\n" + "<p align=\"center\" style=\" margin-top:0px;"
				+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce"
				+ " programme permet de convertir un <span style=\" font-weight:600;\">AFD</span> en un <span style=\""
				+ " font-weight:600;\">AFD</span> et/ou le minimiser.</p></body></html>", null));
		textEditFinalStateWindow.setDisabled(true);
		quitButtonFinalStateWindow
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
		nextButtonFinalStateWindow
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
		textEditEnterNumberOfFinalStates.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; font-style:normal;\">"
						+ "\n"
						+ "<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><br /></p>\n"
						+ "<p style=\" margin-top:0px;"
						+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"> "
						+ " Veuillez saisir le nombre d'\u00e9tats finaux:</p></body></html>",
				null));
		textEditEnterNumberOfFinalStates.setDisabled(true);
		centralwidgetFinalStateWindow.show();

	}

	/***********************************************************************************
	 ******************** FONCTION POUR AJOUTER LES ETAT FINAUX ***********************
	 ***********************************************************************************/
	/*
	 * public void addFinalStates() {
	 * System.out.println("This value will be saved:" +
	 * finalStatesNumber.value()); exemple1.nombreEtatFinaux =
	 * finalStatesNumber.value(); AddStatesDialogBox.close(); }
	 */

	/***********************************************************************************
	 ******************** DIALOG BOX POUR SELECTIONNER LES ETAT FINAUX ****************
	 ***********************************************************************************/

	public void selectFinalStatesBox() // bug: was being shown and hidden after
										// having been used
	{

		if (!vB_displayDFA && !vB_displayMinDFA) {
			exemple1.nombreEtatFinaux = finalStatesNumber.value(); // Save Final states
		} else {
			resultatFinal.nombreEtatFinaux = finalStatesNumber.value(); // Save Final states

		}

		enterFinalStatesDialogBox = new QDialog(centralwidgetFinalStateWindow); // issue:
																				// Why
																				// are
																				// widget
																				// object
																				// names different from function names
		enterFinalStatesComboBox = new QComboBox(enterFinalStatesDialogBox);
		enterFinalStatesComboBox.setObjectName("enterFinalStatesSpinBox");
		enterFinalStatesComboBox.setGeometry(new QRect(260, 40, 81, 21));
		if (!vB_displayDFA && !vB_displayMinDFA) {
			enterFinalStatesComboBox.addItems(exemple1.etats);
		} else {
			enterFinalStatesComboBox.addItems(resultatFinal.etats);
		}

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

		enterFinalStatesDialogBox
				.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Les etats finaux", null));
		enterStatesLabelText.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
				"S\u00e9lectionner" + " l'\u00e9tat final n\u00b0 1 :", null));

		enterFinalStatesCloseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Terminer", null));
		enterFInalStatesNextButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Suivant", null));
		enterFinalStatesDialogBox.show();
	}

	/***********************************************************************************
	 ******************** FONCTION POUR SELECTIONNER LES ETAT FINAUX ******************
	 ***********************************************************************************/

	public void selectFinalStates() {

		if (!vB_displayDFA && !vB_displayMinDFA) {

			exemple1.etatsFinaux.add(enterFinalStatesComboBox.currentText());
			enterFinalStatesComboBox.removeItem(enterFinalStatesComboBox.currentIndex());

			iterFinalStates++;
			enterStatesLabelText.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
					"S\u00e9lectionner" + " l'\u00e9tat final n\u00b0 " + iterFinalStates + " :", null));
			if (iterFinalStates > exemple1.nombreEtatFinaux) // bug: had to move it below for states 1 and final states 1
			{
				enterFinalStatesCloseButton.setEnabled(true);
				nextButtonFinalStateWindow.clicked.disconnect(); // bug: Previous slot wasn't being disconnected making the box show again

				nextButtonFinalStateWindow.clicked.connect(this, "fonctionTransitionPart1Box()");
				nextButtonFinalStateWindow.setEnabled(true);
				// enterFInalStatesNextButton.setEnabled(false); Not needed since box is closed
				enterFinalStatesDialogBox.close(); // bug: was placed a few lines above centralwidgetFinalStateWindow.close();

				// fonctionTransitionPart1Box();
			}
		} else {
			resultatFinal.etatsFinaux.add(enterFinalStatesComboBox.currentText());
			enterFinalStatesComboBox.removeItem(enterFinalStatesComboBox.currentIndex());

			iterFinalStates++;
			enterStatesLabelText.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
					"S\u00e9lectionner" + " l'\u00e9tat final n\u00b0 " + iterFinalStates + " :", null));
			if (iterFinalStates > resultatFinal.nombreEtatFinaux) // bug: had to move it below for states 1 and final states 1
			{
				enterFinalStatesCloseButton.setEnabled(true);
				nextButtonFinalStateWindow.clicked.disconnect(); // bug: Previous slot wasn't being disconnected making the box show again

				nextButtonFinalStateWindow.clicked.connect(this, "fonctionTransitionPart1Box()");
				nextButtonFinalStateWindow.setEnabled(true);
				// enterFInalStatesNextButton.setEnabled(false); Not needed since box is closed
				enterFinalStatesDialogBox.close(); // bug: was placed a few lines above centralwidgetFinalStateWindow.close();

				// fonctionTransitionPart1Box();
			}
		}

	}

	/***********************************************************************************
	 ************* DIALOG BOX POUR LA FONCTION DE TRANSITION PART 1 ******************
	 ***********************************************************************************/

	public void fonctionTransitionPart1Box() {
		if (!vB_displayDFA && !vB_displayMinDFA) {

			counterMultiplePathsIteration = exemple1.etats.size() * (exemple1.alphabet.size() + 1);
		} else {
			counterMultiplePathsIteration = resultatFinal.etats.size() * (resultatFinal.alphabet.size());

		}

		// Initialize variables
		if (!vB_displayDFA && !vB_displayMinDFA) {
			exemple1.fonctionTransition = new String[exemple1.etats.size()][exemple1.alphabet.size() + 1]; // +1 is for epsilon column

			if (countertransitionPathSymbols == exemple1.alphabet.size()) {
				labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + "," + "epsilon"
						+ ")";
			} else {
				labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + ","
						+ exemple1.alphabet.get(countertransitionPathSymbols) + ")";
			}
		}

		else {
			resultatFinal.fonctionTransition = new String[resultatFinal.etats.size()][resultatFinal.alphabet.size()];

			labelCurrentPathFunction = "f(" + resultatFinal.etats.get(counterTransitionPathStates) + ","
					+ resultatFinal.alphabet.get(countertransitionPathSymbols) + ")";
		}

		// Cacher le contenu du widget central
		centralwidgetFinalStateWindow.hide();

		centralwidgetTransitionFct1 = new QWidget(centralwidgetFinalStateWindow);
		centralwidgetTransitionFct1.setObjectName("centralwidgetTransitionFct1");
		textEditFonctionTransitionPart1Box = new QTextBrowser(centralwidgetTransitionFct1);
		textEditFonctionTransitionPart1Box.setObjectName("textBrowser");
		textEditFonctionTransitionPart1Box.setGeometry(new QRect(30, 20, 741, 101));
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
		checkboxEmptyState.setChecked(true);
		checkboxMultipleStates = new QRadioButton(centralwidgetTransitionFct1);
		checkboxMultipleStates.setObjectName("checkboxMultipleStates");
		checkboxMultipleStates.setGeometry(new QRect(120, 310, 131, 41));
		nextButtonTransitionFct1.clicked.connect(this, "processTransitionFct1Box()");
		howManyStatesTransFct = new QSpinBox(centralwidgetTransitionFct1);
		howManyStatesTransFct.setObjectName("howManyStatesTransFct");
		howManyStatesTransFct.setGeometry(new QRect(240, 320, 52, 23));
		if (!vB_displayDFA && !vB_displayMinDFA) {
			howManyStatesTransFct.setMaximum(exemple1.tailleEtats());
		} else {
			howManyStatesTransFct.setMaximum(1);
		}
		this.setCentralWidget(centralwidgetTransitionFct1);
		howManyStatesTransFct.setValue(1);
		howManyStatesTransFct.editingFinished.connect(checkboxMultipleStates, "click()");
		quitButtonTransitionFct1.clicked.connect(this, "close()");

		centralwidgetTransitionFct1.connectSlotsByName();

		this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
		textEditFonctionTransitionPart1Box.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
						+ "font-style:normal;\">\n" + "<p align=\"center\" style=\"-qt-paragraph-type:empty; "
						+ "margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; "
						+ "text-indent:0px;\"><br /></p>\n" + "<p align=\"center\" style=\" margin-top:0px;"
						+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;"
						+ "\"><span style=\" font-size:12pt; text-decoration: underline;\">CONVERSTION D'UN </span>"
						+ "<span style=\" font-size:12pt; font-weight:600; text-decoration: underline;\">AFN </span>"
						+ "<span style=\" font-size:12pt; text-decoration: underline;\">EN UN </span><span style=\" "
						+ "font-size:12pt; font-weight:600; text-decoration: underline;\">AFD</span></p>\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px;"
						+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; "
						+ "font-weight:600; text-decoration: underline;\"><br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Ce programme permet de convertir"
						+ " un <span style=\" font-weight:600;\">AFD</span> en un <span style=\" font-weight:600;\">"
						+ "AFD</span> et/ou le minimiser.</p></body></html>",
				null));
		textEditFonctionTransitionPart1Box.setDisabled(true);
		quitButtonTransitionFct1
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Quitter", null));
		nextButtonTransitionFct1
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Suivant >", null));
		labelFonctionTransition
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "f(q0,0) = ?", null));
		labelFonctionTransition.setText(labelCurrentPathFunction);

		checkboxEmptyState.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Vide", null));
		checkboxMultipleStates
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Plusieurs \u00e9tats", null));

		centralwidgetTransitionFct1.show();
	}

	/***********************************************************************************
	 ************* FONCTION POUR LE DIALOG BOX POUR SAISIR LES ETATS FINAUX **********
	 ***********************************************************************************/

	/***********************************************************************************
	 ******* FONCTION POUR LE TRAITEMENT CONCERNANT LA FONCTION DE TRANSITION ********
	 ***********************************************************************************/

	public void processTransitionFct1Box() {
		// show final result
		if (!vB_displayDFA && !vB_displayMinDFA) {

			nextButtonTransitionFct1.clicked.disconnect();
			nextButtonTransitionFct1.clicked.connect(this, "enterPathsAFN()");

			enterPathsAFN();

		}

		else {
			//limit multiple paths radio box to 1, as it is DFA
			howManyStatesTransFct.setMaximum(1);
			nextButtonTransitionFct1.clicked.disconnect();
			nextButtonTransitionFct1.clicked.connect(this, "enterPathsAFD()");
			enterPathsAFD();

		}

	}

	// function to update GUI, for entering paths of functions.
	public void enterPathsAFN() {
		if (!checkboxEmptyState.isChecked() && !checkboxMultipleStates.isChecked()) {
			QMessageBox.critical(centralwidgetTransitionFct1, "Erreur",
					"Vous n'avez sélectionné aucune case à cocher!");
			return;
		}
		counterMultiplePathsIteration--;

		// check if radiobox for Empty path was selected
		if (checkboxEmptyState.isChecked()) {
			exemple1.fonctionTransition[counterTransitionPathStates][countertransitionPathSymbols] = "vide";
			countertransitionPathSymbols++;

			if (countertransitionPathSymbols > exemple1.alphabet.size()) {
				countertransitionPathSymbols = 0;
				counterTransitionPathStates++;
			}
			if (counterMultiplePathsIteration == 0) // check if all states have
			// been entered to show the
			// result.
			{
				nextButtonTransitionFct1.clicked.disconnect();
				displayAFNResult();

			}

		} else if (checkboxMultipleStates.isChecked()) {
			fonctionTransitionDialogBox();

		}

		if (countertransitionPathSymbols == exemple1.alphabet.size()
				&& counterTransitionPathStates <= exemple1.etats.size()) // For
		// displaying
		// Epsilon
		// Question : why doesn't she add epsilon as the last symbol earlier on
		// in code?
		{
			labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + "," + "epsilon)";
			labelFonctionTransition.setText(labelCurrentPathFunction);
		} else if (counterMultiplePathsIteration > 0) {
			labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + ","
					+ exemple1.alphabet.get(countertransitionPathSymbols) + ")";
			labelFonctionTransition.setText(labelCurrentPathFunction);
		}

	}

	public void enterPathsAFD() {

		if (!checkboxEmptyState.isChecked() && !checkboxMultipleStates.isChecked()) {
			QMessageBox.critical(centralwidgetTransitionFct1, "Erreur",
					"Vous n'avez sélectionné aucune case à cocher!");
			return;
		}

		counterMultiplePathsIteration--;
	//	System.out.println("counterMultiplePathsIteration" + counterMultiplePathsIteration);
		// check if radiobox for Empty path was selected

		if (checkboxEmptyState.isChecked()) {
			//System.out.println("Shouldnt run");
			resultatFinal.fonctionTransition[counterTransitionPathStates][countertransitionPathSymbols] = "vide";
			countertransitionPathSymbols++;

			if (countertransitionPathSymbols >= resultatFinal.alphabet.size()) {
				countertransitionPathSymbols = 0;
				counterTransitionPathStates++;
			}
			if (counterMultiplePathsIteration == 0) // check if all states have been entered to show the result.
			{
				nextButtonTransitionFct1.clicked.disconnect();
				if (vB_displayDFA) {
					displayDFA();
				} else if (vB_displayMinDFA) {
					displayDFAMin();
				}

			}

		} else if (checkboxMultipleStates.isChecked()) {
			fonctionTransitionDialogBox();

		}

		/*
		 * if (countertransitionPathSymbols == exemple1.alphabet.size() &&
		 * counterTransitionPathStates <= exemple1.etats.size()) // For //
		 * displaying // Epsilon // Question : why doesn't she add epsilon as
		 * the last symbol earlier on // in code? { labelCurrentPathFunction =
		 * "f(" + exemple1.etats.get(counterTransitionPathStates) + "," +
		 * "epsilon)";
		 * labelFonctionTransition.setText(labelCurrentPathFunction); } else
		 */
		if (counterMultiplePathsIteration > 0) {
			//System.out.println("errorrrrrrrrr " + countertransitionPathSymbols);
			labelCurrentPathFunction = "f(" + resultatFinal.etats.get(counterTransitionPathStates) + ","
					+ resultatFinal.alphabet.get(countertransitionPathSymbols) + ")";
			labelFonctionTransition.setText(labelCurrentPathFunction);
		}

	}

	public void displayAFNResult() {
		centralwidgetTransitionFct1.close();
		// exemple1.fonctionTrans();
		exemple1.afficherFonctionTransition();

		//System.out.println("Printing Afn fonctionTransition");
		//print2DArray(exemple1.fonctionTransition);

		exemple2.testEpsilonTransition(exemple1);
		exemple2.transfert(exemple1);
		//System.out.println("Running \"afficherFonctionTransition\"");
		exemple2.afficherFonctionTransition();

		//System.out.println("Printing Afntoafd fin");
		//print2DArray(exemple2.getFin());

		

		/*
		 * Afd finAfd = min.minimaliser();
		 * System.out.println("printing after mini");
		 * print2DArray(finAfd.fonctionTransitionM);
		 */
		finalResultsWindow();

	}

	public void displayDFA() { 
		
		
		
		String[][] addedDFA = addAlphabetAndStates(resultatFinal.fonctionTransition, resultatFinal.alphabet, resultatFinal.etats);
		//print2DArray(addedDFA);
		HashSet<String> dfaStates = new HashSet<String>(); //Convert to HashSet, from ArrayList
		for (int i = 0; i < resultatFinal.etatsFinaux.size(); i++) {
			dfaStates.add(resultatFinal.etatsFinaux.get(i));
		}
		
		String[][] markedDFA = markFinalStates(addedDFA, dfaStates);

		QDialog showDFA = new QDialog(this);
		// minDFA.setGeometry(new QRect(220 150));
		showDFA.resize(new QSize(561, 370));
		showDFA.setWindowTitle("DFA");
		QTableWidget dfaTable = new QTableWidget(showDFA);
		dfaTable.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		dfaTable.verticalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		dfaTable.horizontalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		//resize(561, 370);
		QPushButton exitDFA = new QPushButton(showDFA);
		exitDFA.setText("Terminer");
		exitDFA.setGeometry(new QRect(260,350,60,20));
		dfaTable.setGeometry(new QRect(5, 5, 551, 335));
		exitDFA.clicked.connect(QApplication.instance(), "quit()");
		dfaTable.setRowCount(markedDFA.length - 1);
		dfaTable.setColumnCount(markedDFA[0].length - 1);

		for (int i = 0; i < markedDFA.length; i++) {

			for (int j = 0; j < markedDFA[0].length; j++) {

				// Set the header "States"
				// System.out.println("I is : " + i + "\nJ is : "+j);
				// if (i == 0 && j == 0){
				// continue;
				// }

				// Set symbol headers
				if (i == 0 && j >= 0) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();

					headerSymbols.setText(markedDFA[0][j]);
					dfaTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// resultTable.setItem(0, j, headerSymbols);
					continue;
				}
				// Set state headers
				if (j == 0) {
					QTableWidgetItem headerStates = new QTableWidgetItem();

					headerStates.setText(markedDFA[i][j]);
					dfaTable.setVerticalHeaderItem(i - 1, headerStates);
					// resultTable.setItem(0, 0, headerStates);
					continue;
				}
				// System.out.println("Out of If");
				QTableWidgetItem resultRows = new QTableWidgetItem();
				resultRows.setText(markedDFA[i][j]);
				// if (set)
				// {
				// resultRows.setBackground(new QBrush(new QColor(174, 174,
				// 174)));

				// }
				resultRows.setFlags(Qt.ItemFlag.ItemIsSelectable, Qt.ItemFlag.ItemIsDragEnabled);
				resultRows.setTextAlignment(Qt.AlignmentFlag.AlignCenter.value());
				dfaTable.setItem(i - 1, j - 1, resultRows);
				dfaTable.setColumnWidth(i - 1, 100); // adjust width

			}
			// set = !set;
		}
		// resultTable.resizeColumnsToContents();

		dfaTable.setAlternatingRowColors(true);
		dfaTable.show();
		showDFA.show();
		showDFA.setModal(true);

	}

	public void displayDFAMin() {
		//Assign variables
		exemple1.alphabet = resultatFinal.alphabet;
		exemple1.etatInitial = resultatFinal.etatInitial;
		exemple1.etats = resultatFinal.etats;
		exemple1.etatsFinaux = resultatFinal.etatsFinaux;
		String[][] convert = new String[resultatFinal.fonctionTransition.length][resultatFinal.fonctionTransition[0].length+1];
		for (int i = 0; i < convert.length; i++) {
			for (int j = 0; j < convert[i].length; j++) {
				if(j == convert[i].length-1){
					convert[i][j] = "vide";
				}
				else {
					convert[i][j] = resultatFinal.fonctionTransition[i][j];
				}
			}
		}
		exemple1.fonctionTransition = new String[convert.length][convert[0].length];
		exemple1.fonctionTransition = convert;
		//centralwidgetTransitionFct1.close();
		// exemple1.fonctionTrans();
		exemple1.afficherFonctionTransition();

//		System.out.println("Printing Afn fonctionTransition");
//		print2DArray(exemple1.fonctionTransition);

		exemple2.testEpsilonTransition(exemple1);
		exemple2.transfert(exemple1);
//		System.out.println("Running \"afficherFonctionTransition\"");
		exemple2.afficherFonctionTransition();
		
		resultatFinal.affichageAlphabet();
		resultatFinal.affichageEtats();
		resultatFinal.affichageEtatsFinaux();
		resultatFinal.affichageEtatsInitial();
		mini = new Afntoafd();
		Afd newAfd = new Afd();

		//Convert AFN-AFD result matrix to Afd and get new states
		
		exemple2.afficherInfoAFd(newAfd, exemple1);

//		for (String s : newAfd.etats){
//			System.out.println("Final States : "+s);
//		}
		newAfd.afficherFonctionTransitionM();
//		for (String s : newAfd.etats){
//			System.out.println("Final States after FonctionTransitionM: "+s);
//		}
		mini.minimiser(newAfd);
		
		

//		System.out.println("Printing Afntoafd fin");
//		print2DArray(exemple2.getFin());
		
		String[][] getResultMin = exemple2.getFin();
//		System.out.println("Printing after getFin-Inside minimizeDFA");
//
//		print2DArray(getResultMin);
		String[][] resultRemoveBracket = removeBrackets(getResultMin);

		String[][] renamedResult = renameResultStates(resultRemoveBracket, exemple1.etatsFinaux);
//		System.out.println("Printing after renameResultStates");
//		print2DArray(renamedResult);
		
		String[][] renamedMinimizedResult = renameMinimizedResult(renamedResult, renamedFinalStates);

//		System.out.println("Printing renamedMinimizedResult in MinimizeDFA");
//		print2DArray(renamedMinimizedResult);
//		System.out.println("renamed minimize finale stateS: "+ renamedMinimizedFinalStates);
		String[][] removedDuplicateStates = removeDuplicates(renamedMinimizedResult);
		
		String[][] markedMinimizedResult = markFinalStates(removedDuplicateStates, renamedMinimizedFinalStates);
		
		
		QDialog minDFA = new QDialog(this);
		// minDFA.setGeometry(new QRect(220 150));
		minDFA.resize(new QSize(561, 370));
		minDFA.setWindowTitle("DFA minimisé");
		minResultTable = new QTableWidget(minDFA);
		minResultTable.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		minResultTable.verticalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		minResultTable.horizontalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		//resize(561, 370);
		QPushButton exitMinDFA = new QPushButton(minDFA);
		exitMinDFA.setText("Terminer");
		exitMinDFA.setGeometry(new QRect(260,350,60,20));
		minResultTable.setGeometry(new QRect(5, 5, 551, 335)); // set the size
																	// and position
																	// of table
																	// Widget the
																	// same as
																	// previously
																	// show
																	// TextBrowser
																	// String[][] convertedResult = convertResultStates(exemple2.getFin(),
																	// exemple1.etatsFinaux);

		minResultTable.setRowCount(markedMinimizedResult.length - 1);
		minResultTable.setColumnCount(markedMinimizedResult[0].length - 1);

		exitMinDFA.clicked.connect(QApplication.instance(), "quit()");
		for (int i = 0; i < markedMinimizedResult.length; i++) {

			for (int j = 0; j < markedMinimizedResult[0].length; j++) {

				// Set the header "States"
				// System.out.println("I is : " + i + "\nJ is : "+j);
				if (i == 0 && j == 0) {
					continue;
				}

				// Set symbol headers
				if (i == 0 && j >= 0) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();

					headerSymbols.setText(markedMinimizedResult[i][j]);
					headerSymbols.setFont(new QFont("Arial", 14));
					minResultTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// minResultTable.setItem(0, j, headerSymbols);
					continue;
				}
				// Set state headers
				if (j == 0) {
					QTableWidgetItem headerStates = new QTableWidgetItem();

					headerStates.setText(markedMinimizedResult[i][j]);
					headerStates.setFont(new QFont("Arial", 14));
					minResultTable.setVerticalHeaderItem(i - 1, headerStates);
					// minResultTable.setItem(0, 0, headerStates);
					continue;
				}
				// System.out.println("Out of If");
				QTableWidgetItem resultRows = new QTableWidgetItem();
				resultRows.setText(markedMinimizedResult[i][j]);
				// if (set)
				// {
				// resultRows.setBackground(new QBrush(new QColor(174, 174,
				// 174)));

				// }
				resultRows.setFlags(Qt.ItemFlag.ItemIsSelectable, Qt.ItemFlag.ItemIsDragEnabled);
				resultRows.setTextAlignment(Qt.AlignmentFlag.AlignCenter.value());
				minResultTable.setItem(i - 1, j - 1, resultRows);
				// minResultTable.setColumnWidth(i - 1, 100); // adjust width

			}
			// set = !set;
		}
		// minResultTable.resizeColumnsToContents();

		minResultTable.setAlternatingRowColors(true);
		minResultTable.show();
		minDFA.show();
		minDFA.setModal(true);

		
		
		

	}

	public void fonctionTransitionDialogBox() {
		counterMultiplePathsIndex = 1;
		//System.out.println("fonctionTransitionDialogBox");
		counterMultiplePathsValue = howManyStatesTransFct.value();
		enterEachFinalStateDialogBox = new QDialog(centralwidgetTransitionFct1);
		enterEachFinalStateDialogBox
				.resize(new QSize(363, 210).expandedTo(enterEachFinalStateDialogBox.minimumSizeHint()));
		enterEachFinalStateNextButton = new QPushButton(enterEachFinalStateDialogBox);
		enterEachFinalStateNextButton.setObjectName("enterEachFinalStateNextButton");
		enterEachFinalStateNextButton.setGeometry(new QRect(130, 160, 111, 28));
		enterEachFinalStateComboBox = new QComboBox(enterEachFinalStateDialogBox);
		enterEachFinalStateComboBox.setObjectName("enterEachFinalStateComboBox");
		enterEachFinalStateComboBox.setGeometry(new QRect(230, 100, 91, 31));
		textEditEnterEachFinalState = new QTextBrowser(enterEachFinalStateDialogBox);
		textEditEnterEachFinalState.setObjectName("enterEachFinalStateTextBrowser");
		textEditEnterEachFinalState.setGeometry(new QRect(10, 10, 341, 71));
		enterEachFinalStateLabel = new QLabel(enterEachFinalStateDialogBox);
		enterEachFinalStateLabel.setObjectName("enterEachFinalStateLabel");
		enterEachFinalStateLabel.setGeometry(new QRect(60, 100, 111, 31));
		if (!vB_displayDFA && !vB_displayMinDFA) {
			enterEachFinalStateComboBox.addItems(exemple1.etats);
		} else {
			enterEachFinalStateComboBox.addItems(resultatFinal.etats);
		}
		enterEachFinalStateNextButton.clicked.connect(this, "addMultiplePaths()");
		enterEachFinalStateDialogBox.connectSlotsByName();

		// nextButtonTransitionFct1.clicked.connect(this,
		// "finalResultsWindow()");
		enterEachFinalStateDialogBox
				.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Form", null));
		enterEachFinalStateNextButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "L'\u00e9tat suivant >", null));
		textEditEnterEachFinalState.setHtml(com.trolltech.qt.core.QCoreApplication.translate("Form",
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/"
						+ "strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400;"
						+ " font-style:normal;\">\n" + "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;"
						+ " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">"
						+ "Selectionner le r\u00e9sultat de cette transition \u00e9tat par \u00e9tat : </p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-" + "right:0px; -qt-block-indent:0; text-indent:0px;\">" + labelCurrentPathFunction
						+ " = ?</p></body></html>",
				null));
		textEditEnterEachFinalState.setDisabled(true);
		enterEachFinalStateLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
				"L'\u00e9tat N\u00b0 " + counterMultiplePathsIndex + ":", null));
		enterEachFinalStateDialogBox.setModal(true);
		enterEachFinalStateDialogBox.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		enterEachFinalStateDialogBox.show();
	}

	/***********************************************************************************
	 *************************************** MAIN **************************************
	 ***********************************************************************************/

	public void addMultiplePaths() {
//		System.out.println("addMultiple paths");
//		System.out.println("counterMultiplePathsIndex : " + counterMultiplePathsIndex);
//		System.out.println("counterMultiplePathsValue : " + counterMultiplePathsValue);
//		System.out.println("counterTransitionPathStates : " + counterTransitionPathStates);
//		System.out.println("countertransitionPathSymbols : " + countertransitionPathSymbols);

		if (!vB_displayDFA && !vB_displayMinDFA) { // Block for NFA

			if (counterMultiplePathsIndex == 1) {
				joinedMultipleStates = "{" + enterEachFinalStateComboBox.currentText();
				enterEachFinalStateComboBox.removeItem(enterEachFinalStateComboBox.currentIndex());
				counterMultiplePathsIndex++;
				enterEachFinalStateLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
						"L'\u00e9tat N\u00b0 " + counterMultiplePathsIndex + ":", null));
			} else if (counterMultiplePathsIndex <= counterMultiplePathsValue) {
				joinedMultipleStates = joinedMultipleStates + "," + enterEachFinalStateComboBox.currentText();
				enterEachFinalStateComboBox.removeItem(enterEachFinalStateComboBox.currentIndex());
				counterMultiplePathsIndex++;
				enterEachFinalStateLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form",
						"L'\u00e9tat N\u00b0 " + counterMultiplePathsIndex + ":", null));
			}

			if (counterMultiplePathsIndex == counterMultiplePathsValue + 1) {

				joinedMultipleStates = joinedMultipleStates + "}";
				exemple1.fonctionTransition[counterTransitionPathStates][countertransitionPathSymbols] = joinedMultipleStates;
				countertransitionPathSymbols++;
				counterMultiplePathsIndex = 0;

				if (countertransitionPathSymbols > exemple1.alphabet.size()) {
					countertransitionPathSymbols = 0;
					counterTransitionPathStates++;
				}

				if (countertransitionPathSymbols == exemple1.alphabet.size()
						&& counterMultiplePathsIndex <= exemple1.etats.size()) {

					labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + "," + "epsilon"
							+ ")";

				} else if (counterMultiplePathsIndex <= exemple1.etats.size() && counterMultiplePathsIteration > 0) {

					labelCurrentPathFunction = "f(" + exemple1.etats.get(counterTransitionPathStates) + ","
							+ exemple1.alphabet.get(countertransitionPathSymbols) + ")";

				}

				labelFonctionTransition.setText(labelCurrentPathFunction);
				nextButtonTransitionFct1.clicked.disconnect();
				nextButtonTransitionFct1.clicked.connect(this, "enterPathsAFN()");
				enterEachFinalStateDialogBox.close();
				if (counterMultiplePathsIteration == 0) { // check if all states have been entered to show the result.
					nextButtonTransitionFct1.clicked.disconnect();
					displayAFNResult();
				}
			}
		}

		else { // Block for DFA

			counterMultiplePathsIndex++;
			if (counterMultiplePathsIndex == counterMultiplePathsValue + 1) {
				resultatFinal.fonctionTransition[counterTransitionPathStates][countertransitionPathSymbols] = enterEachFinalStateComboBox
						.currentText();
				countertransitionPathSymbols++;
				counterMultiplePathsIndex = 0;
				if (countertransitionPathSymbols >= resultatFinal.alphabet.size()) {
					countertransitionPathSymbols = 0;
					counterTransitionPathStates++;
				}

				if (counterMultiplePathsIndex <= resultatFinal.etats.size() && counterMultiplePathsIteration > 0) {

					labelCurrentPathFunction = "f(" + resultatFinal.etats.get(counterTransitionPathStates) + ","
							+ resultatFinal.alphabet.get(countertransitionPathSymbols) + ")";

				}
				labelFonctionTransition.setText(labelCurrentPathFunction);
				nextButtonTransitionFct1.clicked.disconnect();
				nextButtonTransitionFct1.clicked.connect(this, "enterPathsAFD()");
				enterEachFinalStateDialogBox.close();
				if (counterMultiplePathsIteration == 0) { // check if all states have been entered to show the result.
					nextButtonTransitionFct1.clicked.disconnect();
					if (vB_displayDFA) {
						displayDFA();
					} else if (vB_displayMinDFA) {
						displayDFAMin();
					}
				}

			}
		}
	}

	/***********************************************************************************
	 *********************** LA FÊNETRE QUI AFFICHE LES RESULTATS *********************
	 ***********************************************************************************/
	

	public void finalResultsWindow() {

		
		//create and call methods only once, as user can run the later methods more than once 
		resultatFinal.affichageAlphabet();
		resultatFinal.affichageEtats();
		resultatFinal.affichageEtatsFinaux();
		resultatFinal.affichageEtatsInitial();
		mini = new Afntoafd();

		//Convert AFN-AFD result matrix to Afd and get new states
		
		exemple2.afficherInfoAFd(resultatFinal, exemple1);

//		for (String s : resultatFinal.etats){
//			System.out.println("Final States : "+s);
//		}
		resultatFinal.afficherFonctionTransitionM();
//		for (String s : resultatFinal.etats){
//			System.out.println("Final States after FonctionTransitionM: "+s);
//		}
		mini.minimiser(resultatFinal);
		// Afd min =  resultatFinal.eliminerEtatInaccessible();  //Charaf method. Returns NullpointerException at line 362
//		System.out.println("Printing after mini minimiser");
//		print2DArray(resultatFinal.fonctionTransitionM); //renamed states
//		
		
		centralwidgetResultsWindow = new QWidget(this);
		centralwidgetResultsWindow.setObjectName("centralwidgetResultsWindow");
		textBrowserResultsWindow = new QTextBrowser(centralwidgetResultsWindow);
		textBrowserResultsWindow.setObjectName("textBrowserResultsWindow");
		textBrowserResultsWindow.setGeometry(new QRect(220, 20, 551, 101));
		finalResultAFDButton = new QPushButton(centralwidgetResultsWindow);
		finalResultAFDButton.setObjectName("finalResultAFDButton");
		finalResultAFDButton.setGeometry(new QRect(20, 150, 151, 71));
		finalResultMinimalAFDButton = new QPushButton(centralwidgetResultsWindow);
		finalResultMinimalAFDButton.setObjectName("finalResultMinimalAFDButton");
		finalResultMinimalAFDButton.setGeometry(new QRect(20, 240, 151, 71));
		quitButtonFinalResult = new QPushButton(centralwidgetResultsWindow);
		quitButtonFinalResult.setObjectName("infoAFNSaisiFinalResultButton");
		quitButtonFinalResult.setGeometry(new QRect(20, 420, 151, 71));
		aFNSaisiFinalResultButton = new QPushButton(centralwidgetResultsWindow);
		aFNSaisiFinalResultButton.setObjectName("aFNSaisiFinalResultButton");
		aFNSaisiFinalResultButton.setGeometry(new QRect(20, 330, 151, 71));
		textBrowerFinalResult = new QTextBrowser(centralwidgetResultsWindow);
		textBrowerFinalResult.setObjectName("textBrowerFinalResult");
		textBrowerFinalResult.setGeometry(new QRect(220, 150, 551, 341));
		finalResultEmptyTextArea = new QTextBrowser(centralwidgetResultsWindow);
		finalResultEmptyTextArea.setObjectName("finalResultEmptyTextArea");
		finalResultEmptyTextArea.setGeometry(new QRect(20, 20, 151, 91));
		lineResultsWindow = new QFrame(centralwidgetResultsWindow);
		lineResultsWindow.setObjectName("lineResultsWindow");
		lineResultsWindow.setGeometry(new QRect(180, -10, 20, 591));
		lineResultsWindow.setFrameShape(QFrame.Shape.VLine);
		this.setCentralWidget(centralwidgetResultsWindow);
		finalResultAFDButton.clicked.connect(this, "showAFNResult()");
		aFNSaisiFinalResultButton.clicked.connect(this, "showAFN()");
		finalResultMinimalAFDButton.clicked.connect(this, "minimizeNFA()");
		quitButtonFinalResult.clicked.connect(QApplication.instance(), "quit()");
		centralwidgetResultsWindow.connectSlotsByName();

		this.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
		textBrowserResultsWindow.setHtml(com.trolltech.qt.core.QCoreApplication.translate("MainWindow",
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
						+ "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
						+ "p, li { white-space: pre-wrap; }\n"
						+ "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400; "
						+ "font-style:normal;\">\n"
						+ "<p align=\"center\" style=\"-qt-paragraph-type:empty; margin-top:0px;"
						+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">"
						+ "<br /></p>\n"
						+ "<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px;"
						+ " margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:12pt;"
						+ " text-decoration: underline;\">CONVERSTION D'UN </span><span style=\" font-size:12pt; "
						+ "font-weight:600; text-decoration: underline;\">AFN </span><span style=\" font-size:12pt;"
						+ " text-decoration: underline;\">EN UN </span><span style=\" font-size:12pt; font-weight:600; "
						+ "text-decoration: underline;\">AFD</span></p>\n" + "<p align=\"center\" "
						+ "style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; "
						+ "margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:12pt; font-weight:600;"
						+ " text-decoration: underline;\"><br /></p>\n" + "<p align=\"center\" style=\" margin-top:0px;"
						+ " margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;"
						+ "\">Ce programme permet de convertir un <span style=\" font-weight:600;\">AFD</span> en un"
						+ " <span style=\" font-weight:600;\">AFD</span> et/ou le minimiser.</p></body></html>",
				null));
		textBrowserResultsWindow.setDisabled(true);

		finalResultAFDButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L'AFD obtenu", null));
		finalResultMinimalAFDButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L'AFD minimal", null));
		quitButtonFinalResult.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Terminer", null));
		aFNSaisiFinalResultButton
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "l'AFN saisi", null));

		/*
		 * textBrowerFinalResult.setHtml(com.trolltech.qt.core.QCoreApplication.
		 * translate("MainWindow",
		 * "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
		 * +
		 * "<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
		 * + "p, li { white-space: pre-wrap; }\n"+
		 * "</style></head><body style=\" font-family:'Noto Sans'; font-size:10pt; font-weight:400;"
		 * + " font-style:normal;\">\n"
		 * +"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px;" +
		 * " margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">TEST CENTERED TEXT</p></body></html>"
		 * , null));
		 */
		centralwidgetResultsWindow.show();

	}

	public String[][] renameResultStates(String[][] input, ArrayList<String> finalStates) {
		String[][] temp = new String[input.length][input[0].length];
		boolean stateIsFinal = false;
		int index = 0;
		if (!renamedFinalStates.isEmpty()) {
			renamedFinalStates.clear();
		}

		if (!renamedStates.isEmpty()) {
			renamedStates.clear();
		}

		HashMap<String, String> states = new HashMap<String, String>();

		for (int i = 0; i < input.length; i++) {

			// skip first row if it is empty or only contains one character
			// because it then contains symbol names
			if (input[i][0].length() < 2) {
				continue;
			}

			if (!states.containsKey(input[i][0])) {

				if (input[i][0] == "vide") {
					renamedStates.add("vide");

					states.put(input[i][0], "vide");
					continue;
				}

				if (!input[i][0].isEmpty() || input[i][0] == " ") {

					for (int j = 0; j < finalStates.size(); j++) {
						if ((input[i][0].contains(finalStates.get(j)))) {
							stateIsFinal = true;
							break;
						}

						else {
							stateIsFinal = false;
						}

					}

					if (stateIsFinal) {

						renamedFinalStates.add("q" + index);

					}
					renamedStates.add("q" + index);
					states.put(input[i][0], "q" + index);
					index++;
				}
			}
		}

		for (int i = 0; i < input.length; i++) {
			// skip first row because it contains symbol names
			if (input[i][0].length() < 2) { // to skip first line if it is result without minimization. 
				//continue;
			}

			for (int j = 0; j < input[i].length; j++) {

				if (!states.containsKey(input[i][j])) {
					temp[i][j] = input[i][j];
					continue;
				}
				temp[i][j] = states.get(input[i][j]);
			}
		}
		return temp;

	}

	String[][] markFinalStates(String[][] input, HashSet<String> finalStates) {
		String[][] temp = new String[input.length][input[0].length];

		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[i].length; j++) {

				if (finalStates.contains(input[i][j])) {
					temp[i][j] = "(" + input[i][j] + ")";
				} else {
					temp[i][j] = input[i][j];
				}

			}
		}
		return temp;

	}

	

	// Add a row and column for alphabet heading and state names column

	String[][] addAlphabetAndStates(String[][] input, ArrayList<Character> alphabets, ArrayList<String> states) {

		String[][] out = new String[input.length + 1][input[0].length + 1];

		// Add alphabet headings, after making sure size matches with matrix
		// columns.
		if (input[0].length < alphabets.size()) {
			System.out.println(
					"Erreur: Dans la méthode addAlphabetAndState, la taille de tableau des input ne correspond pas à la taille de l'alphabet : "
							+ alphabets.size() + "\n" + input[0].length);
			return input;
		}

		for (int i = 0; i <= alphabets.size(); i++) {
			if (i == 0) {
				out[0][0] = " ";
			}

			else {
				out[0][i] = alphabets.get(i - 1).toString();
			}
		}
		// Add state names to first column

		for (int i = 0; i < states.size(); i++) {

			out[i + 1][0] = states.get(i);

		}

		// Copy the input Array

		for (int i = 0; i < out.length; i++) {

			if (i == 0) {
				continue;
			}
			for (int j = 0; j < out[i].length; j++) {

				if (j == 0) {
					continue;
				}

				out[i][j] = input[i - 1][j - 1];
			}
		}

		return out;

	}

	public void showAFNResult() {

		textBrowerFinalResult.hide(); // Hide the TextBrowser previously shown
		if (vB_showAFNTable) {
			showAFNTable.close();
			vB_showAFNTable = false;
		}
		if (vB_minResultTable) {
			minResultTable.close();
			vB_minResultTable = false;
		}

		resultTable = new QTableWidget(centralwidgetResultsWindow);
		resultTable.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		resultTable.verticalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		resultTable.horizontalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		resultTable.setGeometry(new QRect(220, 150, 551, 341)); // set the size
																// and position
																// of table
																// Widget the
																// same as
																// previously
																// show
																// TextBrowser
																// String[][] convertedResult = convertResultStates(exemple2.getFin(),
																// exemple1.etatsFinaux);
		String[][] getResultNFA = exemple2.getFin();
//		System.out.println("Printing after getResult get Fin");
//
//		print2DArray(getResultNFA);

		String[][] renameResult = renameResultStates(getResultNFA, exemple1.etatsFinaux);
//		System.out.println("Printing after renameResultStates");
//
//		print2DArray(renameResult);
		renameResult = markFinalStates(renameResult, renamedFinalStates);

//		System.out.println("Printing after markFinalStates");

//		print2DArray(renameResult);
		resultTable.setRowCount(renameResult.length - 1);
		resultTable.setColumnCount(renameResult[0].length - 1);

		for (int i = 0; i < renameResult.length; i++) {

			for (int j = 0; j < renameResult[0].length; j++) {

				// Set the header "States"
				// System.out.println("I is : " + i + "\nJ is : "+j);
				if (i == 0 && j == 0) {
					continue;
				}

				// Set symbol headers
				if (i == 0 && j >= 0) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();

					headerSymbols.setText(renameResult[i][j]);
					headerSymbols.setFont(new QFont("Arial", 14));
					resultTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// resultTable.setItem(0, j, headerSymbols);
					continue;
				}
				// Set state headers
				if (j == 0) {
					QTableWidgetItem headerStates = new QTableWidgetItem();

					headerStates.setText(renameResult[i][j]);
					headerStates.setFont(new QFont("Arial", 14));
					resultTable.setVerticalHeaderItem(i - 1, headerStates);
					// resultTable.setItem(0, 0, headerStates);
					continue;
				}
				// System.out.println("Out of If");
				QTableWidgetItem resultRows = new QTableWidgetItem();
				resultRows.setText(renameResult[i][j]);
				// if (set)
				// {
				// resultRows.setBackground(new QBrush(new QColor(174, 174,
				// 174)));

				// }
				resultRows.setFlags(Qt.ItemFlag.ItemIsSelectable, Qt.ItemFlag.ItemIsDragEnabled);
				resultRows.setTextAlignment(Qt.AlignmentFlag.AlignCenter.value());
				resultTable.setItem(i - 1, j - 1, resultRows);
				//resultTable.setColumnWidth(i - 1, 100); // adjust width
				/*resultTable.horizontalHeader().setStretchLastSection(true);
				resultTable.verticalHeader().setStretchLastSection(true);*/

			}
			// set = !set;
		}
		// resultTable.resizeColumnsToContents();

		resultTable.setAlternatingRowColors(true);
		resultTable.show();
		vB_resultTable = true;

	}

	void showAFN() {

		textBrowerFinalResult.hide(); // Hide the TextBrowser previously shown
		if (vB_resultTable) {
			resultTable.close();
			vB_resultTable = false;
		}
		if (vB_minResultTable) {
			minResultTable.close();
			vB_minResultTable = false;
		}

		showAFNTable = new QTableWidget(centralwidgetResultsWindow);
		showAFNTable.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		showAFNTable.verticalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		showAFNTable.horizontalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		showAFNTable.setGeometry(new QRect(220, 150, 551, 341)); // set the size
																	// and
																	// position
																	// of table
																	// Widget
																	// the same
																	// as
																	// previously
																	// show
																	// TextBrowser
		String[][] showAFN = addAlphabetAndStates(exemple1.fonctionTransition, exemple1.alphabet, exemple1.etats);

		showAFNTable.setRowCount(showAFN.length - 1);
		showAFNTable.setColumnCount(showAFN[1].length - 1);
//		System.out.println("Debug starts");
//		print2DArray(showAFN);
		for (int i = 0; i < showAFN.length; i++) {

			for (int j = 0; j < showAFN[i].length; j++) {

				// Set the header "States"
				// System.out.println("I is : " + i + "\nJ is : "+j);
				if (i == 0 && j == 0) {
					continue;
				}
				// Set Epsilon header
				if (i == 0 && j == showAFN[0].length - 1) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();
//					System.out.println("Setting E");
					headerSymbols.setText("Epsilon");
					headerSymbols.setFont(new QFont("Arial", 14));
					showAFNTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// showAFNTable.setItem(0, j, headerSymbols);
					continue;
				}
				// Set symbol headers
				if (i == 0 && j >= 0) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();

					headerSymbols.setText(showAFN[i][j]);
					headerSymbols.setFont(new QFont("Arial", 14));
					showAFNTable.horizontalHeader().setStretchLastSection(true);
					showAFNTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// showAFNTable.setItem(0, j, headerSymbols);
					continue;
				}

				// Set state headers
				if (j == 0) {
					QTableWidgetItem headerStates = new QTableWidgetItem();

					headerStates.setText(showAFN[i][j]);
					headerStates.setFont(new QFont("Arial", 14));

					showAFNTable.setVerticalHeaderItem(i - 1, headerStates);
					// showAFNTable.setItem(0, 0, headerStates);
					continue;
				}
				// System.out.println("Out of If");
				QTableWidgetItem resultRows = new QTableWidgetItem();
				resultRows.setText(showAFN[i][j]);
				// if (set)
				// {
				// resultRows.setBackground(new QBrush(new QColor(174, 174,
				// 174)));

				// }
				resultRows.setFlags(Qt.ItemFlag.ItemIsSelectable, Qt.ItemFlag.ItemIsDragEnabled);
				resultRows.setTextAlignment(Qt.AlignmentFlag.AlignCenter.value());
				showAFNTable.setItem(i - 1, j - 1, resultRows);
				// showAFNTable.setColumnWidth(i - 1, 100); // adjust width
			

			}
			// set = !set;
		}
		// showAFNTable.resizeColumnsToContents();
		/*
		 * QLabel states = new QLabel(centralwidgetResultsWindow); states.
		 * setText("<p><strong><span style=\"color: rgb(56, 46, 205);\"><span style=\"font-size: 14px;\">Etats : "
		 * + exemple1.etats.size() + "</span></span></strong></p>");
		 * states.setGeometry(220, 500, 100, 20); states.show(); String tmp =
		 * ""; for (int i = 0; i < exemple1.alphabet.size(); i++) { tmp +=
		 * exemple1.alphabet.get(i); if (i < exemple1.alphabet.size()-1){ tmp +=
		 * ", "; } }
		 * 
		 * QLabel symbols = new QLabel(centralwidgetResultsWindow); symbols.
		 * setText("<p><strong><span style=\"color: rgb(0, 0, 205);\"><span style=\"font-size: 14px;\">Alphabets : "
		 * + tmp + "</span></span></strong></p>");
		 * 
		 * symbols.setGeometry(220, 530, 300, 20); symbols.show();
		 */
		showAFNTable.setAlternatingRowColors(true);
		showAFNTable.show();
		vB_showAFNTable = true;

	}

	void print2DArray(String[][] array) {
		if (array == null || array.length < 1) {
			System.out.println("==Print2DArray==\nEmpty array. return");
			return;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {

				System.out.println("Placeholder[" + i + "][" + j + "] = \"" + array[i][j] + "\"" + ";");
			}
		}

	}

	void minimizeNFA() {

		textBrowerFinalResult.hide(); // Hide the TextBrowser previously shown
		if (vB_resultTable) {
			resultTable.close();
			vB_resultTable = false;
		}
		if (vB_showAFNTable) {
			showAFNTable.close();
			vB_showAFNTable = false;
		}

		
		
		
		
		// Rename result states

		String[][] getResultMin = exemple2.getFin();
//		System.out.println("Printing after getFin-Inside minimizeNFA");
//
//		print2DArray(getResultMin);
		String[][] resultRemoveBracket = removeBrackets(getResultMin);

		String[][] renamedResult = renameResultStates(resultRemoveBracket, exemple1.etatsFinaux);
//		System.out.println("Printing after renameResultStates");
//		print2DArray(renamedResult);
		
		String[][] renamedMinimizedResult = renameMinimizedResult(renamedResult, renamedFinalStates);

//		System.out.println("Printing renamedMinimizedResult in MinimizeNFA");
//		print2DArray(renamedMinimizedResult);
//		System.out.println("renamed minimize finale stateS: "+ renamedMinimizedFinalStates);
		String[][] removedDuplicateStates = removeDuplicates(renamedMinimizedResult);
		
		String[][] markedMinimizedResult = markFinalStates(removedDuplicateStates, renamedMinimizedFinalStates);
		
		
				
		

		minResultTable = new QTableWidget(centralwidgetResultsWindow);
		minResultTable.setAttribute(Qt.WidgetAttribute.WA_DeleteOnClose);
		minResultTable.verticalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		minResultTable.horizontalHeader().setResizeMode(QHeaderView.ResizeMode.Stretch);
		minResultTable.setGeometry(new QRect(220, 150, 551, 341)); // set the size
																	// and position
																	// of table
																	// Widget the
																	// same as
																	// previously
																	// show
																	// TextBrowser
																	// String[][] convertedResult = convertResultStates(exemple2.getFin(),
																	// exemple1.etatsFinaux);

		minResultTable.setRowCount(markedMinimizedResult.length - 1);
		minResultTable.setColumnCount(markedMinimizedResult[0].length - 1);

		for (int i = 0; i < markedMinimizedResult.length; i++) {

			for (int j = 0; j < markedMinimizedResult[0].length; j++) {

				// Set the header "States"
				// System.out.println("I is : " + i + "\nJ is : "+j);
				if (i == 0 && j == 0) {
					continue;
				}

				// Set symbol headers
				if (i == 0 && j >= 0) {
					QTableWidgetItem headerSymbols = new QTableWidgetItem();

					headerSymbols.setText(markedMinimizedResult[i][j]);
					headerSymbols.setFont(new QFont("Arial", 14));
					minResultTable.setHorizontalHeaderItem(j - 1, headerSymbols);
					// minResultTable.setItem(0, j, headerSymbols);
					continue;
				}
				// Set state headers
				if (j == 0) {
					QTableWidgetItem headerStates = new QTableWidgetItem();

					headerStates.setText(markedMinimizedResult[i][j]);
					headerStates.setFont(new QFont("Arial", 14));
					minResultTable.setVerticalHeaderItem(i - 1, headerStates);
					// minResultTable.setItem(0, 0, headerStates);
					continue;
				}
				// System.out.println("Out of If");
				QTableWidgetItem resultRows = new QTableWidgetItem();
				resultRows.setText(markedMinimizedResult[i][j]);
				// if (set)
				// {
				// resultRows.setBackground(new QBrush(new QColor(174, 174,
				// 174)));

				// }
				resultRows.setFlags(Qt.ItemFlag.ItemIsSelectable, Qt.ItemFlag.ItemIsDragEnabled);
				resultRows.setTextAlignment(Qt.AlignmentFlag.AlignCenter.value());
				minResultTable.setItem(i - 1, j - 1, resultRows);
				// minResultTable.setColumnWidth(i - 1, 100); // adjust width

			}
			// set = !set;
		}
		// minResultTable.resizeColumnsToContents();

		minResultTable.setAlternatingRowColors(true);
		minResultTable.show();
		vB_minResultTable = true;

	}
	String[][] renameMinimizedResult(String[][] input, HashSet<String> finalStates){
		renamedMinimizedFinalStates.clear();; // clear just in case this method was run before.
		String[][] out = new String[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j].toLowerCase().contains("q")){ // Skip empty columns and alphabets
					if (!mini.minimizedStates.get(input[i][j]).isEmpty() || mini.minimizedStates.get(input[i][j]) != null){ //make sure no null or empty value is written
						out[i][j] = "q" + mini.minimizedStates.get(input[i][j]);
						if (finalStates.contains(input[i][j])) { // current state is final. Save its new name for marking it later
							renamedMinimizedFinalStates.add("q"+mini.minimizedStates.get(input[i][j]));
						}
					}
					else {
						out[i][j] = input[i][j]; // write old value if no key / value was found
						if (finalStates.contains(input[i][j])) { // current state is final. Save its new name for marking it later
							renamedMinimizedFinalStates.add("q"+mini.minimizedStates.get(input[i][j]));
						}
					}
				}
				else {
					out[i][j] = input[i][j]; //write old value if the element didn't have state names
				}

			}
		}
		
		
		return out;
		
	}
	
	String[][] removeDuplicates(String[][] input) {
		//HashSet<String> uniqueStates = new HashSet<String>();
		String currentState = "";
		boolean first = false;
		ArrayList<Integer> duplicates = new ArrayList<Integer>();
		// remove rows only if they are identical 

		//Create a list with unique states only 
		/*for (int i = 0; i < input.length; i++) {
			if (input[i][0] != null && input[i][0].toLowerCase().startsWith("q")){
				uniqueStates.add(input[i][0]);
			}
			else {
				continue;
			}

		}*/

		for (int i = 0; i < input.length; i++) {
			if (input[i][0] != null && input[i][0].toLowerCase().startsWith("q")){
				currentState = input[i][0];
			} else {
				continue;
			}
			boolean identical = true;
			for (int j = 0; j < input.length; j++) {


				if (input[j][0] != null && input[j][0].toLowerCase().startsWith("q")){

					if(input[j][0].equals(currentState) && !first){
						first = true;
						continue;
					}
					else if(input[j][0].equals(currentState) && first && !duplicates.contains(j)){
						for (int j2 = 0; j2 < input[j].length; j2++) {
							if(!input[i][j2].equals(input[j][j2])){
								identical = false;
							}
						}
						if (identical){
							duplicates.add(j);
							identical = true;
						}
					}

				} else {
					continue;
				}
			}
			first = false;

		}
		
		String[][] out = new String[input.length-duplicates.size()][input[1].length];
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			
			if (!duplicates.contains(i)){
				out[index] = input[i];
				index++;
			}
		}

		return out;


	}
	

	String[][] nfaResultToDFA(String[][] nfaArray) {

		String[][] tempArray = new String[nfaArray.length - 1][nfaArray[0].length - 1]; // create
																						// a
																						// temporary
																						// Array
																						// with
																						// one
																						// less
																						// row
																						// and
																						// column
		for (int i = 0; i < nfaArray.length; i++) {
			if (nfaArray[i][0].length() < 2) {
				//System.out.println("continuing");
				continue;
			}

			for (int j = 0; j < nfaArray[i].length; j++) {
				if (j == 0) {
					continue;
				}

				tempArray[i - 1][j - 1] = nfaArray[i][j];

			}

		}
		return tempArray;

	}

	String[][] removeBrackets(String[][] inputArray) { // replace all { and }
															// with empty strings
		String[][] temp = new String[inputArray.length][inputArray[0].length];
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[0].length; j++) {
//				System.out.println("Currently at " + i + " " + j);
				temp[i][j] = inputArray[i][j].replaceAll("\\{", "");
				temp[i][j] = inputArray[i][j].replaceAll("\\}", "");
			}

		}
		return temp;
	}

	void enterDFA() {
		vB_displayDFA = true;
		setupCheckboxes1();

	}

	void enterDFAMin() {
		vB_displayMinDFA = true;
		setupCheckboxes1();

	}

	/***********************************************************************************
	 *************************************** MAIN **************************************
	 ***********************************************************************************/

	public static void main(String[] args) {

		exemple1 = new Afn();
		exemple2 = new Afntoafd();
		resultatFinal = new Afd();
		
		QApplication.initialize(args);
		QApplication.setStyle(QStyleFactory.create("plastique"));
		// change the string to any of the following to see if the colours
		// change too. or only buttons
		// plastique
		// windowsxp
		// macintosh
		// motif
		qInitMainWindow = new Ui_MainWindow();

		QApplication.execStatic();

	}

}