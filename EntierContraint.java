package saejava;

/**
 * Classe qui permet de créer et de gérer un Objet de type EntierContraint
 * @author lukalindberg
 */
public class EntierContraint {
    /**
     * int min qui désigne la valeur minimum de l'EntierContraint
     */
    private int min;

    /**
     * int max qui désigne la valeur maximum de l'EntierContraint
     */
    private int max;

    /**
     * int val qui désigne la valeur de l'entier contraint qui sera bloqué entre le minimum (min) et le maximum (max)
     */
    private int val;

    /**
     * Constructeur de l'objet EntierContraint avec un int min, un int max et un int val
     * @param min un int qui sera défini comme le minimum
     * @see EntierContraint#min
     * @param max un int qui sera défini comme le maximum
     * @see EntierContraint#max
     * @param val un int quelconque qui sera bloqué entre le min et le max
     * @see EntierContraint#val
     * @see EntierContraint#setMinMax(int, int) 
     * @see EntierContraint#setVal(int)
     */
    protected EntierContraint(int min, int max, int val){
        this.setMinMax(min, max);
        this.setVal(val);
    }

    /**
     * Méthode qui permet de mettre une valeur au minimum (min) et au maximum (max) en gérant les erreurs de saisies
     * @param min valeur du minimum
     * @param max valeur du maximum
     * @see EntierContraint#max
     * @see EntierContraint#min
     */
    protected void setMinMax(int min, int max){
        if(min > max){
            this.max = min;
            this.min = max;
        }
        else{
            this.max = max;
            this.min = min;
        }
    }

    /**
     * Méthode qui permet de mettre une valeur int à val
     * @param val int val quelconque entre le min et le max
     * @see EntierContraint#val
     * @see EntierContraint#max
     * @see EntierContraint#min
     */
    protected void setVal(int val){
        if(val < this.min) this.val = this.min;
        else if(val > this.max) this.val = this.max;
        else this.val = val;
    }

    /**
     * Méthode qui retourne la valeur de l'EntierContraint (val)
     * @see EntierContraint#val
     * @return un int qui correspondant à la valeur de val
     */
    protected int getVal(){return this.val;}
}
