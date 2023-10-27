#ifndef CONSTANTES_H	
#define CONSTANTES_H

// J'ai utilis� un header CONSTANTES pour pouvoir �viter de diviser mes structs et les d�clarations de fonctions qui utilisent des structs, notamment dans le fichier clients.cpp.
// Ainsi, mes autres headers contiennent toutes les d�clarations de fonction ainsi que les structs.
// Exclusion des constantes MAX_CHAR afin d'�viter des red�finitions
extern const std::string NOM_FICHIER_CLIENTS; // Publique
extern const std::string NOM_FICHIER_LIVRES; // Publique



#endif
