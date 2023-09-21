#include <iostream>    
#include <conio.h>
#include <stdlib.h>
#include <random>

using namespace std;


struct Boule_s // La structure d'une boule unique, qui a une Lettre et un Nombre
{
	char Lettre;
	int Nombre;
};

struct Case_s // Chaque case de la carte de bingo a ces propri�t�s
{
	bool Tire = false;
	Boule_s ValeurCase;
};


// Variables
char Choix; // Les lettres que l'utilisateur peut appuyer
const int TailleTableaux = 75; // La taille maximale du boulier. Taille utilis�e pour le tableau de boules qui repr�sente le boulier.
int IndexBouleTiree; // Pour la fonction TirerAuHAsard
int BoulesRestantes = 75; // Pour suivre les boules non nulles qui restent dans le boulier. Utilis�e dans la fonction TirerAuHasard
int NbBoulesNonNulles = 0; // On commence avec 0 boules non nulles dans le tableau de boules tir�es


//Variables de structures
Boule_s BouleNulle; // Variable utilis�e pour initialiser le tableau de boules nulles ainsi que pour mettre une boule nulle � la fin du boulier apr�s avoir tir� une boule
Boule_s BouleTiree;   // Repr�sente la boule qu'on vient de tirer. Variable utilis�e dans la fonction RetirerLaBouleTiree

// Tableaux de boules
Boule_s Boulier[TailleTableaux]; // Boulier
Boule_s BoulesTirees[TailleTableaux]; // L'endroit o� on met chaque boule qui a �t� tir�e




// Fonctions
void DisplayMenu(void); // Affiche le menu de jeu
void InitialiserBoulier(Boule_s Boulier[], int Taille); // Initialise le boulier
void InitialiserBoulesNulles(Boule_s BoulesTirees[], int Taille); // Initialise les boules tir�es
void AfficherTableauDeBoules(Boule_s TableauDeBoules[], int Taille);//Fonction qui affiche les boules d'un tableau si elles ne sont pas des boules nulles
void InitialiserCarte(Case_s TableauDeCarte[5][5]); // Initialise la carte de bingo
void AfficherCarte(Case_s TableauDeCarte[5][5]); // Affiche la carte de bingo
int TirerAuHasard(int BoulesRestantes); // Tire au hasard une boule parmi les boules restantes dans le boulier. Initialement 75. 
// Une fois la boule tir�e au hasard, la fonction RetirerLaBouleTiree la retire du boulier
// Sera aussi utilis�e pour identifier cette boule de bingo dans le programme principal
Boule_s RetirerLaBouleTiree(Boule_s TableauDeBoules[], int BoulesRestantes, int IndexBouleTiree); // Enl�ve la boule tir�e du boulier
void AjouterBouleAUnTableau(Boule_s TableauDeBoules[], int NbBoulesNonNulles, Boule_s BouleAAjouter);//Sera utilis� pour ajouter la boule tir�e � la liste des boules d�j� tir�es
// Et ajouter une boule nulle � la fin du boulier.
void ValiderCarte(Case_s TableauDeCartes[5][5]); // Fonction utilis�e pour valider si le boule tir�e est pr�sente dans la carte de bingo. 
//Si oui, changer son �tat pour pouvoir changer sa couleur.
void RecommencerPartie(Case_s Carte[5][5]); // Fonction pour recommencer une partie apr�s avoir cri� BINGO!



void main(void) // Fonction principale
{
	Case_s Carte[5][5]; // Matrice de carte de bingo (TableauDeCarte[5][5])
	InitialiserBoulier(Boulier, TailleTableaux); // Remplir le boulier des 75 boules cr�es
	InitialiserBoulesNulles(BoulesTirees, TailleTableaux); // Remplir le tableau de 75 boules tir�es, qui sont des boules nulles
	InitialiserCarte(Carte); // Remplir la carte de bingo avec les valeurs sans l'afficher tout de suite.

	bool MetaLoop = true; // Pour sortir du programme
	while (MetaLoop == true) // Pour r�afficher le menu apr�s les choix
	{
		//Menu de jeu
		system("cls");
		DisplayMenu();
		cout << "\n BOULIER : ";
		cout << "\n";
		// Les boules en jeu
		AfficherTableauDeBoules(Boulier, TailleTableaux);
		cout << "\n\n\n TIRAGE DE LA BOULE : " << BouleTiree.Lettre << BouleTiree.Nombre;
		cout << "\n\n\n BOULES DEJA TIRES : ";
		AfficherTableauDeBoules(BoulesTirees, TailleTableaux);
		cout << "\n\n\n\n";
		//Carte de bingo
		AfficherCarte(Carte);
		// Recueillir le choix de l'utilisateur
		Choix = _getch();
		Choix = toupper(Choix);

		//Les diff�rents choix de l'utilisateur
		switch (Choix)
		{
			// Tirer une boule
		case 'T':
			if (Boulier[0].Lettre == ' ')// Pour g�rer le cas o� un utilisateur n'appuyait jamais sur bingo malgr� l'avertissement
			{
				MetaLoop = false;
				system("cls");
				break;
			}
			TirerAuHasard(BoulesRestantes);
			BoulesRestantes = BoulesRestantes - 1; // D�cr�mente le nombre de boules restantes 
			RetirerLaBouleTiree(Boulier, BoulesRestantes, IndexBouleTiree);
			AjouterBouleAUnTableau(BoulesTirees, NbBoulesNonNulles, BouleTiree);
			ValiderCarte(Carte);
			if (Boulier[0].Lettre == ' ') // Pour traiter le cas o� un utilisateur oublierait de crier bingo
			{
				system("cls");
				cout << " VOUS AVEZ PASSE TOUT DROIT, CRIEZ BINGO !";
				_getch;
			}
			break;

			// CRIER BINGO!!!!
		case 'B':
			system("cls");
			cout << "********************" << endl;
			cout << "***** BINGO!!! *****" << endl;
			cout << "********************" << endl;
			_getch();
			RecommencerPartie(Carte);
			break;

		case 'Q':
			system("cls");
			MetaLoop = false;
			break;
		}
		_getch();
	}
}

