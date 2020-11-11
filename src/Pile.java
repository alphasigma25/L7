/**
 *pile générique capable de stocker un nombre quelconque d'objets
 */
public class Pile {

    private Element head;
    private int size = 0;

    public Pile() {

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void empiler(Object o) {
        if (isEmpty()) {
            head = new Element(o, null);
        } else {
            head = new Element(o, head);
        }
        ++size;
    }

    public Object desempiler(){
        Object data = head.data;
        head = head.next;
        --size;
        return data;
    }

    public Object[] tab(){
        Object[] t = new Object[size];

        Examinator ex = examinator();
        int i = size;
        while (ex.possedeSuivant()) {
            t[--i] = ex.suivant();
        }
        return t;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("[ ");
        Examinator ex = examinator();

        while (ex.possedeSuivant()) {
            txt.append("<").append(ex.suivant()).append("> ");
        }

        return txt+"]";
    }

    public Examinator examinator() {
        return new Examinator(head);
    }
}
