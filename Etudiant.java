package saejava;

/**
 * Classe qui permet de créer et de gérer des Objets de type Etudiant hérité de la classe Personne
 * @author lukalindberg
 * @see Personne
 */
public class Etudiant extends Personne {
    /**
     * Constructeur d'un Etudiant qui prend en paramètre un nom, un prénom, un nombre d'absences injustifié et un nombre d'absences justifié et qui appelle testAbs()
     * @param name un String qui désigne le nom
     * @param firstName un String qui désigne le prénom
     * @param absInj un int qui désigne le nombre d'absences injustifié
     * @param absJust un int qui désgine le nombre d'absences justifié
     * @see Etudiant#testAbs()
     */
    protected Etudiant(String name, String firstName, int absInj, int absJust) {super(name, firstName, absInj, absJust); testAbs();}

    /**
     * Constructeur d'un Etudiant qui prend en paramètre un nom et un prénom en appelant le constructeur principal
     * @param name un String qui désigne le nom
     * @param firstName un String qui désigne le prénom
     * @see Etudiant#Etudiant(String, String, int, int)  Etudiant
     */
    protected Etudiant(String name, String firstName) {this(name, firstName, 0, 0);}

    /**
     * Constructeur d'un Etudiant par défaut en mettant les valeurs à "NULL" et à 0 en appelant le constructeur principal
     * @see Etudiant#Etudiant(String, String, int, int)  Etudiant
     */
    protected Etudiant() {this("NULL", "NULL", 0, 0);}

    /**
     * Méthode qui appelle la méthode afficherAbsences() si jamais l'Etudiant a plus de 5 absences injustifié
     * @see Etudiant#afficherAbsences()
     */
    @Override
    protected void testAbs() {if (this.getNbAbsInjustifie() > 5) this.afficherAbsences();}

    /**
     * Méthode qui affiche un message disant que l'Etudiant a trop d'absences
     */
    protected void afficherAbsences() {
        System.out.println("\nL'étudiant " + this.getName() + " " + this.getFirstName() + " avec le numéro : " + this.getId() +
                "\nne pourra plus valider son année à cause du nombre maximum d'absences atteint");
    }

    /**
     * Méthode qui renvoie un tableau d'Etudiant qui ont plus de 5 absences qui sont injustifiés
     * @return un tableau Etudiant[] comportant les Etudiants avec plus de 5 absences injustifiés
     */
    protected static Etudiant[] getTabOfEtudiantsWithTooMuchAbs(){
        Etudiant[] tabEtudiant = new Etudiant[Personne.getTabPersonne().length];
        int i = 0;
        for(int j = 0; j < Personne.getTabPersonne().length; j++){
            if(Etudiant.isEtudiant(Personne.getTabPersonne()[j]) && Personne.getTabPersonne()[j].getNbAbsInjustifie() > 5){
                Etudiant a = (Etudiant)Personne.getTabPersonne()[j];
                tabEtudiant[i] = a;
                i++;
            }
        }
        return tabEtudiant;
    }

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type Etudiant
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type Etudiant sinon renvoie false
     */
    protected static boolean isEtudiant(Object o) {return (o instanceof Etudiant);}
}