package saejava;

/**
 * Classe PersonnelEnseignantVacataire qui permet de créer et de gérer des Objets de type PersonnelEnseignantVacataire
 * hérité de PersonnelEnseignant
 * @author lukalindberg
 * @see PersonnelEnseignant
 */

public class PersonnelEnseignantVacataire extends PersonnelEnseignant{
    /**
     * Constructeur de la classe PersonneEnseignantVacataire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié, un nombre d'absences justifié et un nombre d'heures
     * @param name un String qui désigne un nom d'un PersonnelEnseignantVacataire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignantVacataire
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantVacataire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantVacataire
     * @param heures un int qui désigne le nombre d'heures de travail d'un PersonnelEnseignantVacataire
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     * @see PersonnelEnseignantVacataire#testAbs()
     */
    protected PersonnelEnseignantVacataire(String name, String firstName, int absInj, int absJust, int heures){
        super(name, firstName, absInj, absJust, heures);
        testAbs();
    }

    /**
     * Constructeur de la classe PersonneEnseignantVacataire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié et un nombre d'absences justifié appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantVacataire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignantVacataire
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantVacataire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantVacataire
     * @see PersonnelEnseignantVacataire#PersonnelEnseignantVacataire(String, String, int, int, int)
     */
    protected PersonnelEnseignantVacataire(String name, String firstName, int absInj, int absJust){
        this(name, firstName, absInj, absJust, 0);
    }

    /**
     * Constructeur de la classe PersonneEnseignantVacataire qui prend en entrée un nom, un prénom et un nombre
     * d'heures appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantVacataire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignantVacataire
     * @param heures un int qui désigne le nombre d'heures de travail d'un PersonnelEnseignantVacataire
     * @see PersonnelEnseignantVacataire#PersonnelEnseignantVacataire(String, String, int, int, int)
     */
    protected PersonnelEnseignantVacataire(String name, String firstName, int heures){
        this(name, firstName, 0, 0, 0);
    }

    /**
     * Constructeur de la classe PersonneEnseignantVacataire qui prend en entrée un nom et un prénom appelant le
     * constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantVacataire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignantVacataire
     * @see PersonnelEnseignantVacataire#PersonnelEnseignantVacataire(String, String, int, int, int)
     */
    protected PersonnelEnseignantVacataire(String name, String firstName){
        this(name, firstName, 0, 0, 0);
    }

    /**
     * Constructeur par défaut de la classe PersonneEnseignantVacataire appelant le constructeur principal
     * @see PersonnelEnseignantVacataire#PersonnelEnseignantVacataire(String, String, int, int, int)
     */
    protected PersonnelEnseignantVacataire(){
        this(null, null, 0, 0, 0);
    }

    /**
     * Méthode qui permet de remettre le salaire à sa valeur de base
     */
    @Override
    protected void resetSalaire() {
        this.setHeuresSup(0);
        this.setRetraitSalaire(0);
        this.setNbAbsJustifie(0);
        this.setNbAbsInjustifie(0);
    }

    /**
     * Méthode qui permet de set le retrait salaire en fonction du nombre d'absences
     * @see PersonnelEnseignantTitulaire#setRetraitSalaire(double)
     */
    @Override
    protected void testAbs() {
        this.setRetraitSalaire(Utils.round2((this.getNbAbsJustifie()*this.getTauxHoraireSup())*0.25) + this.getNbAbsInjustifie()*this.getTauxHoraireSup());
    }

    /**
     * Méthode qui permet de retourner le salaire d'un PersonnelEnseignantVacataire pour le mois
     * @return un double correspondant au salaire d'un PersonnelEnseignantVacataire pour le mois
     */
    protected double getSalaire(){
        if(this.getNbAbs()>this.getHeureSup()) return 0;
        System.out.println("\nAttention il y a + d'absences que d'heures de travail");
        return (this.getTauxHoraireSup()*this.getHeureSup()) - this.getRetraitSalaire();
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au PersonnelEnseignantVacataire
     */
    @Override
    public String toString(){
        return super.toString() +
                "\nSalaire : "+ this.getSalaire();
    }

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type
     * PersonnelEnseignantVacataire
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type PersonnelEnseignantVacataire sinon renvoie false
     */
    protected static boolean isPersonnelEnseignantVacataire(Object o){ return o instanceof PersonnelEnseignantVacataire;}
}
