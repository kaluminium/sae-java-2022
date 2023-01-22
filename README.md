# Pour utiliser l'application
- Importer le package **saejava.App** dans un fichier en .java
- Appeler la fonction **App.start()** dans une méthode main(String [] args)
- Pour la première fois, l'application demandera de mettre une Prime Annuelle pour les Personnes concernées

# Fonctionnement de l'application
- Cette application permet de gérer des : 
  - Etudiants
  - Etudiants Boursier
  - Personnel Administratif
  - Enseignant Vacataire
  - Enseignant Titulaire
- On peut créer et supprimer des Personnes avec leurs identifiants
- Pour connaitre les identifiants il suffit de regarder les informations d'une Personne grace au menu
- Un Personnel a toujours un Bureau, on peut en créer de la taille que l'on souhaite entre 1 et 3
- Si jamais il n'y a pas de Bureau pour un Personnel, alors un Bureau de 3 places sera créé automatiquement et un message dans la console sera envoyé
- On peut ajouter des absences que ce soit justifier ou non grace au menu
- On peut modifier n'importe quel valeur d'une Personne grace au menu
- Il est possible de changer de mois pour le salaire d'un Personnel en faisant un reset Salaire

# Gestion des absences et salaires :
- Pour les Enseignants les absences se compteront en heures alors que le reste sera en jours
- On a pris en compte qu'un Personnel Administratif travaillait 24 jours par mois, donc une absence injustifiée lui enlève un jour de sa paye et une absence injustifiée un quart
- Cela fonctionne de la même manière pour les Enseignants hormis que ça soit par heures
- On peut facilement retrouver qui a un retrait sur salaire ou un Etudiant qui a plus de 5 absences injustifiées grace au menu
- Un message sera envoyé dans la console si jamais un Etudiant a plus de 5 absences injustifiées

### Ilyas :
- Création de l'interface Affichable
- Création d'EtudiantBoursier
- Création de PersonnelAdministratif
- Ecriture d'une partie de la JavaDoc