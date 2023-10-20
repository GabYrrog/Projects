#ifndef LIVRES_H	
#define LIVRES_H
#include <iostream>

using namespace std; 


const int MAX_CHAR = 125;

struct Livre_s
{
	int NumeroUniqueDeLivre;
	char TitreDuLivre[MAX_CHAR];
	char AuteurDuLivre[MAX_CHAR];
	bool Prete;
};


int NombreDeLivresTotaux();
void NouveauLivre();
void AfficherLivre(int Numero);
Livre_s RechercherLivre(int Numero);
void MettreAJourLivre(int Numero, Livre_s ClientModifie);
void ListeDesLivresPretes();
void AfficherLesLivres();
#endif