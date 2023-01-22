package saejava;

import static saejava.Utils.stringVerification;

/**
 * Classe Abstraite qui gère des Objets de type Personne
 * @author lukalindberg
 */
public abstract class Personne implements Affichable{
    /**
     * String name qui désigne le nom d'une Personne
     */
    private String name;

    /**
     * String firstname qui désigne le prénom d'une Personne
     */
    private String firstName;

    /**
     * int nbAbsInjustifie qui désigne le nombre d'absences injustifié d'une Personne
     */
    private int nbAbsInjustifie;

    /**
     * int nbAbsJustifie qui désigne le nombre d'absences justifié d'une Personne
     */
    private int nbAbsJustifie;

    /**
     * int id qui désigne l'identifiant d'une Personne
     */
    private final int id;

    /**
     * int cpt qui s'incrémente à chaque fois qu'une Personne est créé
     */
    private static int cpt = 0;

    /**
     * Personne[] tabPersonne de taille 20 qui désigne un tableau de Personne pour indexer tous les objets de type Personne dedans
     */
    private static Personne[] tabPersonne = new Personne[20];

    /**
     * Constructeur de la Classe Personne qui prend en entrée un nom, un prénom, un nombre d'absences injustifié et un nombre d'absences justifié
     * @param name un String name qui désigne le nom de la Personne
     * @param firstName un String firstname qui désigne le prénom de la Personne
     * @param absInj un int absInj qui désigne le nombre d'absences injustifié
     * @param absJust un int absJust qui désigne le nombre d'absences justifié
     * @see Personne#setName(String)
     * @see Personne#setFirstName(String)
     * @see Personne#setNbAbsInjustifie(int)
     * @see Personne#setNbAbsJustifie(int)
     * @see Personne#addPersonneToTab()
     */
    protected Personne(String name, String firstName, int absInj, int absJust){
        cpt++;
        this.id = cpt;
        setName(name);
        setFirstName(firstName);
        setNbAbsInjustifie(absInj);
        setNbAbsJustifie(absJust);
        addPersonneToTab();
    }

    /**
     * Constructeur de la Classe Personne qui prend en entrée un nom et un prénom qui appelle le constructeur principal
     * @param name un String name qui désigne le nom
     * @param firstName un String firstname qui désigne le prénom
     * @see Personne#Personne(String, String, int, int)  Personne
     */
    protected Personne(String name, String firstName){this(name, firstName, 0, 0);}

    /**
     * Constructeur de la Classe Personne par défaut qui appelle le constructeur principal
     * @see Personne#Personne(String, String, int, int)  Personne
     */
    protected Personne(){this(null, null, 0, 0);}

    /**
     * Méthode qui ajoute 1 à l'attribut nbAbsInjustifie
     * @see Personne#nbAbsInjustifie
     */
    protected void incrAbsInjustifie(){
        this.nbAbsInjustifie++;
        testAbs();
    }

    /**
     * Méthode qui ajoute 1 à l'attribut nbAbsJustifie
     * @see Personne#nbAbsJustifie
     */
    protected void incrAbsJustifie(){
        this.nbAbsJustifie++;
        testAbs();
    }

    /**
     * Méthode qui ajoute x à l'attribut nbAbsInjustifie
     * @param x un int quelconque
     * @see Personne#nbAbsInjustifie
     * @see Math#abs(int)
     */
    protected void incrAbsInjustifie(int x){
        this.nbAbsInjustifie += Math.abs(x);
        testAbs();
    }

