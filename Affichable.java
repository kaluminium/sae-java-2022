package saejava;

/**
 * Interface qui permet d'implémenter une méthode d'affichage pour les classes
 * @author lukalindberg
 */

public interface Affichable {
    /**
     * Méthode qui permet de forcer d'utiliser une méthode d'affiche d'un toString ou autre
     */
    void affiche();
    String toString();
}
