package util;

/**
 * pile générique capable de stocker un nombre quelconque d'objets
 */
public class Pile {
    private Element head;
    private int size = 0;

    /**
     * @return si la pile est vide
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @return taille de la pile
     */
    public int size() {
        return size;
    }

    /**
     * empile un objet o sur la pile
     *
     * @param o objet à empiler
     */
    public void empiler(Object o) {
        head = new Element(o, isEmpty() ? null : head);
        ++size;
    }

    /**
     * désempile l'objet au sommet de la pile
     *
     * @return l'objet au sommet de la pile
     */
    public Object desempiler() {
        if (isEmpty()) return null;
        Object data = head.data;
        head = head.next;
        --size;
        return data;
    }

    /**
     * @return un tableau d'Objets représentant la pile
     */
    public Object[] tab() {
        Object[] t = new Object[size];

        Examinator ex = examinator();
        int i = size;
        while (ex.possedeSuivant()) {
            t[--i] = ex.suivant();
        }
        return t;
    }

    /**
     * @return chaine de caractère représentant la pile
     */
    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("[ ");
        Examinator ex = examinator();

        while (ex.possedeSuivant()) {
            txt.append("<").append(ex.suivant()).append("> ");
        }

        return txt + "]";
    }

    /**
     * itérateur sur la pile
     *
     * @return un itérateur sur la pile
     */
    public Examinator examinator() {
        return new Examinator(head);
    }
}
