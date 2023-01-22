package saejava;

/**
 * Classe qui permet de créer et de gérer des Objets de type EtudiantBoursier hérité de la classe Etudiant
 * @author lukalindberg
 * @see Etudiant
 */
public class EtudiantBoursier extends Etudiant{
    /**
     * double bourse un nombre qui a un type double qui désigne la bourse de l'EtudiantBoursier
     */
    private final double bourse;

    /**
     * Constructeur de l'objet EtudiantBoursier qui prend en paramètre un nom, un prénom, un nombre d'absences injustifié, un nombre d'absences justifié et une bourse mis au supérieur avec Math.abs()
     * @param name un String qui désigne le nom
     * @param firstName un String qui désigne le prénom
     * @param absInj un int qui désigne le nombre d'absences injustifié
     * @param absJust un int qui désigne le nombre d'absences justifié
     * @param bourse un double qui désigne la somme de la bourse
     * @see Etudiant#Etudiant(String, String, int, int)  Etudiant
     * @see Math#abs(int) 
     */
    protected EtudiantBoursier(String name, String firstName, int absInj, int absJust, double bourse){
        super(name, firstName, absInj, absJust);
        this.bourse = Math.abs(bourse);
    }

    /**
     * Constructeur de l'objet EtudiantBoursier qui prend en paramètre un nom, un prénom et une bourse en appelant le constructeur principal
     * @param name un String qui désigne le nom
     * @param firstName un String qui désigne le prénom
     * @param bourse un double qui désigne la somme de la bourse
     * @see Etudiant#Etudiant(String, String, int, int)  Etudiant
     */
    protected EtudiantBoursier(String name, String firstName, double bourse){this(name, firstName, 0, 0, bourse);}

    /**
     * Constructeur de l'objet EtudiantBoursier qui prend en paramètre un nom et un prénom en appelant le constructeur principal
     * @param name un String qui désigne le nom
     * @param firstName un String qui désigne le prénom
     * @see EtudiantBoursier#EtudiantBoursier(String, String)  EtudiantBoursier
     */
    protected   EtudiantBoursier(String name, String firstName){this(name, firstName, 0, 0, 0);}

    /**
     * Constructeur par défaut de l'Objet EtudiantBoursier en appelant le constructeur principal
     * @see EtudiantBoursier#EtudiantBoursier(String, String)  EtudiantBoursier
     */
    protected EtudiantBoursier(){this("NULL", "NULL", 0, 0, 0);}

    /**
     * Méthode qui renvoie un double qui est la bourse de l'EtudiantBoursier
     * @return double bourse
     */
    protected double getBourse(){return this.bourse;}

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant à l'EtudiantBoursier
     */
    @Override
    public String toString(){
        return super.toString()+
                "\nBourse : " + this.bourse;
    }

    /**
     * Méthode qui vérifie si deux objets de type Object sont les mêmes
     * @param o un objet quelconque
     * @return true si les objets sont les mêmes et de type EtudiantBoursier sinon false
     */
    @Override
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        if(!(o instanceof EtudiantBoursier)) return false;
        EtudiantBoursier a = (EtudiantBoursier) o;
        return a.bourse == this.bourse;
    }

    /**
     * Méthode qui affiche dans la console le montant que l'EtudiantBoursier devra rembourser
     */
    @Override
    protected void afficherAbsences(){
        super.afficherAbsences();
        System.out.println("Il devra aussi rembourser : " + this.bourse + "€ comme il était boursier.");
    }

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type EtudiantBoursier
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type EtudiantBoursier sinon renvoie false
     */
    protected static boolean isEtudiantBoursier(Object o){
        return o instanceof EtudiantBoursier;
    }
}