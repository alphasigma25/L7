package util;

/**
 * classe d'itérateur
 */
public class Examinator {

    private Element current;

    /**
     * @param head premier élément à examiner
     */
    public Examinator(Element head) {
        current = head;
    }

    /**
     * @return s'il existe un élément suivant
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