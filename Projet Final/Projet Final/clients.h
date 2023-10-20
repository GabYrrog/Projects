#ifndef CLIENTS_H	
#define CLIENTS_H


#include <iostream>
#include "utils.h"
#include <vector>

using namespace std; 

//const int MAX_CHAR = 125;

//static const int MAX_CHAR = 125;



int NombreDeClientsTotaux();
void NouveauClient();
void AfficherLesClients();
void EffacerLesFichiers();
void AfficherDossierClient(int Numero);
void ListeDesClientsEnRetard();
void Location(int NumeroDeLivre, int NumeroDeClient);
void Retour(int Numero);
void TestJours();

#endif 