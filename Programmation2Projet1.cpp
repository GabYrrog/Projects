/****************************************************************************
 AUTEUR: GG
 NOM DU PROGRAMME: Prog2TP1.CPP
 DESCRIPTION: Travail pratique 1






*****************************************************************************/
#include <iostream>    // pour std::cin et std::cout
#include <iomanip>     // pour les manipulateurs
#include <string>      // pour utiliser la classe string
#include <conio.h>     // pour la fonction _getch()
#include <windows.h>
#include <cstdlib>
#include <limits>

using namespace std;   // pour ne pas devoir écrire std::

//Créer la première sous-structure

struct Dispositif_s
{
	string Type;
	float EspaceTotal;
	float EspaceLibre;
};

//Créer la deuxième sous-structure

struct StockageOccupe_s
{
	Dispositif_s DispositifStockage;
	float QtEspaceOccupe;
};

// Créer la structure-mère
struct Applications_s
{
	string Nom;
	string Categorie;
	StockageOccupe_s StockageOccupe;
};



void main(void)

{
	// Déclarer les variables qui seront utilisées plus loin

	int Cat1;
	int Cat2;
	int Cat3;
	int Cat4;
	int Cat5;

	float QtEspaceOccupeTotal1;
	float QtEspaceOccupeTotal2;
	float QtEspaceOccupeTotal3;
	float QtEspaceOccupeTotal4;
	float QtEspaceOccupeTotal5;

	float QtEspaceOccupePourType1;
	float QtEspaceOccupePourType2;
	float QtEspaceOccupePourType3;

	float DeuxiemeQtEspaceOccupePourType1;
	float DeuxiemeQtEspaceOccupePourType2;
	float DeuxiemeQtEspaceOccupePourType3;

	//constante pour le nb d'applications du tableau 1
	const int NB_APP1 = 10;

	//constante pour le tableau 2
	const int NB_APP2 = 11;

	//Créer un tableau de string pour les catégories d'applications
	string Categorie1 = "Divertissement";
	string Categorie2 = "Medias sociaux";
	string Categorie3 = "Utilitaire";
	string Categorie4 = "Systeme";
	string Categorie5 = "Productivite";
	string Categorie[5] = { Categorie1, Categorie2, Categorie3, Categorie4, Categorie5 };

	//Créer un tableau de string pour les types de dispotitifs de stockage
	string TypeDispositif1 = "Disque dur";
	string TypeDispositif2 = "Carte SD";
	string TypeDispositif3 = "Carte SIM";
	string TypeDispositif[3] = { TypeDispositif1, TypeDispositif2, TypeDispositif3 };

	//Créer un tableau de structure pour les dispositifs de stockage

	Dispositif_s Dispositif1 = { TypeDispositif1, 8000, 8000 };
	Dispositif_s Dispositif2 = { TypeDispositif2, 4000, 4000 };
	Dispositif_s Dispositif3 = { TypeDispositif3, 1000, 1000 };
	Dispositif_s Dispositifs[3] = { Dispositif1, Dispositif2, Dispositif3 };

	//Créer un tableau de structure pour 10 applications
	Applications_s Application1 = { "Clash of Clans", Categorie[0], {{Dispositif2}, 1500} };
	Applications_s Application2 = { "Instagramme", Categorie[1], {{Dispositif1}, 830} };
	Applications_s Application3 = { "Calculatrice", Categorie[2], {{Dispositif1}, 5.2} };
	Applications_s Application4 = { "Messagerie SMS", Categorie[2], {{Dispositif3}, 24.5} };
	Applications_s Application5 = { "Contacts", Categorie[3], {{Dispositif3}, 58.9} };
	Applications_s Application6 = { "TikTok", Categorie[1], {{Dispositif1}, 430} };
	Applications_s Application7 = { "Youtube", Categorie[0], {{Dispositif1}, 260} };
	Applications_s Application8 = { "Google Play store", Categorie[3], {{Dispositif1}, 41.2} };
	Applications_s Application9 = { "Candy Crush Saga", Categorie[0], {{Dispositif2}, 146} };
	Applications_s Application10 = { "Omnivox", Categorie[4], {{Dispositif1}, 90.8} };
	Applications_s Applications[10] = { Application1, Application2, Application3, Application4, Application5, Application6, Application7, Application8, Application9, Application10 };

	//2. Affichez à l’écran la liste des applications avec le stockage qu’il occupe. 
	// Le code doit fonctionner indépendamment du nombre d’applications sur l’appareil (utilisez un boucle…).
	cout << "\nQuestion 1 : Voir le code\n";

	cout << "\nQuestion 2 :\n";
	for (int i = 0; i < NB_APP1; i++)
	{
		cout << "\n" << Applications[i].Nom << " : " << Applications[i].StockageOccupe.QtEspaceOccupe << " Mo\n";
	}

	//3.	Affichez à l’écran le nombre d’application installées par Catégorie.    Le code doit fonctionner indépendamment du nombre d’applications sur l’appareil.

	// Question : Est-ce que je dois déclarer mes variables en haut même dans ce type de TP ? 
	Cat1 = 0;
	Cat2 = 0;
	Cat3 = 0;
	Cat4 = 0;
	Cat5 = 0;

	for (int i = 0; i < NB_APP1; i++)
	{

		if (Applications[i].Categorie == Categorie1)
		{
			Cat1++;
		}

		if (Applications[i].Categorie == Categorie2)
		{
			Cat2++;
		}

		if (Applications[i].Categorie == Categorie3)
		{
			Cat3++;
		}

		if (Applications[i].Categorie == Categorie4)
		{
			Cat4++;
		}

		if (Applications[i].Categorie == Categorie5)
		{
			Cat5++;
		}

	}
	cout << "\n\nQuestion 3 :\n";
	cout << "\n" << "Le nombre d'applications installees pour la categorie 1 est : " << Cat1;
	cout << "\n" << "Le nombre d'applications installees pour la categorie 2 est : " << Cat2;
	cout << "\n" << "Le nombre d'applications installees pour la categorie 3 est : " << Cat3;
	cout << "\n" << "Le nombre d'applications installees pour la categorie 4 est : " << Cat4;
	cout << "\n" << "Le nombre d'applications installees pour la categorie 5 est : " << Cat5;


	//4.	Affichez à l’écran le stockage total occupé par Catégorie d’application. Le code doit fonctionner indépendamment du nombre d’applications sur l’appareil.
	cout << "\n\nQuestion 4 :\n";



	QtEspaceOccupeTotal1 = 0;
	QtEspaceOccupeTotal2 = 0;
	QtEspaceOccupeTotal3 = 0;
	QtEspaceOccupeTotal4 = 0;
	QtEspaceOccupeTotal5 = 0;

	for (int i = 0; i < NB_APP1; i++)
	{
		if (Applications[i].Categorie == Categorie1)
		{
			QtEspaceOccupeTotal1 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].Categorie == Categorie2)
		{
			QtEspaceOccupeTotal2 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].Categorie == Categorie3)
		{
			QtEspaceOccupeTotal3 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].Categorie == Categorie4)
		{
			QtEspaceOccupeTotal4 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].Categorie == Categorie5)
		{
			QtEspaceOccupeTotal5 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
	}

	cout << "\n" << "Le stockage total occupe pour la categorie 1 est : " << QtEspaceOccupeTotal1 << " Mo";
	cout << "\n" << "Le stockage total occupe pour la categorie 2 est : " << QtEspaceOccupeTotal2 << " Mo";
	cout << "\n" << "Le stockage total occupe pour la categorie 3 est : " << QtEspaceOccupeTotal3 << " Mo";
	cout << "\n" << "Le stockage total occupe pour la categorie 4 est : " << QtEspaceOccupeTotal4 << " Mo";
	cout << "\n" << "Le stockage total occupe pour la categorie 5 est : " << QtEspaceOccupeTotal5 << " Mo";

	//5.	Calculez l’espace occupé par la somme des applications sur les 3 différents types de stockage et affichez la quantité utilisée de stockage par type de stockage.

	//Ensuite, mettez à jour la donnée espace libre pour tous les éléments de stockage de toutes les applications dans la liste d’applications.


	cout << "\n\nQuestion 5 :\n";

	QtEspaceOccupePourType1 = 0;
	QtEspaceOccupePourType2 = 0;
	QtEspaceOccupePourType3 = 0;

	for (int i = 0; i < NB_APP1; i++)
	{
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif1)
		{
			QtEspaceOccupePourType1 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif2)
		{
			QtEspaceOccupePourType2 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif3)
		{
			QtEspaceOccupePourType3 += Applications[i].StockageOccupe.QtEspaceOccupe;
		}

	}

	cout << "\n" << "L'espace de stockage occupe par la somme des applications pour le type de stockage Disque dur est : " << QtEspaceOccupePourType1 << " Mo";
	cout << "\n" << "L'espace de stockage occupe par la somme des applications pour le type de stockage Carte SD est : " << QtEspaceOccupePourType2 << " Mo";
	cout << "\n" << "L'espace de stockage occupe par la somme des applications pour le type de stockage Carte SIM est : " << QtEspaceOccupePourType3 << " Mo";

	//Ensuite, mettez à jour la donnée espace libre pour tous les éléments de stockage de toutes les applications dans la liste d’applications.

	for (int i = 0; i < NB_APP1; i++)
	{
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif1)
		{
			Applications[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif1.EspaceTotal - QtEspaceOccupePourType1;
			//cout << "\n" << Applications[i].StockageOccupe.DispositifStockage.EspaceLibre;
		}
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif2)
		{
			Applications[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif2.EspaceTotal - QtEspaceOccupePourType2;
			//cout << "\n" << Applications[i].StockageOccupe.DispositifStockage.EspaceLibre;
		}
		if (Applications[i].StockageOccupe.DispositifStockage.Type == TypeDispositif3)
		{
			Applications[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif3.EspaceTotal - QtEspaceOccupePourType3;
			//cout << "\n" << Applications[i].StockageOccupe.DispositifStockage.EspaceLibre;
		}

	}



	//6.	Pour chaque application de la liste d’application, affichez : son nom, l’espace qu’elle occupe sur le stockage, 
	// le type du dispositif de stockage et la quantité d’espace libre sur ce stockage.

	cout << "\n\nQuestion 6 :\n";



	for (int i = 0; i < NB_APP1; i++)
	{
		cout << "\n\n" << "Nom de l'application : " << Applications[i].Nom << "\n\t" << "Espace qu'elle occupe : " << Applications[i].StockageOccupe.QtEspaceOccupe << " Mo" << "\n\t" <<
			"Type de dispositif de stockage : " << Applications[i].StockageOccupe.DispositifStockage.Type << "\n\t" << "Quantite d'espace libre sur le stockage : "
			<< Applications[i].StockageOccupe.DispositifStockage.EspaceLibre;
	}



	//7. 7.	Insérez une nouvelle application dans la liste d’application installées en troisième position du tableau (indice = 2).  

	cout << "\n\nQuestion 7 : Voir le code\n";

	Applications_s DeuxiemeApplication[NB_APP2]; // Créer deuxieme tableau d'applications avec 11 applications

	for (int i = 0; i < NB_APP2; i++)
	{
		if (i < 2)
		{
			DeuxiemeApplication[i] = Applications[i]; // Copier les valeurs du premier tableau vers le deuxieme
		}
		else if (i == 2)
		{
			DeuxiemeApplication[i] = { "Parametres", Categorie4, {{TypeDispositif[0]}, 77.2} };
		}
		else
		{
			DeuxiemeApplication[i] = Applications[i - 1];
		}

	}


	// 8.	Affichez à nouveau les applications du tableau résultant avec leur catégorie, le stockage utilisé et l’espace utilisé 

	cout << "\n\nQuestion 8 :\n";

	//Mettre à jour la quantité d'espace occupé pour chaque APP du deuxieme tableau d'app selon le type de mémoire 
	DeuxiemeQtEspaceOccupePourType1 = 0;
	DeuxiemeQtEspaceOccupePourType2 = 0;
	DeuxiemeQtEspaceOccupePourType3 = 0;

	for (int i = 0; i < NB_APP2; i++)
	{
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif1)
		{
			DeuxiemeQtEspaceOccupePourType1 += DeuxiemeApplication[i].StockageOccupe.QtEspaceOccupe;
		}
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif2)
		{
			DeuxiemeQtEspaceOccupePourType2 += DeuxiemeApplication[i].StockageOccupe.QtEspaceOccupe;
		}
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif3)
		{
			DeuxiemeQtEspaceOccupePourType3 += DeuxiemeApplication[i].StockageOccupe.QtEspaceOccupe;
		}

	}


	for (int i = 0; i < NB_APP2; i++) // Mettre à jour l'espace libre pour chaque app
	{
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif1)
		{
			DeuxiemeApplication[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif1.EspaceTotal - DeuxiemeQtEspaceOccupePourType1;

		}
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif2)
		{
			DeuxiemeApplication[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif2.EspaceTotal - DeuxiemeQtEspaceOccupePourType2;

		}
		if (DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type == TypeDispositif3)
		{
			DeuxiemeApplication[i].StockageOccupe.DispositifStockage.EspaceLibre = Dispositif3.EspaceTotal - DeuxiemeQtEspaceOccupePourType3;

		}

	}


	for (int i = 0; i < NB_APP2; i++) // Output les résultats
	{
		cout << "\n\n" << "Nom de l'application : " << DeuxiemeApplication[i].Nom << "\n\t" << "Espace qu'elle occupe : " << DeuxiemeApplication[i].StockageOccupe.QtEspaceOccupe << " Mo" << "\n\t" <<
			"Type de dispositif de stockage : " << DeuxiemeApplication[i].StockageOccupe.DispositifStockage.Type << "\n\t" << "Quantite d'espace libre sur le stockage : "
			<< DeuxiemeApplication[i].StockageOccupe.DispositifStockage.EspaceLibre;
	}




	_getch();

}