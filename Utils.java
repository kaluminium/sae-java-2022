package saejava;

/**
 * Classe qui gère des méthodes utilitaires
 * @author lukalindberg
 */
public abstract class Utils {
    /**
     * Méthode qui vérifie une chaine de caractère, la renvoie si jamais elle est différente de null sinon renvoie "NULL"
     * @param test une chaine de caractère quelconque
     * @return une chaine de caractère différent de null
     */
    public static String stringVerification(String test){
        if(test == null || test.equals("")) return "NULL";
        return test;
    }

    /**
     * Méthode qui permet d'arrondir un double avec une précision de 10^-2
     * @param x un double quelconque
     * @return un double arrondi à 10^-2
     */
    public static double round2(double x){
        return Math.round(x*100.0)/100.0;
    }

    /**
     * Méthode qui permet d'arrondir un double avec une précision de 10^-y
     * @param x un double quelconque
     * @param y un int quelconque
     * @return un double arrondi à 10^-x
     */
    public static double round(double x, int y){return Math.round(x*10.0*y)/(10.0*y);}
}
