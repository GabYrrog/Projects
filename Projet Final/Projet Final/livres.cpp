#include <iostream>
#include <conio.h>
#include <fstream>
#include <string>
#include <time.h>
#include "utils.h"
#include "livres.h"




using namespace std;
extern const string NOM_FICHIER_LIVRES = "X:\\Programmation 2\\fichiers\\livres.bin";

//const int MAX_CHAR = 125;
//
//struct Livre_s
//{
//	int NumeroUniqueDeLivre;
//	char TitreDuLivre[MAX_CHAR];
//	char AuteurDuLivre[MAX_CHAR];
//	bool Prete;
//};

Livre_s RechercherLivre(int Numero);
void MettreAJourLivre(int Numero, Livre_s ClientModifie);

int NombreDeLivresTotaux()
{
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::in | ios::binary);

	int NombreDeLivres = 0;
	Livre_s UnLivre;

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&UnLivre, sizeof(Livre_s));
	while (!FluxFichier.eof())
	{
		NombreDeLivres++;
		FluxFichier.read((char*)&UnLivre, sizeof(Livre_s));
	}


	FluxFichier.close();
	//cout << "\n" << NombreDeClients; // TEST
	return NombreDeLivres;
}


void NouveauLivre()
{
	Livre_s NouveauLivre;
	string TitreLivre;
	string AuteurLivre;
	
	cout << "\n\n\n";
	cout << "Entrez le titre du livre : ";
	getline(cin, TitreLivre);

	cout << "Entrez le nom de l'auteur/autrice : ";
	getline(cin, AuteurLivre);

	_getch();
	NouveauLivre.NumeroUniqueDeLivre = NombreDeLivresTotaux();
	NouveauLivre.Prete = false;

	StringEnTabChar(TitreLivre, NouveauLivre.TitreDuLivre); 
	StringEnTabChar(AuteurLivre, NouveauLivre.AuteurDuLivre);

	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::app | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.write((char*)&NouveauLivre, sizeof(Livre_s));
	FluxFichier.close();
	cout << "\nLivre enregistre" << endl;
	cout << "Appuyez sur une touche pour continuer" << endl;
	_getch();
}

Livre_s RechercherLivre(int Numero)
{
	Livre_s LivreALire;
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.seekg(Numero * sizeof(Livre_s), ios::beg);
	FluxFichier.read((char*)&LivreALire, sizeof(Livre_s));

	FluxFichier.close();
	return LivreALire;
}

void AfficherLivre(int Numero)
{
	string Choix;
	cout << "\n\n\nEntrez le numero du livre a afficher: ";
	getline(cin, Choix);
	int NumeroLivreAAfficher = stoi(Choix);
	Livre_s LivreAAfficher = RechercherLivre(NumeroLivreAAfficher);

	int Total = NombreDeLivresTotaux();

	if (NumeroLivreAAfficher <= Total)
	{
		cout << "Titre du livre: " << LivreAAfficher.TitreDuLivre << "    Auteur: " << LivreAAfficher.AuteurDuLivre << "	Numero du livre: " << LivreAAfficher.NumeroUniqueDeLivre << "    Prete ";
		cout << LivreAAfficher.Prete << endl;
		_getch();
	}
	else
	{
		cout << "Numero de livre invalide" << endl;
		cout << "Appuyez sur une touche pour continuer" << endl;
		_getch();
	}
	cout << "Appuyez sur une touche pour continuer" << endl;
	_getch();
}

void MettreAJourLivre(int Numero, Livre_s LivreModifie) // À TESTER
{
	
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::in | ios::out | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.seekp(Numero * sizeof(Livre_s), ios::beg);
	FluxFichier.write((char*)&LivreModifie, sizeof(Livre_s));


	FluxFichier.close();
}

void ListeDesLivresPretes() // A tester
{
	Livre_s LivreALire;
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&LivreALire, sizeof(Livre_s));
	while (!FluxFichier.eof())
	{
		if (LivreALire.Prete == true)
		{
			cout << "Titre du livre: " << LivreALire.TitreDuLivre << "    Numero: " << LivreALire.NumeroUniqueDeLivre << endl;
		}
		FluxFichier.read((char*)&LivreALire, sizeof(Livre_s));
	}

	FluxFichier.close();
	cout << "Appuyez sur une touche pour continuer" << endl;
	_getch();
}

void AfficherLesLivres() // TEST pour voir tous les livres
{

	Livre_s LivreALire;
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&LivreALire, sizeof(Livre_s));
	while (!FluxFichier.eof())
	{

		cout << "Titre: " << LivreALire.TitreDuLivre << "    Auteur: " << LivreALire.AuteurDuLivre << "	Numero: " << LivreALire.NumeroUniqueDeLivre << "    Prete ";
		cout << LivreALire.Prete << endl;

		FluxFichier.read((char*)&LivreALire, sizeof(Livre_s));
	}

	FluxFichier.close();

	_getch();
}