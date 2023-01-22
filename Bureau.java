package saejava;

/**
 * Classe qui permet de créer et de gérer des objets de type Bureau
 * @author lukalindberg
 */
public class Bureau implements Affichable{
    /**
     * Tableau de Personnel non modifiable après création (taille du tableau)
     */
    private final Personnel [] tabPersonnel;

    /**
     * EntierContraint taille qui défini la taille du tableau maximum
     * @see EntierContraint
     */
    private final EntierContraint taille;

    /**
     * int id qui défini l'identifiant du Bureau
     */
    private final int id;

    /**
     * static int compteur un compteur qui permet d'incrément l'id du Bureau automatiquement après chaque création
     */
    private static int compteur = 0;

    /**
     * Tableau de Bureau tabBureau qui permet d'indexer tous les bureaux créés dedans
     */
    private static Bureau [] tabBureau = new Bureau[0];

    /**
     * Constructeur de Bureau avec un paramètre qui défini la taille.
     * @param taille un int qui sera bloqué entre 1 et 3.
     */
    protected Bureau(int taille){
        this.taille = new EntierContraint(1, 3, taille);
        tabPersonnel = new Personnel[this.taille.getVal()];
        compteur++;
        this.id = compteur;
        incrTabBureau();
    }

    /**
     * Constructeur de Bureau par défaut qui défini un bureau avec une valeur de taille à 3.
     */
    protected Bureau(){this(3);}

    /**
     * Méthode qui permet d'ajouter un Bureau dans le tableau de Bureau
     */
    protected void incrTabBureau(){
        Bureau[] newTab = new Bureau[Bureau.tabBureau.length + 1];
        for(int i = 0; i < newTab.length - 1; i++) newTab[i] = Bureau.tabBureau[i];
        newTab[newTab.length-1] = this;
        Bureau.tabBureau = newTab;
    }

    /**
     * Redéfinition de la méthode toString()
     * @return retourne un String avec tous les éléments correspondant au Bureau
     */
    @Override
    public String toString(){
        return "\nClassName : " + this.getClass().getSimpleName()+
                "\nid : " + this.id+
                "\ntaille : "+ this.taille.getVal()+
                "\ntabPersonne ("+Personne.lengthNotNull(tabPersonnel)+"/"+this.taille.getVal()+") : " + Personne.toString(tabPersonnel);
    }

    /**
     * Méthode qui permet de savoir si un Bureau a une place disponible ou pas
     * @return Renvoie un int -1 si jamais il n'y a pas de place sinon envoie le nombre de places
     */
    protected int placeInside(){
        for(int i = 0; i < this.tabPersonnel.length; i++) if(tabPersonnel[i] == null) return i;
        return -1;
    }

    /**
     * Méthode qui permet de récupérer les Personnels dans le Bureau
     * @return Personnel[] Le tableau de Personnels qui sont dans le Bureau
     */
    protected Personne[] getTabPersonnel(){return this.tabPersonnel;}

    /**
     * Méthode qui permet de récupérer le tableau de Bureau
     * @return Bureau[] Le tableau de Bureaux
     */
    static protected Bureau[] getTabBureau(){return Bureau.tabBureau;}

    /**
     * Méthode qui renvoie l'id du Bureau
     * @return un int qui est l'id du Bureau
     */
    protected int getId(){return this.id;}

    /**
     * Méthode qui permet d'afficher un Bureau dans la console
     */
    @Override
    public void affiche(){
        System.out.println(this);
    }

    /**
     * Méthode qui permet de rechercher un Bureau avec son id, s'il le trouve renvoie le bureau sinon renvoie null
     * @param id un int qui désigne l'id du Bureau que l'on veut chercher
     * @return un objet de type Bureau ou null
     */
    protected static Bureau searchBureauWithId(int id){
        int i = 0;
        while (i < tabBureau.length){
            if(tabBureau[i] != null && tabBureau[i].getId() == id) return tabBureau[i];
            i++;
        }
        return null;
    }

    /**
     * Méthode qui renvoie true si jamais l'id envoyé à la méthode searchBureauWithId() renvoie autre chose que null sinon renvoie false
     * @see Bureau#searchBureauWithId(int)
     * @param id un int qui désigne l'id du Bureau que l'on veut vérifier
     * @return True ou False en fonction de si l'id a été trouvé ou non
     */
    protected static boolean isInTabBureau(int id){
        return searchBureauWithId(id) != null;
    }

    /**
     * Méthode qui permet d'afficher la liste des Bureaux en affichant leur IDs
     */
    protected static void afficheIdsOfBureauxInTabBureau(){
        String a = "";
        for(int i = 0; i < Bureau.tabBureau.length; i++){
            if(Bureau.tabBureau[i] != null) a = a + Bureau.tabBureau[i].getId() + "; ";
        }
        System.out.println("\nLa liste des IDs du tableau de Bureau est : "+ a);
    }
}