#ifndef LIVRES_H	
#define LIVRES_H

#include "CONSTANTES.h"
extern const std::string NOM_FICHIER_LIVRES;
const int MAX_CHAR_LIVRES = 125; // Comme ces constantes sont Livres et Clients, ils ne se red�finieront pas dans le main ou dans d'autres fichiers CPP.
// La d�finition ici permet aux structs qui les utilisent d'utiliser la constante directement, car les headers sont compil�s avant.

struct Livre_s
{
	int NumeroUniqueDeLivre;
	char TitreDuLivre[MAX_CHAR_LIVRES];
	char AuteurDuLivre[MAX_CHAR_LIVRES];
	bool Prete;
};

Livre_s RechercherLivre(int Numero); // A conserver ici en raison du besoin d'avoir la struct d�finie
void MettreAJourLivre(int Numero, Livre_s ClientModifie); // A conserver ici en raison du besoin d'avoir la struct d�finie
int NombreDeLivresTotaux(); // Besoin dans le client.cpp mais pas dans le main donc on le laisse ici
void NouveauLivre();
//void AfficherLivre(int Numero); Inutile dans le programme 
void ListeDesLivresPretes();
void AfficherLesLivres(); // TEST

#endif

