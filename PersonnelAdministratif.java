package saejava;

/**
 * Classe qui permet de créer et gérer des Objets de type PersonnelAdministratif hérité de la classe Personnel
 * @author lukalindberg
 * @see Personnel
 */
public class PersonnelAdministratif extends Personnel{
    /**
     * double salary qui désigne le salaire mensuel du PersonnelAdministratif
     */
    private double salary;

    /**
     * double retraitSalaire qui désigne le retrait du salaire du PersonnelAdministratif
     */
    private double retraitSalaire;

    /**
     * Constructeur principal d'un objet PersonnelAdministratif qui prend en entrée un nom, un prénom, un nombre d'absences injustifié, un nombre d'absences justifié et un salaire en appelant le constructeur de la classe Personnel
     * @param name un String name qui désigne le nom du PersonnelAdministratif
     * @param firstName un String firstname qui désigne le prénom du PersonnelAdministratif
     * @param absInj un int absInj qui désigne le nombre d'absences injustifié du PersonnelAdministratif
     * @param absJust un int absJust qui désigne le nombre d'absences justifié du PersonnelAdministratif
     * @param salary un double salary qui désgine le salaire du PersonnelAdministratif
     * @see Personnel#Personnel(String, String, int, int)  Personnel
     * @see PersonnelAdministratif#setSalary(double)
     * @see PersonnelAdministratif#testAbs()
     */
    protected PersonnelAdministratif(String name, String firstName, int absInj, int absJust, double salary){
        super(name, firstName, absInj, absJust);
        setSalary(salary);
        testAbs();
    }

    /**
     * Constructeur qui appelle le constructeur principal en prenant comme entrée un nom, un prénom et un salaire
     * @param name un String name qui désigne le nom du PersonnelAdministratif
     * @param firstName un String firstname qui désigne le prénom du PersonnelAdministratif
     * @param salary un double salary qui désgine le salaire du PersonnelAdministratif
     * @see PersonnelAdministratif#PersonnelAdministratif(String, String, int, int, double)
     */
    protected PersonnelAdministratif(String name, String firstName, double salary){
        this(name, firstName, 0, 0, salary);
    }

    /**
     * Constructeur qui appelle le constructeur principal en prenant comme entrée un nom et un prénom
     * @param name un String name qui désigne le nom du PersonnelAdministratif
     * @param firstName un String firstname qui désigne le prénom du PersonnelAdministratif
     * @see PersonnelAdministratif#PersonnelAdministratif(String, String, int, int, double)
     */
    protected PersonnelAdministratif(String name, String firstName){
        this(name, firstName, 0, 0, 0);
    }

    /**
     * Constructeur par défaut qui appelle le constructeur principal
     * @see PersonnelAdministratif#PersonnelAdministratif(String, String, int, int, double)
     */
    protected PersonnelAdministratif(){
        this(null, null, 0, 0, 0);
    }

    /**
     * Méthode qui appelle la Méthode setRetraitSalaire()
     * @see PersonnelAdministratif#getRetraitSalaire() 
     */
    @Override
    protected void testAbs() {
        this.setRetraitSalaire();
    }

    /**
     * Méthode qui permet de reset les absences et donc de remettre le salaire du mois à sa normale
     * @see PersonnelAdministratif#setNbAbsJustifie(int) 
     * @see PersonnelAdministratif#setNbAbsInjustifie(int)
     */
    protected void resetAbs(){
        this.setNbAbsInjustifie(0);
        this.setNbAbsJustifie(0);
    }

    /**
     * Méthode qui permet de donner une valeur au retrait salaire en fonction du nombre d'absences
     */
    protected void setRetraitSalaire(){
        this.retraitSalaire = Utils.round2(((double)getNbAbsInjustifie()/24*salary + ((double)getNbAbsJustifie()/24*salary)/4));
    }

    /**
     * Méthode qui permet de modifier la valeur de l'attribut salary en fonction de x et appelle la méthode pour le retrait salaire
     * @param x un double quelconque
     * @see PersonnelAdministratif#setRetraitSalaire()
     */
    protected void setSalary(double x){
        this.salary = Math.abs(Utils.round2(x));
        setRetraitSalaire();
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au PersonnelAdministratif
     */
    public String toString(){
        return super.toString()+
                "\nsalary : "+ this.salary+
                "\nprime : "+ Personnel.getPrime()+
                "\nretraitSalaire : "+ this.getRetraitSalaire()+
                "\nsalaire au mois : "+ this.getSalaire()+
                "\nsalaire à l'année : "+ (this.getSalaire() + this.salary*11+getPrime());
    }

    /**
     * Méthode qui permet de récupérer le Salaire final du PersonnelAdministratif en fonction du salaire et du retrait
     * @return le salaire final du PersonnelAdministratif
     */
    @Override
    protected double getSalaire() {
        if(salary - retraitSalaire < 0){
            System.out.println("Attention il y a + d'absences que de jours travaillé");
            return 0;
        }
        return salary - retraitSalaire;
    }

    /**
     * Méthode qui permet de récupérer la valeur de l'attribut salary
     * @return un double correspondant à l'attribut salary
     */
    protected double getSalary(){return this.salary;}

    /**
     * Méthode qui permet de récupérer la valeur de l'attribut retraitSalaire
     * @return un double correspondant à l'attribut retraitSalaire
     * @see PersonnelAdministratif#setRetraitSalaire()
     */
    protected double getRetraitSalaire(){
        this.setRetraitSalaire();
        return this.retraitSalaire;
    }

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type PersonnelAdministratif
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type PersonneAdministratif sinon renvoie false
     */
    protected static boolean isPersonnelAdministratif(Object o){ return o instanceof PersonnelAdministratif;}
}
