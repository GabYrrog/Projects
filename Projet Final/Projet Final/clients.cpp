#include <iostream>
#include <fstream>
#include <conio.h>
#include <string>
#include <time.h>
#include "clients.h"
#include "livres.h"
#include "utils.h"

using namespace std;


struct LivresPretes_s // Peut-être à mettre dans le CPP
{
	int NumeroDeLivre;//Correspond à la position du livre dans le fichier
	Date_s DateEtHeureDeLocation;
	Date_s DateEtHeureDeRetourPrevu;
};



struct Client_s
{
	int NumeroUniqueDeClient; //Correspond à la position du client dans le fichier
	char NomCompletDeClient[MAX_CHAR];
	char NumeroDeTelephone[MAX_CHAR];
	char AdresseDuClient[MAX_CHAR];
	int NombreDeLivresPretes;
	Date_s DateDinscription;
	LivresPretes_s LivresPretes[3];
};


extern const string NOM_FICHIER_CLIENTS = "X:\\Programmation 2\\fichiers\\clients.bin";
extern const string NOM_FICHIER_LIVRES; // POUR LA FONCTION QUI ECRASE LES FICHIERS

Client_s RechercherDossierClient(int IDClient);

void MettreAJourClient(int IDClient, Client_s ClientModifie);


int NombreDeClientsTotaux()
{
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::in | ios::binary);

	int NombreDeClients = 0;
	Client_s UnClient;

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&UnClient, sizeof(Client_s));
	while (!FluxFichier.eof())
	{
		NombreDeClients++;
		FluxFichier.read((char*)&UnClient, sizeof(Client_s));
	}
	

	FluxFichier.close();
	//cout << "\n" << NombreDeClients; // TEST
	return NombreDeClients;
}

void NouveauClient()
{
	Client_s NouveauClient;
	string NomClient;
	string TelephoneCLient;
	string AdresseClient;
	

	cout << "\n\n\n";
	cout << "Entrez le nom complet du client : ";
	getline(cin, NomClient);

	cout << "Entrez le numero de telephone du client : ";
	getline(cin, TelephoneCLient);

	cout << "Entrez l'adresse du client : ";
	getline(cin, AdresseClient);

	_getch();
	NouveauClient.NumeroUniqueDeClient = NombreDeClientsTotaux();
	NouveauClient.DateDinscription = Aujourdhui();
	NouveauClient.NombreDeLivresPretes = 0;

	StringEnTabChar(NomClient, NouveauClient.NomCompletDeClient);
	StringEnTabChar(TelephoneCLient, NouveauClient.NumeroDeTelephone);
	StringEnTabChar(AdresseClient, NouveauClient.AdresseDuClient);

	//struct LivresPretes_s // Peut-être à mettre dans le CPP
	//{
	//	int NumeroDeLivre;//Correspond à la position du livre dans le fichier
	//	Date_s DateEtHeureDeLocation;
	//	Date_s DateEtHeureDeRetourPrevu;
	//};

	LivresPretes_s TableauVide[3] = { {},{},{} };


	for (int i = 0; i < 3; i++)
	{
		NouveauClient.LivresPretes[i] = TableauVide[i];
	}
	


	//Écrire le NouveauClient à la suite des autres dans Clients.bin
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::app | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.write((char*)&NouveauClient, sizeof(Client_s));
	FluxFichier.close();
	cout << "\nClient ajoute avec succes" << endl;
	cout << "Appuyez sur une touche pour continuer" << endl;
	_getch();
}

void AfficherLesClients() // TEST pour voir tous les clients
{

	Client_s ClientALire;
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&ClientALire, sizeof(Client_s));
	while (!FluxFichier.eof())
	{
		
		cout << "Nom du Client: " << ClientALire.NomCompletDeClient << "    Telephone: " << ClientALire.NumeroDeTelephone << "	Adresse: " << ClientALire.AdresseDuClient << "    ID ";
		cout << ClientALire.NumeroUniqueDeClient << "    Date dinscription: " << ClientALire.DateDinscription.Annee << "/" << ClientALire.DateDinscription.Mois << "/" << ClientALire.DateDinscription.Jour << endl;
		cout << "Nombre livres prete: " << ClientALire.NombreDeLivresPretes << endl;
		for (int i = 0; i < ClientALire.NombreDeLivresPretes; i++)
		{
			cout << ClientALire.LivresPretes[i].NumeroDeLivre << endl;
			cout << ClientALire.LivresPretes[i].DateEtHeureDeLocation.Jour << " / " << ClientALire.LivresPretes[i].DateEtHeureDeLocation.Mois << ClientALire.LivresPretes[i].DateEtHeureDeLocation.Annee << endl;
			cout << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Jour << "/" << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Mois << "/" << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Annee << endl;
		}
		FluxFichier.read((char*)&ClientALire, sizeof(Client_s));
	}

	FluxFichier.close();
}

