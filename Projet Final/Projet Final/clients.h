#ifndef CLIENTS_H	
#define CLIENTS_H
#include "utils.h"
#include "CONSTANTES.h"

const int MAX_CHAR_CLIENTS = 125;// Comme ces constantes sont Livres et Clients, ils ne se redéfinieront pas dans le main ou dans d'autres fichiers CPP.
// La définition ici permet aux structs qui les utilisent d'utiliser la constante directement, car les headers sont compilés avant.

struct LivresPretes_s
{
	int NumeroDeLivre;
	Date_s DateEtHeureDeLocation;
	Date_s DateEtHeureDeRetourPrevu;
};



struct Client_s
{
	int NumeroUniqueDeClient;
	char NomCompletDeClient[MAX_CHAR_CLIENTS];
	char NumeroDeTelephone[MAX_CHAR_CLIENTS];
	char AdresseDuClient[MAX_CHAR_CLIENTS];
	int NombreDeLivresPretes;
	Date_s DateDinscription;
	LivresPretes_s LivresPretes[3];
};


Client_s RechercherDossierClient(int IDClient);
void MettreAJourClient(int IDClient, Client_s ClientModifie);
int NombreDeClientsTotaux();
void NouveauClient();
void AfficherLesClients();
void EffacerLesFichiers();
void AfficherDossierClient(int Numero);
void ListeDesClientsEnRetard();
void Location(int NumeroDeLivre, int NumeroDeClient);
void Retour(int Numero);


#endif 