package util;

/**
 * classe d'itérateur
 */
public class Examinator {

    private Element current;

    /**
     * Construit un itérateur depuis un élément donné
     * @param head premier élément à examiner
     */
    public Examinator(Element head) {
        current = head;
    }

    /**
     * @return vrai s'il existe un élément suivant, faux sinon
     */
    public boolean possedeSuivant() {
        return current != null;
    }

    /**
     * @return l'élément suivant
     */
    public Object suivant() {
        Object data = current.data;
        current = current.next;
        return data;
    }
}