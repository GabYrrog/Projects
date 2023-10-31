#ifndef CLIENTS_H	
#define CLIENTS_H
#include "utils.h"
#include "CONSTANTES.h"

const int MAX_CHAR_CLIENTS = 125;// Comme ces constantes sont Livres et Clients, ils ne se red�finieront pas dans le main ou dans d'autres fichiers CPP.
// La d�finition ici permet aux structs qui les utilisent d'utiliser la constante directement, car les headers sont compil�s avant.

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


Client_s RechercherDossierClient(int IDClient);// A conserver ici en raison du besoin d'avoir la struct d�finie
void MettreAJourClient(int IDClient, Client_s ClientModifie); // A conserver ici en raison du besoin d'avoir la struct d�finie

void NouveauClient();
void AfficherLesClients(); // TEST
void EffacerLesFichiers(); // TEST
void AfficherDossierClient(int Numero);
void ListeDesClientsEnRetard();
void Location(int NumeroDeLivre, int NumeroDeClient);
void Retour(int Numero);


#endif 