public class Examinator {

    private Element current;

    public Examinator(Element head){
        this.current = head;
    }

    public boolean possedeSuivant(){
        return current != null;
    }

    public Object suivant(){
        Object data = current.data;
        current = current.next;
        return data;
    }
}