void EffacerLesFichiers() // TEST 
{
	
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::out | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.close();
	//Maintenant, les livres
	FluxFichier.open(NOM_FICHIER_LIVRES, ios::out | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.close();
}

Client_s RechercherDossierClient(int IDClient)
{
	Client_s ClientALire;
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.seekg(IDClient * sizeof(Client_s), ios::beg);
	FluxFichier.read((char*)&ClientALire, sizeof(Client_s)); 
	
	FluxFichier.close();
	return ClientALire;
}

void AfficherDossierClient(int Numero) // A DEBUGER
{
	Client_s ClientAAfficher = RechercherDossierClient(Numero);
	
	int Total = NombreDeClientsTotaux();

	if (Numero <= Total)
	{
		cout << "Nom du Client: " << ClientAAfficher.NomCompletDeClient << "    Telephone: " << ClientAAfficher.NumeroDeTelephone << "	Adresse: " << ClientAAfficher.AdresseDuClient << "    ID ";
		cout << ClientAAfficher.NumeroUniqueDeClient << "    Date dinscription: " << ClientAAfficher.DateDinscription.Annee << "/" << ClientAAfficher.DateDinscription.Mois << "/" << ClientAAfficher.DateDinscription.Jour << endl;
		_getch();
	}
	else
	{
		cout << "Numero de client invalide" << endl;
		cout << "Appuyez sur une touche pour continuer" << endl;
		_getch();
	}
}

void MettreAJourClient(int IDClient, Client_s ClientModifie) // À TESTER
{
	
	fstream FluxFichier;
	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::in |ios::out | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.seekp(IDClient * sizeof(Client_s), ios::beg);
	FluxFichier.write((char*)&ClientModifie, sizeof(Client_s));
	

	FluxFichier.close();
}

void ListeDesClientsEnRetard()// A TESTER
{
	Client_s ClientALire;
	fstream FluxFichier;

	Date_s CeJour = Aujourdhui();

	int DifferenceEntreDateRetourPrevuEtCeJour;

	FluxFichier.open(NOM_FICHIER_CLIENTS, ios::in | ios::binary);

	if (FluxFichier.fail()) {
		cout << "Impossible d'ouvrir le fichier!";
		exit(EXIT_FAILURE);
	}

	FluxFichier.read((char*)&ClientALire, sizeof(Client_s));
	while (!FluxFichier.eof())
	{
		for (int i = 0; i < ClientALire.NombreDeLivresPretes; i++)
		{
			DifferenceEntreDateRetourPrevuEtCeJour = NombreJours(ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu, CeJour);
			if (DifferenceEntreDateRetourPrevuEtCeJour > 0)
			{
				cout << "\nNom du Client : " << ClientALire.NomCompletDeClient << " Telephone : " << ClientALire.NumeroDeTelephone << "  Date de retour prevue: " << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Jour << "/" << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Mois << "/" << ClientALire.LivresPretes[i].DateEtHeureDeRetourPrevu.Annee << endl;
				cout << "Nombre de jours de retard: " << DifferenceEntreDateRetourPrevuEtCeJour << endl;
			}
		}
		FluxFichier.read((char*)&ClientALire, sizeof(Client_s));
	}

	FluxFichier.close();
	cout << "\nAppuyez sur une touche pour continuer" << endl;
	_getch();
}



void Location(int NumeroDeClient, int NumeroDeLivre) 
{
	Client_s ClientQuiLoue = RechercherDossierClient(NumeroDeClient);
	Livre_s LivreLoue = RechercherLivre(NumeroDeLivre);
	Date_s DateAujourdhui = Aujourdhui();
	int annee = DateAujourdhui.Annee;
	int mois = DateAujourdhui.Mois;
	int jour = DateAujourdhui.Jour;
	
	if (ClientQuiLoue.NombreDeLivresPretes == 3)
	{
		cout << "\nMaximum de location(3) atteint, impossible d'effectuer la location" << endl;
		cout << "Appuyez sur une touche pour continuer" << endl;
		_getch();
	}
	else
	{
		if (LivreLoue.Prete == true)
		{
			cout << "\nImpossible, ce livre est deja prete..." << endl;
			_getch();
		}
		else
		{
			ClientQuiLoue.LivresPretes[ClientQuiLoue.NombreDeLivresPretes].DateEtHeureDeLocation.Annee = annee;
			ClientQuiLoue.LivresPretes[ClientQuiLoue.NombreDeLivresPretes].DateEtHeureDeLocation.Mois = mois;
			ClientQuiLoue.LivresPretes[ClientQuiLoue.NombreDeLivresPretes].DateEtHeureDeLocation.Jour = jour;
			ClientQuiLoue.LivresPretes[ClientQuiLoue.NombreDeLivresPretes].DateEtHeureDeRetourPrevu = AjouterJours(15, Aujourdhui());
			ClientQuiLoue.LivresPretes[ClientQuiLoue.NombreDeLivresPretes].NumeroDeLivre = LivreLoue.NumeroUniqueDeLivre;
			ClientQuiLoue.NombreDeLivresPretes += 1;

			MettreAJourClient(NumeroDeClient, ClientQuiLoue);

			LivreLoue.Prete = true;
			

			MettreAJourLivre(NumeroDeLivre, LivreLoue);
			cout << "\nLocation effectuee avec succes" << endl;
			cout << "Appuyez sur une touche pour continuer" << endl;
			_getch();
		}
	}
}

void Retour(int Numero) // A tester
{
	Date_s DateDeRetour = Aujourdhui();
	int DifferenceEntreRetourEffectifEtLocation;
	int DifferenceEntreRetourPrevuEtLocation;
	int DifferenceEntreRetourEffectifEtRetourPrevu;
	
	LivresPretes_s TableauVide[3];
	Livre_s LivreLoue;
	Client_s Client = RechercherDossierClient(Numero);

	for (int i = 0; i < Client.NombreDeLivresPretes; i++)
	{
		DifferenceEntreRetourEffectifEtLocation = NombreJours(Client.LivresPretes[i].DateEtHeureDeLocation, DateDeRetour);
		DifferenceEntreRetourPrevuEtLocation = NombreJours(Client.LivresPretes[i].DateEtHeureDeLocation, Client.LivresPretes[i].DateEtHeureDeRetourPrevu);
		DifferenceEntreRetourEffectifEtRetourPrevu = NombreJours(Client.LivresPretes[i].DateEtHeureDeRetourPrevu, DateDeRetour);
		if (DifferenceEntreRetourEffectifEtLocation > DifferenceEntreRetourPrevuEtLocation)
		{
			cout << "\nVous avez un retard de : " << DifferenceEntreRetourEffectifEtRetourPrevu << " jours." << endl;
			_getch();
		}
	}

	if (RechercherDossierClient(Numero).NumeroUniqueDeClient != Numero)
	{
		cout << "\Le numero du client n'existe pas" << endl;
		_getch();
	}
	else
	{
		for (int i = 0; i < Client.NombreDeLivresPretes; i++)
		{
			LivreLoue = RechercherLivre(Client.LivresPretes[i].NumeroDeLivre);
			LivreLoue.Prete = false;
			MettreAJourLivre(LivreLoue.NumeroUniqueDeLivre, LivreLoue);
			Client.LivresPretes[i] = TableauVide[i];
			Client.NombreDeLivresPretes = 0;
			MettreAJourClient(Client.NumeroUniqueDeClient, Client);
		}
		cout << "\nLe retour s'est effectue avec succes" << endl;
		cout << "Appuyez sur une touche pour continuer" << endl;
		_getch();
	}
}

void TestJours() // TEST
{
	Date_s CeJour = Aujourdhui();

	Date_s Demain;

	Date_s AnneeProchaine;

	AnneeProchaine.Annee = CeJour.Annee + 1;
	AnneeProchaine.Mois = CeJour.Mois;
	AnneeProchaine.Jour = CeJour.Jour;

	Demain.Annee = CeJour.Annee;
	Demain.Mois = CeJour.Mois;
	Demain.Jour = CeJour.Jour + 1;

	int Difference = NombreJours(CeJour, Demain);
	int DifferenceAnnee = NombreJours(CeJour, AnneeProchaine);

	cout << Difference << endl;
	cout << DifferenceAnnee << endl;
	_getch();
}


