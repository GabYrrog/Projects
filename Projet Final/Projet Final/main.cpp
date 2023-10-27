#include <iostream>
#include <conio.h>
#include "livres.h"
#include "clients.h"
#include "utils.h"
#include "CONSTANTES.h"


using namespace std;




void main(void)
{
	char Choix;
	//EffacerLesFichiers(); // TEST
	bool meta = false;
	while (!meta)
	{

		
		system("cls");
		cout << "=======================================" << endl;
		cout << "Bibliotheque MRC de St-Clin-de-banlieue" << endl;
		cout << "=======================================" << endl;

		cout << "\t1. Ajouter un livre" << endl;
		cout << "\t2. Ajouter un client" << endl;
		cout << "\t3. Afficher le dossier d'un client" << endl;
		cout << "\t4. Louer un livre" << endl;
		cout << "\t5. Retourner un livre" << endl;
		cout << "\t6. Liste des livres pretes" << endl;
		cout << "\t7. Liste des clients en retard" << endl;
		cout << "\t8. Quitter" << endl; 
		//cout << "\t9. Afficher les livres" << endl; // test
		
		
		Choix = _getch();

		int Choix1;
		int Choix2;
		int Choix3;
		int Choix4;
		int NumeroClient;
		int NumeroLivre1;
		int NumeroLivre2;

		switch (Choix)
		{
		case '0':
			break;
		case '1':NouveauLivre();
			break;

		case '2': NouveauClient();
			break;

		case '3':
			cout << "\n\n\nEntrez le numero du client a afficher: ";
			cin >> Choix4;
			
			AfficherDossierClient(Choix4);

			break;
		case '4':
			
			cout << "\n\n\nEntrez le numero du client qui loue un livre:";
			cin >> Choix1;
			NumeroClient = Choix1;
		
			cout << "\nEntrez le numero du livre prete:";
			cin >> Choix2;
			NumeroLivre1 = Choix2;

			Location(NumeroClient, NumeroLivre1);

			break;

		case '5':

			cout << "\n\n\nEntrez le numero du client qui retourne ses livres: ";
			cin >> Choix3;
			NumeroLivre2 = Choix3;
			Retour(NumeroLivre2);
			break;

		case '6':ListeDesLivresPretes();
			_getch();
			break;

		case '7': ListeDesClientsEnRetard();
			_getch();
			break;

		case '8':
			meta = true;
			//AfficherLesClients(); // TEST
			//_getch();
			
			break;

		//case '9': AfficherLesLivres(); // TEST
		//	break;
		
		}
	}
}