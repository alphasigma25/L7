import hanoi.Hanoi;
import hanoi.SpeedDisplayer;
import hanoi.gui.JHanoi;

/**
 * Programme principal
 */
public class Main2 {
    public static void main(String[] args) {
        new Hanoi(64, new SpeedDisplayer()).solve();
    }
}
