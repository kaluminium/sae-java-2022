package saejava;

/**
 * Classe Abstraite qui gère des Objets de type Personnel hérité de la classe Personne
 * @see Personne
 * @author lukalindberg
 */
public abstract class Personnel extends Personne{
    /**
     * bureau de type Bureau qui désigne le bureau d'un Personnel
     */
    private final Bureau bureau;

    /**
     * double prime qui désigne la prime d'un Personnel
     */
    private static double prime = 1000;

    /**
     * Constructeur principal de l'objet Personnel qui prend en entrée un nom, un prénom, un nombre d'absences injustifié et un nombre d'absences justifié en appelant le constructeur de Personne
     * @param name un String name qui désigne le nom de la Personne
     * @param firstName un String firstname qui désigne le prénom de la Personne
     * @param absInj un int absInj qui désigne le nombre d'absences injustifié
     * @param absJust un int absJust qui désigne le nombre d'absences justifié
     * @see Personne#Personne(String, String, int, int)  Personne
     * @see Personnel#setPrime(double)
     * @see Personnel#addPersonnelToBureau()
     */
    protected Personnel(String name, String firstName, int absInj, int absJust){
        super(name, firstName, absInj, absJust);
        setPrime(prime);
        this.bureau = this.addPersonnelToBureau();
    }

    /**
     * Constructeur de l'objet Personnel qui prend en entrée un nom et un prénom en appelant le constructeur principal
     * @param name un String name qui désigne le nom de la Personne
     * @param firstName un String firstname qui désigne le prénom de la Personne
     * @see Personnel#Personnel(String, String, int, int)
     */
    protected Personnel(String name, String firstName){this(name, firstName, 0, 0);}

    /**
     * Constructeur de l'objet Personnel par défaut appelant le constructeur principal
     * @see Personnel#Personnel(String, String, int, int)
     */
    protected Personnel(){this(null, null, 0, 0);}

    /**
     * Méthode qui retourne le Bureau du Personnel
     * @return un type Bureau
     */
    protected Bureau getBureau(){return this.bureau;}

    /**
     * Méthode qui permet d'ajouter et de renvoyer le Bureau auquel le Personnel a été ajouté
     * @return le type Bureau du Personnel
     * @see Bureau#placeInside()
     * @see Bureau#getTabPersonnel()
     */
    protected Bureau addPersonnelToBureau(){
        Bureau bureau = null;
        boolean trouve = false;
        int i = 0;
        while(i < Bureau.getTabBureau().length && !trouve){
            int testPlaceInside = Bureau.getTabBureau()[i].placeInside();
            if(testPlaceInside != -1){
                trouve = true;
                Bureau.getTabBureau()[i].getTabPersonnel()[testPlaceInside] = this;
                bureau = Bureau.getTabBureau()[i];
            }
            i++;
        }
        if(!trouve){
            Bureau b = new Bureau();
            b.getTabPersonnel()[0] = this;
            System.out.println("\nUn bureau avec l'id "+b.getId()+" a été créé au vu du manque de place");
            bureau = b;
        }
        return bureau;
    }

    /**
     * Méthode qui permet de retirer un Personnel de son Bureau
     * @see Bureau#getTabPersonnel()
     */
    protected void removePersonnelToBureau(){
        for(int i = 0; i < this.bureau.getTabPersonnel().length; i++){
            if(this.bureau.getTabPersonnel()[i] != null && this.bureau.getTabPersonnel()[i].getId() == this.getId()) this.bureau.getTabPersonnel()[i] = null;
        }
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au Personnel
     */
    @Override
    public String toString(){
        return super.toString() +
                "\nidBureau : " + this.getBureau().getId();
    }

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type Personnel
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type Personnel sinon renvoie false
     */
    protected static boolean isPersonnel(Object o){
        return(o instanceof Personnel);
    }

    /**
     * Méthode qui permet de modifier la valeur de l'attribut prime
     * @param x double quelconque
     */
    protected static void setPrime(double x){Personnel.prime = Math.abs(Utils.round2(x));}

    /**
     * Méthode qui permet de retourner la valeur de l'attribut prime
     * @return un double correspondant à l'attribut prime
     */
    protected static double getPrime(){return Personnel.prime;}

    /**
     * Méthode abstraite qui sera défini dans ses enfants qui retourne le salaire d'un Personnel
     * @return un double correspondant au salaire du Personnel
     */
    protected abstract double getSalaire();

    /**
     * Méthode qui permet de récupérer un tableau de Personne[] comprenant tous les objets de type Personnel ayant au moins une absence
     * @return un tableau Personne[] avec une absence minimum
     * @see Personnel#getTabPersonne()
     */
    protected static Personnel[] getTabPersonnelWithAbs(){
        Personnel[] tabPersonnel = new Personnel[Personne.getTabPersonne().length];
        int i = 0;
        for(int j = 0; j < Personne.getTabPersonne().length; j++){
            if(Personnel.isPersonnel(Personne.getTabPersonne()[j]) && Personne.getTabPersonne()[j].getNbAbs() > 0){
                Personnel a = (Personnel)Personne.getTabPersonne()[j];
                tabPersonnel[i] = a;
                i++;
            }
        }
        return tabPersonnel;
    }

    /**
     * Méthode qui permet de renvoyer un tri du tableau de Personne[] avec que des Personnel[]
     * @return un tableau de Personnel[]
     * @see Personne#getTabPersonne()
     * @see Personnel#isPersonnel(Object)
     */
    protected static Personnel[] getTabPersonnel(){
        Personnel[] tabPersonnel = new Personnel[Personne.getTabPersonne().length];
        int i = 0;
        for(int j = 0; j < Personne.getTabPersonne().length; j++){
            if(Personnel.isPersonnel(Personne.getTabPersonne()[j])){
                Personnel a = (Personnel) Personne.getTabPersonne()[j];
                tabPersonnel[i] = a;
                i++;
            }
        }
        return tabPersonnel;
    }

    /**
     * Méthode qui permet d'afficher le tableau de Personnel
     * @see Personne#toString(Personne...)
     * @see Personnel#getTabPersonnel()
     */
    protected static void afficheIdsOfPersonnel(){
        String a = toString(getTabPersonnel());
        System.out.println("\nLa liste des IDs du tableau de Personnel est : \n"+ a);
    }
}