// Fonction pour afficher le menu
void DisplayMenu(void)
{
	cout << "****************************** Menu ******************************" << endl;
	cout << "***  T - Tirer un numero     B - Bingo    Q - Quitter le menu  ***" << endl;
	cout << "******************************************************************" << endl;
}

// Fonction pour remplir le tableau de boules avec 75 structures de boules
void InitialiserBoulier(Boule_s Boulier[], int Taille)
{
	
	for (int i = 1; i <= TailleTableaux + 1; i++)
	{
		for (int i = 1; i <= Taille && i <= 76; i++)
		{
			char LettreCourante;
			if (i <= 15)
			{
				LettreCourante = 'B';
			}
			else if (i <= 30)
			{
				LettreCourante = 'I';
			}
			else if (i <= 45)
			{
				LettreCourante = 'N';
			}
			else if (i <= 60)
			{
				LettreCourante = 'G';
			}
			else
			{
				LettreCourante = 'O';
			}

			Boulier[i - 1].Lettre = LettreCourante;
			Boulier[i - 1].Nombre = i;
		}
	}
}

// Fonction pour remplir le tableau de boules tir�es avec 75 boules nulles
void InitialiserBoulesNulles(Boule_s BoulesTirees[], int Taille)
{
	for (int i = 1; i <= TailleTableaux; i++)
	{
		BoulesTirees[i] = BouleNulle;
		BouleNulle.Lettre = ' ';
		BouleNulle.Nombre = 0;
	}
}

// Fonction pour afficher les tableaux de boules, peu importe si ce sont le boulier ou les boules nulles
void AfficherTableauDeBoules(Boule_s TableauDeBoules[], int Taille)
{
	for (int i = 0; i < TailleTableaux; i++)
	{
		if (TableauDeBoules[i].Lettre != ' ' && TableauDeBoules[i].Nombre != 0)
		{
			cout << TableauDeBoules[i].Lettre << TableauDeBoules[i].Nombre << " ";
		}
	}
}

// Fonction d'initialisation de la carte
void InitialiserCarte(Case_s TableauDeCarte[5][5])
{


	int NombreColonne1 = 11; // Variables pour incr�menter et assigner les nomberes de chaque case. 
	int NombreColonne2 = 16;
	int NombreColonne3 = 31;
	int NombreColonne4 = 46;
	int NombreColonne5 = 61;

	for (int i = 0; i <= 4; i++) // Boucle pour les rangees
	{

		for (int j = 0; j <= 4; j++) // Boucle pour les colonnes
		{
			if (j == 0) // Tracker de colonne
			{
				TableauDeCarte[i][j].ValeurCase.Lettre = 'B';
				TableauDeCarte[i][j].ValeurCase.Nombre = NombreColonne1;
				TableauDeCarte[i][j].Tire = false; // Je rajoute �a pour la fonction RecommencerPartie une fois que l'utilisateur a cri� BINGO!
				NombreColonne1++;
			}
			else if (j == 1)
			{
				TableauDeCarte[i][j].ValeurCase.Lettre = 'I';
				TableauDeCarte[i][j].ValeurCase.Nombre = NombreColonne2;
				TableauDeCarte[i][j].Tire = false;
				NombreColonne2++;
			}
			else if (j == 2)
			{
				TableauDeCarte[i][j].ValeurCase.Lettre = 'N';
				TableauDeCarte[i][j].ValeurCase.Nombre = NombreColonne3;
				TableauDeCarte[i][j].Tire = false;
				NombreColonne3++;
			}
			else if (j == 3)
			{
				TableauDeCarte[i][j].ValeurCase.Lettre = 'G';
				TableauDeCarte[i][j].ValeurCase.Nombre = NombreColonne4;
				TableauDeCarte[i][j].Tire = false;
				NombreColonne4++;
			}
			else if (j == 4)
			{
				TableauDeCarte[i][j].ValeurCase.Lettre = 'O';
				TableauDeCarte[i][j].ValeurCase.Nombre = NombreColonne5;
				TableauDeCarte[i][j].Tire = false;
				NombreColonne5++;
			}
		}
	}
}

