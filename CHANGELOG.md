# First Commit 05/12/2022
# Commit 07/12/2022
- Ajout de la Classe Bureau, de la Classe Etudiant, de la Classe EtudiantBoursier avec les méthodes corespondantes à leur utilisation.
- Ajout des setters et des getters
- Ajout de la méthode addPersonneToBureau() d'ajout d'une personne dans un bureau mis au point en gérant le fait qu'il y ait toujours une place de libre.
- Les méthodes toString() et equals(Object o) mis à jour.
- Méthode testAbs() créé qui gère les Etudiants et les EtudiantBoursiers en fonction du nombre d'absences qu'ils ont.
- Création de Tableau Dynamique de type Bureau[] et Personne[] avec les fonctions d'incrémentations incrTabPersonne() et incrTabBureau()

# Commit du 07/12/2022 22:50
- Ajout de la Classe Abstraite Personnel Hérité de Personne avec ses 3 constructeurs
  - Méthode addPersonneToBureau() déplacé et renommé en addPersonnelToBureau() dedans pour être plus sécurisé 
  - Ajout de getBureau() qui permet d'avoir le bureau du Personnel
- Modification dans Bureau
  - Le tableau de Personne est devenu un tableau de Personnel
  - La Méthode addPersonnelToBureau() a été déplacé et modifié
  - Les Méthodes qui appelaient addPersonneToBureau() ont été changé en addPersonnelToBureau()
- Modification dans Personne
  - Ajout de la Méthode Static getTabPersonne() qui permet de récupérer le nombre de Personnes dans un tableau de Personne qui ne sont pas null

# Commit du 08/12/2022 15:50
- Ajout de la Classe PersonnelAdministratif hérité de Personnel avec 
  - ses 6 constructeurs
  - ses trois attributs (double salary, double prime, double retraitSalaire)
  - Override de la méthode testAbs qui définit le retraitSalaire en fonction des absences
  - Ajout de la méthode afficheSalaire() qui permet de print un aperçu complet du salaire annuel du PersonnelAdministratif
  - Ajout de la méthode resetAbs() qui permet de mettre les absences justifiés et injustifés d'un PersonnelAdministratif
  - Setters et Getters ajoutés
  - Override de la méthode toString
- Ajout de l'interface Affichable
  - void affiche();
  - String toString();
- Modification de la classe Bureau
  - Ajout de la méthode affiche()
- Modification de la classe Etudiant
  - Ajout de la méthode isEtudiant(Object o) pour savoir si un objet est un Etudiant ou non
- Modification de la classe EtudiantBoursier
  - Ajout d'un getter sur la bourse
- Modification de la classe Personne
  - Modification de nbAbs en nbAbsInjustifie et nbAbsInjustifie et réécriture des méthodes correspondantes
  - Ajout de la méthode getAbs qui renvoie le total d'absences
  - Ajout de la méthode isPersonne(Object o) qui renvoie si un objet est une Personne ou non
  - Ajout de la méthode affiche()
- Modification de la classe Utils
  - Ajout de la méthode Round2 qui arrondi un double à 2 chiffres après la virgule