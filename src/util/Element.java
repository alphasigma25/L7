package util;

/**
 * classe élément, constituants fondamentaux d'une pile
 */
public class Element {
    Object data;
    Element next;

    /**
     * Construit un élément à partir d'un objet et de son élément suivant
     * @param data objet à stoquer dans l'élément
     * @param next élément suivant (peut être null)
     */
    public Element(Object data, Element next) {
        this.data = data;
        this.next = next;
    }

}