//Fonction d'affichage de la carte de Bingo
void AfficherCarte(Case_s TableauDeCarte[5][5])
{
	cout << "================================" << endl;
	cout << "|| B  || I  ||  N || G  || O  ||" << endl;
	cout << "================================" << endl;

	for (int i = 0; i < 5; i++) // Rang�es
	{
		cout << "||";
		for (int j = 0; j < 5; j++) // Colonnes
		{
			if (TableauDeCarte[i][j].Tire == true) // Si le num�ro est tir�
			{
				cout << "\033[30;47m"; // Noir sur blanc
			}

			cout.width(3);
			cout << TableauDeCarte[i][j].ValeurCase.Nombre; // �crire le num�ro
			cout << "\033[0m"; // Tout de suite revenir � la couleur de base
			cout << " ||";
		}
		cout << "\n================================" << endl;
	}
}

// Tire au hasard une boule parmi les boules restantes dans le boulier. Initialement 75. 
int TirerAuHasard(int BoulesRestantes)
{
	srand(time(NULL));
	IndexBouleTiree = (rand() % (BoulesRestantes));// Enlev� le +1 car mes boules restantes sont d�j� de 75, donc les index de 0 � 74.
	return IndexBouleTiree;
}

//Enl�ve la boule tir�e du boulier et stock en m�moire quelle boule a �t� tir�e
Boule_s RetirerLaBouleTiree(Boule_s TableauDeBoules[], int BoulesRestantes, int IndexBouleTiree)
{
	BouleTiree = TableauDeBoules[IndexBouleTiree];

	for (int i = IndexBouleTiree; i < BoulesRestantes; i++)// Loop sur les boules restantes � partir de l'index de la boule tir�e
	{
		TableauDeBoules[i] = TableauDeBoules[i + 1]; // La boule tir�e perd sa place et est remplac�e par la suivante, et toutes les boules se d�calent de -1 index avec le loop
	}
	NbBoulesNonNulles++;
	return BouleTiree; // Pour identifier la boule tir�e dans le programme principal
}

// Fonction pour ajouter la boule tir�e � la liste des boules d�j� tir�es et pour mettre � jour le boulier avec des boules nulles
void AjouterBouleAUnTableau(Boule_s TableauDeCarte[], int NbBoulesNonNulles, Boule_s BouleAAjouter)
{
	//Ajouter la boule tir�e � la liste des boules d�j� tir�es 
	for (int i = 0; i < TailleTableaux; i++)
	{
		if (i == NbBoulesNonNulles)
		{
			TableauDeCarte[i] = BouleAAjouter;
		}
	}
	//	Ajoute une boule nulle � la suite des boules non nulles dans le Boulier
	Boulier[BoulesRestantes] = BouleNulle; // � l'index final + 1 de boules non nulles du tableau, on met une boule nulle
	BouleNulle.Lettre = ' '; // Comme les valeurs de la boule nulle ne sont pas dans le scope global, on les d�finit ici.
	BouleNulle.Nombre = 0;
}

//Fonction pour changer l'�tat de chaque case de la carte de bingo (tir� ou non tir�). Sert notamment � changer la couleur d'une carte tir�e dans la fonction d'affichage.
void ValiderCarte(Case_s TableauDeCarte[5][5])
{
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			if (TableauDeCarte[i][j].ValeurCase.Lettre == BouleTiree.Lettre && TableauDeCarte[i][j].ValeurCase.Nombre == BouleTiree.Nombre)
			{
				TableauDeCarte[i][j].Tire = true;
			}
		}
	}
}

void RecommencerPartie(Case_s Carte[5][5])
{
	// Effacer l'�cran
	system("cls");

	// R�initialiser les variables et tableaux
	InitialiserBoulesNulles(BoulesTirees, TailleTableaux);
	InitialiserBoulier(Boulier, TailleTableaux);
	InitialiserCarte(Carte);
	BoulesRestantes = 75;
	NbBoulesNonNulles = 0;
	BouleTiree = BouleNulle;
	// R�afficher
	DisplayMenu();
	cout << "\n BOULIER : ";
	cout << "\n";
	AfficherTableauDeBoules(Boulier, TailleTableaux);
	cout << "\n\n\n TIRAGE DE LA BOULE : " << BouleTiree.Lettre << BouleTiree.Nombre;
	cout << "\n\n\n BOULES DEJA TIRES : ";
	AfficherTableauDeBoules(BoulesTirees, TailleTableaux);
	cout << "\n\n\n\n";
	//Carte de bingo
	AfficherCarte(Carte);
}