    /**
     * Méthode qui ajoute x à l'attribut nbAbsJustifie
     * @param x un int quelconque
     * @see Personne#nbAbsJustifie
     * @see Math#abs(int)
     */
    protected void incrAbsJustifie(int x){
        this.nbAbsJustifie += Math.abs(x);
        testAbs();
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant à la Personne
     */
    @Override
    public String toString(){
        return "\nClassName : " + this.getClass().getSimpleName()+
                "\nid : " + this.id +
                "\nname : " + this.name +
                "\nfirstName : " + this.firstName +
                "\nnbAbs : " + (this.nbAbsInjustifie + this.nbAbsJustifie) +
                "\n - nbAbsInjustifie : " + this.nbAbsInjustifie +
                "\n - nbAbsJustifie : " + this.nbAbsJustifie;
    }

    /**
     * Méthode qui vérifie si deux objets de type Object sont les mêmes
     * @param o un objet quelconque
     * @return true si les objets sont les mêmes et de type Personne sinon false
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Personne)) return false;
        Personne a = (Personne)o;
        return this.nbAbsJustifie == a.nbAbsJustifie && this.nbAbsInjustifie == a.nbAbsInjustifie && this.id == a.id && this.firstName.equals(a.firstName) && this.name.equals(a.name);
    }

    /**
     * Méthode qui renvoie un String qui correspond à l'attribut name
     * @return un String qui correspond à l'attribut name
     */
    protected String getName() {return this.name;}

    /**
     * Méthode qui renvoie un String qui correspond à l'attribut firstname
     * @return un String qui correspond à l'attribut firstname
     */
    protected String getFirstName() {return this.firstName;}

    /**
     * Méthode qui renvoie un int qui correspond à l'attribut nbAbsInjustifie + l'attribut nbAbsJustifie
     * @return un int qui correspond à l'attribut nbAbsInjustifie + l'attribut nbAbsJustifie
     */
    protected int getNbAbs(){return this.nbAbsInjustifie + this.nbAbsJustifie;}

    /**
     * Méthode qui renvoie un int qui correspond à l'attribut nbAbsJustifie
     * @return un int qui correspond à l'attribut nbAbsJustifie
     */
    protected int getNbAbsJustifie() {return this.nbAbsJustifie;}

    /**
     * Méthode qui renvoie un int qui correspond à l'attribut nbAbsInjustifie
     * @return un int qui correspond à l'attribut nbAbsInjustifie
     */
    protected int getNbAbsInjustifie() {return this.nbAbsInjustifie;}

    /**
     * Méthode qui renvoie un int qui correspond à l'attribut id
     * @return un int qui correspond à l'attribut id
     */
    protected int getId() {return id;}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut nbAbsInjustifie en nbAbs avec sa valeur absolu
     * @param nbAsb un int quelconque
     * @see Math#abs(int)
     */
    protected void setNbAbsInjustifie(int nbAsb) {
        this.nbAbsInjustifie = Math.abs(nbAsb);
        this.testAbs();
    }

    /**
     * Méthode qui permet de modifier la valeur de l'attribut nbAbsJustifie en nbAbs avec sa valeur absolu
     * @param nbAsb un int quelconque
     * @see Math#abs(int)
     */
    protected void setNbAbsJustifie(int nbAsb) {
        this.nbAbsJustifie = Math.abs(nbAsb);
        this.testAbs();
    }

    /**
     * Méthode qui permet de retirer une absInjustifie pour ajouter une absJustifie
     */
    protected void justifiyAbs(){
        if(this.nbAbsInjustifie == 0) System.out.println("La Personne : \n" +
                toString(this)+
                "\n n'a pas d'absences injustifiées");
        else{
            this.nbAbsInjustifie--;
            this.nbAbsJustifie++;
        }
    }

    /**
     * Méthode qui permet de retirer x absInjustifie pour ajouter x absJustifie
     * @param x un int quelconque
     */
    protected void justifiyAbs(int x){
        x = Math.abs(x);
        if(this.nbAbsInjustifie - x == 0) System.out.println("La Personne : \n" +
                toString(this)+
                "\n n'a pas assez d'absences injustifiées");
        else{
            this.nbAbsInjustifie-=x;
            this.nbAbsJustifie-=x;
        }
    }

    /**
     * Méthode qui permet de modifier la valeur de l'attribut name en appelant stringVerification
     * @param name un String quelconque
     * @see Utils#stringVerification(String)
     */
    protected void setName(String name){this.name = stringVerification(name);}

    /**
     * Méthode qui permet de modifier la valeur de l'attribut firstName en appelant stringVerification
     * @param firstName un String quelconque
     * @see Utils#stringVerification(String)
     */
    protected void setFirstName(String firstName){this.firstName = stringVerification(firstName);}

    /**
     * Méthode qui agrandit la taille du tableau Personne[] en augmentant sa taille de 20 et ajoute un élément à une place libre
     */
    protected void incrTabPersonne(){
        Personne[] newTab = new Personne[Personne.tabPersonne.length + 20];
        for(int i = 0; i < Personne.tabPersonne.length; i++) newTab[i] = Personne.tabPersonne[i];
        newTab[Personne.tabPersonne.length] = this;
        Personne.tabPersonne = newTab;
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant à la Personne
     */
    protected static String toString(Personne ... tab){
        String a = "";
        if(tab == null) return a;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != null)
                a += "\n - ["+i+"][ id : "+ tab[i].getId() + "; type : "+tab[i].getClass().getSimpleName()+"; name : " + tab[i].getName() + "; firstname : " + tab[i].getFirstName() + " ]";
        }
        return a;
    }

    /**
     * Méthode qui renvoie un int correspondant à la taille du tableau de Personne envoyé où les index sont différents de null
     * @param tab un tableau de type Personne[] quelconque ou plusieurs arguments de type Personne
     * @return un int qui désigne la taille de remplissage du tableau différent de null
     */
    protected static int lengthNotNull(Personne ... tab){
        int a = 0;
        if(tab == null) return a;
        for(Personne personne : tab){
            if(personne != null) a++;
        }
        return a;
    }

