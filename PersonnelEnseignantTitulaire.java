package saejava;

/**
 * Classe PersonnelEnseignantTitulaire qui permet de créer et de gérer des Objets de type PersonnelEnseignantTitulaire hérité de PersonnelEnseignant
 * @author lukalindberg
 * @see PersonnelEnseignant
 */

public class PersonnelEnseignantTitulaire extends PersonnelEnseignant{
    /**
     * EntierContraint heuresStatuaire qui désigne le nombre d'heures d'un PersonnelEnseignantTitulaire
     * @see EntierContraint
     */
    private final EntierContraint heuresStatuaire;

    /**
     * double tauxHoraires qui désigne le taux horaire d'un PersonnelEnseignantTitulaire
     */
    private double tauxHoraire;

    /**
     * Constructeur de la classe PersonneEnseignantTitulaire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié, un nombre d'absences justifié, un nombre d'heures supplémentaire, un nombre d'heures et un taux
     * horaire
     * @param name un String qui désigne un nom d'un PersonnelEnseignantTitulaire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignantTitulaire
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantTitulaire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantTitulaire
     * @param heuresSup un int qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignantTitulaire
     * @param heures un int qui désigne le nombre d'heures de travail d'un PersonnelEnseignantTitulaire
     * @param tauxHoraire un double qui désigne le taux horaire d'un PersonnelEnseignantTitulaire
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     * @see PersonnelEnseignantTitulaire#setTauxHoraireSup(double)
     * @see PersonnelEnseignantTitulaire#testAbs()
     */
    public PersonnelEnseignantTitulaire(String name, String firstName, int absInj, int absJust, int heuresSup, int heures, double tauxHoraire) {
        super(name, firstName, absInj, absJust, heuresSup);
        this.heuresStatuaire = new EntierContraint(64, 384, heures);
        setTauxHoraire(tauxHoraire);
        testAbs();
    }

    /**
     * Constructeur de la classe PersonneEnseignantTitulaire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié, un nombre d'absences justifié, un nombre d'heures supplémentaire et un nombre d'heures en appelant le
     * constructeur de la Classe PersonnelEnseignant
     * @param name un String qui désigne un nom d'un PersonnelEnseignantTitulaire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantTitulaire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantTitulaire
     * @param heuresSup un int qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignantTitulaire
     * @param heures un int qui désigne le nombre d'heures de travail d'un PersonnelEnseignantTitulaire
     * @see PersonnelEnseignantTitulaire#PersonnelEnseignantTitulaire(String, String, int, int, int, int, double)
     */
    protected PersonnelEnseignantTitulaire(String name, String firstName, int absInj, int absJust, int heuresSup, int heures){
        this(name, firstName, absInj, absJust, heuresSup, heures, 0);
    }

    /**
     * Constructeur de la classe PersonneEnseignantTitulaire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié, un nombre d'absences justifié et un nombre d'heures supplémentaire en appelant le constructeur
     * principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantTitulaire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantTitulaire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantTitulaire
     * @param heuresSup un int qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignantTitulaire
     * @see PersonnelEnseignantTitulaire#PersonnelEnseignantTitulaire(String, String, int, int, int, int, double)
     */
    protected PersonnelEnseignantTitulaire(String name, String firstName, int absInj, int absJust, int heuresSup){
        this(name, firstName, absInj, absJust, heuresSup, 0, 0);
    }

    /**
     * Constructeur de la classe PersonneEnseignantTitulaire qui prend en entrée un nom, un prénom, un nombre d'absences
     * injustifié et un nombre d'absences justifié en appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantTitulaire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignantTitulaire
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignantTitulaire
     * @see PersonnelEnseignantTitulaire#PersonnelEnseignantTitulaire(String, String, int, int, int, int, double)
     */
    protected PersonnelEnseignantTitulaire(String name, String firstName, int absInj, int absJust){
        this(name, firstName, absInj, absJust, 0, 0, 0);
    }

