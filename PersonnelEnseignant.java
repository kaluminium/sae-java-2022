package saejava;

/**
 * Classe abstraite PersonnelEnseignant qui permet de gérer des Objets de type PersonnelEnseignant hérité de la classe Personnel
 * @author lukalindberg
 * @see Personnel
 */
public abstract class PersonnelEnseignant  extends  Personnel{
    /**
     * double tauxHoraireSup qui désigne le salaire horaire d'un PersonnelEnseignant
     */
    private double tauxHoraireSup = 42;

    /**
     * int heuresSup qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignant
     */
    private int heuresSup;

    /**
     * double retraitSalaire qui désigne le montant du retrait du salaire
     */
    private double retraitSalaire;

    /**
     * Constructeur principal de la Classe PersonnelEnseignant prenant en entrée un nom, un prénom, un nombre d'absences injustifié, un nombre d'absences justifié et un nombre d'heures supplémentaire en appelant le constructeur de Personnel
     * @param name un String qui désigne un nom d'un PersonnelEnseignant
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignant
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignant
     * @param heuresSup un int qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignant
     * @see Personnel#Personnel(String, String, int, int) 
     * @see Math#abs(int)
     */
    protected PersonnelEnseignant(String name, String firstName, int absInj, int absJust, int heuresSup){
        super(name, firstName, absInj, absJust);
        this.heuresSup = Math.abs(heuresSup);
    }

    /**
     * Constructeur de la Classe PersonnelEnseignant prenant en entrée un nom, un prénom, un nombre d'absences injustifié et un nombre d'absences justifié en appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignant
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param absInj un int qui désigne le nombre d'absences injustifié d'un PersonnelEnseignant
     * @param absJust un int qui désigne le nombre d'absences justifié d'un PersonnelEnseignant
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     */
    protected PersonnelEnseignant(String name, String firstName, int absInj, int absJust){
        this(name, firstName, absInj, absJust, 0);
    }

    /**
     * Constructeur de la Classe PersonnelEnseignant prenant en entrée un nom et un prénom en appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignant
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @param heures un int qui désigne le nombre d'heures supplémentaire d'un PersonnelEnseignant
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     */
    protected PersonnelEnseignant(String name, String firstName, int heures){
        this(name, firstName, 0, 0, 0);
    }

    /**
     * Constructeur de la Classe PersonnelEnseignant prenant en entrée un nom et un prénom en appelant le constructeur principal
     * @param name un String qui désigne un nom d'un PersonnelEnseignant
     * @param firstName un String qui désigne un prénom d'un PersonnelEnseignant
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     */
    protected PersonnelEnseignant(String name, String firstName){
        this(name, firstName, 0, 0, 0);
    }

    /**
     * Constructeur de la Classe PersonnelEnseignant par défaut en appelant le constructeur principal
     * @see PersonnelEnseignant#PersonnelEnseignant(String, String, int, int, int)
     */
    protected PersonnelEnseignant(){
        this(null, null, 0, 0, 0);
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au PersonnelEnseignant
     */
    @Override
    public String toString(){
        return super.toString()+
                "\nheuresSup : " + this.heuresSup+
                "\ntauxHoraireSup : "+ this.tauxHoraireSup+
                "\nretraitSalaire : " + this.retraitSalaire;

    }

    /**
     * Méthode qui permet d'ajouter un int absolu hours à l'attribut heuresSup 
     * @param hours un int quelconque
     * @see Math#abs(int)
     */
    protected void addHeuresSup(int hours){
        this.heuresSup += Math.abs(hours);
    }

    /**
     * Méthode qui permet de modifier l'attribut heuresSup en fonction de x en tant qu'absolu
     * @param x un int quelconque
     */
    protected void setHeuresSup(int x){ this.heuresSup = Math.abs(x);}

    /**
     * Méthode qui permet de retourner la valeur de l'attribut heuresSup en fonction de x.
     * @return un int correspondant à la valeur de l'attribut heureSup
     */
    protected int getHeureSup(){ return this.heuresSup;}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut retraitSalaire en fonction de x.
     * @param x un double quelconque
     */
    protected void setRetraitSalaire(double x){
        this.retraitSalaire = Math.abs(x);
    }

    /**
     * Méthode qui retourne la valeur de l'attribut retraitSalaire
     * @return un double qui correspond à la valeur de l'attribut retraitSalaire
     */
    protected double getRetraitSalaire(){return this.retraitSalaire;}

    /**
     * Méthode qui retourne la valeur de l'attribut tauxHoraireSup
     * @return un double correspondant à la valeur de l'attribut tauxHoraireSup
     */
    protected double getTauxHoraireSup(){ return this.tauxHoraireSup;}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut tauxHoraireSup en fonction de x avec sa valeur absolue
     * @param x un double quelconque
     */
    protected void setTauxHoraireSup(double x){this.tauxHoraireSup = Math.abs(x);}

    /**
     * Méthode abstraite qui forcera la création d'une méthode resetSalaire à ses classes filles
     */
    protected abstract void resetSalaire();

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type PersonnelEnseignant
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type PersonnelEnseignant sinon renvoie false
     */
    protected static boolean isPersonnelEnseignant(Object o){ return o instanceof PersonnelEnseignant;}

    /**
     * Méthode qui permet de renvoyer un tri du tableau de Personne[] avec que des PersonnelEnseignant[]
     * @return un tableau de PersonnelEnseignant[]
     * @see Personne#getTabPersonne()
     * @see PersonnelEnseignant#isPersonnelEnseignant(Object)
     */
    protected static PersonnelEnseignant[] getTabPersonnelEnseignant(){
        PersonnelEnseignant[] tabPersonnel = new PersonnelEnseignant[Personne.getTabPersonne().length];
        int i = 0;
        for(int j = 0; j < Personne.getTabPersonne().length; j++){
            if(PersonnelEnseignant.isPersonnelEnseignant(Personne.getTabPersonne()[j])){
                PersonnelEnseignant a = (PersonnelEnseignant) Personne.getTabPersonne()[j];
                tabPersonnel[i] = a;
                i++;
            }
        }
        return tabPersonnel;
    }

    /**
     * Méthode qui permet d'afficher le tableau de PersonnelEnseignant
     * @see Personne#toString(Personne...)
     * @see PersonnelEnseignant#getTabPersonnelEnseignant()
     */
    protected static void afficheIdsOfPersonnelEnseignant(){
        String a = toString(getTabPersonnelEnseignant());
        System.out.println("\nLa liste des IDs du tableau de Personnel Enseignant est : \n"+ a);
    }
}