    /**
     * Méthode qui permet de retourner le tableau de Personne[] tabPersonne
     * @return Personne[] le tableau tabPersonne de la classe
     */
    protected static Personne[] getTabPersonne() {return tabPersonne;}

    /**
     * Méthode abstraite testAbs() qui permettra de vérifier les absences
     */
    protected abstract void testAbs();

    /**
     * Méthode qui renvoie true ou false en fonction de si l'objet en entrée est un objet de type Personne
     * @param o Objet quelconque
     * @return renvoie true si l'Objet est un Objet de type Personne sinon renvoie false
     */
    protected static boolean isPersonne(Object o){return(o instanceof Personne);}

    /**
     * Méthode qui permet d'afficher une Personne dans la console
     */
    @Override
    public void affiche(){
        System.out.println(this);
    }

    /**
     * Méthode qui permet d'ajouter une personne dans le tableau de Personne[]
     * @see Personne#incrTabPersonne()
     */
    protected void addPersonneToTab(){
        if(lengthNotNull(Personne.tabPersonne) == tabPersonne.length) this.incrTabPersonne();
        else{
            int i = 0;
            boolean trouve = false;
            while(i < Personne.tabPersonne.length && !trouve){
                if(Personne.tabPersonne[i] == null){
                    Personne.tabPersonne[i] = this;
                    trouve = true;
                }
                else i++;
            }
        }
    }

    /**
     * Retourne un int correspondant à la place de la Personne dans le tableau de Personne
     * @return un int correspondant à l'index de la Personne si elle est dans le tableau de Personne sinon renvoie -1
     */
    protected int getIndexInTabPersonne(){
        int id = this.getId();
        for(int i = 0; i < Personne.tabPersonne.length; i++){
            if(id == Personne.tabPersonne[i].getId()) return i;
        }
        return -1;
    }

    /**
     * Permet de retirer une Personne dans le tableau de Personne[] en fonction de son index
     * @param i un int correspondant à l'index de la Personne dans le tableau de Personne[]
     */
    protected static void removePersonneInTabPersonne(int i){
        Personne garbage = Personne.tabPersonne[i];
        Personne.tabPersonne[i] = null;
        if(Personnel.isPersonnel(garbage)){
            Personnel a = (Personnel)garbage;
            a.removePersonnelToBureau();
        }
        System.out.println("\nLa Personne avec l'id numéro "+ garbage.getId() + " a été supprimé avec succès");
    }

    /**
     * Méthode qui permet d'afficher les IDs ainsi que les informations de base de toutes les Personnes dans le tableau de Personne[]
     */
    protected static void afficheIdsOfPersonneInTabPersonne(){
        String a = toString(getTabPersonne());
        System.out.println("\nLa liste des IDs du tableau de Personne est : \n"+ a);
    }

    /**
     * Méthode qui permet de retirer une personne dans le tableau de Personne[] en fonction de l'ID de la personne
     * @param id un int correspondant à l'id de la Personne voulant être retirée
     * @see Personne#removePersonneInTabPersonne(int)
     */
    protected static void removePersonneInTabPersonneWithId(int id){
        boolean trouve = false;
        int i = 0;
        while (!trouve && i < tabPersonne.length){
            if(tabPersonne[i] != null && tabPersonne[i].getId() == id){
                trouve = true;
                removePersonneInTabPersonne(i);
            }
            i++;
        }
        if(!trouve) System.out.println("Aucune Personne n'est enregistré avec l'id numéro : " + id);
    }

    /**
     * Méthode qui permet de retourner une Personne en fonction de l'id envoyé
     * @param id int quelconque
     * @return une Personne qui a le même id que l'id mis en paramètre
     */
    protected static Personne searchPersonneWithId(int id){
        int i = 0;
        while (i < tabPersonne.length){
            if(tabPersonne[i] != null && tabPersonne[i].getId() == id) return tabPersonne[i];
            i++;
        }
        return null;
    }

    /**
     * Méthode qui permet de vérifier si la Personne est dans le tableau de Personne[] ou non
     * @param id un int quelconque
     * @return True si jamais la Personne est dans le tableau Personne[] sinon false
     * @see Personne#searchPersonneWithId(int)
     */
    protected static boolean isInTabPersonne(int id){return searchPersonneWithId(id) != null;}

    /**
     * Méthode qui permet de retirer la Personne du tableau de Personne[]
     */
    protected void removePersonne(){
        int index = this.getIndexInTabPersonne();
        Personne.removePersonneInTabPersonne(index);
    }
}