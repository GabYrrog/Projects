#ifndef CONSTANTES_H	
#define CONSTANTES_H

// J'ai utilisé un header CONSTANTES pour pouvoir éviter de diviser mes structs et les déclarations de fonctions qui utilisent des structs, notamment dans le fichier clients.cpp.
// Ainsi, mes autres headers contiennent toutes les déclarations de fonction ainsi que les structs.
// Exclusion des constantes MAX_CHAR afin d'éviter des redéfinitions
extern const std::string NOM_FICHIER_CLIENTS; // Publique
extern const std::string NOM_FICHIER_LIVRES; // Publique



#endif