    /**
     * Constructeur de la classe PersonneEnseignantTitulaire qui prend en entrée un nom et un prénom en appelant le
     * constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignantTitulaire
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @see PersonnelEnseignantTitulaire#PersonnelEnseignantTitulaire(String, String, int, int, int, int, double)
     */
    protected PersonnelEnseignantTitulaire(String name, String firstName){
        this(name, firstName, 0, 0, 0, 0, 0);
    }

    /**
     * Constructeur par défaut de la classe PersonneEnseignantTitulaire en appelant le constructeur principal
     * @see PersonnelEnseignantTitulaire#PersonnelEnseignantTitulaire(String, String, int, int, int, int, double)
     */
    protected PersonnelEnseignantTitulaire(){
        this(null, null, 0, 0, 0, 0, 0);
    }

    /**
     * Méthode qui permet de retourner le salaire du PersonnelEnseignantTitulaire au mois
     * @return un double correspondant au salaire du PersonnelEnseignantTitulaire au mois
     * @see PersonnelEnseignantTitulaire#getRetraitSalaire()
     */
    protected double getSalaire(){
        double salaire = 0;
        if(this.heuresStatuaire.getVal() >= 192){
            salaire += (this.getHeureSup() * this.getTauxHoraireSup());
        }
        if(this.heuresStatuaire.getVal() < this.getNbAbs()){
            System.out.println("\nAttention il y a plus d'absences que d'heures travaillé");
            return 0;
        }
        salaire += (this.heuresStatuaire.getVal()*this.tauxHoraire) - this.getRetraitSalaire();
        return Utils.round2(salaire);
    }

    /**
     * Méthode qui permet de retourner le salaire du PersonnelEnseignantTitulaire à l'année
     * @return un double correspondant au salaire du PersonnelEnseignantTitulaire à l'année
     * @see PersonnelEnseignantTitulaire#getSalaire()
     */
    protected double getSalaireAnnuel(){
        return (this.getSalaire() + this.heuresStatuaire.getVal()*this.tauxHoraire*11 + getPrime());
    }

    /**
     * Méthode qui permet de retourner le nombre d'heures statuaire d'un PersonnelEnseignantTitulaire
     * @return int correspondant au nombre d'heures statuaire d'un PersonnelEnseignantTitulaire
     */
    protected int getHeuresStatuaire(){return this.heuresStatuaire.getVal();}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut heuresStatuaire en fonction de x.
     * @param x un int quelconque
     */
    protected void setHeuresStatuaire(int x){this.heuresStatuaire.setVal(x);}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut tauxHoraire en fonction de x.
     * @param x un int quelconque
     */
    protected void setTauxHoraire(double x){this.tauxHoraire = Math.abs(x);}

    /**
     * Méthode qui permet de set le retrait salaire en fonction du nombre d'absences
     * @see PersonnelEnseignantTitulaire#setRetraitSalaire(double) 
     */
    @Override
    protected void testAbs() {
        this.setRetraitSalaire(Utils.round2(this.tauxHoraire*getNbAbsInjustifie() + (this.tauxHoraire*getNbAbsJustifie()*0.25)));
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au PersonnelEnseignantTitulaire
     */
    @Override
    public String toString(){
        return super.toString()+
                "\nSalaire : " + this.getSalaire()+
                "\nPrime : "+ Personnel.getPrime()+
                "\nSalaire Annuel : " + this.getSalaireAnnuel()+
                "\nHeures : " + this.heuresStatuaire.getVal()+
                "\nTauxHoraire : " + this.tauxHoraire;
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
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type
     * PersonnelEnseignantTitulaire
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type PersonnelEnseignantTitulaire sinon renvoie false
     */
    protected static boolean isPersonnelEnseignantTitulaire(Object o){ return o instanceof PersonnelEnseignantTitulaire;}
}
