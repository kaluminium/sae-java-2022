package saejava;

/**
 * Classe Applicative qui permet de lancer Système de gestion
 * @author lukalindberg
 */
public class App {

    /**
     * Méthode de démarrage lorsque l'on lance le programme
     * @see App#welcome()
     * @see App#setPrime()
     * @see App#mainMenu()
     */
    public static void start(){
        App.welcome();
        App.setPrime();
        App.mainMenu();
    }

    /**
     * Méthode qui affiche un message de bienvenue
     */
    private static void welcome(){
        System.out.println("\n________________________________________________________________________________" +
                "\nBonjour et bienvenue sur le Système de gestion de l'IUT Lyon1" +
                "\n"+
                "\nPour plus d'informations sur ses fonctionnalités veuillez lire le fichier README.md" +
                "\n________________________________________________________________________________");
    }

    /**
     * Méthode qui permet de poser une valeur à la Prime des salariés
     * @see Personnel#setPrime(double)
     */
    private static void setPrime(){
        double prime = -1;
        System.out.println("\nAvant toutes choses veuillez définir une Prime annuelle pour les Salariés");
        while (prime == -1){
            System.out.println("Prime :");
            prime = Clavier.lireDouble();
        }
        Personnel.setPrime(prime);
    }

    /**
     * Méthode principale du programme qui affiche tout le menu et le gère
     * @see App#addPeople()
     * @see App#removePeople()
     * @see App#showEtudiantsWithFiveAbs()
     * @see App#showPersonnelsWithAbs()
     * @see App#showStats()
     * @see App#modifyPersonne()
     * @see App#modifyAbs()
     * @see App#addHours()
     * @see App#resetSalary()
     */
    private static void mainMenu(){
        int choix = -1;
        while(choix < 0 || choix > 9){
            System.out.println("\nVeuillez faire votre choix :"+
                    "\n - 0 : Arrêter le programme" +
                    "\n - 1 : Ajouter un utilisateur ou un bureau [Etudiant, EtudiantBoursier, PersonnelAdministratif, PersonnelEnseignantVacataire, PersonnelEnseignantTitulaire, Bureau]"+
                    "\n - 2 : Supprimer un utilisateur"+
                    "\n - 3 : Voir la liste Etudiants avec plus de 5 absences injustifié" +
                    "\n - 4 : Voir la liste des Personnels qui ont une retenue sur salaire" +
                    "\n - 5 : Voir les informations d'une personne ou d'un bureau"+
                    "\n - 6 : Modifier des valeurs à une personne"+
                    "\n - 7 : Modifier les absences d'une personne"+
                    "\n - 8 : Ajouter des heures supplémentaires à un PersonnelEnseignantVacataire ou PersonnelEnseignantTitulaire"+
                    "\n - 9 : Reset le salaire d'un Personnel");
            System.out.println("\nNombre de personnes dans la base de données "+Personne.lengthNotNull(Personne.getTabPersonne()) + " / " + Personne.getTabPersonne().length);
            System.out.println("\nChoix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 1) addPeople();
        else if(choix == 2) removePeople();
        else if(choix == 3) showEtudiantsWithFiveAbs();
        else if(choix == 4) showPersonnelsWithAbs();
        else if(choix == 5) showStats();
        else if(choix == 6) modifyPersonne();
        else if(choix == 7) modifyAbs();
        else if(choix == 8) addHours();
        else if(choix == 9) resetSalary();
        else {
            System.out.println("\nfin du programme");
            System.exit(0);
        }
    }

    /**
     * Méthode qui permet d'afficher le menu pour ajouter des éléments à la base de données
     * @see App#addEtudiant()
     * @see App#addEtudiantBoursier()
     * @see App#addPersonnelAdministratif()
     * @see App#addPersonnelTitulaire()
     * @see App#addPersonnelVacataire()
     * @see App#addBureau()
     */
    private static void addPeople(){
        int choix = -1;
        while(choix < 0 || choix > 6) {
            System.out.println("\nVeuillez faire un choix :" +
                    "\n - 0 : Retour au menu" +
                    "\n - 1 : Ajouter un Etudiant" +
                    "\n - 2 : Ajouter un EtudiantBoursier" +
                    "\n - 3 : Ajouter un PersonnelAdministratif" +
                    "\n - 4 : Ajouter un PersonnelEnseignantTitulaire" +
                    "\n - 5 : Ajouter un PersonnelEnseignantVacataire" +
                    "\n - 6 : Ajouter un Bureau");
            System.out.println("\nChoix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1) addEtudiant();
        else if(choix == 2) addEtudiantBoursier();
        else if(choix == 3) addPersonnelAdministratif();
        else if(choix == 4) addPersonnelTitulaire();
        else if(choix == 5) addPersonnelVacataire();
        else addBureau();
    }

    /**
     * Méthode qui permet d'ajouter un Etudiant à la base de données
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see Etudiant
     */
    private static void addEtudiant(){
        String name;
        String firstName;
        System.out.println("\nAjout d'un Etudiant");
        System.out.println(" - Nom : ");
        name = Clavier.lireString();
        System.out.println(" - Prenom : ");
        firstName = Clavier.lireString();
        Etudiant a = new Etudiant(name, firstName);
        a.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter un EtudiantBoursier à la base de données
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see EtudiantBoursier
     */
    private static void addEtudiantBoursier(){
        String name;
        String firstName;
        double bourse = -1;
        System.out.println("\nAjout d'un EtudiantBoursier");
        System.out.println(" - Nom : ");
        name = Clavier.lireString();
        System.out.println(" - Prenom : ");
        firstName = Clavier.lireString();
        while (bourse == -1){
            System.out.println(" - Bourse : ");
            bourse = Clavier.lireDouble();
        }
        Etudiant a = new EtudiantBoursier(name, firstName, bourse);
        a.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter un PersonnelAdministratif à la base de données
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelAdministratif
     */
    private static void addPersonnelAdministratif(){
        String name;
        String firstName;
        double salary = -1;
        System.out.println("\nAjout d'un PersonnelAdministratif");
        System.out.println(" - Nom : ");
        name = Clavier.lireString();
        System.out.println(" - Prénom : ");
        firstName = Clavier.lireString();
        while (salary == -1){
            System.out.println(" - Salaire : ");
            salary = Clavier.lireDouble();
        }
        PersonnelAdministratif a = new PersonnelAdministratif(name, firstName, salary);
        a.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter un PersonnelEnseignantTitulaire à la base de données
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelEnseignantTitulaire
     */
    private static void addPersonnelTitulaire(){
        String name;
        String firstName;
        double tauxHoraire = -1;
        int heures = -1;
        System.out.println("\nAjout d'un PersonnelEnseignantTitulaire");
        System.out.println(" - Nom : ");
        name = Clavier.lireString();
        System.out.println(" - Prenom : ");
        firstName = Clavier.lireString();
        while (tauxHoraire == -1) {
            System.out.println(" - TauxHoraire : ");
            tauxHoraire = Clavier.lireDouble();
        }
        while (heures == -1){
            System.out.println(" - heures : ");
            heures = Clavier.lireInt();
        }
        PersonnelEnseignantTitulaire a = new PersonnelEnseignantTitulaire(name, firstName, 0, 0, 0, heures, tauxHoraire);
        a.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter un PersonnelEnseignantVacataire à la base de données
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelEnseignantVacataire
     */
    private static void addPersonnelVacataire(){
        String name;
        String firstName;
        System.out.println("\nAjout d'un PersonnelEnseignantVacataire");
        System.out.println(" - Nom : ");
        name = Clavier.lireString();
        System.out.println(" - Prenom : ");
        firstName = Clavier.lireString();
        PersonnelEnseignantVacataire a = new PersonnelEnseignantVacataire(name, firstName);
        a.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter un Bureau à la base de données
     * @see Bureau#affiche()
     * @see App#mainMenu()
     * @see Bureau
     */
    private static void addBureau(){
        int taille = -1;
        System.out.println("\nAjout d'un Bureau");
        while (taille == -1){
            System.out.println(" - Taille (entre 1 et 3) : ");
            taille = Clavier.lireInt();
        }
        Bureau b = new Bureau(taille);
        b.affiche();
        mainMenu();
    }

    /**
     * Méthode qui permet de retirer une Personne de la base de données
     * @see Personne#afficheIdsOfPersonneInTabPersonne()
     * @see Personne#removePersonneInTabPersonneWithId(int)
     * @see App#mainMenu()
     * @see Personne
     */
    private static void removePeople(){
        Personne.afficheIdsOfPersonneInTabPersonne();
        int choix = -1;
        System.out.println("\nRetirer une Personne via son ID");
        while (choix == -1){
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        Personne.removePersonneInTabPersonneWithId(choix);
        mainMenu();
    }

    /**
     * Méthode qui permet d'afficher les Etudiants avec plus de 5 absences injustifiées
     * @see Personne#toString(Personne...)
     * @see Etudiant#getTabOfEtudiantsWithTooMuchAbs()
     * @see Etudiant
     * @see App#mainMenu()
     */
    private static void showEtudiantsWithFiveAbs(){
        System.out.println("\nVoici la liste des Etudiants avec trop d'absences (Supérieur à 5 absences injustifiés)");
        System.out.println(Personne.toString(Etudiant.getTabOfEtudiantsWithTooMuchAbs()));
        mainMenu();
    }

    /**
     * Méthode qui permet d'afficher les Personnels qui ont une retenue sur salaire
     * @see Personne#toString(Personne...)
     * @see Personnel#getTabPersonnelWithAbs()
     * @see Personnel
     * @see App#mainMenu()
     */
    private static void showPersonnelsWithAbs(){
        System.out.println("\nVoici la liste des Personnels avec des absences");
        System.out.println(Personne.toString(Personnel.getTabPersonnelWithAbs()));
        mainMenu();
    }

    /**
     * Méthode qui permet de choisir entre un bureau et une personne où voir les informations
     * @see App#mainMenu()
     * @see App#showStatsBureau()
     * @see App#showStatsPersonne()
     */
    private static void showStats(){
        int choix = -1;
        while (choix < 0 || choix > 2){
            System.out.println("\nVeuillez faire un choix : "+
                    "\n - 0 Retour au menu"+
                    "\n - 1 Voir les informations d'un bureau"+
                    "\n - 2 Voir les informations d'une personne");
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1) showStatsBureau();
        else showStatsPersonne();
    }

    /**
     * Méthode qui permet de voir les informations d'un Bureau
     * @see Bureau#afficheIdsOfBureauxInTabBureau()
     * @see Bureau#isInTabBureau(int)
     * @see Bureau#searchBureauWithId(int)
     * @see Bureau#affiche()
     * @see Bureau
     * @see App#mainMenu()
     */
    private static void showStatsBureau(){
        Bureau.afficheIdsOfBureauxInTabBureau();
        int choix = -1;
        System.out.println("\nVeuillez choisir un ID que vous voulez voir : ");
        while (choix == -1){
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(Bureau.isInTabBureau(choix)){
            Bureau.searchBureauWithId(choix).affiche();
        }
        else System.out.println("Il n'existe pas d'ID de bureau avec l'ID : " + choix+"\n");
        mainMenu();
    }

    /**
     * Méthode qui permet de voir les informations d'une Personne
     * @see Personne#afficheIdsOfPersonneInTabPersonne()
     * @see Personne#isInTabPersonne(int)
     * @see Personne#searchPersonneWithId(int)
     * @see Personne#affiche()
     * @see Personne
     * @see App#mainMenu()
     */
    private static void showStatsPersonne(){
        int choix = -1;
        Personne.afficheIdsOfPersonneInTabPersonne();
        System.out.println("\nVeuillez choisir un ID que vous voulez voir : ");
        while (choix == -1){
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(Personne.isInTabPersonne(choix)){
            Personne.searchPersonneWithId(choix).affiche();
        }
        else System.out.println("\nIl n'existe pas d'ID de personne avec l'ID : " + choix+"\n");
        mainMenu();
    }

    /**
     * Méthode qui est un menu qui permet de gérer les modifications des Personnes
     * @see Personne
     * @see Personne#afficheIdsOfPersonneInTabPersonne() 
     * @see Personne#searchPersonneWithId(int) 
     * @see Personne#isInTabPersonne(int) 
     * @see PersonnelEnseignantVacataire#isPersonnelEnseignantVacataire(Object) 
     * @see PersonnelEnseignantTitulaire#isPersonnelEnseignantTitulaire(Object) 
     * @see PersonnelAdministratif#isPersonnelAdministratif(Object) 
     * @see Etudiant#isEtudiant(Object)
     * @see App#mainMenu()
     */
    private static void modifyPersonne(){
        int choix = -1;
        Personne.afficheIdsOfPersonneInTabPersonne();
        System.out.println("\nVeuillez choisir un ID que vous voulez modifier : ");
        while (choix == -1){
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(Personne.isInTabPersonne(choix)){
            Personne a = Personne.searchPersonneWithId(choix);
            if(PersonnelEnseignantVacataire.isPersonnelEnseignantVacataire(a)) modifyPersonnePersonnelEnseignantVacataire((PersonnelEnseignantVacataire) a);
            else if(PersonnelEnseignantTitulaire.isPersonnelEnseignantTitulaire(a)) modifyPersonnePersonnelEnseignantTitulaire((PersonnelEnseignantTitulaire) a);
            else if(PersonnelAdministratif.isPersonnelAdministratif(a)) modifyPersonnePersonnelAdministratif((PersonnelAdministratif) a);
            else if(Etudiant.isEtudiant(a)) modifyPersonneEtudiant((Etudiant) a);
        }
        else {
            System.out.println("\nIl n'existe pas d'ID de personne avec l'ID : " + choix+"\n");
            mainMenu();
        }
    }

    /**
     * Méthode qui permet de modifier les éléments d'un Etudiant
     * @param a un Etudiant quelconque
     * @see Etudiant
     * @see Personne#setName(String)
     * @see Personne#setFirstName(String)
     * @see Personne#setNbAbsInjustifie(int)
     * @see Personne#setNbAbsJustifie(int)
     * @see Personne#affiche()
     * @see App#mainMenu() 
     */
    private static void modifyPersonneEtudiant(Etudiant a){
        int choix = -1;
        while (choix < 0 || choix > 4){
            System.out.println("\nVeuillez faire un choix"+
                    "\n - 0 : Retour au menu"+
                    "\n - 1 : Changer le nom"+
                    "\n - 2 : Changer le prénom"+
                    "\n - 3 : Changer les absences Injustifiés"+
                    "\n - 4 : Changer les absences Justifiés");
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1){
            System.out.println("\nNouveau nom : ");
            String name = Clavier.lireString();
            a.setName(name);
        }
        else if(choix == 2){
            System.out.println("\nNouveau prénom : ");
            String firstname = Clavier.lireString();
            a.setFirstName(firstname);
        }
        else if(choix == 3){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Injustifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsInjustifie(abs);
        }
        else{
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Justifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsJustifie(abs);
        }
        a.affiche();
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui permet de modifier les éléments d'un PersonnelAdministratif
     * @param a un PersonnelAdministratif quelconque
     * @see Personne#setName(String)
     * @see Personne#setFirstName(String)
     * @see Personne#setNbAbsInjustifie(int)
     * @see Personne#setNbAbsJustifie(int)
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelAdministratif#setSalary(double) 
     */
    private static void modifyPersonnePersonnelAdministratif(PersonnelAdministratif a){
        int choix = -1;
        while (choix < 0 || choix > 5){
            System.out.println("\nVeuillez faire un choix"+
                    "\n - 0 : Retour au menu"+
                    "\n - 1 : Changer le nom"+
                    "\n - 2 : Changer le prénom"+
                    "\n - 3 : Changer les absences Injustifiés"+
                    "\n - 4 : Changer les absences Justifiés"+
                    "\n - 5 : Changer le salaire");
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1){
            System.out.println("\nNouveau nom : ");
            String name = Clavier.lireString();
            a.setName(name);
        }
        else if(choix == 2){
            System.out.println("\nNouveau prénom : ");
            String firstname = Clavier.lireString();
            a.setFirstName(firstname);
        }
        else if(choix == 3){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Injustifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsInjustifie(abs);
        }
        else if (choix == 4){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Justifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsJustifie(abs);
        }
        else{
            double salaire = -1;
            while (salaire == -1){
                System.out.println("\nNouveau salaire : ");
                salaire = Clavier.lireDouble();
            }
            a.setSalary(salaire);
        }
        a.affiche();
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui permet de modifier les éléments d'un PersonnelEnseignantTitulaire
     * @param a un PersonnelEnseignantTitulaire quelconque
     * @see Personne#setName(String)
     * @see Personne#setFirstName(String)
     * @see Personne#setNbAbsInjustifie(int)
     * @see Personne#setNbAbsJustifie(int)
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelEnseignantTitulaire#setTauxHoraire(double)
     * @see PersonnelEnseignantTitulaire#setHeuresStatuaire(int)
     * @see PersonnelEnseignantTitulaire#setHeuresSup(int)
     */
    private static void modifyPersonnePersonnelEnseignantTitulaire(PersonnelEnseignantTitulaire a){
        int choix = -1;
        while (choix < 0 || choix > 7){
            System.out.println("\nVeuillez faire un choix"+
                    "\n - 0 : Retour au menu"+
                    "\n - 1 : Changer le nom"+
                    "\n - 2 : Changer le prénom"+
                    "\n - 3 : Changer les absences Injustifiés"+
                    "\n - 4 : Changer les absences Justifiés"+
                    "\n - 5 : Changer le taux horaires"+
                    "\n - 6 : Changer le nombre d'heures"+
                    "\n - 7 : Changer le nombre d'heures supplémentaire");
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1){
            System.out.println("\nNouveau nom : ");
            String name = Clavier.lireString();
            a.setName(name);
        }
        else if(choix == 2){
            System.out.println("\nNouveau prénom : ");
            String firstname = Clavier.lireString();
            a.setFirstName(firstname);
        }
        else if(choix == 3){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Injustifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsInjustifie(abs);
        }
        else if (choix == 4){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Justifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsJustifie(abs);
        }
        else if(choix == 5){
            double taux = -1;
            while (taux == -1){
                System.out.println("\nNouveau taux horaires : ");
                taux = Clavier.lireDouble();
            }
            a.setTauxHoraire(taux);
        }
        else if(choix == 6){
            int heures = -1;
            while (heures == -1){
                System.out.println("\nNouveau nombre d'heures : ");
                heures = Clavier.lireInt();
            }
            a.setHeuresStatuaire(heures);
        }
        else {
            int heures = -1;
            while (heures == -1){
                System.out.println("\nNouveau nombre d'heures supplémentaires : ");
                heures = Clavier.lireInt();
            }
            a.setHeuresSup(heures);
        }
        a.affiche();
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui permet de modifier les éléments d'un PersonnelEnseignantVacataire
     * @param a un PersonnelEnseignantVacataire quelconque
     * @see Personne#setName(String)
     * @see Personne#setFirstName(String)
     * @see Personne#setNbAbsInjustifie(int)
     * @see Personne#setNbAbsJustifie(int)
     * @see Personne#affiche()
     * @see App#mainMenu()
     * @see PersonnelEnseignantVacataire#setHeuresSup(int)
     */
    private static void modifyPersonnePersonnelEnseignantVacataire(PersonnelEnseignantVacataire a){
        int choix = -1;
        while (choix < 0 || choix > 5){
            System.out.println("\nVeuillez faire un choix"+
                    "\n - 0 : Retour au menu"+
                    "\n - 1 : Changer le nom"+
                    "\n - 2 : Changer le prénom"+
                    "\n - 3 : Changer les absences Injustifiés"+
                    "\n - 4 : Changer les absences Justifiés"+
                    "\n - 5 : Changer le nombre d'heures");
            System.out.println("Votre choix : ");
            choix = Clavier.lireInt();
        }
        if(choix == 0) mainMenu();
        else if(choix == 1){
            System.out.println("\nNouveau nom : ");
            String name = Clavier.lireString();
            a.setName(name);
        }
        else if(choix == 2){
            System.out.println("\nNouveau prénom : ");
            String firstname = Clavier.lireString();
            a.setFirstName(firstname);
        }
        else if(choix == 3){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Injustifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsInjustifie(abs);
        }
        else if (choix == 4){
            int abs = -1;
            while (abs == -1){
                System.out.println("\nNouveau nombre d'absences Justifiés : ");
                abs = Clavier.lireInt();
            }
            a.setNbAbsJustifie(abs);
        }
        else {
            int heures = -1;
            while (heures == -1){
                System.out.println("\nNouveau nombre d'heures : ");
                heures = Clavier.lireInt();
            }
            a.setHeuresSup(heures);
        }
        a.affiche();
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui est un menu pour pouvoir modifier les absences d'une Personne
     * @see Personne
     * @see Personne#afficheIdsOfPersonneInTabPersonne()
     * @see Personne#searchPersonneWithId(int)
     * @see Personne#getId()
     * @see Personne#getName()
     * @see Personne#getFirstName()
     * @see Object#getClass()
     * @see Personne#getNbAbsInjustifie()
     * @see Personne#getNbAbsJustifie()
     * @see Personne#incrAbsInjustifie()
     * @see Personne#incrAbsJustifie()
     * @see Personne#justifiyAbs()
     * @see Personne#affiche()
     * @see App#mainMenu()
     */
    private static void modifyAbs(){
        Personne.afficheIdsOfPersonneInTabPersonne();
        System.out.println("\nVeuillez choisir un ID que vous voulez modifier : ");
        System.out.println("Votre choix : ");
        int choix = Clavier.lireInt();
        if(Personne.isInTabPersonne(choix)){
            Personne a = Personne.searchPersonneWithId(choix);
            System.out.println("\nVoici les informations de l'id : "+ a.getId()+
                    "\nNom : "+ a.getName() +", Prénom : "+ a.getFirstName()+
                    "\nType : "+ a.getClass().getSimpleName()+
                    "\nAbsJustifié : " + a.getNbAbsJustifie() + ", AbsInjustifié : " + a.getNbAbsInjustifie());
            choix = -1;
            while (choix < 0 || choix > 3){
                System.out.println("\nQue voulez vous faire : "+
                        "\n - 0 : Retour au menu"+
                        "\n - 1 : Ajouter une absence justifié"+
                        "\n - 2 : Ajouter une absence injustifié"+
                        "\n - 3 : Justifier une absence"+
                        "\n"+
                        "\n Notes : Les absences pour les Etudiants et les PersonnelAdministratif sont par jours alors que les Enseignants sont par heures");
                System.out.println("Votre choix : ");
                choix = Clavier.lireInt();
            }
            if(choix == 0) mainMenu();
            else if(choix == 1) a.incrAbsJustifie();
            else if(choix == 2) a.incrAbsInjustifie();
            else a.justifiyAbs();
            a.affiche();
        }
        else System.out.println("\nIl n'existe pas d'ID de personne avec l'ID : " + choix+"\n");
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui permet d'ajouter des heures supplémentaires à un Vacataire ou un Titulaire
     * @see PersonnelEnseignantTitulaire
     * @see PersonnelEnseignantVacataire
     * @see PersonnelEnseignant#afficheIdsOfPersonnelEnseignant()
     * @see Personne#isInTabPersonne(int)
     * @see PersonnelEnseignant#isPersonnelEnseignant(Object)
     * @see Personne#searchPersonneWithId(int)
     * @see PersonnelEnseignant#addHeuresSup(int)
     * @see App#mainMenu()
     * @see Personne#affiche()
     */
    private static void addHours(){
        PersonnelEnseignant.afficheIdsOfPersonnelEnseignant();
        System.out.println("\nVeuillez choisir un ID que vous voulez modifier : ");
        System.out.println("Votre choix : ");
        int choix = Clavier.lireInt();
        if(Personne.isInTabPersonne(choix) && PersonnelEnseignant.isPersonnelEnseignant(Personne.searchPersonneWithId(choix))){
            PersonnelEnseignant a = (PersonnelEnseignant)Personne.searchPersonneWithId(choix);
            choix = -1;
            while (choix < 0 || choix > 2){
                System.out.println("\nQue voulez vous faire : "+
                        "\n - 0 : Retour au menu"+
                        "\n - 1 : Ajouter une heure supplémentaire");
                System.out.println("Votre choix : ");
                choix = Clavier.lireInt();
            }
            if(choix == 1) a.addHeuresSup(1);
            else mainMenu();
            a.affiche();
        }
        else System.out.println("\nIl n'existe pas d'ID de personnel Enseignant avec l'ID : " + choix+"\n");
        if(choix != 0) mainMenu();
    }

    /**
     * Méthode qui permet de remettre le salaire à la base d'un salarié
     * @see Personnel#afficheIdsOfPersonnel()
     * @see Personne#isInTabPersonne(int)
     * @see Personnel#isPersonnel(Object)
     * @see Personne#searchPersonneWithId(int)
     * @see PersonnelEnseignant#isPersonnelEnseignant(Object)
     * @see PersonnelEnseignant#resetSalaire()
     * @see PersonnelAdministratif#resetAbs()
     * @see Personne#affiche()
     * @see App#mainMenu()
     */
    private static void resetSalary(){
        Personnel.afficheIdsOfPersonnel();
        System.out.println("\nVeuillez choisir un ID que vous voulez modifier : ");
        System.out.println("Votre choix : ");
        int choix = Clavier.lireInt();
        if(Personne.isInTabPersonne(choix) && Personnel.isPersonnel(Personne.searchPersonneWithId(choix))){
            Personne a = Personne.searchPersonneWithId(choix);
            if(PersonnelEnseignant.isPersonnelEnseignant(a)){
                PersonnelEnseignant b = (PersonnelEnseignant)a;
                b.resetSalaire();
            }
            else if(PersonnelAdministratif.isPersonnelAdministratif(a)){
                PersonnelAdministratif b = (PersonnelAdministratif)a;
                b.resetAbs();
            }
            a.affiche();
        }
        else System.out.println("\nIl n'existe pas d'ID de personnel avec l'ID : " + choix+"\n");
        mainMenu();
    }
}