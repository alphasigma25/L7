package util;

/**
 * classe élément, constituants fondamentaux d'une pile
 */
public class Element {
    Object data;
    Element next;

    /**
     * @param data objet à stoquer dans l'élément
     * @param next élément suivant
     */
    public Element(Object data, Element next) {
        this.data = data;
        this.next = next;
    }

}
